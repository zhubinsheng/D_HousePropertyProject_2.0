package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.PostJudgeAddBean;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.judgeinitBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.Dilog_Evaluate;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean.UserEvaluateBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 评价邀请人和评价置业顾问
 */
public class Act_UserEvaluate extends BaseAct implements Dilog_Evaluate.OnBackCenter {
    @BindView(R.id.evaluate_back)
    ImageView evaluateBack;
    @BindView(R.id.evaluate_title)
    TextView evaluateTitle;
    @BindView(R.id.evaluate_image)
    CircleImageView evaluateImage;
    @BindView(R.id.evaluate_nickname)
    TextView evaluateNickname;
    @BindView(R.id.evaluate_gaoji)
    TextView evaluateGaoji;
    @BindView(R.id.text)
    EditText text;
    @BindView(R.id.shuliang)
    TextView shuliang;
    @BindView(R.id.yaoqingren_rationgbar)
    RatingBar yaoqingren_rationgbar;
    @BindView(R.id.evaluate_grade)
    ImageView evaluate_grade;
    @BindView(R.id.ProblemFeedback_commit)
    TextView ProblemFeedbackCommit;
    @BindView(R.id.userevaluate_status)
    LinearLayout userevaluate_status;
    private String actStatus = "";
    private String type = "";
    private Dilog_Evaluate dialogEvaluate;

