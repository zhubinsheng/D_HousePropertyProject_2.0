package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.AddUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.CheckUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.QueryInfoBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.Dilog_ChoseDateBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_ChoseDate;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_RegistrationResult;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_TestingDate;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_HouseOrder;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_UserEvaluate;
import com.example.d_housepropertyproject.view.HouseinspectionTimerText;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页=立即报名=户型详情=看房团报名
 */
public class Act_HouseInspection extends BaseActivity implements Dilog_ChoseDate.OnBackTime, Dilog_TestingDate.OnBackCenter {
    @BindView(R.id.HouseInspection_startTime)
    EditText HouseInspectionStartTime;
    @BindView(R.id.HouseInspection_Name)
    EditText HouseInspectionName;
    @BindView(R.id.HouseInspection_Number)
    EditText HouseInspectionNumber;
    @BindView(R.id.HouseInspection_Phone)
    EditText HouseInspectionPhone;
    @BindView(R.id.lg_Timer)
    HouseinspectionTimerText lgTimer;
    @BindView(R.id.HouseInspection_RadioButton)
    TextView HouseInspection_RadioButton;
    @BindView(R.id.HouseInspection_commit)
    TextView HouseInspectionCommit;
    @BindView(R.id.HouseInspection_Code)
    EditText HouseInspectionCode;
    @BindView(R.id.houseinspection_img)
    RoundedImageView houseinspection_img;
    private Dilog_ChoseDate dilog_choseDate;
    private Dilog_TestingDate testingDlog;//未报名完成
    private Dilog_RegistrationResult registrationResult;//报名结果果
    private String id_event;
    private String Pic;

    @Override
    public int initLayoutId() {
        return R.layout.act_houseinspection;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    String orderId = "";

    @Override
    public void initView() {
        id_event = getIntent().getStringExtra("id_event");
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        registrationResult = new Dilog_RegistrationResult(this, () -> {
            if (MyApplication.getLoGinBean() != null && MyApplication.getUserGetUserBean() != null) {
                Intent intent = new Intent();
                intent.putExtra("title", "HouseInspection");
                intent.putExtra("actStatus", "INTENTION_evaluate");
                intent.putExtra("judgedId", MyApplication.getUserGetUserBean().getResult().getData().getRecommender() + "");
                intent.putExtra("orderId", orderId + "");
                intent.setClass(getApplicationContext(), Act_UserEvaluate.class);
                startActivityForResult(intent, 10);
            } else if (MyApplication.getLoGinBean() != null && MyApplication.getUserGetUserBean() == null) {
                startAct(Act_HouseOrder.class);
            } else {
                finish();
            }
        });
    }

    @Override
    public void initData() {
        testingDlog = new Dilog_TestingDate(this, this);
        dilog_choseDate = new Dilog_ChoseDate(this, this);
        HouseInspectionName.addTextChangedListener(textWatcher);
        HouseInspectionNumber.addTextChangedListener(textWatcher);
        HouseInspectionPhone.addTextChangedListener(textWatcher);
        HouseInspectionCode.addTextChangedListener(textWatcher);
        HouseInspection_RadioButton.setSelected(true);
        queryinfo();
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            HouseInspectionCommit.setSelected(coomitStatus());
        }
    };

    @OnClick({R.id.HouseInspection_back, R.id.HouseInspection_call, R.id.lg_Timer, R.id.HouseInspection_commit
            , R.id.re_startTime, R.id.HouseInspection_Explain, R.id.HouseInspection_RadioButton, R.id.HouseInspection_xuzhi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.HouseInspection_back:
                finish();
                break;
            case R.id.HouseInspection_call://电话
                MyUtils.callPhone(ApiConstant.callPhone, this);
                break;
            case R.id.lg_Timer:
                if (TextUtils.isEmpty(HouseInspectionPhone.getText().toString())) {
                    MyToast.show(context, "手机号码不能为空");
                    return;
                }
                if (HouseInspectionPhone.getText().toString().length() != 11) {
                    MyToast.show(context, "您输入的手机号码位数不对，请重新输入！");
                    return;
                }
                postBackCode(HouseInspectionPhone.getText().toString());
                break;
            case R.id.HouseInspection_commit:
                if (HouseInspectionCommit.isSelected() == false) {
                    MyToast.show(context, "请检查您的参数是否输入完整！");
                    return;
                }
                if (HouseInspectionName.getText().length() < 2) {
                    MyToast.show(context, "输入的名字不能少于2个字符！");
                    return;
                }
                if (HouseInspectionName.getText().length() < 2) {
                    MyToast.show(context, "报名人数不能超过一百人");
                    return;
                }
                if (HouseInspectionPhone.getText().toString().length() != 11) {
                    MyToast.show(context, "您输入的手机号码位数不对，请重新输入！");
                    return;
                }
                if (HouseInspection_RadioButton.isSelected() == false) {
                    MyToast.show(context, "您尚未同意看房协议、请同意后重试！");
                    return;
                }
                if (HouseInspectionCode.getText().toString().length() != 6) {
                    MyToast.show(context, "请输入六位数验证码！");
                    return;
                }
                checkUser();
                break;
            case R.id.re_startTime://出发时间
                if (queryInfoBean != null && queryInfoBean.getResult().getTime().size() != 0) {
                    dilog_choseDate.setData(data);
                    dilog_choseDate.show();
                } else {
                    MyToast.show(context, "暂未获取到有效时间！");
                }
                break;
            case R.id.HouseInspection_Explain://看房说明
                startAct(Act_Explain.class);
                break;
            case R.id.HouseInspection_RadioButton:
                HouseInspection_RadioButton.setSelected(!HouseInspection_RadioButton.isSelected());
                break;
            case R.id.HouseInspection_xuzhi://参团需知
                startAct(Act_Instructionsforparticipatinginthemission.class);
                break;
        }
    }

