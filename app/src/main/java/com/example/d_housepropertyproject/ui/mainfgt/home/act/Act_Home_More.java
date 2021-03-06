package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.os.Bundle;
import android.view.View;

import com.example.d_housepropertyproject.R;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 更多
 */
public class Act_Home_More extends BaseActivity {
    @Override
    public int initLayoutId() {
        return R.layout.act_home_more;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void initView() {
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        hideHeader();
    }

    @Override
    public void initData() {

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

    @OnClick({R.id.min_More_Record_back, R.id.home_more_jisuanqi, R.id.home_more_shangjin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_More_Record_back:
                finish();
                break;
            case R.id.home_more_jisuanqi://计算器

                break;
            case R.id.home_more_shangjin://去赚钱
                break;
        }
    }
}
