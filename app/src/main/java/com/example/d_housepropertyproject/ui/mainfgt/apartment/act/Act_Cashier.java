package com.example.d_housepropertyproject.ui.mainfgt.apartment.act;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.Act_Main;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_HouseOrder;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_MerchandiseOrder;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 支付成功后的状态
 */
public class Act_Cashier extends BaseActivity {
    @BindView(R.id.Cashier_call)
    ImageView CashierCall;
    @BindView(R.id.ll_lose)
    LinearLayout llLose;
    @BindView(R.id.ll_Success)
    LinearLayout ll_Success;
    @BindView(R.id.Cashier_home)
    TextView CashierHome;
    @BindView(R.id.Cashier_oder)
    TextView CashierOder;

    @Override
    public int initLayoutId() {
        return R.layout.act_cashier;
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
        CashierOder.setSelected(true);
        CashierOder.setOnClickListener(v -> {
            if (getIntent().getStringExtra("cashistatus") != null||getIntent().getStringExtra("status") != null) {
                if (MyApplication.payWxStatus.equals("fangchan")) {
                    startAct(Act_HouseOrder.class);
                } else if (MyApplication.payWxStatus.equals("shopping")) {
                    startAct(Act_MerchandiseOrder.class);
                }
            } else {
                finish();
            }
        });
    }

    String status = "";

    @Override
    public void initData() {
        status = getIntent().getStringExtra("status");
        if (status.equals("success")) {
            llLose.setVisibility(View.GONE);
            ll_Success.setVisibility(View.VISIBLE);
        } else {
            llLose.setVisibility(View.VISIBLE);
            ll_Success.setVisibility(View.GONE);
        }
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick({R.id.Cashier_call, R.id.Cashier_home, R.id.Cashier_oder})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Cashier_call://联系客户
                MyUtils.callPhone(ApiConstant.PHONE, this);
                break;
            case R.id.Cashier_home:
                startActClear(Act_Main.class);
                break;
            case R.id.Cashier_oder://订单
                if (getIntent().getStringExtra("cashistatus") != null||getIntent().getStringExtra("status") != null) {
                    if (MyApplication.payWxStatus.equals("fangchan")) {
                        startAct(Act_HouseOrder.class);
                    } else if (MyApplication.payWxStatus.equals("shopping")) {
                        startAct(Act_MerchandiseOrder.class);
                    }
                } else {
                    finish();
                }
                break;
        }
    }
}
