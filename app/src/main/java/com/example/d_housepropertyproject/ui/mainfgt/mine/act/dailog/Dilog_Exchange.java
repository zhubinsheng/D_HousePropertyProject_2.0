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
    private int Stock;

    public void setBackCommit(BackCommit backCommit) {
        this.backCommit = backCommit;
    }

    public Dilog_Exchange(Context context, int Stock1) {
        super(context);
        Stock = Stock1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_exchange;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    private TextView tvNumber, tv_Stock;

    @Override
    protected void initView() {
        setOnClickListener(R.id.tv_jian);
        setOnClickListener(R.id.tv_jia);
        setOnClickListener(R.id.bt_Integral);
        tvNumber = getView(R.id.number);
        tv_Stock = getView(R.id.tv_Stock1);
    }

    @Override
    protected void initData() {
        tv_Stock.setText(Stock + "");
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.tv_jian://减
                int numbr1 = Integer.valueOf(tvNumber.getText().toString()) - 1;
                if (numbr1 < 1) {
                    return;
                }
                tvNumber.setText(numbr1 + "");
                break;
            case R.id.tv_jia://加
                int numbr = Integer.valueOf(tvNumber.getText().toString()) + 1;
                if (numbr > Stock) {
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
