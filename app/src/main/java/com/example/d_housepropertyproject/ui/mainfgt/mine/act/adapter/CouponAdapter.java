package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;

import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.CouponBean;
import com.lykj.aextreme.afinal.utils.TimeUtils;

import java.util.List;

public class CouponAdapter extends BaseMultiItemQuickAdapter<CouponBean, BaseViewHolder> {

    public CouponAdapter(List<CouponBean> data) {
        super(data);
        addItemType(CouponBean.TEXT, R.layout.item_coupon_notused);
        addItemType(CouponBean.IMG, R.layout.item_coupon_alreadyused);
        addItemType(CouponBean.IMG_TEXT, R.layout.item_coupon_failure);
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponBean item) {
        switch (helper.getItemViewType()) {
            case CouponBean.TEXT:
                helper.addOnClickListener(R.id.item_coupon_notused_but);
                if (TextUtils.isEmpty(item.getSuitable())) {
                    helper.setText(R.id.suitable, "满0元可使用");
                } else {
                    helper.setText(R.id.suitable, "满" + item.getSuitable() + "元可使用");
                }
                helper.setText(R.id.timeOverdate, MyTimeUtils.dateToStampTimeHH(item.getTimeOverdate() + ""));
                TextView price = helper.getView(R.id.price);
                TextView pricedayang = helper.getView(R.id.dayang);
                if (item.getType().equals("1")) {
                    helper.setText(R.id.tv_type, "房产优惠券");
                    price.setTextColor(mContext.getResources().getColor(R.color.mycolor1));
                    pricedayang.setTextColor(mContext.getResources().getColor(R.color.mycolor1));
                } else if (item.getType().equals("3")) {
                    helper.setText(R.id.tv_type, "房产优惠券");
                    price.setTextColor(mContext.getResources().getColor(R.color.mycolor2));
                    pricedayang.setTextColor(mContext.getResources().getColor(R.color.mycolor2));
                }
                break;
            case CouponBean.IMG:

                break;
            case CouponBean.IMG_TEXT:

                break;
        }
        helper.setText(R.id.price, item.getPrice() + "");

    }
}
