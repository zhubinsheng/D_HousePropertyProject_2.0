package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.GlideImageLoader;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.CouponBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.GoodsQueryInfoIntegralUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.adapter.ClipCouponsAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.ClipCouponsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.couponGetCouponListBean;
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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 我的=》优惠劵=》使用优惠劵
 */
public class Act_ClipCoupons extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.min_ClipCoupons_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.min_ClipCoupons_refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.noteIntenet)
    RelativeLayout view_nonett;
    @BindView(R.id.noteOder)
    RelativeLayout view_noteoder;

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
            page = 1;
            dataList.clear();
            couponGetCouponInfoList();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            page++;
            couponGetCouponInfoList();
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
        });
    }

    List<couponGetCouponListBean.ResultBean.CouponBean> dataList = new ArrayList<>();
    private ClipCouponsAdapter adapter;

    @Override
    public void initData() {
        adapter = new ClipCouponsAdapter(dataList);
        adapter.setOnItemClickListener(this);
        myRecyclerView.setAdapter(adapter);
        couponGetCouponInfoList();
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

    private int page = 1;
    private String searchValue = "";
    /**
     * 获取优惠券list
     */
    public void couponGetCouponInfoList() {
        HttpHelper.couponGetMyCouponList(getContext(), "1", page + "", searchValue, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
                view_nonett.setVisibility(View.VISIBLE);
                view_noteoder.setVisibility(View.GONE);
                myRecyclerView.setVisibility(View.GONE);
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                couponGetCouponListBean entity = gson.fromJson(succeed, couponGetCouponListBean.class);
                if (entity.getCode() == 20000) {
                    dataList.addAll(entity.getResult().getCoupon());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                myRecyclerView.setVisibility(View.GONE);
                MyToast.show(getContext(), error);
            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent();
        intent.putExtra("bean",dataList.get(position));
        setResult(11, intent);
        finish();
    }
}
