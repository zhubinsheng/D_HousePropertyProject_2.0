package com.example.d_housepropertyproject.ui.mainfgt.home.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_ConfirmationOfOrder;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GoodsQueryInfoStoreUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.pmsOrderAddBasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.pmsgoodsqueryproductinfoBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.AddShoppingAdapter;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.ArrayList;
import java.util.List;

public class Dalog_AddShopping extends BaseDialog {
    private GoodsQueryInfoStoreUserBean customerBean;

    public GoodsQueryInfoStoreUserBean getCustomerBean() {
        return customerBean;
    }

    public ZLoadingDialog loding;

    public boolean isLijigouwu() {
        return lijigouwu;
    }

    public void setLijigouwu(boolean lijigouwu) {
        this.lijigouwu = lijigouwu;
    }

    public boolean lijigouwu = false;

    public void setCustomerBean(GoodsQueryInfoStoreUserBean customerBean) {
        this.customerBean = customerBean;
    }

    public Dalog_AddShopping(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_addshopping;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    private TextView price, unit, time;
    private EditText num;
    private RoundedImageView home_tuangou;
    private RecyclerView dlogRecyclerView;

    @Override
    protected void initView() {
        loding = new ZLoadingDialog(getContext());
        loding.setLoadingBuilder(Z_TYPE.ROTATE_CIRCLE)//设置类型
                .setLoadingColor(Color.DKGRAY)//颜色
                .setHintText("数据加载中...")
                .setHintTextSize(16) // 设置字体大小 dp
                .setHintTextColor(Color.DKGRAY)  // 设置字体颜色
                .setDurationTime(0.5) // 设置动画时间百分比 - 0.5倍
                .setDialogBackgroundColor(Color.parseColor("#CCffffff")); // 设置背景色，默认白色
        setOnClickListener(R.id.dlg_jian);
        setOnClickListener(R.id.dlg_add);
        setOnClickListener(R.id.bt_commit);
        unit = getView(R.id.unit);
        price = getView(R.id.price);
        home_tuangou = getView(R.id.home_tuangou);
        num = getView(R.id.dlg_number);
        time = getView(R.id.time);
        num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (num.getText().toString().length() == 0) {
                    num.setText("1");
                }
            }
        });
        dlogRecyclerView = getView(R.id.dlog_RecyclerView);
        dlogRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initData() {
        unit.setText("/" + customerBean.getResult().getUnit());
        for (int i = 0; i < getCustomerBean().getResult().getPAttrs().size(); i++) {
            for (int j = 0; j < getCustomerBean().getResult().getPAttrs().get(i).getAttrs().size(); j++) {
                getCustomerBean().getResult().getPAttrs().get(i).getAttrs().get(j).setStatus(false);
            }
        }
        price.setText(getCustomerBean().getResult().getSalePrice() + "");
        if (customerBean.getResult().getTime() == null) {
            time.setVisibility(View.GONE);
        } else {
            time.setVisibility(View.VISIBLE);
            time.setText(MyTimeUtils.format(customerBean.getResult().getTime() + "") + "后恢复原价");
        }
        Glide.with(getContext()).load(getCustomerBean().getResult().getPic()).into(home_tuangou);
        AddShoppingAdapter addShoppingAdapter = new AddShoppingAdapter(getContext(), getCustomerBean().getResult().getPAttrs());
        addShoppingAdapter.setOnBackItem((position, chlidePosition) -> {
            for (int i = 0; i < getCustomerBean().getResult().getPAttrs().get(position).getAttrs().size(); i++) {
                getCustomerBean().getResult().getPAttrs().get(position).getAttrs().get(i).setStatus(false);
            }
            getCustomerBean().getResult().getPAttrs().get(position).getAttrs().get(chlidePosition).setStatus(!getCustomerBean().getResult().getPAttrs().get(position).getAttrs().get(chlidePosition).isStatus());
            if (setGuiGe()) {
                return;
            }
            loding.show();
            pmsgoodsqueryproductinfo(getCustomerBean().getResult().getId());
        });
        dlogRecyclerView.setAdapter(addShoppingAdapter);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.dlg_jian://减
                if (!num.getText().toString().equals("1")) {
                    int number = Integer.valueOf(num.getText().toString()) - 1;
                    num.setText(String.valueOf(number));
                }
                break;
            case R.id.dlg_add://加
                int number = Integer.valueOf(num.getText().toString()) + 1;
                num.setText(String.valueOf(number));
                break;
            case R.id.bt_commit:
                commitShopping();
                break;
        }
    }

    List<String> attrs = new ArrayList<>();

    /**
     * 剔除选中属性
     * true 表示有规格参数未选中
     * false表示。。都选中了规格的一个参数
     */
    public boolean setGuiGe() {
        attrs.clear();
        for (int i = 0; i < getCustomerBean().getResult().getPAttrs().size(); i++) {
            for (int j = 0; j < getCustomerBean().getResult().getPAttrs().get(i).getAttrs().size(); j++) {
                if (getCustomerBean().getResult().getPAttrs().get(i).getAttrs().get(j).isStatus()) {
                    attrs.add(getCustomerBean().getResult().getPAttrs().get(i).getAttrs().get(j).getAttrId());
                }
            }
        }
        if (attrs.size() == getCustomerBean().getResult().getPAttrs().size()) {

        } else {
            return true;
        }
        return false;
    }

    String stAttrs = "";

    /**
     * 提交到购物车
     */
    public void commitShopping() {
        if (setGuiGe()) {
            MyToast.show(getContext(), "请选择商品属性");
            return;
        }
        if (pmsgoodsqueryproductinfo == null) {
            return;
        }
        if (pmsgoodsqueryproductinfo.getCode() == 400) {
            MyToast.show(getContext(), "无货、请重新选择！");
            return;
        }
        Gson gson = new Gson();
        stAttrs = gson.toJson(attrs);
        loding.show();
        HttpHelper.pmsOrderAddBasket(stAttrs, getCustomerBean().getResult().getId(), num.getText().toString(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                pmsOrderAddBasketBean entity = gson.fromJson(succeed, pmsOrderAddBasketBean.class);
                if (entity.getCode() == 20000) {
                    if (lijigouwu) {
                        customerBean.getResult().setGoodnum(Integer.valueOf(num.getText().toString()));
                        Intent intent = new Intent();
                        intent.putExtra("datas", customerBean);
                        intent.putExtra("basketIdItem1", entity.getResult());
                        intent.setClass(getContext(), Act_ConfirmationOfOrder.class);
                        getContext().startActivity(intent);
                    } else {
                        MyToast.show(getContext(), "添加购物车" + entity.getMessage());
                    }
                    dismiss();
                } else {
                    MyToast.show(getContext(), entity.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });

    }

    pmsgoodsqueryproductinfoBean pmsgoodsqueryproductinfo;

    /**
     * 产品信息
     */
    public void pmsgoodsqueryproductinfo(String id) {
        HttpHelper.pmsgoodsqueryproductinfo(id, attrs.toString(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                pmsgoodsqueryproductinfo = gson.fromJson(succeed, pmsgoodsqueryproductinfoBean.class);
                if (pmsgoodsqueryproductinfo.getCode() == 20000) {
                    Glide.with(getContext()).load(pmsgoodsqueryproductinfo.getResult().getAlbumPics()).into(home_tuangou);
                    price.setText(pmsgoodsqueryproductinfo.getResult().getSalePrice() + "");
                    customerBean.getResult().setSalePrice(pmsgoodsqueryproductinfo.getResult().getSalePrice());
//                    customerBean.getResult().setId(pmsgoodsqueryproductinfo.getResult().getId());
                    customerBean.getResult().setName(pmsgoodsqueryproductinfo.getResult().getName());
                    customerBean.getResult().setPic(pmsgoodsqueryproductinfo.getResult().getAlbumPics());
                } else {
                    MyToast.show(getContext(), "无货");
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), "无货");
            }
        });

    }
}
