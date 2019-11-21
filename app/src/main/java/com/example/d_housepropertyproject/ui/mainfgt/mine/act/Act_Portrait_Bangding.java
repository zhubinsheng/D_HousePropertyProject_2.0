package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UserUntiedBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.Dilog_BangDing;
import com.example.d_housepropertyproject.wxapi.WXEntryActivity;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 第三方账号绑定
 */
public class Act_Portrait_Bangding extends BaseAct {
    @BindView(R.id.modifycellphone_back)
    ImageView modifycellphoneBack;
    @BindView(R.id.modifycellphone_title)
    TextView modifycellphoneTitle;
    @BindView(R.id.bangding_status1)
    TextView bangdingStatus1;
    @BindView(R.id.bangding_status2)
    TextView bangdingStatus2;
    private Dilog_BangDing bangDing;

    @Override
    public int initLayoutId() {
        return R.layout.act_portrait_bangding;
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
        bangDing = new Dilog_BangDing(context, new Dilog_BangDing.OnBackCenter() {
            @Override
            public void onBackCenter() {//确定解绑
                userUntied();
            }

            @Override
            public void onBackCancle() {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(MyApplication.getUserGetUserBean()==null){
            return;
        }
        if (MyApplication.getUserGetUserBean().getResult().getData().getWechatKey() == null) {
            bangdingStatus1.setSelected(true);
            bangdingStatus1.setText("去绑定");
        } else {
            bangdingStatus1.setSelected(false);
            bangdingStatus1.setText("解绑");
        }
        bangdingStatus2.setSelected(true);
        bangdingStatus2.setText("去绑定");
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

    @OnClick({R.id.modifycellphone_back, R.id.modifycellphone_title, R.id.bangding_status1, R.id.bangding_status2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.modifycellphone_back:
                finish();
                break;
            case R.id.modifycellphone_title:
                break;
            case R.id.bangding_status1:
                if(MyApplication.getUserGetUserBean()==null){
                    return;
                }
                if (bangdingStatus1.isSelected()) {//绑定
                    WXEntryActivity.WXEStatics = "bangding";
                    WXLogin();
                } else {//解绑
                    bangDing.show();
                }
                break;
            case R.id.bangding_status2:
                MyToast.show(context, "工程师还在开发中。。。");
                break;
        }
    }

    /**
     * 解绑
     */
    public void userUntied() {
        loding.show();
        HttpHelper.userUntied(this,new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                UserUntiedBean entity = gson.fromJson(succeed, UserUntiedBean.class);
                if (entity.getCode() == 20000) {
                    MyApplication.getLoGinBean().getResult().getUser().setWechat(null);
                    bangdingStatus1.setSelected(true);
                    bangdingStatus1.setText("去绑定");
                    MyToast.show(context, "解绑成功！");
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    // 微信登录
    private static IWXAPI WXapi;
    private String WX_APP_ID = "wxd16726e67b213517";

    /**
     * 登录微信
     */
    private void WXLogin() {
        WXapi = WXAPIFactory.createWXAPI(this, WX_APP_ID, true);
        WXapi.registerApp(WX_APP_ID);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo";
        WXapi.sendReq(req);
    }
}
