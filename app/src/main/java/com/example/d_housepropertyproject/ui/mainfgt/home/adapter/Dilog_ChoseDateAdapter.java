package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.Dilog_ChoseDateBean;

import java.util.List;

/**
 * 报名==选择日期
 */
public class Dilog_ChoseDateAdapter extends BaseQuickAdapter<Dilog_ChoseDateBean, BaseViewHolder> {

    public Dilog_ChoseDateAdapter(List<Dilog_ChoseDateBean> data) {
        super(R.layout.item_dilog_chosedate, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, Dilog_ChoseDateBean item) {
        if (item.isStatus()) {
            helper.getView(R.id.choseTime).setSelected(true);
        } else {
            helper.getView(R.id.choseTime).setSelected(false);
        }
        helper.addOnClickListener(R.id.choseTime);
        helper.setText(R.id.choseTime, item.getTime());
    }



}
