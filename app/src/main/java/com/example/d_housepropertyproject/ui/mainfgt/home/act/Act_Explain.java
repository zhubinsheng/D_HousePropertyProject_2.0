package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.UserAgreementBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 看房说明
 */
public class Act_Explain extends BaseActivity {
    @BindView(R.id.usergreement_webview)
    WebView webView;

    @Override
    public int initLayoutId() {
        return R.layout.act_explain;
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
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
    }

    @Override
    public void initData() {
        syswordGetByType();
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick({R.id.Explain_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Explain_back:
                finish();
                break;
        }

    }
    /**
     * 看房团协议
     */
    public void syswordGetByType() {
        HttpHelper.syswordGetByType(context, "2", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                UserAgreementBean entity = gson.fromJson(succeed, UserAgreementBean.class);
                if (entity.getCode() == 20000) {
                    webView.loadDataWithBaseURL(null, entity.getResult().get(0).getContent(), "text/html", "utf-8", null);
                }
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
}
