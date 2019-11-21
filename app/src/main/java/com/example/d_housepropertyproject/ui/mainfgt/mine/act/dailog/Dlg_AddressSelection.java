package com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.adapter.AddrSelectionAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.bean.areagetByParentIdBean;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

/**
 * 门店地址选择
 */
public class Dlg_AddressSelection extends BaseDialog {
    private onBackText onBackText;

    public void setOnBackText(Dlg_AddressSelection.onBackText onBackText) {
        this.onBackText = onBackText;
    }

    public Dlg_AddressSelection(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_addressselection;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    private RecyclerView RecyclerView_province, RecyclerView_city, RecyclerView_area;
    private TextView tv_province, tv_city, tv_area;
    private AddrSelectionAdapter ProvinceAdapter, cityAdapter, areaAdapter;
    private List<areagetByParentIdBean.ResultBean> provinceData = new ArrayList<>();//省
    private List<areagetByParentIdBean.ResultBean> cityData = new ArrayList<>();//市
    private List<areagetByParentIdBean.ResultBean> areaData = new ArrayList<>();//区
    private String stStatus = "1";

    @Override
    protected void initView() {
        setOnClickListener(R.id.cancel);
        setOnClickListener(R.id.center);
        tv_province = getView(R.id.tv_province);
        tv_city = getView(R.id.tv_city);
        tv_area = getView(R.id.tv_area);
        RecyclerView_province = getView(R.id.RecyclerView_province);
        RecyclerView_city = getView(R.id.RecyclerView_city);
        RecyclerView_area = getView(R.id.RecyclerView_area);
        RecyclerView_province.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView_city.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView_area.setLayoutManager(new LinearLayoutManager(getContext()));
        ProvinceAdapter = new AddrSelectionAdapter(provinceData);
        RecyclerView_province.setAdapter(ProvinceAdapter);
        //省点击事件
        ProvinceAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            provinceData.get(ProvinceIndext).setStatus(false);
            provinceData.get(position).setStatus(true);
            ProvinceIndext = position;
            ProvinceAdapter.notifyDataSetChanged();
            tv_province.setText(provinceData.get(position).getCityName());
            stStatus = "2";
            cityData.clear();
            tv_city.setText("请选择");
            tv_area.setText("请选择");
            cityData.clear();
            areaId = "";
            cityAdapter.notifyDataSetChanged();
            areaData.clear();
            areaAdapter.notifyDataSetChanged();
            areagetByParentId(provinceData.get(position).getCodeid() + "");
        });

        cityAdapter = new AddrSelectionAdapter(cityData);
        RecyclerView_city.setAdapter(cityAdapter);
        //市点击事件
        cityAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            cityData.get(cityIndext).setStatus(false);
            cityData.get(position).setStatus(true);
            cityIndext = position;
            cityAdapter.notifyDataSetChanged();
            stStatus = "3";
            areaId = "";
            tv_area.setText("请选择");
            areaData.clear();
            tv_city.setText(cityData.get(position).getCityName());
            areagetByParentId(cityData.get(position).getCodeid() + "");
        });
        areaAdapter = new AddrSelectionAdapter(areaData);
        RecyclerView_area.setAdapter(areaAdapter);
        //区点击事件
        areaAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            areaData.get(areaIndext).setStatus(false);
            areaData.get(position).setStatus(true);
            areaIndext = position;
            areaAdapter.notifyDataSetChanged();
            tv_area.setText(areaData.get(position).getCityName());
            areaId = areaData.get(position).getCodeid() + "";
        });
    }

    String areaId = "";
    private int ProvinceIndext = 0, cityIndext = 0, areaIndext = 0;

    @Override
    protected void initData() {
        stStatus = "1";
        areagetByParentId("1");
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.cancel://取消
                dismiss();
                break;
            case R.id.center://确认
                if (TextUtils.isEmpty(areaId)) {
                    MyToast.show(getContext(), "请选择完整地址，后确认！");
                    return;
                }
                dismiss();
                onBackText.onBackItem(areaId, tv_province.getText().toString() + tv_city.getText().toString() + tv_area.getText().toString());
                break;

        }
    }
    /**
     * 添加联系人
     */
    public void areagetByParentId(String parentId) {
//        HttpHelper.areagetByParentId(parentId, new HttpHelper.HttpUtilsCallBack<String>() {
//            @Override
//            public void onFailure(String failure) {
//                MyToast.show(getContext(), failure);
//            }
//
//            @Override
//            public void onSucceed(String succeed) {
//                Gson gson = new Gson();
//                areagetByParentIdBean entity = gson.fromJson(succeed, areagetByParentIdBean.class);
//                if (entity.getCode() == 20000) {
//                    switch (stStatus) {
//                        case "1"://添加省数据
//                            provinceData.addAll(entity.getResult());
//                            ProvinceAdapter.notifyDataSetChanged();
//                            break;
//                        case "2"://添加市数据
//                            cityData.addAll(entity.getResult());
//                            cityAdapter.notifyDataSetChanged();
//                            break;
//                        case "3"://添加区数据
//                            areaData.addAll(entity.getResult());
//                            areaAdapter.notifyDataSetChanged();
//                            break;
//                    }
//
//
//                }
//
//            }
//
//            @Override
//            public void onError(String error) {
//                MyToast.show(getContext(), error);
//            }
//        });
    }

    public interface onBackText {
        void onBackItem(String areaId, String addr);
    }
}
