package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.HouseInspectionOrderDetailsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.DilogOderCancler;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 看房订单详情
 */
public class Act_HouseInspectionOrderDetails extends BaseActivity {
    @BindView(R.id.OrderDetails_back)
    ImageView OrderDetailsBack;
    @BindView(R.id.id_order)
    TextView idOrder;
    @BindView(R.id.time_created)
    TextView timeCreated;
    @BindView(R.id.status)
    TextView status;
    @BindView(R.id.num_order)
    TextView numOrder;
    @BindView(R.id.onlinebooking)
    TextView onlinebooking;
    @BindView(R.id.CustomerService)
    TextView CustomerService;
    @BindView(R.id.oader_img)
    RoundedImageView oader_img;
    @BindView(R.id.ll_buttom_status1)
    LinearLayout llButtomStatus1;
    @BindView(R.id.ll_buttom_status2)
    LinearLayout llButtomStatus2;
    @BindView(R.id.odredetaile_tuikuan)
    TextView odredetaileTuikuan;
    @BindView(R.id.odredetaile_zhifu)
    TextView odredetaileZhifu;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvContext)
    TextView tvContext;
    @BindView(R.id.phone_u)
    TextView phone_u;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.name_visitor)
    TextView name_visitor;
    @BindView(R.id.ll_buttom_status3)
    LinearLayout ll_buttom_status3;
    @BindView(R.id.time_begin_time_end)
    TextView time_begin_time_end;
    @BindView(R.id.orderdetails_evaluate)
    TextView orderdetails_evaluate;
    @BindView(R.id.ll_show)
    TextView ll_show;
    @BindView(R.id.ll_zhipaizhong)
    LinearLayout ll_zhipaizhong;
    @BindView(R.id.ll_youzhiyeguwen)
    LinearLayout ll_youzhiyeguwen;
    @BindView(R.id.zhiyeguwen)
    TextView zhiyeguwen;
    @BindView(R.id.price1)
    TextView price1;
    @BindView(R.id.price2)
    TextView price2;
    @BindView(R.id.ll_money)
    LinearLayout ll_money;
    @BindView(R.id.ll_buttom_status5)
    LinearLayout ll_buttom_status5;//立即评价

    @Override
    public int initLayoutId() {
        return R.layout.act_orderdetails;
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

    private String id_seeuser;

    @Override
    public void initData() {
        id_seeuser = getIntent().getStringExtra("id_seeuser");
//        time_begin = getIntent().getStringExtra("time_begin");
//        pic = getIntent().getStringExtra("pic");
        listEventAdmin();
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    /**
     * 获取数据看房详情
     */
    HouseInspectionOrderDetailsBean entity;

    public void listEventAdmin() {
        HttpHelper.listEventAdmin(this, id_seeuser, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                showNotInterNetLoading();
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, HouseInspectionOrderDetailsBean.class);
                if (entity == null) {
                    return;
                }
                Glide.with(context).load(entity.getResult().getPic()).into(oader_img);
                if (entity.getResult().getNum_order() != null) {
                    idOrder.setText(entity.getResult().getNum_order() + "");
                } else {
                    idOrder.setText(entity.getResult().getId_seeuser() + "");
                }
                time_begin_time_end.setText(MyTimeUtils.stampToDate(entity.getResult().getTime_begin(), "yyyy.MM.dd") + "-" + MyTimeUtils.stampToDate(entity.getResult().getTime_end(), "yyyy.MM.dd"));
                name_visitor.setText(entity.getResult().getName_visitor());
                phone_u.setText(entity.getResult().getPhone_u());
                count.setText(entity.getResult().getCount() + "人");
                numOrder.setText(MyApplication.getLoGinBean().getResult().getUser().getUsername() + "");
                tvTitle.setText(entity.getResult().getName_trip());
                tvContext.setText(MyTimeUtils.stampToDate(entity.getResult().getTime_begin(), "yyyy年MM月dd日") + "看房团报名");
                timeCreated.setText(MyTimeUtils.stampToDate(entity.getResult().getTime_created(), "yyyy.MM.dd HH:mm"));
                switch (entity.getResult().getStatus()) {
                    case "d"://意向订单
                        status.setText("意向单");
                        if (entity.getResult().getName_adviser() != null) {     //以前意向
                            onlinebooking.setVisibility(View.VISIBLE);
                            llButtomStatus1.setVisibility(View.VISIBLE);
                            ll_buttom_status3.setVisibility(View.GONE);
                            llButtomStatus2.setVisibility(View.GONE);
                            ll_youzhiyeguwen.setVisibility(View.VISIBLE);
                            zhiyeguwen.setText(entity.getResult().getName_adviser() + " " + entity.getResult().getPhone());
                        } else if (entity.getResult().getName_adviser() == null && (entity.getResult().getName_ins() != null)) {//现在
                            onlinebooking.setVisibility(View.GONE);
                            llButtomStatus1.setVisibility(View.GONE);
                            ll_buttom_status3.setVisibility(View.VISIBLE);
                            llButtomStatus2.setVisibility(View.GONE);
                            ll_show.setVisibility(View.GONE);
                            orderdetails_evaluate.setVisibility(View.GONE);
                            ll_zhipaizhong.setVisibility(View.VISIBLE);//置业顾问指派中
                        } else {//第三种
                            status.setText("待联系");
                            onlinebooking.setVisibility(View.GONE);
                            llButtomStatus1.setVisibility(View.GONE);
                            ll_buttom_status3.setVisibility(View.VISIBLE);
                            llButtomStatus2.setVisibility(View.GONE);
                        }
                        break;
                    case "p"://待付款
                        status.setText("待付款");
                        onlinebooking.setVisibility(View.VISIBLE);
                        llButtomStatus1.setVisibility(View.VISIBLE);
                        llButtomStatus2.setVisibility(View.GONE);
                        ll_buttom_status3.setVisibility(View.GONE);
                        ll_money.setVisibility(View.VISIBLE);
                        price1.setText("¥" + entity.getResult().getPrice());
                        price2.setText("¥" + "0");
                        break;
                    case "t"://已付款
                        status.setText("已付款");
                        onlinebooking.setVisibility(View.GONE);
                        llButtomStatus1.setVisibility(View.VISIBLE);
                        llButtomStatus2.setVisibility(View.GONE);
                        ll_buttom_status3.setVisibility(View.GONE);
                        price1.setText("¥" +entity.getResult().getPrice());
                        price2.setText("¥" + entity.getResult().getPrice());
                        ll_money.setVisibility(View.VISIBLE);
                        ll_youzhiyeguwen.setVisibility(View.VISIBLE);
                        zhiyeguwen.setText(entity.getResult().getName_adviser() + " " + entity.getResult().getPhone());
                        break;
                    case "f"://已取消
                        status.setText("已取消");
                        llButtomStatus1.setVisibility(View.GONE);
                        llButtomStatus2.setVisibility(View.GONE);
                        ll_buttom_status3.setVisibility(View.GONE);
                        break;
                    case "s"://已完成
                        status.setText("已完成");
                        llButtomStatus1.setVisibility(View.GONE);
                        llButtomStatus2.setVisibility(View.GONE);
                        ll_buttom_status3.setVisibility(View.GONE);
                        ll_money.setVisibility(View.VISIBLE);
                        price1.setText("¥" + "0");
                        price2.setText("¥" + entity.getResult().getPrice());
                        if (entity.getResult().getId_rate_c() != null) {

                        } else {
                            ll_buttom_status5.setVisibility(View.VISIBLE);
                        }
                        ll_youzhiyeguwen.setVisibility(View.VISIBLE);
                        zhiyeguwen.setText(entity.getResult().getName_adviser() + " " + entity.getResult().getPhone());
                        price1.setText("¥" + entity.getResult().getPrice());
                        price2.setText("¥" + entity.getResult().getPrice());
                        break;
                    case "x"://已退款
                        status.setText("已退款");
                        llButtomStatus1.setVisibility(View.GONE);
                        llButtomStatus2.setVisibility(View.VISIBLE);
                        ll_buttom_status3.setVisibility(View.GONE);
                        ll_money.setVisibility(View.VISIBLE);
                        price1.setText("¥" + "0");
                        price2.setText("¥" + entity.getResult().getPrice());
                        odredetaileTuikuan.setText("您的￥"+entity.getResult().getPrice()+"报名费已退还");
//                        odredetaileZhifu.setText("支付：￥" + entity.getResult().getPrice());
                        break;
                }
                showCView();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.OrderDetails_back, R.id.CustomerService, R.id.onlinebooking, R.id.lijipingjia
            , R.id.orderdetails_cancel, R.id.orderdetails_customerService, R.id.orderdetails_evaluate, R.id.CustomerService1, R.id.tuikuan})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.OrderDetails_back:
                finish();
                break;
            case R.id.CustomerService://联系顾问
            case R.id.CustomerService1:
                if (entity == null || entity.getResult().getPhone() == null || entity.getResult().getPhone().equals("")) {
                    MyToast.show(getContext(), "暂无置业顾问");
                    return;
                }
                MyUtils.callPhone(entity.getResult().getPhone() + "", this);
                break;
            case R.id.onlinebooking://取消订单
            case R.id.orderdetails_cancel:
                if (entity == null) {
                    return;
                }
//                Dilog_Login_Cler dilog_login_cler = new Dilog_Login_Cler(this, () -> eventOut(entity.getResult().getId_seeuser()), "您确定要取消该订单么？");
//                dilog_login_cler.show();
                DilogOderCancler dilog_login_cler = new DilogOderCancler(Act_HouseInspectionOrderDetails.this, new DilogOderCancler.OnBackCenter() {
                    @Override
                    public void onBackCenter(String neirong) {
                        eventOut(neirong);
                    }
                });
                dilog_login_cler.show();
                break;
            case R.id.orderdetails_customerService://联系客户
                if (entity == null || entity.getResult().getPhone() == null || entity.getResult().getPhone().equals("")) {
                    MyUtils.callPhone(ApiConstant.callPhone + "", this);
                    return;
                }
                MyUtils.callPhone(entity.getResult().getPhone() + "", this);
                break;
            case R.id.orderdetails_evaluate://评价邀请人
                if (entity.getResult().getId_rate_r() != null) {
                    MyToast.show(getContext(), "您已对邀请人做出评价！");
                    return;
                }
                intent.putExtra("actStatus", "INTENTION_evaluate");
                intent.putExtra("judgedId", entity.getResult().getId_recommend() + "");
                intent.putExtra("orderId", entity.getResult().getId_order() + "");
                intent.setClass(getContext(), Act_UserEvaluate.class);
                startActivityForResult(intent, 10);
                break;
            case R.id.tuikuan://申请退款

                break;
            case R.id.lijipingjia://立即评价
                if (entity.getResult().getId_rate_c() != null) {
                    MyToast.show(getContext(), "您已对置业顾问做出评价！");
                    return;
                }
                intent.putExtra("orderId", entity.getResult().getId_order());
                intent.putExtra("actStatus", "APPRAISE_APPRAISEGUWEN");
                intent.putExtra("judgedId", entity.getResult().getId_recommend() + "");
                startAct(intent, Act_UserEvaluate.class);
                break;
        }
    }

    /**
     * 退团申请
     */
    public void eventOut(String neirong) {
        loding.show();
        HttpHelper.eventOut(entity.getResult().getId_seeuser() + "", neirong,new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(getContext(), failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(getContext(), "取消理由已提交！");
                    setResult(10);
                    finish();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            finish();
        }
    }
}
