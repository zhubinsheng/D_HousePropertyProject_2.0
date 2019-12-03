package com.example.d_housepropertyproject.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.bean.RegisterAndLoginBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.Act_UserAgreement;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_RechargePassword;
import com.example.d_housepropertyproject.view.MyTimerText;
import com.example.d_housepropertyproject.wxapi.WXEntryActivity;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录
 */
public class Act_Login extends BaseActivity {
    @BindView(R.id.lg_phone)
    EditText lgPhone;
    @BindView(R.id.lg_yzm)
    EditText lgYzm;
    @BindView(R.id.lg_Timer)
    MyTimerText lgTimer;
    @BindView(R.id.lg_UserAgreement)
    TextView lgUserAgreement;
    @BindView(R.id.lg_Submission)
    TextView lgSubmission;
    @BindView(R.id.tabTv_registerLogin)
    TextView tabTvRegisterLogin;
    @BindView(R.id.tabTv_pwdLogin)
    TextView tabTvPwdLogin;
    @BindView(R.id.login_code)
    LinearLayout loginCode;
    @BindView(R.id.lg_pwd)
    EditText lgPwd;
    @BindView(R.id.login_pwd)
    LinearLayout loginPwd;
    @BindView(R.id.login_userGreen)
    ImageView login_userGreen;
    @BindView(R.id.login_login)
    TextView login_login;
    private ACache aCache;
    // 微信登录
    private static IWXAPI WXapi;
    private String WX_APP_ID = "wxd16726e67b213517";

