package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.view.View;

import com.example.d_housepropertyproject.R;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的钱包
 */
public class Act_MyWallet extends BaseActivity {
    @Override
    public int initLayoutId() {
        return R.layout.act_mywallet;
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

    @OnClick({R.id.Cash_WithdrawalSuccess_back, R.id.mywallet_bill, R.id.mywallet_Bank_card, R.id.mywallet_Cash_withdrawal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Cash_WithdrawalSuccess_back:
                finish();
                break;
            case R.id.mywallet_bill://账单
                startAct(Act_Bill.class);
                break;
            case R.id.mywallet_Bank_card://银行卡

                break;
            case R.id.mywallet_Cash_withdrawal://提现
                startAct(Act_Cash_withdrawal.class);
                break;
        }
    }
}
