package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
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
 * 手机号修改
 */
public class Act_ModifyCellPhone extends BaseAct {
    public int viewStatus = 1;//界面显示状态 1：旧手机验证、2:绑定手机号\
    @BindView(R.id.modifycellphone_back)
    ImageView modifycellphoneBack;
    @BindView(R.id.modifycellphone_title)
    TextView modifycellphoneTitle;
    @BindView(R.id.modifycellphone_Phone)
    EditText modifycellphonePhone;
    @BindView(R.id.lg_Timer)
    MyTimerText lgTimer;
    @BindView(R.id.modifycellphone_yzm)
    EditText modifycellphoneYzm;
    @BindView(R.id.lg_Submission)
    TextView lgSubmission;

    @Override
    public int initLayoutId() {
        return R.layout.act_modifycellphone;
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
        if (MyApplication.getLoGinBean() == null) {
            return;
        }
        modifycellphonePhone.setText(MyApplication.getLoGinBean().getResult().getUser().getPhone() + "");
        modifycellphonePhone.setFocusable(false);
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

    @OnClick({R.id.modifycellphone_back, R.id.modifycellphone_title, R.id.modifycellphone_Phone, R.id.lg_Timer, R.id.modifycellphone_yzm, R.id.lg_Submission})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.modifycellphone_back:
                if (viewStatus == 1) {
                    finish();
                    return;
                }
                modifycellphonePhone.setFocusable(false);
                modifycellphonePhone.setText(MyApplication.getLoGinBean().getResult().getUser().getPhone() + "");
                modifycellphoneTitle.setText("旧手机验证");
                viewStatus--;
                break;
            case R.id.modifycellphone_title:
                break;
            case R.id.modifycellphone_Phone:
                break;
            case R.id.lg_Timer:
                if (TextUtils.isEmpty(modifycellphonePhone.getText().toString())) {
                    MyToast.show(context, "手机号码不能为空");
                    return;
                }
                if (modifycellphonePhone.getText().toString().length() != 11) {
                    MyToast.show(context, "您输入的手机号码位数不对，请重新输入！");
                    return;
                }
                postBackCode(modifycellphonePhone.getText().toString());
                break;
            case R.id.lg_Submission:
                code = modifycellphoneYzm.getText().toString();
                if (TextUtils.isEmpty(modifycellphonePhone.getText().toString())) {
                    MyToast.show(context, "您还未输入手机号码！");
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    MyToast.show(context, "您还未输入验证码！");
                    return;
                }
                if (viewStatus == 1) {
                    getCertificateByOldPhone();
                } else if (viewStatus == 2) {
                    userUpdateMemberUserById();
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (viewStatus == 1) {
                finish();
                return true;
            }
            viewStatus--;
            modifycellphoneTitle.setText("旧手机验证");
            return true;
        }
        return true;
    }


    /**
     * 发送验证码
     *
     * @param phone
     */
    private String code = "";

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
     * 旧手机验证
     */
    public void getCertificateByOldPhone() {
        loding.show();
        HttpHelper.getCertificateByVerificationCode(this, MyApplication.getLoGinBean().getResult().getUser().getPhone()+"", code, new HttpHelper.HttpUtilsCallBack<String>() {
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
                    MyToast.show(context, "验证" + entity.getMessage());
                    certificate = entity.getResult();
                    viewStatus = 2;
                    modifycellphoneYzm.setText("");
                    modifycellphoneTitle.setText("绑定手机号");
                    modifycellphonePhone.setFocusable(true);
                    modifycellphonePhone.requestFocus();
                    modifycellphonePhone.setFocusableInTouchMode(true);
                    modifycellphonePhone.setText("");
                    lgTimer.end();
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

    private String certificate;

    /**
     * 绑定新手机号
     */
    public void userUpdateMemberUserById() {
        loding.show();
        HttpHelper.userUpdateMemberUserPhone(this, certificate, modifycellphonePhone.getText().toString(), code, new HttpHelper.HttpUtilsCallBack<String>() {
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
                    MyApplication.getLoGinBean().getResult().getUser().setPhone(modifycellphonePhone.getText().toString());
                    MyToast.show(context, "修改" + entity.getMessage());
                    setResult(10);
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

        return true;
    }
}
