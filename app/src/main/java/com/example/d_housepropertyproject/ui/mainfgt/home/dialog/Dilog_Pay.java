package com.example.d_housepropertyproject.ui.mainfgt.home.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseDialog;

/**
 * 支付选择
 */
public class Dilog_Pay extends BaseDialog {
    public OnBackCenter onBackTime;

    public Dilog_Pay(Context context, OnBackCenter onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_pay;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.bt_cancel);
        setOnClickListener(R.id.bt_wx);
        setOnClickListener(R.id.bt_zfb);
    }


    @Override
    protected void initData() {
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.bt_cancel:
                dismiss();
                break;
            case R.id.bt_wx://微信支付
                onBackTime.onPayWx();
                break;
            case R.id.bt_zfb://支付宝支付
                onBackTime.onPayZFB();
                break;
        }
    }

    public interface OnBackCenter {
        void onPayWx();

        void onPayZFB();
    }
}
