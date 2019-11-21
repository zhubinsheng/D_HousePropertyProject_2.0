package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_Ap_UnitDetails;
import com.example.d_housepropertyproject.ui.mainfgt.mine.adapter.ApartmentAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.ApartmentBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 热门详情列表
 */
public class Act_Hot_details extends BaseAct {
    @BindView(R.id.my_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public int initLayoutId() {
        return R.layout.act_hot_details;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);

    }

    ApartmentAdapter apartmentAdapter;
    List<ApartmentBean.ResultBean> datas;

    @Override
    public void initData() {
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

    @Override
    public void onNoInterNet() {

    }

    public void postBackData() {
        datas.clear();
//        loding.show();
        HttpHelper.houseTypeProject(this, ApiConstant.PROJECT_ID, new HttpHelper.HttpUtilsCallBack<String>() {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id._Hot_details_back)
    public void onClick() {
        finish();
    }
}
