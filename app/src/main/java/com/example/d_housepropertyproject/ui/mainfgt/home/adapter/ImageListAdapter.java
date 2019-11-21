package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;

import java.util.List;

public class ImageListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ImageListAdapter( List<String> data) {
        super(R.layout.item_imagelist, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.imghader));
    }
}