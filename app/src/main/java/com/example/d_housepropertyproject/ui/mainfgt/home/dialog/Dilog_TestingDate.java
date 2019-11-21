package com.example.d_housepropertyproject.ui.mainfgt.home.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.Dilog_ChoseDateAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.Dilog_ChoseDateBean;
import com.lykj.aextreme.afinal.common.BaseDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 检测用户是否已输入报名信息
 */
public class Dilog_TestingDate extends BaseDialog implements BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView myRecyclerView;
    public OnBackCenter onBackTime;

    public Dilog_TestingDate(Context context, OnBackCenter onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_testing;
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
    private Dilog_ChoseDateAdapter adapter;

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
                onBackTime.onBackCenter();
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
        void onBackCenter();

        void onBackCancle();
    }
}
