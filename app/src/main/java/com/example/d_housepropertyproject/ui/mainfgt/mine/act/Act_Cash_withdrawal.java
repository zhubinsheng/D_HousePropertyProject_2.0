package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.view.View;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.Dilog_ChoseBank;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 提现
 */
public class Act_Cash_withdrawal extends BaseActivity {
    private Dilog_ChoseBank dilog_choseBank;

    @Override
    public int initLayoutId() {
        return R.layout.act_cash_withdrawal;
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
        dilog_choseBank = new Dilog_ChoseBank(this);
        dilog_choseBank.setTouchCancle(true);
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

    @OnClick({R.id.cash_withdrawal_back, R.id.cash_withdrawal_zhuanchu, R.id.cash_withdrawal_bankCar, R.id.cash_withdrawal_Submission})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cash_withdrawal_back:
                finish();
                break;
            case R.id.cash_withdrawal_zhuanchu://切换

                break;
            case R.id.cash_withdrawal_bankCar:
                dilog_choseBank.show();
                break;
            case R.id.cash_withdrawal_Submission:
                startAct(Act_Cash_WithdrawalSuccess.class);
                break;
        }
    }
}
