package com.example.d_housepropertyproject.ui.mainfgt;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_Ap_UnitDetails;
import com.example.d_housepropertyproject.ui.mainfgt.mine.adapter.ApartmentAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.ApartmentBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fgt_Apartment extends BaseFragment {
    @BindView(R.id.my_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public int initLayoutId() {
        return R.layout.fgt_apartment;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    private Unbinder unbinder;

    @Override
    public void onStart() {
        super.onStart();
    }

    ApartmentAdapter apartmentAdapter;
    List<ApartmentBean.ResultBean> datas;

    @Override
    public void initData() {
        setTitle(R.string.home_OnlineBooking_name);
        datas = new ArrayList<>();
        apartmentAdapter = new ApartmentAdapter(datas, context);
        apartmentAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.item_apptment_text:
                    Intent intent = new Intent();
                    intent.putExtra("id", datas.get(position).getId());
                    startAct(intent, Act_Ap_UnitDetails.class);
                    break;
            }
        });
        updateUI();
    }

    @Override
    public void updateUI() {
        unbinder = ButterKnife.bind(Fgt_Apartment.this, v);
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        myRecyclerView.setLayoutManager(layoutManager);
        mRefreshLayout.setEnableRefresh(false);//启用刷新
        mRefreshLayout.setEnableLoadMore(false);
        postBackData();
    }

    /**
     * 没有数据时调用
     */
    @Override
    public void onNoInterNet() {
        postBackData();
    }

    @Override
    public void sendMsg(int flag, Object obj) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void postBackData() {
        datas.clear();
        loding.show();
        HttpHelper.houseTypeProject(context, ApiConstant.PROJECT_ID, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                showNotInterNetLoading();
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                ApartmentBean entity = gson.fromJson(succeed, ApartmentBean.class);
                for (int i = 0; i < entity.getResult().size(); i++) {
                    datas.add(entity.getResult().get(i));
                }
                myRecyclerView.setAdapter(apartmentAdapter);
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                showNotInterNetLoading();
                MyToast.show(context, error);
            }
        });
    }


}
