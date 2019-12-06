package com.example.d_housepropertyproject.ui.mainfgt.apartment.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.AuthResult;
import com.example.d_housepropertyproject.tool.PayResult;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionAliUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionWXUnifiedOrderBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 支付订单
 */
public class Act_PaymentOrder extends BaseActivity {
    @BindView(R.id.PaymentOrder_back)
    ImageView PaymentOrderBack;
    @BindView(R.id.cb_zhifubao)
    ImageView cbZhifubao;
    @BindView(R.id.rl_zhifubao)
    RelativeLayout rlZhifubao;
    @BindView(R.id.cb_weixin)
    ImageView cbWeixin;
    @BindView(R.id.rl_weixin)
    RelativeLayout rlWeixin;
    @BindView(R.id.paymentorder_pay)
    TextView paymentorderPay;
    @BindView(R.id.tv_EarnestRmbPrice)
    TextView tv_EarnestRmbPrice;
    @BindView(R.id.id_number)
    TextView number_num;

    @Override
    public int initLayoutId() {
        return R.layout.act_paymentorder;
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

    private String price, num_order, Id_order;

    @Override
    public void initData() {
        cbWeixin.setSelected(true);
        cbZhifubao.setSelected(false);
        price = getIntent().getStringExtra("price");
        num_order = getIntent().getStringExtra("num_order");
        Id_order = getIntent().getStringExtra("Id_order");
        tv_EarnestRmbPrice.setText("￥" + price);
        number_num.setText(num_order);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {
    }

    private String type = "w";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_zhifubao, R.id.rl_weixin, R.id.PaymentOrder_back, R.id.paymentorder_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_zhifubao:
                type = "z";
                cbWeixin.setSelected(false);
                cbZhifubao.setSelected(true);
                break;
            case R.id.rl_weixin:
                type = "w";
                cbWeixin.setSelected(true);
                cbZhifubao.setSelected(false);
                break;
            case R.id.PaymentOrder_back:
                finish();
                break;
            case R.id.paymentorder_pay:
                if (type.equals("w")) {//微信
                    transactionWXUnifiedOrder(Id_order, "127.168.1.1");
                } else {//支付宝
                    transactionAliUnifiedOrder(Id_order);
                }
                break;
        }
    }

    /**
     * 微信统一下单
     */
    public void transactionWXUnifiedOrder(String id_order, String ip) {
        loding.show();
        HttpHelper.transactionWXUnifiedOrder(this, id_order, ip, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                TransactionWXUnifiedOrderBean entity = gson.fromJson(succeed, TransactionWXUnifiedOrderBean.class);
                if (entity.getCode() == 20000) {
                    loding.dismiss();
                    toWXPay(entity);
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
     * 支付宝统一下单
     */
    public void transactionAliUnifiedOrder(String id_order) {
        loding.show();
        HttpHelper.transactionAliUnifiedOrder(this, id_order, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                TransactionAliUnifiedOrderBean entity = gson.fromJson(succeed, TransactionAliUnifiedOrderBean.class);
                if (entity.getCode() == 20000) {
                    loding.dismiss();
                    appPlayZFB(entity.getResult());
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    private IWXAPI iwxapi; //微信支付api

    /**
     * 调起微信支付的方法
     **/
    private void toWXPay(TransactionWXUnifiedOrderBean wxBean) {
        MyApplication.payWxStatus = "fangchan";
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

    private static final int SDK_PAY_FLAG = 1;

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
                        Intent intent1 = new Intent();
                        intent1.setClass(Act_PaymentOrder.this, Act_Cashier.class);
                        intent1.putExtra("cashistatus", "liebiao");
                        intent1.putExtra("status", "success");
                        startActivity(intent1);
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
                        Intent intent1 = new Intent();
                        intent1.setClass(Act_PaymentOrder.this, Act_Cashier.class);
                        intent1.putExtra("status", "lose");
                        startActivity(intent1);
                        // 其他状态值则为授权失败
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };
}
