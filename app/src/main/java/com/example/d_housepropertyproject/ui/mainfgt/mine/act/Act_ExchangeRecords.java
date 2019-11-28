package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.ExchangeRecordsAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ExchangeRecordsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.Act_MerchandiseOrderDetails;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryOrdersetBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 兑换记录
 */
public class Act_ExchangeRecords extends BaseActivity {
    @BindView(R.id.min_SmartRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.ExchangeRecords_RecyclerView)
    RecyclerView ExchangeRecordsRecyclerView;
    @Override
    public int initLayoutId() {
        return R.layout.act_exchangerecords;
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
        //刷新
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
        mRefreshLayout.setEnableHeaderTranslationContent(true);  //内容跟随偏移
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));  //设置 Header 为 Material风格
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));    //设置 Footer 为 球脉冲
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            page_num = 1;
            dataAll.clear();
            orderQueryIntegralListUser();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            page_num++;
            orderQueryIntegralListUser();
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示刷新失败
        });
        ExchangeRecordsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private List<ExchangeRecordsBean.ResultBean.ListBean> dataAll = new ArrayList<>();
    private ExchangeRecordsAdapter adapter;
    @Override
    public void initData() {
        adapter = new ExchangeRecordsAdapter(dataAll);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent();
            intent.putExtra("bean", dataAll.get(position));
            startAct(intent, Act_IntegralOrder.class);
        });
        ExchangeRecordsRecyclerView.setAdapter(adapter);
        orderQueryIntegralListUser();
    }
    @Override
    public void updateUI() {

    }
    @Override
    public void onNoInterNet() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    @OnClick(R.id.min_Historical_Record_back)
    public void onClick() {
        finish();
    }
    private int page_num = 1;
    /**
     * 积分订单列表
     */
    public void orderQueryIntegralListUser() {
        HttpHelper.orderQueryIntegralListUser(page_num, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(Act_ExchangeRecords.this, failure);
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                ExchangeRecordsBean entity = gson.fromJson(succeed, ExchangeRecordsBean.class);
                if (entity.getCode() == 20000) {
                    if (page_num <= entity.getResult().getPageNum()) {
                        dataAll.addAll(entity.getResult().getList());
                    }
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(Act_ExchangeRecords.this, error);
            }
        });
    }
}
