package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.UnitDetailsBean;

import java.util.List;

public class UnitDetailsAdapter extends BaseQuickAdapter<UnitDetailsBean, BaseViewHolder> {
    public UnitDetailsAdapter(List<UnitDetailsBean> data) {
        super(R.layout.item_unitdetails, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, UnitDetailsBean item) {
    }
}
