package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.HomeByidBean;
import com.example.d_housepropertyproject.view.ResizableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookingpropertyAdapter extends BaseQuickAdapter<HomeByidBean.ResultBean.ProjectBean.SellingPointListBean, BaseViewHolder> {
    private Context context;

    public BookingpropertyAdapter(List<HomeByidBean.ResultBean.ProjectBean.SellingPointListBean> data, Context context1) {
        super(R.layout.item_preferentialinformation, data);
        context = context1;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeByidBean.ResultBean.ProjectBean.SellingPointListBean item) {
        Picasso.with(context)
                .load(item.getPicUrl())
                .into((ResizableImageView) helper.getView(R.id.oader_img));
    }
}
