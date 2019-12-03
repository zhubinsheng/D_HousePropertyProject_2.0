package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.MyIncomeBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.VipGetVipRemarkBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 会员中心
 */
public class Act_MemberCenter extends BaseActivity {
    @BindView(R.id.ll_vip)
    LinearLayout llVip;
    @BindView(R.id.ll_noVip)
    LinearLayout llNoVip;
    @BindView(R.id.tv_remark)
    TextView tvRemark;

    @Override
    public int initLayoutId() {
        return R.layout.act_membercenter;
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
        vipGetMyVip();
        vipGetVipRemark();
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

    @OnClick({R.id.min_Historical_Record_back, R.id.addHuiYuan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                finish();
                break;
            case R.id.addHuiYuan:
                loding.show();
                vipPay();
                break;
        }

    }

    /**
     * 获取我的会员
     */
    public void vipGetMyVip() {
        HttpHelper.vipGetMyVip(context, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                MyIncomeBean entity = gson.fromJson(succeed, MyIncomeBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult() != null) {
                        llVip.setVisibility(View.VISIBLE);
                        llNoVip.setVisibility(View.GONE);
                    } else {
                        llVip.setVisibility(View.GONE);
                        llNoVip.setVisibility(View.VISIBLE);
                    }
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
     * 获取会员描述
     */
    public void vipGetVipRemark() {
        HttpHelper.vipGetVipRemark(context, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                VipGetVipRemarkBean entity = gson.fromJson(succeed, VipGetVipRemarkBean.class);
                if (entity.getCode() == 20000) {
                    tvRemark.setText(entity.getResult().getRemark());
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
     * 购买会员
     */
    public void vipPay() {
        HttpHelper.vipPay("", MyApplication.getLoGinBean().getResult().getUser().getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                VipGetVipRemarkBean entity = gson.fromJson(succeed, VipGetVipRemarkBean.class);
                if (entity.getCode() == 20000) {
                    tvRemark.setText(entity.getResult().getRemark());
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
