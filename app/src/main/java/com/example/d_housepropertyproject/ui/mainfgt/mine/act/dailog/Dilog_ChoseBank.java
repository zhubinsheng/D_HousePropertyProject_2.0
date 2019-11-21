package com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.adapter.ChoseBankAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.bean.ChoseBankBean;
import com.lykj.aextreme.afinal.common.BaseDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择银行
 */
public class Dilog_ChoseBank extends BaseDialog implements BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView myRecyclerView;
    public OnBackTime onBackTime;

    public Dilog_ChoseBank(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_chosebank;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        myRecyclerView = getView(R.id.ChoseBank_RecyclerView);
    }

    List<ChoseBankBean> data = new ArrayList<>();
    private ChoseBankAdapter adapter;

    @Override
    protected void initData() {
        for (int i = 0; i < 8; i++) {
            ChoseBankBean bean = new ChoseBankBean();
            data.add(bean);
        }
        adapter = new ChoseBankAdapter(data);
        adapter.setOnItemChildClickListener(this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                dismiss();
                break;
            case R.id.center://确认
                dismiss();
                onBackTime.onBackDate(stDate);
                break;
        }
    }

    String stDate = "";
    private int indext = 0;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
    }

    public interface OnBackTime {
        void onBackDate(String time);
    }
}
