package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.CouponBean;

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
                break;
            case CouponBean.IMG:

                break;
            case CouponBean.IMG_TEXT:

                break;
        }
    }
}
