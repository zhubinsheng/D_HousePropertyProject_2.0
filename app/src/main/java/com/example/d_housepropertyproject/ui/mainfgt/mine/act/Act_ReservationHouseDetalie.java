package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_PaymentOrder;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderDetaileBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.Dilog_Login_Cler;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 订房订单详情
 */
public class Act_ReservationHouseDetalie extends BaseAct {
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
    @BindView(R.id.fanghao)
    TextView fanghao;
    @BindView(R.id.yangtai)
    TextView yangtai;
    @BindView(R.id.mianji)
    TextView mianji;
    @BindView(R.id.mianji1)
    TextView mianji1;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.ll_buttom_status3)
    RelativeLayout llButtomStatus3;
    @BindView(R.id.dingjia)
    TextView dingjing;
    @BindView(R.id.oder_Time)
    TextView oderTime;
    @BindView(R.id.name_p)
    TextView name_p;

    @Override
    public int initLayoutId() {
        return R.layout.act_reservationhousedetalie;
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

    private String odrid;

    @Override
    public void initData() {
        odrid = getIntent().getStringExtra("Id_order");
        orderInfoBook(odrid);
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

    @OnClick({R.id.OrderDetails_back, R.id.onlinebooking, R.id.ll_buttom_status3, R.id.daifukuan, R.id.concel_odr})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.OrderDetails_back:
                finish();
                break;
            case R.id.onlinebooking://联系置业顾问
            case R.id.ll_buttom_status3://联系置业顾问
                MyUtils.callPhone(ApiConstant.callPhone, this);
                break;
            case R.id.daifukuan://待付款
                if (orderDetaileBean == null) {
                    return;
                }
                if (time <= 0) {
                    MyToast.show(context, "您需要支付的订单已过期！");
                    return;
                }
                intent.putExtra("num_order", orderDetaileBean.getResult().getNum_order() + "");
                intent.putExtra("price", orderDetaileBean.getResult().getPrice() + "");
                intent.putExtra("Id_order", orderDetaileBean.getResult().getId_order() + "");
                startAct(intent, Act_PaymentOrder.class);
                break;
            case R.id.concel_odr://取消订单
                if (time <= 0) {
                    MyToast.show(context, "订单已超时、已自动取消！");
                    return;
                }
                Dilog_Login_Cler dilog_login_cler = new Dilog_Login_Cler(context, () -> goodsUpdateBookOut(odrid), "您确定要取消该订单么？");
                dilog_login_cler.show();
                break;
        }

    }

    OrderDetaileBean orderDetaileBean;

    /**
     * 订单详情
     */
    public void orderInfoBook(String odrid) {
        HttpHelper.orderInfoBook(this, odrid, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(getContext(), failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                orderDetaileBean = gson.fromJson(succeed, OrderDetaileBean.class);
                if (orderDetaileBean.getCode() == 20000) {
                    swiche();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    /**
     * 倒计时
     */
    public void timerStart(long time) {
        mTimer300 = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                long remainingSeconds = seconds % 60;
                oderTime.setText("（剩余" + String.valueOf(minutes) + ":" + String.valueOf(remainingSeconds) + "）");
//            mGoodsBuyOrderEndTime.setText("剩" + String.valueOf(minutes) + "分" + String.valueOf(remainingSeconds) + "秒自动结束");
//                Debug.e("--------------------------" + "剩" + String.valueOf(minutes) + "分" + String.valueOf(remainingSeconds) + "秒自动结束");
//                if (remainingSeconds == 0) {
//                    loding.show();
//                    orderInfoBook(odrid);
//                }
            }

            @Override
            public void onFinish() {
                finish();
            }
        };
    }

    private CountDownTimer mTimer300;
    long time = 0;

    /**
     * 根据值设置不同的显示方式
     */
    public void swiche() {
        Glide.with(context).load(orderDetaileBean.getResult().getPic()).into(oader_img);
        idOrder.setText(orderDetaileBean.getResult().getNum_order() + "");
        numOrder.setText(MyApplication.getLoGinBean().getResult().getUser().getUsername() + "");
        tvTitle.setText(orderDetaileBean.getResult().getName_e() + orderDetaileBean.getResult().getName_b() + orderDetaileBean.getResult().getName_u() + orderDetaileBean.getResult().getFanghao() + "");
        timeCreated.setText(MyTimeUtils.stampToDate(orderDetaileBean.getResult().getCreated(), "yyyy.MM.dd HH:mm"));
        fanghao.setText(orderDetaileBean.getResult().getCode() + "");
        yangtai.setText(orderDetaileBean.getResult().getYangtai() + "m²");
        mianji.setText(orderDetaileBean.getResult().getMianji() + "m²");
        mianji1.setText(orderDetaileBean.getResult().getMianji() + "m²");
        price.setText(orderDetaileBean.getResult().getJiage() + "万");
        dingjing.setText(orderDetaileBean.getResult().getPrice() + "元");//定
        name_p.setText(orderDetaileBean.getResult().getName_p());
        switch (orderDetaileBean.getResult().getStatus()) {
            case "p"://待付款
                Long endTime = System.currentTimeMillis();
                time = Long.parseLong(orderDetaileBean.getResult().getInvalid()) - endTime;
                timerStart(time);
                if (time > 0) {
                    mTimer300.start();
                }
                status.setText("待付款");
                llButtomStatus1.setVisibility(View.VISIBLE);
                llButtomStatus2.setVisibility(View.GONE);
                llButtomStatus3.setVisibility(View.GONE);
//                daifukuan.setText("付定金：￥" + orderDetaileBean.getResult().getPrice());
                break;
            case "s"://已预订
                status.setText("已预订");
                llButtomStatus1.setVisibility(View.GONE);
                llButtomStatus2.setVisibility(View.GONE);
                llButtomStatus3.setVisibility(View.VISIBLE);
                break;
            case "f"://已取消=>全部隐藏
                status.setText("已取消");
                llButtomStatus1.setVisibility(View.GONE);
                llButtomStatus2.setVisibility(View.GONE);
                llButtomStatus3.setVisibility(View.GONE);
                break;
            case "x"://待退款
                status.setText("待退款");
                llButtomStatus1.setVisibility(View.GONE);
                llButtomStatus2.setVisibility(View.GONE);
                llButtomStatus3.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer300 != null) {
            mTimer300.cancel();
        }
    }

    /**
     * 取消订单
     */
    public void goodsUpdateBookOut(String id_order) {
        HttpHelper.goodsUpdateBookOut(id_order, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "您已成功取消订单！");
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
