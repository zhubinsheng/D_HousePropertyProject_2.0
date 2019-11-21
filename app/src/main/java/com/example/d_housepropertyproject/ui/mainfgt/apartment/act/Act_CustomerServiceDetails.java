package com.example.d_housepropertyproject.ui.mainfgt.apartment.act;

import android.os.Bundle;
import android.widget.TextView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.CustomerServiceBean;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.Debug;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 客户详情页
 */
public class Act_CustomerServiceDetails extends BaseAct {
    @BindView(R.id.usergreement_webview)
    TextView webView;
    @BindView(R.id.CustomerServiceDetails_title)
    TextView title;
    @BindView(R.id.usergreement_right)
    TextView right;
    @Override
    public int initLayoutId() {
        return R.layout.act_customerservicedetails;
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

    CustomerServiceBean.ResultBean bean;
    @Override
    public void initData() {
        bean = (CustomerServiceBean.ResultBean) getIntent().getSerializableExtra("bean");
        title.setText("问答");
        webView.setText(bean.getContent());
        right.setText(bean.getName());
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);//允许使用js
//        webView.loadDataWithBaseURL(null, bean.getContent(), "text/html", "utf-8", null);
        Debug.e("------------"+bean.getContent());
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
    @OnClick(R.id.CustomerServiceDetails_back)
    public void onClick() {
        finish();
    }
}
