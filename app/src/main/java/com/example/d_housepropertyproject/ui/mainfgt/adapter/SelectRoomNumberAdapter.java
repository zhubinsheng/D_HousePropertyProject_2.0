package com.example.d_housepropertyproject.ui.mainfgt.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.SelectRoomNumberBean;

import java.util.List;

public class SelectRoomNumberAdapter extends BaseQuickAdapter<SelectRoomNumberBean.ResultBean, BaseViewHolder> {
    private Context context;

    public SelectRoomNumberAdapter(List<SelectRoomNumberBean.ResultBean> data, Context context1) {
        super(R.layout.item_selectroomnumber, data);
        context = context1;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectRoomNumberBean.ResultBean item) {
        helper.getView(R.id.my_historical_item).setSelected(item.isStatus());
        helper.getView(R.id.item_title).setSelected(item.isStatus());
        helper.getView(R.id.item_context).setSelected(item.isStatus());
        helper.getView(R.id.item_taiguo_price).setSelected(item.isStatus());
        helper.getView(R.id.item_price).setSelected(item.isStatus());
        helper.getView(R.id.item_fuhao).setSelected(item.isStatus());
        helper.setText(R.id.item_title, item.getPeriod() +item.getBuilder() + item.getUnit() + item.getRoomNumber())
                .setText(R.id.item_context, item.getOriented() + "•" +item.getFloors()+"楼"+ "•" + item.getDecoration())
                .setText(R.id.item_price, item.getReferenceRmbPrice() +"");
    }
}
