package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 房贷计算器
 */
public class Act_HousingLoanCalculation extends BaseAct {
    @BindView(R.id.HousingLoanCalculation_back)
    ImageView HousingLoanCalculationBack;
    @BindView(R.id.HousingLoanCalculation_myWebView)
    WebView myWebView;

    @Override
    public int initLayoutId() {
        return R.layout.act_housingloancalculation;
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
        myWebView.loadUrl("http://www.dingduoduo.net.cn/cel/index.html");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = myWebView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
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

    @OnClick(R.id.HousingLoanCalculation_back)
    public void onClick() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myWebView.canGoBack()) {
                myWebView.goBack();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (myWebView != null) {
            //加载null内容
            myWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            //清除历史记录
            myWebView.clearHistory();
            //移除WebView
            ((ViewGroup) myWebView.getParent()).removeView(myWebView);
            //销毁VebView
            myWebView.destroy();
            //WebView置为null
            myWebView = null;
        }
        super.onDestroy();
    }
}
