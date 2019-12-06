package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.MessageStatus;
import com.example.d_housepropertyproject.bean.vipAliUnifiedOrderBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.AuthResult;
import com.example.d_housepropertyproject.tool.GlideImageLoader;
import com.example.d_housepropertyproject.tool.PayResult;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionWXUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_Pay;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.GoodsQueryInfoIntegralUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.MyIncomeBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.VipGetVipRemarkBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 会员中心
 */
public class Act_MemberCenter extends BaseActivity implements Dilog_Pay.OnBackCenter {
    @BindView(R.id.ll_vip)
    LinearLayout llVip;
    @BindView(R.id.ll_noVip)
    LinearLayout llNoVip;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    Dilog_Pay pay;

    @Override
    public int initLayoutId() {
        return R.layout.act_membercenter;
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
        EventBus.getDefault().register(this);
        pay = new Dilog_Pay(this, this);
        pay.setTouchCancle(true);
    }

    @Override
    public void initData() {
        vipGetMyVip();
        vipGetVipRemark();
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(MessageStatus message) {
        switch (message.status) {
            case "1"://微信支付成功
                MyToast.show(getApplicationContext(), "会员开通成功！");
                setResult(11);
                finish();
                break;
            case "2"://微信支付失败
                MyToast.show(getApplicationContext(), "支付失败、请重试！");
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.min_Historical_Record_back, R.id.addHuiYuan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                finish();
                break;
            case R.id.addHuiYuan:
                pay.show();
                break;
        }

    }

    /**
     * 获取我的会员
     */
    public void vipGetMyVip() {
        HttpHelper.vipGetMyVip(context, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                MyIncomeBean entity = gson.fromJson(succeed, MyIncomeBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult() != null) {
                        llVip.setVisibility(View.VISIBLE);
                        llNoVip.setVisibility(View.GONE);
                    } else {
                        llVip.setVisibility(View.GONE);
                        llNoVip.setVisibility(View.VISIBLE);
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
     * 获取会员描述
     */
    public void vipGetVipRemark() {
        HttpHelper.vipGetVipRemark(context, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                VipGetVipRemarkBean entity = gson.fromJson(succeed, VipGetVipRemarkBean.class);
                if (entity.getCode() == 20000) {
                    tvRemark.setText(entity.getResult().getRemark());
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    //微信
    @Override
    public void onPayWx() {
        pay.dismiss();
        loding.show();
        vipWxfiedOrder();
    }

    //支付宝
    @Override
    public void onPayZFB() {
        pay.dismiss();
        loding.show();
        goodsQueryInfoIntegralUser();
    }

    /**
     * 支付宝统一下单
     */
    public void goodsQueryInfoIntegralUser() {
        HttpHelper.vipAliUnifiedOrder("", "1", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
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
                MyToast.show(context, error);
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
                        MyToast.show(getApplicationContext(), "会员开通成功!！");
                        setResult(11);
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
                        MyToast.show(getApplicationContext(), "支付失败、请重试！");
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
     * 微信统一下单
     */
    public void vipWxfiedOrder() {
        HttpHelper.vipWxfiedOrder("1", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
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
                MyToast.show(context, error);
            }
        });
    }

    private IWXAPI iwxapi; //微信支付api

    /**
     * 调起微信支付的方法
     **/
    private void toWXPay(TransactionWXUnifiedOrderBean wxBean) {
        MyApplication.payWxStatus = "vip";
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
}
