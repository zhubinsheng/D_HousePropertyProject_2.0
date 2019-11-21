package com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址返回确定按钮
 */
public class Dlg_AddressCenter extends BaseDialog {
    private onBackCenter onBackText;

    public void setOnBackText(onBackCenter onBackText) {
        this.onBackText = onBackText;
    }

    public Dlg_AddressCenter(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_addresscenter;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }
    @Override
    protected void initView() {
        setOnClickListener(R.id.center);
    }
    @Override
    protected void initData() {
    }
    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.center://取消
                onBackText.onBackItemCenter();
                break;
        }
    }
    public interface onBackCenter {
        void onBackItemCenter();
    }
}
