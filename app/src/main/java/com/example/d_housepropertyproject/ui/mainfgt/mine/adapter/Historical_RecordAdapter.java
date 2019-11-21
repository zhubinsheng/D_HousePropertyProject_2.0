package com.example.d_housepropertyproject.ui.mainfgt.mine.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.Historical_RecordBean;

import java.util.List;

public class Historical_RecordAdapter extends BaseQuickAdapter<Historical_RecordBean.ResultBean.DataBean, BaseViewHolder> {
    private Context context;

    public Historical_RecordAdapter(List<Historical_RecordBean.ResultBean.DataBean> data, Context context1) {
        super(R.layout.item_historical_record, data);
        context = context1;
    }
    @Override
    protected void convert(BaseViewHolder helper, Historical_RecordBean.ResultBean.DataBean item) {
        if (helper.getPosition() == 0) {
            helper.getView(R.id.item_line).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.item_line).setVisibility(View.VISIBLE);
        }
        if (item != null) {
            Glide.with(context).load(item.getImgurl()).into((ImageView) helper.getView(R.id.item_apartment_img));
            helper.setText(R.id.item_apartment_name, item.getName())
                    .setText(R.id.item_apptment_ReferenceForeignPrice, item.getReferenceForeignPrice() + "")
                    .setText(R.id.item_apptment_referenceRmbPrice, item.getReferenceRmbPrice() + "")
                    .setText(R.id.item_apptment_carpetArea, "面积：" +String.valueOf(item.getCarpetArea() ) + "m²");
        }
    }

}
