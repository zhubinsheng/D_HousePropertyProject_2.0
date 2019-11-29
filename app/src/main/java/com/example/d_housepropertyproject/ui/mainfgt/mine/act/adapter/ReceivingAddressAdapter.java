package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ReceivingAddressBean;

import java.util.List;

public class ReceivingAddressAdapter extends BaseQuickAdapter<ReceivingAddressBean.ResultBean, BaseViewHolder> {
    public ReceivingAddressAdapter(List<ReceivingAddressBean.ResultBean> data) {
        super(R.layout.item_receivingaddress, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReceivingAddressBean.ResultBean item) {
        helper.setText(R.id.tv_linkmanPhone, item.getLinkman() + " " + item.getPhone())
                .setText(R.id.tv_address, item.getAddress());
        helper.addOnClickListener(R.id.tv_bianji);
        helper.addOnClickListener(R.id.item_addr);
        TextView tvChecoe = helper.getView(R.id.tv_checkbox);
        if (item.getIsdefault().equals("1")) {
            tvChecoe.setSelected(true);
        } else {
            tvChecoe.setSelected(false);
        }

    }
}
