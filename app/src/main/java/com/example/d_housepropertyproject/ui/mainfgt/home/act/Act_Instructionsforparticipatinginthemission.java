package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 参团需知
 */
public class Act_Instructionsforparticipatinginthemission extends BaseActivity {
    @BindView(R.id.usergreement_webview)
    ImageView usergreementWebview;
    @BindView(R.id.status_bar_fix)
    TextView statusBarFix;
    @BindView(R.id.Explain_back)
    ImageView ExplainBack;
    @BindView(R.id.rl_userhome_top)
    RelativeLayout rlUserhomeTop;
    @BindView(R.id.myScrollview)
    NestedScrollView myScrollview;

    @Override
    public int initLayoutId() {
        return R.layout.act_instructionsforparticipatinginthemission;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void initView() {
        hideHeader();
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        statusBarFix.setAlpha(0);
        myScrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @SuppressLint("Range")
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY >= 0 && scrollY < 200) {
                    statusBarFix.setAlpha(scrollY / 3);
                } else if (scrollY >= 200) {
                    statusBarFix.setAlpha(255);
                }
            }
        });
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick(R.id.Explain_back)
    public void onClick() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
