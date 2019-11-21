package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class RecommendingCommoditiesAdapter extends BaseQuickAdapter<RecommendingCommoditiesBean.ResultBean.ListBean, BaseViewHolder> {
    public RecommendingCommoditiesAdapter(List<RecommendingCommoditiesBean.ResultBean.ListBean> data) {
        super(R.layout.item_recommendingcommodities, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendingCommoditiesBean.ResultBean.ListBean item) {
        Glide.with(mContext).load(item.getPic()).into((RoundedImageView) helper.getView(R.id.image));
        helper.setText(R.id.title, item.getName())
                .setText(R.id.costPrice, item.getSalePrice() + "/" + item.getUnit());
        if (item.getNewStatus().equals("0")) {
            helper.getView(R.id.newStatus).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.newStatus).setVisibility(View.VISIBLE);
        }
    }
}