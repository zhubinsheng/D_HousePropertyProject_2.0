package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.Popular_recommendaBean;

import java.util.List;

public class Popular_recommendaAdapter extends BaseQuickAdapter<Popular_recommendaBean, BaseViewHolder> {
    private Context context;

    public Popular_recommendaAdapter(List<Popular_recommendaBean> data, Context context1) {
        super(R.layout.item_popular_recommenda, data);
        context = context1;
    }
    @Override
    protected void convert(BaseViewHolder helper, Popular_recommendaBean item) {
        helper.setText(R.id.home_title, item.getHome_title());
        Glide.with(context).load(item.getPic()).into((ImageView) helper.getView(R.id.home_img));
    }
}
