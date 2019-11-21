package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.HomeGridViewBean;

import java.util.List;

public class HomeGridViewAdapter1 extends BaseQuickAdapter<HomeGridViewBean, BaseViewHolder> {
    public HomeGridViewAdapter1(List<HomeGridViewBean> data) {
        super(R.layout.item_homegridview, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGridViewBean item) {
        Glide.with(mContext).load(item.getImg()).into((ImageView) helper.getView(R.id.home_grid_img));
        helper.setText(R.id.home_grid_name, item.getTitleName());
    }
}