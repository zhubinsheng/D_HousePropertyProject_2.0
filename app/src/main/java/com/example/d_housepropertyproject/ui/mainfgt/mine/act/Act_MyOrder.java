package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.view.View;

import com.example.d_housepropertyproject.R;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的订单
 */
public class Act_MyOrder extends BaseActivity {
    @Override
    public int initLayoutId() {
        return R.layout.act_myorder;
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

    @OnClick({R.id.MyOrder_back, R.id.HouseOrder, R.id.commodityOder})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MyOrder_back:
                finish();
                break;
            case R.id.HouseOrder://房产订单
                startAct(Act_HouseOrder.class);
                break;
            case R.id.commodityOder://商城订单
                startAct(Act_MerchandiseOrder.class);
                break;
        }
    }
}
