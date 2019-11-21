package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.view.View;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.Dlg_AddressCenter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.Dlg_AddressSelection;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址修改
 */
public class Act_ReceivingAddressModify extends BaseActivity {
    @Override
    public int initLayoutId() {
        return R.layout.act_receivingaddressmodify;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
    }

    private Dlg_AddressSelection addressSelection;
    private Dlg_AddressCenter addressCenter;
    @Override
    public void initData() {
        addressSelection = new Dlg_AddressSelection(this);
        addressCenter=new Dlg_AddressCenter(this);
        addressCenter.setOnBackText(() -> {
                finish();
        });
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.min_Historical_Record_back, R.id.bt_xiangxidizhi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                addressCenter.show();
                break;
            case R.id.bt_xiangxidizhi:
                addressSelection.show();
                break;
        }
    }
}
