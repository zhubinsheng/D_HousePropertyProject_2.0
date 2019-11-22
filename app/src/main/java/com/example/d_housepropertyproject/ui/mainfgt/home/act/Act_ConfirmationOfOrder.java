package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GoodsQueryInfoStoreUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.PostBasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_ClipCoupons;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 确认订单
 */
public class Act_ConfirmationOfOrder extends BaseActivity {
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
    }

    GoodsQueryInfoStoreUserBean bean;
    private Double numPrice = 0.0;

    @Override
    public void initData() {
        bean = (GoodsQueryInfoStoreUserBean) getIntent().getSerializableExtra("datas");
        Glide.with(this).load(bean.getResult().getPic()).into(image);
        name.setText(bean.getResult().getName());
        price.setText(bean.getResult().getSalePrice() + "");
        price1.setText("市场价:" + bean.getResult().getPrice() + "/" + bean.getResult().getUnit());
        dlgNumber.setText(bean.getResult().getGoodnum() + "");
        unit.setText("/" + bean.getResult().getUnit());
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
            R.id.dlg_jian, R.id.dlg_add, R.id.but_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Cash_WithdrawalSuccess_back:
                finish();
                break;
            case R.id.choseCoupon:
                startAct(Act_ClipCoupons.class);
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
                pmsordersubmitbasket();
                break;
        }
    }

    List<PostBasketBean.BasketBean> basket = new ArrayList<>();
    private String linkman = "1";

    /**
     * 下单购物车信息
     * FirmId厂商id
     * remark备注
     * BasketId购物车id
     * linkman//联系人id
     */
    public void pmsordersubmitbasket() {
//        if (TextUtils.isEmpty(linkman)) {
//            MyToast.show(getContext(), "请选联系人");
//            return;
//        }
        basket.clear();
        PostBasketBean.BasketBean basketBean = new PostBasketBean.BasketBean();
        List<String> basketIdDatas = new ArrayList<>();
        numPrice += (bean.getResult().getSalePrice() * bean.getResult().getGoodnum());
        basketIdDatas.add(bean.getResult().getId());
        basketBean.setBasketId(basketIdDatas);
        basketBean.setRemark(et_Remark.getText().toString());
        basketBean.setFirmId(bean.getResult().getFirmId());
        basket.add(basketBean);
        loding.show();
        HttpHelper.pmsordersubmitbasket(linkman, basket, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
//                pmsordersubmitbasketBean entity = gson.fromJson(succeed, pmsordersubmitbasketBean.class);
//                if (entity.getCode() == 20000) {
//                    EventBus.getDefault().post(new UserEvent("1", "刷新购物车"));
//                    dlg_shopingCenter = new Dlg_ShopingCenter(Act_ShoppingDetails.this, address.getText().toString());
//                    dlg_shopingCenter.show();
//                    dlg_shopingCenter.setBackItem(new Dlg_ShopingCenter.backItem(){
//                        @Override
//                        public void onBackFinsh() {
//                            finish();
//                        }
//                        @Override
//                        public void onShowOder() {
//                            finish();
//                            startAct(Act_MyOrder.class);
//                        }
//                    });
//                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }
}
