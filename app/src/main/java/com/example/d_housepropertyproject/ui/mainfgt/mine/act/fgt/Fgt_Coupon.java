package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.CouponAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.CouponBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_ClipCoupons;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 我的订单fragment
 */
@SuppressLint("ValidFragment")
public class Fgt_Coupon extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.min_Order_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.min_Order_refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String title;

    public Fgt_Coupon(String title1) {
        title = title1;
    }

    private Unbinder unbinder;

    @Override
    public void onStart() {
        super.onStart();
        updateUI();
    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_order;
    }

    @Override
    public void initView() {
        hideHeader();
        updateUI();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        myRecyclerView.setLayoutManager(layoutManager);
        //内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
        });
    }

    CouponBean bean;

    @Override
    public void initData() {
        List<CouponBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (title) {
                case "未使用":
                    bean = new CouponBean(CouponBean.TEXT);
                    break;
                case "已使用":
                    bean = new CouponBean(CouponBean.IMG);
                    break;
                case "已失效":
                    bean = new CouponBean(CouponBean.IMG_TEXT);
                    break;
            }
            data.add(bean);
        }
        CouponAdapter orderAdapter = new CouponAdapter(data);
        orderAdapter.setOnItemChildClickListener(this);
        myRecyclerView.setAdapter(orderAdapter);
    }

    @Override
    public void updateUI() {
        unbinder = ButterKnife.bind(Fgt_Coupon.this, v);
    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.item_coupon_notused_but://可使用
                startAct(Act_ClipCoupons.class);
                break;
        }
    }
}
