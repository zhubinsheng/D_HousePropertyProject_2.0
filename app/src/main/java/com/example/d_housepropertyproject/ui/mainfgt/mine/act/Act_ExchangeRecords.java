package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.ExchangeRecordsAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ExchangeRecordsBean;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
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
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示刷新失败
        });
        ExchangeRecordsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<ExchangeRecordsBean> dataAll = new ArrayList<>();

    @Override
    public void initData() {
        for (int i = 0; i < 10; i++) {
            dataAll.add(new ExchangeRecordsBean());
        }
        ExchangeRecordsAdapter adapter = new ExchangeRecordsAdapter(dataAll);
        adapter.setOnItemClickListener((adapter1, view, position) -> startAct(Act_IntegralOrder.class));
        ExchangeRecordsRecyclerView.setAdapter(adapter);
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
}
