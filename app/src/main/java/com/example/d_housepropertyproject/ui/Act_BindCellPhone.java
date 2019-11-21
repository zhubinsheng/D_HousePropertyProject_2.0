package com.example.d_housepropertyproject.ui;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.bean.RegisterAndLoginBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.view.MyTimerText;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 绑定手机号
 */
public class Act_BindCellPhone extends BaseActivity {
    @BindView(R.id.BindCellPhone_phone)
    EditText BindCellPhonePhone;
    @BindView(R.id.BindCellPhone_yzm)
    EditText BindCellPhoneYzm;
    @BindView(R.id.BindCellPhone_Timer)
    MyTimerText BindCellPhoneTimer;
    @BindView(R.id.BindCellPhone_Submission)
    TextView BindCellPhoneSubmission;

    @Override
    public int initLayoutId() {
        return R.layout.act_bindcellphone;
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

    private String token;

    @Override
    public void initData() {
        BindCellPhonePhone.addTextChangedListener(textWatcher);
        BindCellPhoneYzm.addTextChangedListener(textWatcher);
        token = getIntent().getStringExtra("token");
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

    @OnClick({R.id.BindCellPhone_back, R.id.BindCellPhone_phone, R.id.BindCellPhone_yzm, R.id.BindCellPhone_Timer, R.id.BindCellPhone_Submission})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BindCellPhone_back:
                finish();
                break;
            case R.id.BindCellPhone_Timer:
                if (TextUtils.isEmpty(BindCellPhonePhone.getText().toString())) {
                    MyToast.show(context, "手机号码不能为空");
                    return;
                }
                if (BindCellPhonePhone.getText().toString().length() != 11) {
                    MyToast.show(context, "您输入的手机号码位数不对，请重新输入！");
                    return;
                }
//                if (MyUtil.isMobile((BindCellPhonePhone.getText().toString())) != true) {
//                    MyToast.show(context, "您输入的手机号码不合规，请重新输入！");
//                    return;
//                }
                postBackCode(BindCellPhonePhone.getText().toString());
                break;
            case R.id.BindCellPhone_Submission:
                if (BindCellPhoneSubmission.isSelected() == false) {
                    return;
                }
                if (BindCellPhonePhone.getText().toString().length() != 11) {
                    MyToast.show(context, "您输入的手机号码位数不对，请重新输入！");
                    return;
                }
//                if (MyUtil.isMobile((BindCellPhonePhone.getText().toString())) != true) {
//                    MyToast.show(context, "您输入的手机号码不合规，请重新输入！");
//                    return;
//                }
                if (BindCellPhoneYzm.getText().toString().length() != 6) {
                    MyToast.show(context, "您输入的验证码少于六位、请重新输入！");
                    return;
                }
                bindPhoneNumber(BindCellPhonePhone.getText().toString(), token, BindCellPhoneYzm.getText().toString());
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
                    BindCellPhoneTimer.start();
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
     * 微信绑定手机号
     *
     * @param phone
     */
    public void bindPhoneNumber(String phone, String token, String verificationCode) {
        loding.show();
        HttpHelper.bindPhoneNumber(this, phone, token, verificationCode, new HttpHelper.HttpUtilsCallBack<String>() {
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
                    MyToast.show(context, "绑定" + entity.getMessage());
                    MyApplication.setLoGinBean(entity);
                    Intent intent1 = new Intent();
                    startActClear(intent1, Act_Main.class);
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
            BindCellPhoneSubmission.setBackgroundDrawable(getResources().getDrawable(R.drawable.lg_login_style));
            BindCellPhoneSubmission.setSelected(true);
        } else {
            BindCellPhoneSubmission.setBackgroundDrawable(getResources().getDrawable(R.drawable.lg_login_false));
        }
    }

    /**
     * 检查非空
     */
    public boolean StateDetection() {
        if (TextUtils.isEmpty(BindCellPhonePhone.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(BindCellPhoneYzm.getText().toString())) {
            return false;
        }
        return true;
    }

}
