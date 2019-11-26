package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.MyOrderDetaleBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class MyOrderDetaleAdapter extends BaseQuickAdapter<MyOrderDetaleBean.ResultBean.ProductsBean, BaseViewHolder> {
    public MyOrderDetaleAdapter(List<MyOrderDetaleBean.ResultBean.ProductsBean> data) {
        super(R.layout.item_myorderdetale, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyOrderDetaleBean.ResultBean.ProductsBean item) {
        Glide.with(mContext).load(item.getAlbumPics()).into((RoundedImageView) helper.getView(R.id.image));
        helper.setText(R.id.context_title, item.getName());
        helper.setText(R.id.num, "x" + item.getNum())
                .setText(R.id.salePrice, item.getSalePrice() + "")
                .setText(R.id.unit,"/"+item.getUnit())
                .setText(R.id.price, "市场价:" + item.getPrice() + "/"+item.getUnit())
        ;


    }
}