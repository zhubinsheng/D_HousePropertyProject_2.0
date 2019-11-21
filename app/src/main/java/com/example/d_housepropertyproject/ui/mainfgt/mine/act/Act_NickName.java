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
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UserGetUserBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 昵称修改
 */
public class Act_NickName extends BaseAct {
    @BindView(R.id.NickName_back)
    ImageView NickNameBack;
    @BindView(R.id.NickName_Preservation)
    TextView NickNamePreservation;
    @BindView(R.id.nickName_input)
    EditText nickNameInput;

    @Override
    public int initLayoutId() {
        return R.layout.act_nickname;
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
        if (TextUtils.isEmpty(MyApplication.getLoGinBean().getResult().getUser().getUsername())) {
            return;
        }
        nickNameInput.setText(MyApplication.getLoGinBean().getResult().getUser().getUsername());
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

    @OnClick({R.id.NickName_back, R.id.NickName_Preservation, R.id.nickName_input})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.NickName_back:
                finish();
                break;
            case R.id.NickName_Preservation://保存
                if (TextUtils.isEmpty(nickNameInput.getText().toString())) {
                    MyToast.show(context, "您还没有填写需要修改的昵称！");
                    return;
                }
                if(nickNameInput.getText().toString().length()>12){
                    MyToast.show(context,"您输入的昵称不能超过12个字符");
                    return;
                }
                updateMemberUserById();
                break;
            case R.id.nickName_input:
                break;
        }
    }
    /**
     * 修改昵称
     */
    public void updateMemberUserById() {
        loding.show();
        HttpHelper.updateMemberUserById(this,nickNameInput.getText().toString(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                UserGetUserBean entity = gson.fromJson(succeed, UserGetUserBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "恭喜您！昵称修改成功！");
                    MyApplication.getLoGinBean().getResult().getUser().setUsername(nickNameInput.getText().toString());
                    setResult(10);
                    finish();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
}
