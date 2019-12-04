package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.ClipCouponsBean;

import java.util.List;

public class ClipCouponsAdapter extends BaseQuickAdapter<ClipCouponsBean.ResultBean, BaseViewHolder> {
    public ClipCouponsAdapter(List<ClipCouponsBean.ResultBean> data) {
        super(R.layout.item_clipcoupons, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ClipCouponsBean.ResultBean item) {
        helper.addOnClickListener(R.id.item_ClipCoupons_cb);
        TextView price = helper.getView(R.id.price);
        TextView pricedayang = helper.getView(R.id.dayang);
        if (item.getType().equals("1")) {
            helper.setText(R.id.tv_type, "房产优惠券");
            price.setTextColor(mContext.getResources().getColor(R.color.mycolor1));
            pricedayang.setTextColor(mContext.getResources().getColor(R.color.mycolor1));
        } else if (item.getType().equals("3")) {
            helper.setText(R.id.tv_type, "商品优惠券");
            price.setTextColor(mContext.getResources().getColor(R.color.mycolor2));
            pricedayang.setTextColor(mContext.getResources().getColor(R.color.mycolor2));
        }
    }
}
