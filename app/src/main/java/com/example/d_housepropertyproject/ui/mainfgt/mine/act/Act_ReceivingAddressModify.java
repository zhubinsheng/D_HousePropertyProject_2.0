package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ReceivingAddressBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.linkmanAddLinkmanBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.Dlg_AddressCenter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.Dlg_AddressSelection;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址修改
 */
public class Act_ReceivingAddressModify extends BaseActivity implements Dlg_AddressSelection.onBackText {
    @BindView(R.id.et_linkman)
    EditText etLinkman;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.tv_region)
    TextView tvRegion;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.newAddr)
    TextView newAddr;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_DelLinkman)
    TextView tv_DelLinkman;
    @BindView(R.id.addr_status)
    LinearLayout addr_status;

    @Override
    public int initLayoutId() {
        return R.layout.act_receivingaddressmodify;
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

    private Dlg_AddressSelection addressSelection;
    private Dlg_AddressCenter addressCenter;
    ReceivingAddressBean.ResultBean resultBean;

    @Override
    public void initData() {
        addressCenter = new Dlg_AddressCenter(this);
        addressCenter.setOnBackText(() -> {
            finish();
        });
        if (getIntent().getSerializableExtra("bean") != null) {
            resultBean = (ReceivingAddressBean.ResultBean) getIntent().getSerializableExtra("bean");
            tvAddress.setText(resultBean.getAddress());
            edPhone.setText(resultBean.getPhone());
            etLinkman.setText(resultBean.getLinkman());
            TextView tvChecoe = getView(R.id.tv_checkbox);
            if (resultBean.getIsdefault().equals("1")) {
                tvChecoe.setSelected(true);
            } else {
                tvChecoe.setSelected(false);
            }
            tv_title.setText("编辑地址");
            tv_DelLinkman.setVisibility(View.VISIBLE);
            addr_status.setVisibility(View.VISIBLE);
        } else {
            addr_status.setVisibility(View.GONE);
            tv_DelLinkman.setVisibility(View.GONE);
            tv_title.setText("收货地址");
        }
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

    @OnClick({R.id.min_Historical_Record_back, R.id.bt_xiangxidizhi
            , R.id.tv_region, R.id.tv_DelLinkman, R.id.newAddr})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                addressCenter.show();
                break;
            case R.id.bt_xiangxidizhi:

                break;
            case R.id.tv_region://区域
                addressSelection = new Dlg_AddressSelection(this);
                addressSelection.setOnBackText(this);
                addressSelection.show();
                break;
            case R.id.tv_DelLinkman://删除
                if (getIntent().getSerializableExtra("bean") != null) {
                    loding.show();
                    linkmanDelLinkman();
                }
                break;
            case R.id.newAddr://保存地址
                if (getIntent().getSerializableExtra("bean") != null) {
                    linkmanUpdateLinkman(resultBean.getId());
                } else {
                    linkmanAddLinkman();
                }
                break;
        }
    }

    /**
     * 删除收货地址
     */
    public void linkmanDelLinkman() {
        HttpHelper.linkmanDelLinkman(Act_ReceivingAddressModify.this, resultBean.getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                ReceivingAddressBean entity = gson.fromJson(succeed, ReceivingAddressBean.class);
                if (entity.getCode() == 20000) {
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
    @Override
    public void onBackItem(String areaId, String addr) {
        tvRegion.setText(addr);
    }

    private String stLinkman, phone, address, addressDetail;

    /**
     * 添加收货地址
     */
    public void linkmanAddLinkman() {
        stLinkman = etLinkman.getText().toString();
        phone = edPhone.getText().toString();
        address = newAddr.getText().toString();
        addressDetail = tvAddress.getText().toString();
        if (TextUtils.isEmpty(stLinkman)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请输入联系人");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请输入联系电话");
            return;
        }
        if (phone.length() != 11) {
            MyToast.show(Act_ReceivingAddressModify.this, "请输入正确手机号码");
            return;
        }
        if (TextUtils.isEmpty(address)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请选择区域");
            return;
        }
        if (TextUtils.isEmpty(addressDetail)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请输入详细地址");
            return;
        }
        loding.show();
        HttpHelper.linkmanAddLinkman(address, addressDetail, stLinkman, phone, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                linkmanAddLinkmanBean entity = gson.fromJson(succeed, linkmanAddLinkmanBean.class);
                if (entity.getCode() == 20000) {
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

    /**
     * 更新收货地址
     */
    public void linkmanUpdateLinkman(String id) {
        stLinkman = etLinkman.getText().toString();
        phone = edPhone.getText().toString();
        address = newAddr.getText().toString();
        addressDetail = tvAddress.getText().toString();
        if (TextUtils.isEmpty(stLinkman)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请输入联系人");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请输入联系电话");
            return;
        }
        if (TextUtils.isEmpty(address)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请选择区域");
            return;
        }
        if (TextUtils.isEmpty(addressDetail)) {
            MyToast.show(Act_ReceivingAddressModify.this, "请输入详细地址");
            return;
        }
        loding.show();
        HttpHelper.linkmanUpdateLinkman(id,address, addressDetail, stLinkman, phone, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                linkmanAddLinkmanBean entity = gson.fromJson(succeed, linkmanAddLinkmanBean.class);
                if (entity.getCode() == 20000) {
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
