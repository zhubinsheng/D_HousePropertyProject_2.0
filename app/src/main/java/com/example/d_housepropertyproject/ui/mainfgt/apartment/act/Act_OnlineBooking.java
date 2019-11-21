package com.example.d_housepropertyproject.ui.mainfgt.apartment.act;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.Ap_UnitDetailsBean1;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.OrderHouseBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.SelectRoomNumberBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_HousingLoanCalculation;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面户型=>户型详情=>在线预定
 */
public class Act_OnlineBooking extends BaseActivity {
    @BindView(R.id.Act_Ap_UnitDetails_referenceRmbPrice)
    TextView ActApUnitDetailsReferenceRmbPrice;
    @BindView(R.id.Act_Ap_UnitDetails_carpetArea1)
    TextView ActApUnitDetailsCarpetArea1;
    @BindView(R.id.Act_Ap_UnitDetails_balconyArea)
    TextView ActApUnitDetailsBalconyArea;
    @BindView(R.id.Act_Ap_UnitDetails_name)
    TextView ActApUnitDetailsName;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.onlinebooking_hader)
    RoundedImageView haderImg;
    @BindView(R.id.onlinebooking_NextStep)
    TextView onlinebooking_NextStep;
    @BindView(R.id.booking_price)
    TextView booking_price;
    private String EarnestRmbPrice;
    SelectRoomNumberBean.ResultBean roomNumberBean;

    @Override
    public int initLayoutId() {
        return R.layout.act_onlinebooking;
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

    Ap_UnitDetailsBean1 entity;

    @Override
    public void initData() {
        roomNumberBean = (SelectRoomNumberBean.ResultBean) getIntent().getSerializableExtra("roombean");
        entity = (Ap_UnitDetailsBean1) getIntent().getSerializableExtra("bean");
        EarnestRmbPrice = getIntent().getStringExtra("EarnestRmbPrice");
        ActApUnitDetailsReferenceRmbPrice.setText(roomNumberBean.getReferenceRmbPrice() + "万/套");
        ActApUnitDetailsCarpetArea1.setText(entity.getResult().getData().getCarpetArea() + "㎡");
        ActApUnitDetailsBalconyArea.setText(entity.getResult().getData().getBalconyArea() + "㎡");
        ActApUnitDetailsName.setText(entity.getResult().getData().getName());
        booking_price.setText(roomNumberBean.getEarnestRmbPrice() + "元");
        title.setText(roomNumberBean.getPeriod() + roomNumberBean.getBuilder() + roomNumberBean.getUnit() + roomNumberBean.getRoomNumber());
        if (entity.getResult().getFileList().getHouse01() != null) {
            Glide.with(context).load(entity.getResult().getFileList().getHouse01().get(0).getPath()).into(haderImg);
        }
        onlinebooking_NextStep.setText("付定金：" + EarnestRmbPrice);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick({R.id.OnlineBooking_back, R.id.onlinebooking_NextStep,R.id.unitdetails_fangdaijisuan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.OnlineBooking_back:
                finish();
                break;
            case R.id.onlinebooking_NextStep://付定金
                orderHouse(getIntent().getStringExtra("sellId"));
                break;
            case R.id.unitdetails_fangdaijisuan://房贷计算器
                startAct(Act_HousingLoanCalculation.class);
                break;
        }
    }

    /**
     * 房屋预订单
     */
    OrderHouseBean entity1;

    public void orderHouse(String id_sell) {
        loding.show();
        HttpHelper.orderAddHouse(this,id_sell, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                loding.dismiss();
                entity1 = gson.fromJson(succeed, OrderHouseBean.class);
                if (entity.getCode() == 20000) {
                    Intent intent = new Intent();
                    intent.putExtra("num_order", entity1.getResult().getNum_order() + "");
                    intent.putExtra("price", entity1.getResult().getPrice() + "");
                    intent.putExtra("Id_order", entity1.getResult().getId_order() + "");
                    startAct(intent, Act_PaymentOrder.class);
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
