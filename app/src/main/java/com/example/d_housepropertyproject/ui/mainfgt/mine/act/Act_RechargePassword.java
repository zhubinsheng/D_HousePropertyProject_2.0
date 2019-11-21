package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.CertificateVerificationBean;
import com.example.d_housepropertyproject.view.MyTimerText;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 重置密码
 */
public class Act_RechargePassword extends BaseAct {

    @BindView(R.id.modifycellphone_back)
    ImageView modifycellphoneBack;
    @BindView(R.id.modifycellphone_title)
    TextView modifycellphoneTitle;
    @BindView(R.id.RechargePassword_Phone)
    EditText RechargePasswordPhone;
    @BindView(R.id.lg_Timer)
    MyTimerText lgTimer;
    @BindView(R.id.RechargePassword_yzm)
    EditText RechargePasswordYzm;
    @BindView(R.id.RechargePassword_pwd1)
    EditText RechargePasswordPwd1;
    @BindView(R.id.RechargePassword_pwd2)
    EditText RechargePasswordPwd2;
    @BindView(R.id.RechargePassword_Submission)
    TextView RechargePasswordSubmission;
    private String token = "";

    @Override
    public int initLayoutId() {
        return R.layout.act_rechargepassword;
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
        if (getIntent().getStringExtra("isLogin") == null) {
            RechargePasswordPhone.setFocusable(false);
            token = MyApplication.getLoGinBean().getResult().getToken();
            RechargePasswordPhone.setText(MyApplication.getLoGinBean().getResult().getUser().getPhone()+"");
        } else {
            modifycellphoneTitle.setText("找回密码");
        }
    }

    @Override
    public void initData() {
        RechargePasswordPhone.addTextChangedListener(textWatcher);
        RechargePasswordYzm.addTextChangedListener(textWatcher);
        RechargePasswordPwd1.addTextChangedListener(textWatcher);
        RechargePasswordPwd2.addTextChangedListener(textWatcher);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.modifycellphone_back, R.id.lg_Timer, R.id.RechargePassword_Submission})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.modifycellphone_back:
                finish();
                break;
            case R.id.lg_Timer:
                if (getIntent().getStringExtra("isLogin") == null) {
                    postBackCode(MyApplication.getLoGinBean().getResult().getUser().getPhone()+"");
                } else {
                    if (TextUtils.isEmpty(RechargePasswordPhone.getText().toString())) {
                        MyToast.show(context, "您还未输入手机号码");
                        return;
                    }
                    if (RechargePasswordPhone.getText().toString().length() != 11) {
                        MyToast.show(context, "您输入的手机号码位数不对");
                        return;
                    }
                    postBackCode(RechargePasswordPhone.getText().toString());
                }
                break;
            case R.id.RechargePassword_Submission:
                userUpdateMemberUserById();
                break;
        }
    }

    /**
     * 发送验证码
     *
     * @param phone
     */
    private String code = "";

    public void postBackCode(String phone) {
        loding.show();
        HttpHelper.getVerificationCode(this,phone, new HttpHelper.HttpUtilsCallBack<String>() {
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
     * 设置密码
     */
    public void userUpdateMemberUserById() {
        if (RechargePasswordSubmission.isSelected() == false) {
            return;
        }
        if (RechargePasswordPhone.getText().toString().length() != 11) {
            MyToast.show(context, "您输入的手机号码不能少于11位、请重新输入！");
            return;
        }
        if (RechargePasswordYzm.getText().toString().length() != 6) {
            MyToast.show(context, "您输入的验证码少于六位、请重新输入！");
            return;
        }
        if (!RechargePasswordPwd2.getText().toString().equals(RechargePasswordPwd1.getText().toString())) {
            MyToast.show(context, "您两次输入的密码不一致、请重新输入！");
            return;
        }
        loding.show();
        HttpHelper.forgetPassword(this,RechargePasswordPwd2.getText().toString(), RechargePasswordPhone.getText().toString(), RechargePasswordYzm.getText().toString(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                CertificateVerificationBean entity = gson.fromJson(succeed, CertificateVerificationBean.class);
                if (entity.getCode() == 20000) {
                    if (MyApplication.getLoGinBean() != null) {
                        MyApplication.getLoGinBean().getResult().getUser().setPassword(RechargePasswordPwd2.getText().toString());
                    }
                    MyToast.show(context, "设置密码" + entity.getMessage());
                    finish();
                } else {
                    MyToast.show(context, entity.getMessage());
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
     * 根据不同状态设置不同颜色
     */
    public void setStatus() {
        if (StateDetection()) {
            RechargePasswordSubmission.setBackgroundDrawable(getResources().getDrawable(R.drawable.lg_login_style));
            RechargePasswordSubmission.setSelected(true);
        } else {
            RechargePasswordSubmission.setBackgroundDrawable(getResources().getDrawable(R.drawable.lg_login_false));
        }
    }

    /**
     * 检查非空
     */
    public boolean StateDetection() {
        if (TextUtils.isEmpty(RechargePasswordPhone.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(RechargePasswordYzm.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(RechargePasswordPwd1.getText().toString()) || TextUtils.isEmpty(RechargePasswordPwd2.getText().toString())) {
            return false;
        }
        if (RechargePasswordPwd1.getText().toString().length() < 6) {
            return false;
        }
        if (RechargePasswordPwd2.getText().toString().length() < 6) {
            return false;
        }
        return true;
    }
}
