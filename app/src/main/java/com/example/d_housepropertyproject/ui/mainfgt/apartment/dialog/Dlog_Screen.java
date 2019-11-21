package com.example.d_housepropertyproject.ui.mainfgt.apartment.dialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.ScreenBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.dialog.adapter.ScreenAdatper;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.dialog.bean.HouseInFoAttrBean;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

public class Dlog_Screen extends BaseDialog implements ScreenAdatper.backItem {
    private onBackItem onBackItem;

    public Dlog_Screen(Context context, String houseTypeId1, onBackItem onBackItem1) {
        super(context);
        this.onBackItem = onBackItem1;
        houseTypeId = houseTypeId1;
    }

    private String houseTypeId;

    @Override
    protected int initLayoutId() {
        return R.layout.dlog_screen;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    private RecyclerView myRcyclerView;
    List<ScreenBean> datas = new ArrayList<>();

    @Override
    protected void initView() {
        myRcyclerView = findViewById(R.id.dlog_screenRecyclerView);
        myRcyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setOnClickListener(R.id.clier);
        setOnClickListener(R.id.center);
        setOnClickListener(R.id.waibu);
    }

    ScreenAdatper adatper;
    EditText ed_min, ed_max;

    @Override
    protected void initData() {
        ed_min = getView(R.id.et_min);
        ed_max = getView(R.id.et_max);
        ed_min.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ed_min.getText().toString().length() == 0) {
                    backEidtextInput("0", ed_max.getText().toString());
                } else if (ed_max.getText().toString().length() == 0) {
                    backEidtextInput(ed_min.getText().toString(), "0");
                } else {
                    backEidtextInput(ed_min.getText().toString(), ed_max.getText().toString());
                }
            }
        });
        ed_max.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ed_min.getText().toString().length() == 0) {
                    backEidtextInput("0", ed_max.getText().toString());
                } else if (ed_max.getText().toString().length() == 0) {
                    backEidtextInput(ed_min.getText().toString(), "0");
                } else {
                    backEidtextInput(ed_min.getText().toString(), ed_max.getText().toString());
                }
            }
        });
        houseInfoAttr();
    }

    List<String> decorationCodes = new ArrayList<>();//装修
    List<String> orientedCodes = new ArrayList<>();//朝向
    String StDecorationCodes = "", StOrientedCodes = "";

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.clier:
                ClicerStatus();
                onBackItem.onBack(StDecorationCodes, StOrientedCodes, max, min);
                dismiss();
                break;
            case R.id.center://确认
                decorationCodes.clear();
                orientedCodes.clear();
                for (int i = 0; i < datas.size(); i++) {
                    for (int j = 0; j < datas.get(i).getAttributeList().size(); j++) {
                        if (datas.get(i).getAttributeList().get(j).isChose()) {
                            if (datas.get(i).getDescription().equals("朝向")) {
                                orientedCodes.add(datas.get(i).getAttributeList().get(j).getCode());
                            } else if (datas.get(i).getDescription().equals("装修")) {
                                decorationCodes.add(datas.get(i).getAttributeList().get(j).getCode());
                            }
                        }
                    }
                }
                dismiss();
                if (datas.size() > 2) {
                    for (int i = 0; i < datas.get(2).getAttributeList().size(); i++) {
                        if (datas.get(2).getAttributeList().get(i).isChose()) {
                            min = datas.get(2).getAttributeList().get(i).getValue();
                            max = datas.get(2).getAttributeList().get(i).getCreated() + "";
                        }
                    }
                }
                for (int i = 0; i < decorationCodes.size(); i++) {
                    if (i == (decorationCodes.size() - 1)) {
                        StDecorationCodes += decorationCodes.get(i);
                    } else {
                        StDecorationCodes += decorationCodes.get(i) + ",";
                    }
                }
                for (int i = 0; i < orientedCodes.size(); i++) {
                    if (i == (orientedCodes.size() - 1)) {
                        StOrientedCodes += orientedCodes.get(i);
                    } else {
                        StOrientedCodes += orientedCodes.get(i) + ",";
                    }
                }
                onBackItem.onBack(StDecorationCodes, StOrientedCodes, min, max);
                StOrientedCodes = "";
                StDecorationCodes = "";
                ClicerStatus();
                ed_min.setText("");
                ed_max.setText("");
                break;
            case R.id.waibu:
                dismiss();
                break;
        }
    }

    @Override
    public void backPosition(int position, int chlidePosition) {
        if (position == 2) {
            for (int i = 0; i < datas.get(2).getAttributeList().size(); i++) {
                datas.get(2).getAttributeList().get(i).setChose(false);
            }
            datas.get(2).getAttributeList().get(chlidePosition).setChose(true);
        } else {
            min = "";
            max = "";
            datas.get(position).getAttributeList().get(chlidePosition).setChose(!datas.get(position).getAttributeList().get(chlidePosition).isChose());
        }
        adatper.notifyDataSetChanged();
    }

    @Override
    public void backEidtext(int position, int chlidePosition, String min1, String max1) {
        if (datas.size() > 2) {
            for (int i = 0; i < datas.get(2).getAttributeList().size(); i++) {
                datas.get(2).getAttributeList().get(i).setChose(false);
            }
            adatper.notifyDataSetChanged();
        }
        max = max1;
        min = min1;
    }

    public void backEidtextInput(String min1, String max1) {
        if (datas.size() > 2) {
            for (int i = 0; i < datas.get(2).getAttributeList().size(); i++) {
                datas.get(2).getAttributeList().get(i).setChose(false);
            }
            adatper.notifyDataSetChanged();
        }
        min = min1;
        max = max1;
    }

    /**
     * 获取数据列表
     */
    ScreenBean bean;
    private String max = "", min = "";

    public void houseInfoAttr() {
        HttpHelper.houseInfoAttr(getContext(), houseTypeId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                ed_min.setText("");
                ed_max.setText("");
                datas.clear();
                Gson gson = new Gson();
                HouseInFoAttrBean entity = gson.fromJson(succeed, HouseInFoAttrBean.class);
                if (entity.getCode() == 20000) {
                    for (int i = 0; i < entity.getResult().size(); i++) {
                        if (entity.getResult().get(i).getDescription().equals("楼层")) {
                            bean = new ScreenBean(ScreenBean.Status2);
                        } else {
                            bean = new ScreenBean(ScreenBean.Status1);
                        }
                        bean.setCreated(entity.getResult().get(i).getCreated());
                        bean.setCreatedby(entity.getResult().get(i).getCreatedby());
                        bean.setUpdated(entity.getResult().get(i).getUpdated());
                        bean.setCreatedby(entity.getResult().get(i).getCreatedby());
                        bean.setId(entity.getResult().get(i).getId());
                        bean.setIsactive(entity.getResult().get(i).getIsactive());
                        bean.setCode(entity.getResult().get(i).getCode());
                        bean.setDescription(entity.getResult().get(i).getDescription());
                        bean.setMAttrCateVer(entity.getResult().get(i).getMAttrCateVer());
                        List<ScreenBean.AttributeListBean> attributeList = new ArrayList<>();
                        if (entity.getResult().get(i).getAttributeList() != null) {
                            for (int j = 0; j < entity.getResult().get(i).getAttributeList().size(); j++) {
                                ScreenBean.AttributeListBean chlideBean = new ScreenBean.AttributeListBean();
                                chlideBean.setCreated(entity.getResult().get(i).getAttributeList().get(j).getCreated());
                                chlideBean.setCreatedby(entity.getResult().get(i).getAttributeList().get(j).getCreatedby());
                                chlideBean.setUpdated(entity.getResult().get(i).getAttributeList().get(j).getUpdated());
                                chlideBean.setUpdatedby(entity.getResult().get(i).getAttributeList().get(j).getUpdatedby());
                                chlideBean.setId(entity.getResult().get(i).getAttributeList().get(j).getId());
                                chlideBean.setMAttrCategoryId(entity.getResult().get(i).getAttributeList().get(j).getMAttrCategoryId());
                                chlideBean.setIsactive(entity.getResult().get(i).getAttributeList().get(j).getIsactive());
                                chlideBean.setCode(entity.getResult().get(i).getAttributeList().get(j).getCode());
                                chlideBean.setValue(entity.getResult().get(i).getAttributeList().get(j).getValue());
                                chlideBean.setDescription(entity.getResult().get(i).getAttributeList().get(j).getDescription());
                                attributeList.add(chlideBean);
                            }
                        } else {
                            for (int j = 0; j < 5; j++) {
                                ScreenBean.AttributeListBean chlideBean = new ScreenBean.AttributeListBean();
                                chlideBean.setChose(false);
                                switch (j) {
                                    case 0:
                                        chlideBean.setValue("0");
                                        chlideBean.setCreated("6");
                                        chlideBean.setDescription("6层以下");
                                        break;
                                    case 1:
                                        chlideBean.setValue("6");
                                        chlideBean.setCreated("12");
                                        chlideBean.setDescription("6-12层");
                                        break;
                                    case 2:
                                        chlideBean.setValue("12");
                                        chlideBean.setCreated("20");
                                        chlideBean.setDescription("12-20层");
                                        break;
                                    case 3:
                                        chlideBean.setValue("20");
                                        chlideBean.setCreated("30");
                                        chlideBean.setDescription("20-30层");
                                        break;
                                    case 4:
                                        chlideBean.setValue("30");
                                        chlideBean.setCreated("100");
                                        chlideBean.setDescription("30层以上");
                                        break;
                                }
                                attributeList.add(chlideBean);
                            }
                        }
                        bean.setAttributeList(attributeList);
                        datas.add(bean);
                    }
                    if (adatper == null) {
                        adatper = new ScreenAdatper(datas, getContext(), Dlog_Screen.this);
                        myRcyclerView.setAdapter(adatper);
                    } else {
                        adatper.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onError(String error) {
                MyToast.show(getContext(), error);
            }
        });
    }

    public interface onBackItem {
        void onBack(String decorationCodes, String orientedCodes, String min, String max);
    }

    public void ClicerStatus() {
        min = "0";
        max = "100";
        for (int i = 0; i < datas.size(); i++) {
            for (int j = 0; j < datas.get(i).getAttributeList().size(); j++) {
                datas.get(i).getAttributeList().get(j).setChose(false);
            }
        }
        adatper.notifyDataSetChanged();
    }
}
