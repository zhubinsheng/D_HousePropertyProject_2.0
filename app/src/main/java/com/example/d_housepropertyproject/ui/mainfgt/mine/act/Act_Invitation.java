package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.InvitationBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 绑定邀请人
 */
public class Act_Invitation extends BaseAct {
    @BindView(R.id.Invitation_back)
    ImageView InvitationBack;
    @BindView(R.id.Invitation_Preservation)
    TextView InvitationPreservation;
    @BindView(R.id.Invitation_input)
    EditText InvitationInput;

    @Override
    public int initLayoutId() {
        return R.layout.act_invitation;
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

    @OnClick({R.id.Invitation_back, R.id.Invitation_Preservation, R.id.Invitation_input})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Invitation_back:
                finish();
                break;
            case R.id.Invitation_Preservation:
                userUpdateMemberUserById(InvitationInput.getText().toString());
                break;
        }
    }

    /**
     * 提交邀请人手机号码
     */
    public void userUpdateMemberUserById(String recommender) {
        if (TextUtils.isEmpty(recommender)) {
            MyToast.show(context, "请输入您的邀请人手机号码！");
            return;
        }
        loding.show();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("recommender", recommender);
        HttpHelper.updateMemberUserById(this,hashMap, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                InvitationBean entity = gson.fromJson(succeed, InvitationBean.class);
                if (entity.getCode() == 20000) {
                    MyApplication.getUserGetUserBean().getResult().getData().setRecommenderPhone(recommender);
                    MyToast.show(context, "邀请人提交" + entity.getMessage());
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
}
