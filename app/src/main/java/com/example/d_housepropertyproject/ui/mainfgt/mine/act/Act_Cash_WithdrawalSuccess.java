package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.view.View;

import com.example.d_housepropertyproject.R;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 提现成功
 */
public class Act_Cash_WithdrawalSuccess extends BaseActivity {
    @Override
    public int initLayoutId() {
        return R.layout.act_cash_withdrawalsuccess;
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

    @OnClick({R.id.Cash_WithdrawalSuccess_back, R.id.Cash_WithdrawalSuccess_oder})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Cash_WithdrawalSuccess_back:
                finish();
                break;
            case R.id.Cash_WithdrawalSuccess_oder://查看账单
                startAct(Act_Bill.class);
                break;
        }
    }
}
