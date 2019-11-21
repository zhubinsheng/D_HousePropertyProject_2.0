package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GuiGeBean;

import java.util.List;

public class GuiGeAdapter extends BaseQuickAdapter<GuiGeBean, BaseViewHolder> {
    public GuiGeAdapter(List<GuiGeBean> data) {
        super(R.layout.item_guige, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GuiGeBean item) {
    }
}