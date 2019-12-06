package com.example.d_housepropertyproject.commt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.StrictMode;

import com.example.d_housepropertyproject.bean.RegisterAndLoginBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UserGetUserBean;
import com.lykj.aextreme.afinal.common.BaseApplication;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhouyou.http.EasyHttp;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

public class MyApplication extends BaseApplication {
    public static String payWxStatus = "";
    private static MyApplication app;
    public static boolean onBackStatus = false;
    public static boolean onWXLoginStatus = false;
    private static final String APP_ID = "wxd16726e67b213517";
    // IWXAPI 是第三方app和微信通信的openApi接口
    private IWXAPI api;

    public static MyApplication getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        EasyHttp.init(this);
        regToWx();
        LeakCanary.install(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        CrashReport.initCrashReport(getApplicationContext(), "1b4e2efad2", false);
    }

    private void regToWx() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(APP_ID);
        //建议动态监听微信启动广播进行注册到微信
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // 将该app注册到微信
                api.registerApp(APP_ID);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
    }

    /**
     * 获取Application的Context
     **/
    public static Context getAppContext() {
        if (app == null)
            return null;
        return app.getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    /**
     * 个人信息获取
     */
    public static UserGetUserBean userGetUserBean;

    public static UserGetUserBean getUserGetUserBean() {
        return userGetUserBean;
    }

    public static void setUserGetUserBean(UserGetUserBean userGetUserBean) {
        MyApplication.userGetUserBean = userGetUserBean;
    }

    /**
     * 登录数据保存
     */
    public static RegisterAndLoginBean loGinBean;

    public static RegisterAndLoginBean getLoGinBean() {
        return loGinBean;
    }

    public static void setLoGinBean(RegisterAndLoginBean loGinBean) {
        MyApplication.loGinBean = loGinBean;
    }
}
