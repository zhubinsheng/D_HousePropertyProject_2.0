package com.example.d_housepropertyproject.ui.mainfgt.apartment.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.Ap_UnitDetailsBean;

import java.util.List;

public class Ap_UnitDetailsAdapter extends BaseQuickAdapter<Ap_UnitDetailsBean, BaseViewHolder> {
    public Ap_UnitDetailsAdapter(List<Ap_UnitDetailsBean> data) {
        super(R.layout.item_apunitdetails, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Ap_UnitDetailsBean item) {
        helper.getView(R.id.Ap_UnitDetails_shi1).setSelected(item.isStatus());
        helper.getView(R.id.Ap_UnitDetails_shitv1).setSelected(item.isStatus());
        helper.getView(R.id.Ap_UnitDetails_shitvtv1).setSelected(item.isStatus());
        helper.setText(R.id.Ap_UnitDetails_shitv1,item.getName()).setText(R.id.Ap_UnitDetails_shitvtv1,item.getContext());
        helper.addOnClickListener(R.id.Ap_UnitDetails_shi1);
    }
}
