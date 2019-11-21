package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.content.Context;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class RecommendingCommoditiesAdapter extends BaseQuickAdapter<RecommendingCommoditiesBean, BaseViewHolder> {
    public RecommendingCommoditiesAdapter(List<RecommendingCommoditiesBean> data) {
        super(R.layout.item_recommendingcommodities, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendingCommoditiesBean item) {
        Glide.with(mContext).load(R.mipmap.icon_test).into((RoundedImageView) helper.getView(R.id.image));
    }
}