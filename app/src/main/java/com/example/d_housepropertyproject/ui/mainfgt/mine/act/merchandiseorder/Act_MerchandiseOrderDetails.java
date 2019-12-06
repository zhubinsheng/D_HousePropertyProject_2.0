package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter.MyOrderDetaleAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.MyOrderDetaleBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryOrdersetBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 商品订单详情
 */
public class Act_MerchandiseOrderDetails extends BaseAct {
    @BindView(R.id.consultation_back)
    ImageView consultationBack;
    @BindView(R.id.myorderdetale_RecyclerView)
    RecyclerView myorderdetaleRecyclerView;
    @BindView(R.id.total)
    TextView total;
    @BindView(R.id.total1)
    TextView total1;
    @BindView(R.id.no)
    TextView no;
    @BindView(R.id.linkmanphone)
    TextView linkmanphone;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.oderTime)
    TextView oderTime;
    @BindView(R.id.oder_payView)
    RelativeLayout oderPayView;
    @BindView(R.id.tv_shouhuo)
    TextView tvShouhuo;
    private CountDownTimer mTimer;

    @Override
    public int initLayoutId() {
        return R.layout.act_merchandiseorderdetails;
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        myorderdetaleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    List<MyOrderDetaleBean.ResultBean.ProductsBean> data = new ArrayList<>();
    private String id = "";
    MyOrderDetaleAdapter adapter;

    @Override
    public void initData() {
        id = getIntent().getStringExtra("id");
        adapter = new MyOrderDetaleAdapter(data);
        myorderdetaleRecyclerView.setAdapter(adapter);
        pmsorderqueryinfocustomer();
        orderQueryOrderset();
    }

    /**
     * 倒计时
     */
    public void timerStart(long time) {
        mTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                long remainingSeconds = seconds % 60;
                oderTime.setText("请在" + String.valueOf(minutes) + "分" + String.valueOf(remainingSeconds) + "秒内完成支付");
            }

            @Override
            public void onFinish() {
                finish();
            }
        };
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    /**
     * 订单详情
     */
    public void pmsorderqueryinfocustomer() {
        HttpHelper.pmsorderqueryinfocustomer(id, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(Act_MerchandiseOrderDetails.this, failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                MyOrderDetaleBean entity = gson.fromJson(succeed, MyOrderDetaleBean.class);
                if (entity.getCode() == 20000) {
                    data.addAll(entity.getResult().getProducts());
                    adapter.notifyDataSetChanged();
                    total.setText("¥" + entity.getResult().getTotal());
                    total1.setText("¥" + entity.getResult().getTotal());
                    no.setText(entity.getResult().getNo());
                    linkmanphone.setText(entity.getResult().getLinkman() + " " + entity.getResult().getPhone());
                    address.setText(entity.getResult().getAddress());
                    time.setText(MyTimeUtils.dateToStampTimeHH(entity.getResult().getTime()));
                    switch (entity.getResult().getStatus()) {
                        case "j"://待收货
                            tvShouhuo.setVisibility(View.VISIBLE);
                            oderPayView.setVisibility(View.GONE);
                            break;
                        case "d"://待发货
                            tvShouhuo.setVisibility(View.GONE);
                            oderPayView.setVisibility(View.VISIBLE);
                            break;
                        default:
                            tvShouhuo.setVisibility(View.GONE);
                            oderPayView.setVisibility(View.GONE);
                            break;
                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(Act_MerchandiseOrderDetails.this, error);
            }
        });
    }

    /**
     * 设置信息
     */
    public void orderQueryOrderset() {
        HttpHelper.orderQueryOrderset(new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(Act_MerchandiseOrderDetails.this, failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                orderQueryOrdersetBean entity = gson.fromJson(succeed, orderQueryOrdersetBean.class);
                if (entity.getCode() == 20000) {
                    for (int i = 0; i < entity.getResult().size(); i++) {
                        if (entity.getResult().get(i).getCode().equals("l") && entity.getResult().get(i).getType().equals("p")) {
                            long minute = 60 * entity.getResult().get(i).getTimeLimit() * 1000;// 分钟前
                            timerStart(minute);
                            mTimer.start();
                        }
                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(Act_MerchandiseOrderDetails.this, error);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.consultation_back, R.id.oder_cancle, R.id.tv_shouhuo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.consultation_back:
                finish();
                break;
            case R.id.oder_cancle://取消订单

                break;
            case R.id.oder_pay://立即支付

                break;
            case R.id.tv_shouhuo://确认收货

                break;
        }
    }
}
