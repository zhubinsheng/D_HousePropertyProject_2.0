package com.example.d_housepropertyproject.ui.mainfgt.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.bean.HomeBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.List;

public class HomeAdapter extends BaseMultiItemQuickAdapter<HomeBean, BaseViewHolder> {
    private Context context1;
    public HomeAdapter(List<HomeBean> data,Context context) {
        super(data);
        context1=context;
        addItemType(HomeBean.TEXT, R.layout.item_home_textimg);
        addItemType(HomeBean.IMG_TEXT, R.layout.item_home_img);
        addItemType(HomeBean.IMG, R.layout.item_home_maximg);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean item) {
        switch (helper.getItemViewType()) {
            case HomeBean.TEXT:
                break;
            case HomeBean.IMG:
                Debug.e("-----------------url==="+item.getPicUrl());
                Glide.with(context1).load(item.getPicUrl()).into((ImageView)helper.getView(R.id.home_item_imag));
                break;
        }
    }
}