    @Override
    public int initLayoutId() {
        return R.layout.act_userevaluate;
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
        dialogEvaluate = new Dilog_Evaluate(Act_UserEvaluate.this, this);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                shuliang.setText(text.getText().toString().length() + "/50");
            }
        });
    }

    @Override
    public void initData() {
        actStatus = getIntent().getStringExtra("actStatus");
        if (actStatus.equals("INTENTION_evaluate")) {//意向订单=》评价邀请人
            type = "1";
            evaluateTitle.setText("评价邀请人");
            evaluate_grade.setVisibility(View.GONE);
            yaoqingren_rationgbar.setVisibility(View.VISIBLE);
            userevaluate_status.setVisibility(View.GONE);
        } else if (actStatus.equals("APPRAISE_APPRAISEGUWEN")) {//待评价=》评价置业顾问
            type = "2";
            evaluateTitle.setText("评价置业顾问");
            evaluate_grade.setVisibility(View.VISIBLE);
            yaoqingren_rationgbar.setVisibility(View.GONE);
            userevaluate_status.setVisibility(View.VISIBLE);
        }
        judgedId = getIntent().getStringExtra("judgedId");
        orderId = getIntent().getStringExtra("orderId");
        judgeinit();
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

    @OnClick({R.id.evaluate_back, R.id.ProblemFeedback_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.evaluate_back:
                if (actStatus.equals("APPRAISE_APPRAISEGUWEN") || actStatus.equals("INTENTION_evaluate")) {//待评价=》评价置业顾问  监听返回
                    dialogEvaluate.show();
                } else if (getIntent().getStringExtra("title") != null && getIntent().getStringExtra("title").equals("HouseInspection")) {//从报名页跳转过来
                    setResult(10);
                    finish();
                } else {
                    finish();
                }

                break;
            case R.id.ProblemFeedback_commit:
                if (actStatus.equals("INTENTION_evaluate")) {//意向订单=》评价邀请人
                    judgeAdd();
                } else if (actStatus.equals("APPRAISE_APPRAISEGUWEN")) {//待评价=》评价置业顾问
                    judgeAdd1();
                }
                break;
        }
    }

    /**
     * 新增评价信息  意向订单=》评价邀请人
     */
    public void judgeAdd() {
        String content = text.getText().toString();
//        if (TextUtils.isEmpty(content)) {
//            MyToast.show(context, "请输入您要评价内容！");
//            return;
//        }
        float score = yaoqingren_rationgbar.getRating();
        if (score == 0) {
            MyToast.show(context, "请打分！");
            return;
        }
        if (entity == null) {
            return;
        }
        String pJudgeItemId = entity.getResult().getPJudgeItemList().get(0).getId();
        String pJudgeItemName = entity.getResult().getPJudgeItemList().get(0).getTitle();
        loding.show();
        List<PostJudgeAddBean.PJudgeInfoVOArrayBean> pJudgeInfoVOArray = new ArrayList<>();
        PostJudgeAddBean.PJudgeInfoVOArrayBean pJudgeInfoVOArrayBean = new PostJudgeAddBean.PJudgeInfoVOArrayBean();
        pJudgeInfoVOArrayBean.setPJudgeItemId(pJudgeItemId);
        pJudgeInfoVOArrayBean.setPJudgeItemName(pJudgeItemName);
        pJudgeInfoVOArrayBean.setScore(score + "");
        pJudgeInfoVOArray.add(pJudgeInfoVOArrayBean);
        HttpHelper.judgeAdd(content, judgedId, orderId, pJudgeInfoVOArray, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                UserEvaluateBean entity = gson.fromJson(succeed, UserEvaluateBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "评论信息已提交成功！");
                    if (getIntent().getStringExtra("title") != null && getIntent().getStringExtra("title").equals("HouseInspection")) {//从报名页跳转过来
                        setResult(10);
                        finish();
                    } else {
                        setResult(10);
                        finish();
                    }
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
     * 新增评价信息  //待评价=》评价置业顾问
     */
    List<PostJudgeAddBean.PJudgeInfoVOArrayBean> pJudgeInfoVODatas = new ArrayList<>();

    public void judgeAdd1() {
        String content = text.getText().toString();
//        if (TextUtils.isEmpty(content)) {
//            MyToast.show(context, "请输入您要评价内容！");
//            return;
//        }
        if (entity == null) {
            return;
        }
//        for (int i = 0; i < pJudgeInfoVODatas.size(); i++) {
//            if (pJudgeInfoVODatas.get(i).getScore().equals("0")) {
//                MyToast.show(context, "请打分！");
//                return;
//            }
//        }
        loding.show();
        HttpHelper.judgeAdd(content, judgedId, orderId, pJudgeInfoVODatas, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                UserEvaluateBean entity = gson.fromJson(succeed, UserEvaluateBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "评论信息已提交成功！");
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
    private String judgedId = "", orderId = "";
    /**
     * 评价信息初始化
     */
    judgeinitBean entity;

    public void judgeinit() {
        HttpHelper.judgeinit(judgedId, type, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, judgeinitBean.class);
                Glide.with(context).load(entity.getResult().getPic()).into(evaluateImage);
                Glide.with(context).load(entity.getResult().getBusScaleLogo()).into(evaluate_grade);//金银铜等级
                evaluateNickname.setText(entity.getResult().getUserName());
                evaluateGaoji.setText(entity.getResult().getBusScaleName());
//                if (!actStatus.equals("APPRAISE_APPRAISEGUWEN")) {//待评价=》评价置业顾问
//                    return;
//                }
                for (int i = 0; i < entity.getResult().getPJudgeItemList().size(); i++) {
                    PostJudgeAddBean.PJudgeInfoVOArrayBean pJudgeInfoVOArrayBean = new PostJudgeAddBean.PJudgeInfoVOArrayBean();
                    pJudgeInfoVOArrayBean.setPJudgeItemId(entity.getResult().getPJudgeItemList().get(i).getId());
                    pJudgeInfoVOArrayBean.setPJudgeItemName(entity.getResult().getPJudgeItemList().get(0).getTitle());
                    pJudgeInfoVOArrayBean.setScore(0 + "");
                    pJudgeInfoVODatas.add(pJudgeInfoVOArrayBean);
                    View view = LayoutInflater.from(context).inflate(R.layout.view_userevaluate, null);
                    TextView name = view.findViewById(R.id.view_userevaluate_title);
                    name.setText(entity.getResult().getPJudgeItemList().get(i).getTitle());
                    RatingBar ratingBar = view.findViewById(R.id.view_userevaluate_titleratingbar);
                    ratingBar.setTag(i);
                    ratingBar.setOnRatingBarChangeListener((ratingBar1, v, b) -> {
                        pJudgeInfoVODatas.get(Integer.valueOf((Integer) ratingBar1.getTag())).setScore(String.valueOf(v));
                    });
                    userevaluate_status.addView(view);
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    @Override
    public void onBackCancle() {
        dialogEvaluate.dismiss();
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (getIntent().getStringExtra("title") != null && getIntent().getStringExtra("title").equals("HouseInspection")) {//从报名页跳转过来
            setResult(10);
            finish();
        } else {
            finish();
        }
        return true;
    }
}
