package com.example.d_housepropertyproject.ui.mainfgt.apartment.act;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.adapter.CustomerServiceAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.CustomerServiceBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面户型=>户型详情=>客服
 */
public class Act_CustomerService extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.min_Historical_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.min_Historical_refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public int initLayoutId() {
        return R.layout.act_customerservice;
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

    @Override
    public void initData() {
        myRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.custom_divider));
        myRecyclerView.addItemDecoration(divider);
        mRefreshLayout.setEnableRefresh(false);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        syswordGetHelpWord();
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick(R.id.CustomerService_back)
    public void onClick() {
        finish();
    }

    /**
     * 客服
     */
    List<CustomerServiceBean.ResultBean> datas = new ArrayList<>();
    CustomerServiceAdapter adapter;
    public void syswordGetHelpWord() {
        HttpHelper.syswordGetHelpWord(this,new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                CustomerServiceBean entity = gson.fromJson(succeed, CustomerServiceBean.class);
                for (int i = 0; i < entity.getResult().size(); i++) {
                    datas.add(entity.getResult().get(i));
                }
                if (adapter == null) {
                    adapter = new CustomerServiceAdapter(datas);
                    adapter.setOnItemClickListener(Act_CustomerService.this);
                    myRecyclerView.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent();
        intent.putExtra("bean", datas.get(position));
        startAct(intent, Act_CustomerServiceDetails.class);
    }
}
