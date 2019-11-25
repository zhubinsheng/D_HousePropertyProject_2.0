package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionWXUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.CouponAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.CouponBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_ClipCoupons;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.couponGetCouponListBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 我的订单fragment
 */
@SuppressLint("ValidFragment")
public class Fgt_Coupon extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.min_Order_RecyclerView)
    RecyclerView myRecyclerView;
//    @BindView(R.id.min_Order_refreshLayout)
//    SmartRefreshLayout mRefreshLayout;
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
        return R.layout.fgt_coupon;
    }

    @Override
    public void initView() {
        hideHeader();
        updateUI();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        myRecyclerView.setLayoutManager(layoutManager);
//        //内容跟随偏移
//        mRefreshLayout.setEnableHeaderTranslationContent(true);
//        //设置 Header 为 Material风格
//        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
//        //设置 Footer 为 球脉冲
//        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
//        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
//            page = 1;
//            couponGetCouponList();
//            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
//        });
//        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
//            page++;
//            couponGetCouponList();
//            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
//        });
        switch (title) {
            case "未使用":
                fettle = "1";
                bean = new CouponBean(CouponBean.TEXT);
                break;
            case "已使用":
                fettle = "2";
                bean = new CouponBean(CouponBean.IMG);
                break;
            case "已失效":
                fettle = "3";
                bean = new CouponBean(CouponBean.IMG_TEXT);
                break;
        }
    }

    CouponBean bean;
    private String fettle = "";
    List<CouponBean> couponDatas = new ArrayList<>();
    CouponAdapter orderAdapter;

    @Override
    public void initData() {
        orderAdapter = new CouponAdapter(couponDatas);
        orderAdapter.setOnItemChildClickListener(this);
        myRecyclerView.setAdapter(orderAdapter);
        couponGetCouponList();
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
//                startAct(Act_ClipCoupons.class);
                break;
        }
    }

    private int page = 1;
    private String searchValue = "";

    /**
     * 获取我的优惠券
     * searchValue 查询值
     * fettle  1: 可使用; 2: 已使用; 3: 已过期
     */
    public void couponGetCouponList() {
        HttpHelper.couponGetMyCouponList(getContext(), fettle, page + "", searchValue, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                couponGetCouponListBean entity = gson.fromJson(succeed, couponGetCouponListBean.class);
                if (entity.getCode() == 20000) {
                        for (int i = 0; i < entity.getResult().getCoupon().size(); i++) {
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
                            bean.setCreated(entity.getResult().getCoupon().get(i).getCreated());
                            bean.setCreatedby(entity.getResult().getCoupon().get(i).getCreatedby());
                            bean.setUpdated(entity.getResult().getCoupon().get(i).getUpdated() + "");
                            bean.setUpdatedby(entity.getResult().getCoupon().get(i).getCreatedby());
                            bean.setId(entity.getResult().getCoupon().get(i).getId());
                            bean.setIdInfo(entity.getResult().getCoupon().get(i).getIdInfo());
                            bean.setIdOrder(entity.getResult().getCoupon().get(i).getIdOrder() + "");
                            bean.setIdUser(entity.getResult().getCoupon().get(i).getIdUser());
                            bean.setPrice(entity.getResult().getCoupon().get(i).getPrice());
                            bean.setTimeUsed(entity.getResult().getCoupon().get(i).getTimeUsed() + "");
                            bean.setFettle(entity.getResult().getCoupon().get(i).getFettle());
                            bean.setIsactive(entity.getResult().getCoupon().get(i).getIsactive());
                            bean.setTimeOverdate(entity.getResult().getCoupon().get(i).getTimeOverdate());
                            bean.setSuitable(entity.getResult().getCoupon().get(i).getSuitable());
                            bean.setType(entity.getResult().getCoupon().get(i).getType());
                            couponDatas.add(bean);
                    }
                    orderAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }
}
