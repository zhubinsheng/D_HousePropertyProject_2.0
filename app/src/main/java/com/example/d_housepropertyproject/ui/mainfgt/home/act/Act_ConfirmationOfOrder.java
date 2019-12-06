package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionWXUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GoodsQueryInfoStoreUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.PostBasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.pmsordersubmitbasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_Pay;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_ReceivingAddress;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ReceivingAddressBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_ClipCoupons;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.couponGetCouponListBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 确认订单
 */
public class Act_ConfirmationOfOrder extends BaseActivity implements Dilog_Pay.OnBackCenter {
    @BindView(R.id.image)
    RoundedImageView image;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.unit)
    TextView unit;
    @BindView(R.id.price1)
    TextView price1;
    @BindView(R.id.dlg_number)
    TextView dlgNumber;
    @BindView(R.id.oderAllPrice)
    TextView oderAllPrice;
    @BindView(R.id.et_Remark)
    EditText et_Remark;
    @BindView(R.id.linkmanPhone)
    TextView linkmanPhone;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.tv_number)
    TextView tv_number;
    @BindView(R.id.choseCoupon)
    TextView choseCoupon;
    private Dilog_Pay dilogPay;
    private String basketIdItem1 = "";

    @Override
    public int initLayoutId() {
        return R.layout.act_confirmationoforder;
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
        dilogPay = new Dilog_Pay(this, this);
    }

    GoodsQueryInfoStoreUserBean bean;
    private Double numPrice = 0.0;

    @Override
    public void initData() {
        bean = (GoodsQueryInfoStoreUserBean) getIntent().getSerializableExtra("datas");
        basketIdItem1 = getIntent().getStringExtra("basketIdItem1");
        Glide.with(this).load(bean.getResult().getPic()).into(image);
        name.setText(bean.getResult().getName());
        price.setText(bean.getResult().getSalePrice() + "");
        price1.setText("市场价:" + bean.getResult().getPrice() + "/" + bean.getResult().getUnit());
//        dlgNumber.setText(bean.getResult().getGoodnum() + "");
        unit.setText("/" + bean.getResult().getUnit());
        tv_number.setText("x" + bean.getResult().getGoodnum());
        numPrice = (bean.getResult().getSalePrice() * bean.getResult().getGoodnum());
        oderAllPrice.setText(numPrice + "");
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

    @OnClick({R.id.Cash_WithdrawalSuccess_back, R.id.choseCoupon,
            R.id.dlg_jian, R.id.dlg_add, R.id.but_commit, R.id.bt_AddressSelection})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Cash_WithdrawalSuccess_back:
                finish();
                break;
            case R.id.choseCoupon:
                startActivityForResult(Act_ClipCoupons.class, 11);
                break;
            case R.id.dlg_jian:
                if (bean.getResult().getGoodnum() == 1) {
                    return;
                }
                bean.getResult().setGoodnum(bean.getResult().getGoodnum() - 1);
                dlgNumber.setText(bean.getResult().getGoodnum() + "");
                Double money = bean.getResult().getSalePrice() * bean.getResult().getGoodnum();
                oderAllPrice.setText(money + "");
                break;
            case R.id.dlg_add:
                bean.getResult().setGoodnum(bean.getResult().getGoodnum() + 1);
                dlgNumber.setText(bean.getResult().getGoodnum() + "");
                Double money1 = bean.getResult().getSalePrice() * bean.getResult().getGoodnum();
                oderAllPrice.setText(money1 + "");
                break;
            case R.id.but_commit://确认订单
                if (TextUtils.isEmpty(linkman)) {
                    MyToast.show(getContext(), "请选联系人");
                    return;
                }
                dilogPay.show();
                break;
            case R.id.bt_AddressSelection://地址选择
                Intent intent = new Intent();
                intent.setClass(this, Act_ReceivingAddress.class);
                intent.putExtra("status", "choseAddress");
                startActivityForResult(intent, 10);
                break;
        }
    }

    List<PostBasketBean.BasketBean> basket = new ArrayList<>();
    private String linkman = "", couponId = "";

    /**
     * 下单购物车信息
     * FirmId厂商id
     * remark备注
     * BasketId购物车id
     * linkman//联系人id
     */
    public void pmsordersubmitbasket() {
        basket.clear();
        PostBasketBean.BasketBean basketBean = new PostBasketBean.BasketBean();
        List<String> basketIdDatas = new ArrayList<>();
        basketIdDatas.add(basketIdItem1);
        basketBean.setBasketId(basketIdDatas);
        basketBean.setRemark(et_Remark.getText().toString());
        basketBean.setFirmId(Long.valueOf(bean.getResult().getFirmId()));
        basket.add(basketBean);
        loding.show();
        HttpHelper.pmsordersubmitbasket(linkman, basket, couponId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                pmsordersubmitbasketBean entity = gson.fromJson(succeed, pmsordersubmitbasketBean.class);
                if (entity.getCode() == 20000) {
                    if (stPay.equals("wx")) {
                        traWxUnified_orderApp(entity.getResult().getId_sub());
                    } else {

                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    private String stPay = "";

    @Override
    public void onPayWx() {
        dilogPay.dismiss();
        stPay = "wx";
        pmsordersubmitbasket();
    }

    @Override
    public void onPayZFB() {
        dilogPay.dismiss();
        stPay = "zfb";
        pmsordersubmitbasket();
    }

    /**
     * 微信商品支付
     */
    public void traWxUnified_orderApp(String result) {
        HttpHelper.traWxUnified_orderApp(this, result, new HttpHelper.HttpUtilsCallBack<String>() {
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
        MyApplication.payWxStatus = "shopping";
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            ReceivingAddressBean.ResultBean bean = (ReceivingAddressBean.ResultBean) data.getSerializableExtra("bean");
            linkman = bean.getId();
            linkmanPhone.setText(bean.getLinkman() + "  " + bean.getPhone());
            address.setText(bean.getAddress());
        } else if (requestCode == 11 && resultCode == 11) {
            couponGetCouponListBean.ResultBean.CouponBean bean = (couponGetCouponListBean.ResultBean.CouponBean) data.getSerializableExtra("bean");
            couponId = bean.getId();
            choseCoupon.setTextColor(getResources().getColor(R.color.mycolor2));
            choseCoupon.setText("满" + bean.getSuitable() + "减" + bean.getPrice() + "元优惠券");
            if (numPrice > Double.valueOf(bean.getSuitable())) {
                numPrice = numPrice - Double.valueOf(bean.getPrice());
            }
            oderAllPrice.setText(numPrice + "");
        }
    }
}
