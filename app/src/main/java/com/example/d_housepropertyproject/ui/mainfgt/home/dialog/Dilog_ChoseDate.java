package com.example.d_housepropertyproject.ui.mainfgt.home.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.Dilog_ChoseDateAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.Dilog_ChoseDateBean;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.List;

/**
 * 选择报名时间
 */
public class Dilog_ChoseDate extends BaseDialog implements BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView myRecyclerView;
    public OnBackTime onBackTime;

    public Dilog_ChoseDate(Context context, OnBackTime onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_chosedate;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.cancel);
        setOnClickListener(R.id.center);
        myRecyclerView = getView(R.id.my_RecyclerView);
    }

    List<Dilog_ChoseDateBean> data;

    public void setData(List<Dilog_ChoseDateBean> data) {
        this.data = data;
    }

    private Dilog_ChoseDateAdapter adapter;

    @Override
    protected void initData() {
        adapter = new Dilog_ChoseDateAdapter(data);
        adapter.setOnItemChildClickListener(this);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(manager);
        myRecyclerView.setAdapter(adapter);
        if (data.size() > 0) {
            stDate = data.get(0).getTime();
        }
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                dismiss();
                break;
            case R.id.center://确认
                if (TextUtils.isEmpty(stDate)) {
                    MyToast.show(getContext(), "请选择一个时间！");
                    return;
                }
                dismiss();
                onBackTime.onBackDate(indext, stDate);
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

    public interface OnBackTime {
        void onBackDate(int position, String time);
    }
}
