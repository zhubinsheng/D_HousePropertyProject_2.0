package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserContext;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class MyOrderChldeType1Adapter extends BaseQuickAdapter<OrderQueryStoreListUserContext.ProductsBean, BaseViewHolder> {
    private Context mContext;

    public MyOrderChldeType1Adapter(Context context, List<OrderQueryStoreListUserContext.ProductsBean> data) {
        super(R.layout.item_myorderchldetype1, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper,OrderQueryStoreListUserContext.ProductsBean item) {
        Glide.with(mContext).load(item.getAlbumPics()).into((RoundedImageView)helper.getView(R.id.image));
    }
}