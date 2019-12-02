package com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseDialog;

/**
 * 兑换积分
 */
public class Dilog_Exchange extends BaseDialog {
    private BackCommit backCommit;

    public void setBackCommit(BackCommit backCommit) {
        this.backCommit = backCommit;
    }

    public Dilog_Exchange(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_exchange;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    private TextView tvNumber;

    @Override
    protected void initView() {
        setOnClickListener(R.id.tv_jian);
        setOnClickListener(R.id.tv_jia);
        setOnClickListener(R.id.bt_Integral);
        tvNumber = getView(R.id.number);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.tv_jian://减
                int numbr1 = Integer.valueOf(tvNumber.getText().toString()) - 1;
                if (numbr1< 1) {
                    return;
                }
                tvNumber.setText(numbr1 + "");
                break;
            case R.id.tv_jia://加
                int numbr = Integer.valueOf(tvNumber.getText().toString()) + 1;
                if (numbr > 999) {
                    return;
                }
                tvNumber.setText(numbr + "");
                break;
            case R.id.bt_Integral://立即兑换
                backCommit.commit(Integer.valueOf(tvNumber.getText().toString()));
                break;
        }
    }

    public interface BackCommit {
        void commit(int number);
    }
}