    /**
     * 返回时间
     *
     * @param time
     */
    @Override
    public void onBackDate(int position, String time) {
        id_time = queryInfoBean.getResult().getTime().get(position).getId();
        HouseInspectionStartTime.setText(time);
        HouseInspectionCommit.setSelected(coomitStatus());
    }

    /**
     * 检测用户输入完整度
     *
     * @return
     */
    public boolean coomitStatus() {
        if (TextUtils.isEmpty(HouseInspectionStartTime.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(HouseInspectionName.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(HouseInspectionNumber.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(HouseInspectionPhone.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(HouseInspectionCode.getText().toString())) {
            return false;
        }
        return true;
    }

    /**
     * 报名校验
     */
    CheckUserBean entity;

    public void checkUser() {
        loding.show();
        HttpHelper.checkUser(this, HouseInspectionCode.getText().toString(), HouseInspectionPhone.getText().toString(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, CheckUserBean.class);
                if (entity.getResult().isHas()) {
                    testingDlog.show();
                } else {
                    addUser();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    /**
     * 活动报名
     */
    private String id_time = "";

    public void addUser() {
        if (entity == null) {
            return;
        }
        HttpHelper.addUser(this, HouseInspectionNumber.getText().toString(),
                id_time,
                entity.getResult().getId_user(),
                HouseInspectionName.getText().toString(),
                HouseInspectionPhone.getText().toString(), new HttpHelper.HttpUtilsCallBack<String>() {
                    @Override
                    public void onFailure(String failure) {
                        MyToast.show(context, failure);
                        loding.dismiss();
                    }

                    @Override
                    public void onSucceed(String succeed) {
                        loding.dismiss();
                        try {
                            Gson gson = new Gson();
                            AddUserBean entity = gson.fromJson(succeed, AddUserBean.class);
                            if (entity.getCode() == 20000) {
                                registrationResult.show();//报名成功
                                orderId = entity.getResult();
                            } else {

                            }
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onError(String error) {
                        loding.dismiss();
                        MyToast.show(context, error);
                    }
                });
    }

    /**
     * 获取出发时间
     */
    QueryInfoBean queryInfoBean;
    List<Dilog_ChoseDateBean> data = new ArrayList<>();

    public void queryinfo() {
        data.clear();
        HttpHelper.queryinfo(this, id_event, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                try {
                    Gson gson = new Gson();
                    queryInfoBean = gson.fromJson(succeed, QueryInfoBean.class);
                    if (queryInfoBean.getCode() == 20000) {
                        for (int i = 0; i < queryInfoBean.getResult().getTime().size(); i++) {
                            Dilog_ChoseDateBean bean = new Dilog_ChoseDateBean();
                            if (i == 0) {
                                bean.setStatus(true);
                            } else {
                                bean.setStatus(false);
                            }
                            String begen = timeStamp2Date(queryInfoBean.getResult().getTime().get(i).getTime_begin());
                            String end = timeStamp2Date(queryInfoBean.getResult().getTime().get(i).getTime_end());
                            bean.setTime(begen
                                    + "-" + end);
                            data.add(bean);
                        }
                        if (houseinspection_img == null) {
                            return;
                        }
                        if (queryInfoBean == null) {
                            return;
                        }
                        Glide.with(context).load(queryInfoBean.getResult().getPic()).into(houseinspection_img);
                    } else {
                        MyToast.show(context, queryInfoBean.getMessage());
                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    public static String timeStamp2Date(String time) {
        Long timeLong = Long.parseLong(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
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
                    MyToast.show(context, "验证码发送" + entity.getMessage());
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
     * 未完成。。弹出框 确认
     */
    @Override
    public void onBackCenter() {
        addUser();
    }

    /**
     * 未完成。。弹出框 取消
     */
    @Override
    public void onBackCancle() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&&resultCode==10){
            finish();
        }
    }
}
