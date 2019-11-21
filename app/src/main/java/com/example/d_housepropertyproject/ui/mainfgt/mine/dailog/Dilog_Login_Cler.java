package com.example.d_housepropertyproject.ui.mainfgt.mine.dailog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseDialog;

/**
 * 退出或者清除缓存
 */
public class Dilog_Login_Cler extends BaseDialog {
    public OnBackCenter onBackTime;
    private String stText;
    private TextView title;

    public Dilog_Login_Cler(Context context, OnBackCenter onBackTime1,String stText) {
        super(context);
        this.onBackTime = onBackTime1;
        this.stText = stText;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_lgcler;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.cancel);
        setOnClickListener(R.id.center);
        title = getView(R.id.call_phone);
        title.setText(stText);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                dismiss();
                break;
            case R.id.center://确认
                dismiss();
                onBackTime.onBackCenter();
                break;
        }
    }

    public interface OnBackCenter {
        void onBackCenter();
    }
}
