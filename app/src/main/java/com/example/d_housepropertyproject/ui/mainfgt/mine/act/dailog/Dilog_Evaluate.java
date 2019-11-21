package com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.Dilog_ChoseDateBean;
import com.lykj.aextreme.afinal.common.BaseDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 评价邀请人。。返回弹出框
 */
public class Dilog_Evaluate extends BaseDialog implements BaseQuickAdapter.OnItemChildClickListener {
    public OnBackCenter onBackTime;

    public Dilog_Evaluate(Context context, OnBackCenter onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_evaluate;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.cancel);
        setOnClickListener(R.id.center);
    }

    List<Dilog_ChoseDateBean> data = new ArrayList<>();
    @Override
    protected void initData() {
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                dismiss();
                onBackTime.onBackCancle();
                break;
            case R.id.center://确认
                dismiss();
                break;
        }
    }

    String stDate = "";
    private int indext = 0;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        data.get(indext).setStatus(false);
        data.get(position).setStatus(true);
        indext = position;
        adapter.notifyDataSetChanged();
        stDate = data.get(position).getTime();
    }

    public interface OnBackCenter {
        void onBackCancle();
    }
}
