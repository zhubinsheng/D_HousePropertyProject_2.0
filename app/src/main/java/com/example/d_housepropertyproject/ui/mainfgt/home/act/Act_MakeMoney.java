package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.Dilog_Login_Cler;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 赚钱
 */
public class Act_MakeMoney extends BaseAct {
    @BindView(R.id.HousingLoanCalculation_back)
    ImageView HousingLoanCalculationBack;
    @BindView(R.id.HousingLoanCalculation_myWebView)
    WebView myWebView;

    //    @BindView(R.id.mSrollView)
//    ScrollView mSrollView;
    @Override
    public int initLayoutId() {
        return R.layout.act_makemoney;
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
        myWebView.loadUrl("http://www.dingduoduo.net.cn/agent");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        WebSettings mWebSettings = myWebView.getSettings();
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setSupportZoom(true);
        mWebSettings.setDomStorageEnabled(true);//开启本地DOM存储
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        mWebSettings.setJavaScriptEnabled(true);//是否允许JavaScript脚本运行，默认为false。设置true时，会提醒可能造成XSS漏洞
        mWebSettings.setSupportZoom(true);//是否可以缩放，默认true
        mWebSettings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        mWebSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        mWebSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        mWebSettings.setAppCacheEnabled(true);//是否使用缓存
        mWebSettings.setDomStorageEnabled(true);//开启本地DOM存储
        mWebSettings.setLoadsImagesAutomatically(true); // 加载图片
        mWebSettings.setMediaPlaybackRequiresUserGesture(false);//播放音频，多媒体需要用户手动？设置为false为可自动播
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //不加，单击超连接，启动系统的浏览器，加了之后在我们自己的APP中显示网页。
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading
                    (WebView view, String url) {
                //判断用户单击的是那个超连接
                String tag = "tel";
                if (url.contains(tag)) {
                    Dilog_Login_Cler dilog_login_cler = new Dilog_Login_Cler(context, new Dilog_Login_Cler.OnBackCenter() {
                        @Override
                        public void onBackCenter() {
                            String mobile = url.substring(url.lastIndexOf("/") + 1);
                            Uri uri = Uri.parse("tel:" + mobile);
                            Intent intent = new Intent(Intent.ACTION_CALL, uri);
                            startActivity(intent);
                            //这个超连接,java已经处理了，webview不要处理了
                        }
                    },"您确认拨打该电话？");
                    dilog_login_cler.show();
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
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

    @OnClick(R.id.HousingLoanCalculation_back)
    public void onClick() {
//        if (myWebView.canGoBack()) {
//            myWebView.goBack();
//        } else {
        finish();
    }
//    }

}