    @Override
    public int initLayoutId() {
        return R.layout.act_login;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    private TextView[] tabTv = new TextView[2];

    @Override
    protected void onResume() {
        super.onResume();
        if (MyApplication.onWXLoginStatus) {
            finish();
            MyApplication.onWXLoginStatus = false;
        }
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        aCache = ACache.get(context);
        tabTv[0] = findViewById(R.id.tabTv_registerLogin);
        tabTv[1] = findViewById(R.id.tabTv_pwdLogin);
    }

    @Override
    public void initData() {
        lgPhone.addTextChangedListener(textWatcher);
        lgYzm.addTextChangedListener(textWatcher);
        lgPwd.addTextChangedListener(textWatcher);
        login_userGreen.setSelected(true);

    }

    //检测输入状态
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            setStatus();
        }
    };

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick({R.id.lg_Timer, R.id.lg_Submission, R.id.login_wx, R.id.login_qq, R.id.tabTv_registerLogin, R.id.tabTv_pwdLogin,
            R.id.login_wangjimima, R.id.lg_UserAgreement, R.id.login_userGreen1, R.id.login_userGreen, R.id.Login_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lg_Timer://发送验证码
                if (TextUtils.isEmpty(lgPhone.getText().toString())) {
                    MyToast.show(context, "手机号码不能为空");
                    return;
                }
                if (lgPhone.getText().toString().length() != 11) {
                    MyToast.show(context, "您输入的手机号码位数不对，请重新输入！");
                    return;
                }
//                if (MyUtil.isMobile((lgPhone.getText().toString())) != true) {
//                    MyToast.show(context, "您输入的手机号码不合规，请重新输入！");
//                    return;
//                }
                postBackCode(lgPhone.getText().toString());
                break;
            case R.id.lg_Submission://提交
                if (lgSubmission.isSelected() == false) {
                    return;
                }
                if (lgPhone.getText().toString().length() != 11) {
                    MyToast.show(context, "您输入的手机号码不能少于11位、请重新输入！");
                    return;
                }
                if (indext == 0) {
                    if (lgYzm.getText().toString().length() != 6) {
                        MyToast.show(context, "您输入的验证码少于六位、请重新输入！");
                        return;
                    }
                }
                if (login_userGreen.isSelected() == false) {
                    MyToast.show(context, "您尚未同意用户协议、请同意后重试！");
                    return;
                }
                if (indext == 0) {
                    postBackLogin(lgPhone.getText().toString());
                } else {
                    login(lgPhone.getText().toString(), lgPwd.getText().toString());
                }
                break;
            case R.id.login_wx:
                WXEntryActivity.WXEStatics = "login";
                WXLogin();
                break;
            case R.id.login_qq:
                startAct(Act_BindCellPhone.class);
                break;
            case R.id.tabTv_registerLogin://注册登录切换
                login_login.setText("手机号首次登录即自动注册");
                setCholseStatus(0);
                setStatus();
                loginCode.setVisibility(View.VISIBLE);
                loginPwd.setVisibility(View.GONE);
                break;
            case R.id.tabTv_pwdLogin://密码登录切换
                login_login.setText("");
                setCholseStatus(1);
                setStatus();
                loginCode.setVisibility(View.GONE);
                loginPwd.setVisibility(View.VISIBLE);
                break;
            case R.id.login_wangjimima://忘记密码
                Intent intent = new Intent();
                intent.putExtra("isLogin", "yes");
                startAct(intent, Act_RechargePassword.class);
                break;
            case R.id.lg_UserAgreement://用户协议
                startAct(Act_UserAgreement.class);
                break;
            case R.id.login_userGreen1:
            case R.id.login_userGreen:
                login_userGreen.setSelected(!login_userGreen.isSelected());
                break;
            case R.id.Login_back:
                finish();
                break;
        }
    }

    /**
     * 发送验证码
     *
     * @param phone
     */
    public void postBackCode(String phone) {
        loding.show();
        HttpHelper.getVerificationCode(this, phone, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                if (entity.getCode() == 20000) {
                    lgTimer.start();
                    MyToast.show(context, "发送" + entity.getMessage());
                }
                loding.dismiss();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    /**
     * 验证码登录
     *
     * @param phone
     */
    public void postBackLogin(String phone) {
        loding.show();
        HttpHelper.registerAndLogin(this, phone, lgYzm.getText().toString(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                RegisterAndLoginBean entity = gson.fromJson(succeed, RegisterAndLoginBean.class);
                if (entity.getCode() == 20000) {
                    aCache.put("logn", succeed);
                    Intent intent = new Intent();
                    setResult(10, intent);
                    MyToast.show(context, "登录" + entity.getMessage());
                    finish();
                }
                loding.dismiss();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    /**
     * 密码登录
     *
     * @param phone
     */
    public void login(String phone, String pwd) {
        loding.show();
        HttpHelper.login(this, phone, pwd, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                RegisterAndLoginBean entity = gson.fromJson(succeed, RegisterAndLoginBean.class);
                if (entity.getCode() == 20000) {
                    aCache.put("logn", succeed);
                    Intent intent = new Intent();
                    setResult(10, intent);
                    finish();
                }
                loding.dismiss();
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
    /**
     * 切换字体状态
     */
    private int indext = 0;
    public void setCholseStatus(int status) {
        tabTv[indext].setTextSize(14);
        tabTv[indext].setTextColor(getResources().getColor(R.color.login_color));
        tabTv[indext].setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
        tabTv[status].setTextSize(39);
        tabTv[status].setTextColor(getResources().getColor(R.color.min_color));
        tabTv[status].setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        indext = status;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 微信登录
     */
    private void WXLogin() {
        WXapi = WXAPIFactory.createWXAPI(this, WX_APP_ID, true);
        WXapi.registerApp(WX_APP_ID);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        WXapi.sendReq(req);
    }
    /**
     * 根据不同状态设置不同颜色
     */
    public void setStatus() {
        if (StateDetection()) {
            lgSubmission.setBackgroundDrawable(getResources().getDrawable(R.drawable.lg_login_style));
            lgSubmission.setSelected(true);
        } else {
            lgSubmission.setBackgroundDrawable(getResources().getDrawable(R.drawable.lg_login_false));
        }
    }
    /**
     * 检查非空
     */
    public boolean StateDetection() {
        if (TextUtils.isEmpty(lgPhone.getText().toString())) {
            return false;
        }
        if (indext == 0) {//注册登录切换
            if (TextUtils.isEmpty(lgYzm.getText().toString())) {
                return false;
            }
            if (lgYzm.getText().toString().length() != 6) {
//                MyToast.show(context, "您输入的验证码少于六位、请重新输入！");
                return false;
            }
        } else {//密码登录
            if (TextUtils.isEmpty(lgPwd.getText().toString())) {
                return false;
            }
            if (lgPwd.getText().toString().length() < 6) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
