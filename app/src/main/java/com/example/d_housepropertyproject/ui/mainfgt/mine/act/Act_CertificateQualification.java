package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.Utils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 证照资质
 */
public class Act_CertificateQualification extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_certificatequalification;
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

    @OnClick({R.id.CertificateQualification_about_back,
            R.id.CertificateQualification_qualification,
            R.id.CertificateQualification_ICP})
    public void onClick(View view) {
        if (Utils.isFastClick() == false) {//防点击过快
            return;
        }
        Intent intent=new Intent();
        switch (view.getId()) {
            case R.id.CertificateQualification_about_back:
                finish();
                break;
            case R.id.CertificateQualification_qualification:
                intent.putExtra("type","1");
                startAct(intent, Act_QualificationDocuments.class);
                break;
            case R.id.CertificateQualification_ICP:
                intent.putExtra("type","2");
                startAct(intent,Act_QualificationDocuments.class);
                break;
        }
    }
}
