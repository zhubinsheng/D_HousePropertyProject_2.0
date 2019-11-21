package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ReceivingAddressBean;

import java.util.List;

public class ReceivingAddressAdapter extends BaseQuickAdapter<ReceivingAddressBean, BaseViewHolder> {
    public ReceivingAddressAdapter(List<ReceivingAddressBean> data) {
        super(R.layout.item_receivingaddress, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ReceivingAddressBean item) {
    }
}
