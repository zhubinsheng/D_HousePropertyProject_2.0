package com.example.d_housepropertyproject.ui.mainfgt.home.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
 * 用户报名后的结果
 */
public class Dilog_RegistrationResult extends BaseDialog implements BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView myRecyclerView;
    public OnBackTime1 onBackTime;

    public Dilog_RegistrationResult(Context context, OnBackTime1 onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_registration_result;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.center);
    }
    List<Dilog_ChoseDateBean> data = new ArrayList<>();
    @Override
    protected void initData() {
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.center://确认
                dismiss();
                onBackTime.onBackOnclick();
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

  public   interface OnBackTime1 {
        void onBackOnclick();
    }
}
