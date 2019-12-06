package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.Act_Login;
import com.example.d_housepropertyproject.ui.mainfgt.bean.HomeBannerBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.RecommendingCommoditiesAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
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

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 爱订商城
 */
public class Act_ShoppingCenter extends BaseAct {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.shoppingCenter_RecyclerView)
    RecyclerView shoppingCenter_RecyclerView;//菜单

    @Override
    public int initLayoutId() {
        return R.layout.act_shoppingcenter;
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

    List<RecommendingCommoditiesBean.ResultBean.ListBean> listDatas = new ArrayList<>();
    private RecommendingCommoditiesAdapter adapter;

    @Override
    public void initData() {
        shoppingCenter_RecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        shoppingCenter_RecyclerView.setNestedScrollingEnabled(false);
        adapter = new RecommendingCommoditiesAdapter(listDatas);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            if (MyApplication.getLoGinBean() == null) {
                Intent intent = new Intent();
                intent.setClass(getContext(), Act_Login.class);
                startActivityForResult(intent, 10);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("goodId", listDatas.get(position).getId());
            startAct(intent, Act_CommodityDetails.class);
        });
        shoppingCenter_RecyclerView.setAdapter(adapter);
        goodsQueryListUser();
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

    @OnClick(R.id.Explain_back)
    public void onClick() {
        finish();
    }

    private int page_num = 1;

    /**
     * 商品列表
     */
    public void goodsQueryListUser() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_num", page_num + "");
        hashMap.put("page_size", "10");
        hashMap.put("type", "p");
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
                    if ( entity.getResult().getPageNum()<=page_num) {
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
}
