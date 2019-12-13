package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.MessageStatus;
import com.example.d_housepropertyproject.bean.vipAliUnifiedOrderBean;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.AuthResult;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.tool.PayResult;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_HousePropertyCustomerService;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionWXUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_Pay;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter.MyOrderDetaleAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.MyOrderDetaleBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryOrdersetBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderUpdateCancelBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.Dilog_Login_Cler;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lykj.aextreme.afinal.utils.TimeUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhouyou.http.EasyHttp.getContext;


/**
 * 商品订单详情
 */
public class Act_MerchandiseOrderDetails extends BaseAct implements Dilog_Pay.OnBackCenter {
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
    @BindView(R.id.oderWuLiu)
    TextView oderWuLiu;
    @BindView(R.id.firmName)
    TextView firmName;
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
        EventBus.getDefault().register(this);
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
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(MessageStatus message) {
        switch (message.status) {
            case "3"://更新状态
                setResult(10);
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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

    private MyOrderDetaleBean entity;

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
                entity = gson.fromJson(succeed, MyOrderDetaleBean.class);
                if (entity.getCode() == 20000) {
                    data.addAll(entity.getResult().getProducts());
                    adapter.notifyDataSetChanged();
                    total.setText("¥" + entity.getResult().getTotal());
                    total1.setText("¥" + entity.getResult().getTotal());
                    no.setText(entity.getResult().getNo());
                    linkmanphone.setText(entity.getResult().getLinkman() + " " + entity.getResult().getPhone());
                    address.setText(entity.getResult().getAddress());
                    time.setText(MyTimeUtils.dateToStampTimeHH(entity.getResult().getTime()));
                    firmName.setText(entity.getResult().getFirmName());
                    switch (entity.getResult().getStatus()) {
                        case "j"://待收货
                            tvShouhuo.setVisibility(View.VISIBLE);
                            oderWuLiu.setVisibility(View.VISIBLE);
                            oderPayView.setVisibility(View.GONE);
                            break;
                        case "d"://待发货
                            if (entity.getResult().getPay_status().equals("p")) {//待付款
                                tvShouhuo.setVisibility(View.GONE);
                                oderWuLiu.setVisibility(View.GONE);
                                oderPayView.setVisibility(View.VISIBLE);
                                oderTime.setVisibility(View.VISIBLE);
                                orderQueryOrderset();
                            } else if (entity.getResult().getPay_status().equals("s")) {//已付款=》待发货
                                tvShouhuo.setVisibility(View.GONE);
                                oderWuLiu.setVisibility(View.GONE);
                                oderPayView.setVisibility(View.GONE);
                                oderTime.setVisibility(View.GONE);
                            } else {//已付款
                                oderWuLiu.setVisibility(View.VISIBLE);
                                oderTime.setVisibility(View.GONE);
                                tvShouhuo.setVisibility(View.VISIBLE);
                                oderPayView.setVisibility(View.GONE);
                            }
                            break;
                        default:
                            oderTime.setVisibility(View.GONE);
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
                orderQueryOrdersetBean entityTime = gson.fromJson(succeed, orderQueryOrdersetBean.class);
                if (entity.getCode() == 20000) {
                    for (int i = 0; i < entityTime.getResult().size(); i++) {
                        if (entityTime.getResult().get(i).getCode().equals("l") && entityTime.getResult().get(i).getType().equals("p")) {
                            long minute = 60 * entityTime.getResult().get(i).getTimeLimit() * 1000;// 分钟前
                            long timeStamp = System.currentTimeMillis();//系统时间
                            long oderTime = Long.valueOf(entity.getResult().getTime()) + minute;//订单时间
                            long chacha = oderTime - timeStamp;
                            if (chacha > 0) {
                                timerStart(chacha);
                                mTimer.start();
                            }
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

    @OnClick({R.id.consultation_back, R.id.oder_cancle, R.id.tv_shouhuo,
            R.id.oder_pay, R.id.oderWuLiu, R.id.Cashier_call})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.consultation_back:
                finish();
                break;
            case R.id.oder_cancle://取消订单
                Dilog_Login_Cler cler = new Dilog_Login_Cler(Act_MerchandiseOrderDetails.this, () -> {
                    orderUpdateCancel(entity.getResult().getId());
                }, "您确认要取消该订单么？");
                cler.show();
                break;
            case R.id.oder_pay://立即支付
                dilogPay = new Dilog_Pay(Act_MerchandiseOrderDetails.this, this);
                dilogPay.show();
                break;
            case R.id.tv_shouhuo://确认收货
                orderUpdateConfirm();
                break;
            case R.id.oderWuLiu://物流
                Intent intent = new Intent();
                intent.putExtra("oderID", entity.getResult().getId() + "");
                startAct(intent, Act_LogisticsInformation.class);
                break;
            case R.id.Cashier_call:
                startAct(Act_HousePropertyCustomerService.class);
                break;
        }
    }

    Dilog_Pay dilogPay;

    /**
     * 取消订单
     */
    public void orderUpdateCancel(String oderId) {
        loding.show();
        HttpHelper.orderUpdateCancel(getContext(), oderId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                orderUpdateCancelBean entity = gson.fromJson(succeed, orderUpdateCancelBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(getContext(), "取消订单成功！");
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
    public void onPayWx() {
        dilogPay.dismiss();
        traWxUnified_orderApp(entity.getResult().getId());
    }

    @Override
    public void onPayZFB() {
        dilogPay.dismiss();
        traAliUnifiedOrderApp(entity.getResult().getId());
    }

    /**
     * 微信商品支付
     */
    public void traWxUnified_orderApp(String result) {
        HttpHelper.traWxUnified_orderApp(getContext(), result, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                TransactionWXUnifiedOrderBean entity = gson.fromJson(succeed, TransactionWXUnifiedOrderBean.class);
                if (entity.getCode() == 20000) {
                    toWXPay(entity);
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    private IWXAPI iwxapi; //微信支付api

    /**
     * 调起微信支付的方法
     **/
    private void toWXPay(TransactionWXUnifiedOrderBean wxBean) {
        MyApplication.payWxStatus = "oderUp";
        iwxapi = WXAPIFactory.createWXAPI(context, wxBean.getResult().getAppid(), false);//填写自己的APPID
        iwxapi.registerApp(wxBean.getResult().getAppid()); //注册appid  appid可以在开发平台获取
        PayReq request = new PayReq(); //调起微信APP的对象
        //下面是设置必要的参数，也就是前面说的参数,这几个参数从何而来请看上面说明
        request.appId = wxBean.getResult().getAppid();
        request.partnerId = wxBean.getResult().getPartnerid();
        request.prepayId = wxBean.getResult().getPrepayid();
        request.packageValue = "Sign=WXPay";
        request.nonceStr = wxBean.getResult().getNoncestr();
        request.timeStamp = wxBean.getResult().getTimestamp();
        request.sign = wxBean.getResult().getSign();
        iwxapi.sendReq(request);//发送调起微信的请求
    }


    /**
     * 支付宝支付统一下单
     */
    public void traAliUnifiedOrderApp(String result) {
        HttpHelper.traAliUnifiedOrderApp(getContext(), result, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                vipAliUnifiedOrderBean entity = gson.fromJson(succeed, vipAliUnifiedOrderBean.class);
                if (entity.getCode() == 20000) {
                    appPlayZFB(entity.getResult());
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    private static final int SDK_PAY_FLAG = 1;

    //    支付宝支付调用
    public void appPlayZFB(String apippp) {
        Runnable payRunnable = () -> {
            PayTask alipay = new PayTask(this);
            Map<String, String> result = alipay.payV2(apippp, true);
            Message msg = new Message();
            msg.what = SDK_PAY_FLAG;
            msg.obj = result;
            mHandler.sendMessage(msg);
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private static final int SDK_AUTH_FLAG = 2;
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        setResult(10);
                        finish();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();
                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                    } else {
                        MyToast.show(getContext(), "支付失败、请重试！");
                        // 其他状态值则为授权失败
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };

    /**
     * 用户订单确认收货
     */
    public void orderUpdateConfirm() {
        loding.show();
        HttpHelper.orderUpdateConfirm(getContext(), entity.getResult().getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                orderUpdateCancelBean entity = gson.fromJson(succeed, orderUpdateCancelBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(getContext(), "确认收货成功！");
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

}
