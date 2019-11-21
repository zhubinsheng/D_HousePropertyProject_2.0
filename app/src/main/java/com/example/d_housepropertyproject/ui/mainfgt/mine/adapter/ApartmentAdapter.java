package com.example.d_housepropertyproject.ui.mainfgt.mine.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.ApartmentBean;

import java.util.List;

public class ApartmentAdapter extends BaseQuickAdapter<ApartmentBean.ResultBean, BaseViewHolder> {
    private Context context;

    public ApartmentAdapter(List<ApartmentBean.ResultBean> data, Context context1) {
        super(R.layout.item_apartment, data);
        context = context1;
    }

    @Override
    protected void convert(BaseViewHolder helper, ApartmentBean.ResultBean item) {
        if (helper.getPosition() == 0) {
            helper.getView(R.id.item_line).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.item_line).setVisibility(View.VISIBLE);
        }
        helper.addOnClickListener(R.id.item_apptment_text);
        Glide.with(context).load(item.getImgurl()).into((ImageView) helper.getView(R.id.item_apartment_img));
        helper.setText(R.id.item_apartment_name, item.getName())
                .setText(R.id.item_apptment_ReferenceForeignPrice, item.getReferenceForeignPrice() + "")
                .setText(R.id.item_apptment_referenceRmbPrice, item.getReferenceRmbPrice() + "")
                .setText(R.id.item_apptment_carpetArea,"面积："+item.getCarpetArea()+"m²");
    }


}
