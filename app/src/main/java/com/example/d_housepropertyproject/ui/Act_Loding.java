package com.example.d_housepropertyproject.ui;

import android.Manifest;
import android.content.Intent;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.RegisterAndLoginBean;
import com.example.d_housepropertyproject.bean.SySAppVersionBean;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.permission.SchedulerTransformer;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.dilog.ShowUpAppDilog;
import com.google.gson.Gson;
import com.luck.picture.lib.permissions.RxPermissions;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.MyToast;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 加载页面
 */
public class Act_Loding extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_loding;
    }
    ShowUpAppDilog showLoding;
    private ACache aCache;
    @Override
    public void initView() {
        hideHeader();
        aCache = ACache.get(this);
    }
    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
//        openRxPermissions();
        backData();
    }

    public void openRxPermissions() {
        new RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .compose(new SchedulerTransformer<Boolean>())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        sysAppVersion();
                    } else {
                        MyToast.show(context, "请允许该读写权限，便于日后自动更新操作！");
                        backData();
                    }
                });
    }

    @Override
    public void updateUI() {

    }
    @Override
    public void onNoInterNet() {

    }
    /**
     * 版本更新
     */
    public void sysAppVersion() {
        HttpHelper.sysAppVersion(new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
                backData();
            }
            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                SySAppVersionBean entity = gson.fromJson(succeed, SySAppVersionBean.class);
                if (entity.getCode() == 20000) {
                    if(entity.getResult().getApp_version().equals(MyUtils.getVerName(getContext()))){
                        backData();
                        return;
                    }
                    showLoding = new ShowUpAppDilog(context, entity.getResult().getApp_version(),Act_Loding.this, entity.getResult().getApp_url(),new ShowUpAppDilog.backOnclick(){
                        @Override
                        public void onCencle() {
                            backData();
                        }
                        @Override
                        public void onCenter() {

                        }
                    });
                    showLoding.show();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                backData();
                MyToast.show(context, error);
            }
        });
    }

    //进入app的数据恢复操作

    public void backData() {
        //        登录信息还原
        if (aCache.getAsString("logn") != null) {
            Gson gson = new Gson();
            RegisterAndLoginBean entity = gson.fromJson(aCache.getAsString("logn"), RegisterAndLoginBean.class);
            MyApplication.setLoGinBean(entity);
        }
        if (aCache.getAsString("loginStatus") != null && aCache.getAsString("loginStatus").equals("yes")) {
            startActivity(new Intent(context, Act_Main.class));
            finish();
        } else {
            startActivity(new Intent(context, Act_WelcomePage.class));
            finish();
        }
    }
}
