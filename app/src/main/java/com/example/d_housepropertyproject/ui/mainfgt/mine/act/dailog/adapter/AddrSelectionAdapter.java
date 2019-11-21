package com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.bean.areagetByParentIdBean;

import java.util.List;

public class AddrSelectionAdapter extends BaseQuickAdapter<areagetByParentIdBean.ResultBean, BaseViewHolder> {
    public AddrSelectionAdapter(List<areagetByParentIdBean.ResultBean> data) {
        super(R.layout.item_addrselectionadapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, areagetByParentIdBean.ResultBean item) {
        TextView name = helper.getView(R.id.tv_name);
        name.setText(item.getCityName());
        name.setSelected(item.isStatus());
        helper.addOnClickListener(R.id.tv_name);
    }
}