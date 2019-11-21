package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.BillBean;

import java.util.List;

public class BillAdapter extends BaseQuickAdapter<BillBean, BaseViewHolder> {
    public BillAdapter(List<BillBean> data) {
        super(R.layout.item_bill, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, BillBean item) {
    }


}
