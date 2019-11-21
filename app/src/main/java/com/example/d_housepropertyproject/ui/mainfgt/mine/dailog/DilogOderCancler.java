package com.example.d_housepropertyproject.ui.mainfgt.mine.dailog;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.MyToast;

/**
 * 订单取消
 */
public class DilogOderCancler extends BaseDialog {
    public OnBackCenter onBackTime;
    private EditText input;

    public DilogOderCancler(Context context, OnBackCenter onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_cancle;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        input = getView(R.id.oder_liyou);
        setOnClickListener(R.id.cancel);
        setOnClickListener(R.id.center);
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
                if (TextUtils.isEmpty(input.getText().toString())) {
                    MyToast.show(getContext(), "请输入取消订单理由后重试！");
                    return;
                }
                onBackTime.onBackCenter(input.getText().toString());
                break;
        }
    }

    public interface OnBackCenter {
        void onBackCenter(String neirong);
    }
}
