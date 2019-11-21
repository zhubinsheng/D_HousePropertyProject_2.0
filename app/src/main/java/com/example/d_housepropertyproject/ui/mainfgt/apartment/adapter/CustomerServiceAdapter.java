package com.example.d_housepropertyproject.ui.mainfgt.apartment.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.CustomerServiceBean;

import java.util.List;

public class CustomerServiceAdapter extends BaseQuickAdapter<CustomerServiceBean.ResultBean, BaseViewHolder> {
    public CustomerServiceAdapter(@Nullable List<CustomerServiceBean.ResultBean> data) {
        super(R.layout.item_customerservice, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CustomerServiceBean.ResultBean item) {
        helper.setText(R.id.item_constomer_title, item.getName());
    }
}
