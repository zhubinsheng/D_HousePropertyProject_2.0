package com.example.d_housepropertyproject.ui.mainfgt.home.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseDialog;

/**
 * 拍照选择
 */
public class Dilog_Photograph extends BaseDialog {
    public OnBackCenter onBackTime;
    public Dilog_Photograph(Context context, OnBackCenter onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }
    @Override
    protected int initLayoutId() {
        return R.layout.dlg_photograph;
    }
    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }
    @Override
    protected void initView() {
        setOnClickListener(R.id.phontograph_cancel);
        setOnClickListener(R.id.phontograph_paizhao);
        setOnClickListener(R.id.phontograph_xiangce);
    }


    @Override
    protected void initData() {
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.phontograph_cancel:
                dismiss();
                break;
            case R.id.phontograph_paizhao://拍照
                dismiss();
                onBackTime.onPicTure();
                break;
            case R.id.phontograph_xiangce://相册选择
                dismiss();
                onBackTime.onphotoAlbum();
                break;
        }
    }

    public interface OnBackCenter {
        void onPicTure();

        void onphotoAlbum();
    }
}
