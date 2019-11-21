package com.example.d_housepropertyproject.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.d_housepropertyproject.bean.RegisterAndLoginBean;
import com.example.d_housepropertyproject.bean.UserBindWechatBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.Act_BindCellPhone;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI api;
    private String WX_APP_ID = "wxd16726e67b213517";
    private String WX_APP_SECRET = "520e5dbbb41abbf9384d71508a1bcc13";
    private ACache aCache;
    public static String WXEStatics = "login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, WX_APP_ID, false);
        api.handleIntent(getIntent(), this);
        aCache = ACache.get(getApplication());
    }
    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq req) {
        finish();
    }
    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        api.handleIntent(getIntent(),this);
    }
    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    @Override
    public void onResp(BaseResp resp) {
        String result = "";
        if (resp != null) {
            resp = resp;
        }
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                String code = ((SendAuth.Resp) resp).code;
                if (WXEStatics.equals("login")) {
                    getBackLogin(code);
                } else {
                    userBindWechat(code);
                }
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                result = "发送取消";
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                finish();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                result = "发送被拒绝";
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                finish();
                break;
            default:
                result = "发送返回";
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                finish();
                break;
        }
    }

    /**
     * 走服务器。。接口
     *
     * @param code
     */
    public void getBackLogin(String code) {
        HttpHelper.wxLogin(this, code, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                finish();
                MyToast.show(getApplicationContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                RegisterAndLoginBean entity = gson.fromJson(succeed, RegisterAndLoginBean.class);
                if (entity.getCode() == 20000) {
                    Intent intent = new Intent();
                    if (entity.getResult().getUser() == null) {
                        MyApplication.setLoGinBean(null);
                        intent.setClass(getApplicationContext(), Act_BindCellPhone.class);
                        intent.putExtra("token", entity.getResult().getToken() + "");
                        startActivity(intent);
                        finish();
                    } else {
                        MyApplication.onWXLoginStatus = true;
                        aCache.put("logn", succeed);
                        MyToast.show(getApplicationContext(), "登录" + entity.getMessage());
                        MyApplication.setLoGinBean(entity);
                        finish();
                    }
                }
            }

            @Override
            public void onError(String error) {
                finish();
                MyToast.show(getApplicationContext(), error);
            }
        });
    }
    /**
     * 走服务器。。绑定微信号
     * @param code
     */
    public void userBindWechat(String code) {
        HttpHelper.userBindWechat(this, code, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                finish();
                MyToast.show(getApplicationContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                UserBindWechatBean entity = gson.fromJson(succeed, UserBindWechatBean.class);
                if (entity.getCode() == 20000) {
                    MyApplication.getUserGetUserBean().getResult().getData().setWechatKey("wechat");
                    MyToast.show(getApplicationContext(), "绑定成功！");
                }
                finish();
            }

            @Override
            public void onError(String error) {
                finish();
                MyToast.show(getApplicationContext(), error);
            }
        });
    }

}
