package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.ClipCouponsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.couponGetCouponListBean;

import java.util.List;

public class ClipCouponsAdapter extends BaseQuickAdapter<couponGetCouponListBean.ResultBean.CouponBean, BaseViewHolder> {
    public ClipCouponsAdapter(List<couponGetCouponListBean.ResultBean.CouponBean> data) {
        super(R.layout.item_clipcoupons, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, couponGetCouponListBean.ResultBean.CouponBean item) {
        TextView price = helper.getView(R.id.price);
        TextView pricedayang = helper.getView(R.id.dayang);
        if (item.getType().equals("1")) {
            helper.setText(R.id.tv_type, "房产优惠券");
            helper.setText(R.id.item_fangfa,"满"+item.getSuitable()+"元可使用");
            price.setTextColor(mContext.getResources().getColor(R.color.mycolor1));
            pricedayang.setTextColor(mContext.getResources().getColor(R.color.mycolor1));
        } else if (item.getType().equals("3")) {
            helper.setText(R.id.tv_type, "商品优惠券");
            helper.setText(R.id.item_fangfa,"满"+item.getSuitable()+"元可使用");
            price.setTextColor(mContext.getResources().getColor(R.color.mycolor2));
            pricedayang.setTextColor(mContext.getResources().getColor(R.color.mycolor2));
        }
        helper.setText(R.id.time,"有效期至 "+MyTimeUtils.dateToStampTimeHH(item.getTimeOverdate()));
        price.setText(item.getPrice()+"");


    }
}
