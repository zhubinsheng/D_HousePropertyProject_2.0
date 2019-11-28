package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ExchangeRecordsBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的=》积分=>积分记录=》订单详情
 */
public class Act_IntegralOrder extends BaseActivity {
    @BindView(R.id.oder_id)
    TextView oderId;
    @BindView(R.id.oder_image)
    RoundedImageView oderImage;
    @BindView(R.id.oder_name)
    TextView oderName;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.oder_time)
    TextView oderTime;
    @BindView(R.id.oder_linkman)
    TextView oderLinkman;
    @BindView(R.id.oder_address)
    TextView oderAddress;

    @Override
    public int initLayoutId() {
        return R.layout.act_integralorder;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }
    private ExchangeRecordsBean.ResultBean.ListBean bean;
    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        bean = (ExchangeRecordsBean.ResultBean.ListBean) getIntent().getSerializableExtra("bean");
        oderId.setText("订单号："+bean.getId());
        Glide.with(this).load(bean.getPic()).into(oderImage);
        oderName.setText(bean.getName());
        tv_price.setText(bean.getPrice()+"");
        oderTime.setText(MyTimeUtils.dateToStampTimeHH(bean.getTime()));
        oderLinkman.setText(bean.getLinkman()+" "+bean.getPhone());
        oderAddress.setText(bean.getAddress());
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

    @OnClick(R.id.min_Historical_Record_back)
    public void onClick() {
        finish();
    }

    /**
     * 积分订单详情
     */
    public void orderQueryIntegralInfoUser() {
//        HttpHelper.orderQueryIntegralInfoUser(id, new HttpHelper.HttpUtilsCallBack<String>() {
//            @Override
//            public void onFailure(String failure) {
//                loding.dismiss();
//                MyToast.show(Act_IntegralOrder.this, failure);
//            }
//
//            @Override
//            public void onSucceed(String succeed) {
//                loding.dismiss();
//                Gson gson = new Gson();
//                ExchangeRecordsBean entity = gson.fromJson(succeed, ExchangeRecordsBean.class);
//                if (entity.getCode() == 20000) {
//
//                }
//            }
//
//            @Override
//            public void onError(String error) {
//                loding.dismiss();
//                MyToast.show(Act_IntegralOrder.this, error);
//            }
//        });
    }
}
