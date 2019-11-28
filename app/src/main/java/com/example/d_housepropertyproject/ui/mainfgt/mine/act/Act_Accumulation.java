package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.AccumulationBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.AccumulationAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.IntegralGetMyIntegralBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 积分商城
 */
public class Act_Accumulation extends BaseActivity {
    @BindView(R.id.jifenRecyclerView)
    RecyclerView jifenRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_totalIntegral)
    TextView tv_totalIntegral;

    @Override
    public int initLayoutId() {
        return R.layout.act_accumulation;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    List<RecommendingCommoditiesBean.ResultBean.ListBean> listDatas = new ArrayList<>();

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
            listDatas.clear();
            goodsQueryListUser();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            page_num++;
            goodsQueryListUser();
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示刷新失败
        });
    }

    AccumulationAdapter adapter;

    @Override
    public void initData() {
        jifenRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new AccumulationAdapter(listDatas);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent();
            intent.putExtra("goodId", listDatas.get(position).getId());
            startAct(intent, Act_GiftDetails.class);
        });
        jifenRecyclerView.setAdapter(adapter);
        jifenRecyclerView.setNestedScrollingEnabled(false);
        goodsQueryListUser();
        integralGetMyIntegral();
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

    @OnClick({R.id.min_Historical_Record_back, R.id.ExchangeRecords, R.id.MyIncome})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                finish();
                break;
            case R.id.ExchangeRecords://兑换记录
                startAct(Act_ExchangeRecords.class);
                break;
            case R.id.MyIncome://我的收益
                startAct(Act_MyIncome.class);
                break;
        }
    }

    private int page_num = 1;

    /**
     * 商品列表
     */
    public void goodsQueryListUser() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_num", page_num + "");
        hashMap.put("page_size", "10");
        hashMap.put("type", "j");
        HttpHelper.goodsQueryListUser(context, hashMap, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                RecommendingCommoditiesBean entity = gson.fromJson(succeed, RecommendingCommoditiesBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult().getPageNum() <= page_num) {
                        listDatas.addAll(entity.getResult().getList());
                    }
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

    /**
     * 获取我的积分
     */
    public void integralGetMyIntegral() {
        HttpHelper.integralGetMyIntegral(context, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                IntegralGetMyIntegralBean entity = gson.fromJson(succeed, IntegralGetMyIntegralBean.class);
                if (entity.getCode() == 20000) {
                    tv_totalIntegral.setText(entity.getResult().getTotalIntegral() + "");
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
}
