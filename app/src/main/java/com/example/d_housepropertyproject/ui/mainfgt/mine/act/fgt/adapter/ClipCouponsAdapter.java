package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.ClipCouponsBean;

import java.util.List;

public class ClipCouponsAdapter extends BaseQuickAdapter<ClipCouponsBean, BaseViewHolder> {
    public ClipCouponsAdapter(List<ClipCouponsBean> data) {
        super(R.layout.item_clipcoupons, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ClipCouponsBean item) {
        helper.addOnClickListener(R.id.item_ClipCoupons_cb);
    }


}
