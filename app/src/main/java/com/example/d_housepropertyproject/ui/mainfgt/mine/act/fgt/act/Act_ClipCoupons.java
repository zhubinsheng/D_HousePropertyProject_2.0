package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.adapter.ClipCouponsAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.ClipCouponsBean;
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
 * 我的=》优惠劵=》使用优惠劵
 */
public class Act_ClipCoupons extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.min_ClipCoupons_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.min_ClipCoupons_refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public int initLayoutId() {
        return R.layout.act_clipcoupons;
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

    List<ClipCouponsBean> data;

    @Override
    public void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ClipCouponsBean bean = new ClipCouponsBean();
            data.add(bean);
        }
        ClipCouponsAdapter adapter = new ClipCouponsAdapter(data);
        adapter.setOnItemChildClickListener(this);
        myRecyclerView.setAdapter(adapter);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick(R.id.min_ClipCoupons_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.item_ClipCoupons_cb:
                if (data.get(position).isStatus()) {
                    data.get(position).setStatus(false);
                } else {
                    data.get(position).setStatus(true);
                }
                break;
        }
    }
}
