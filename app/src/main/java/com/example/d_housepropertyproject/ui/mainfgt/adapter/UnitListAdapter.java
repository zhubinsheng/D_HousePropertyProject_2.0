package com.example.d_housepropertyproject.ui.mainfgt.adapter;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;

import java.util.List;
public class UnitListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Context context;

    public UnitListAdapter(List<String> data, Context context1) {
        super(R.layout.view_img, data);
        context = context1;
    }
    @Override
    protected void convert(BaseViewHolder helper, String pic) {
        Glide.with(context).load(pic).into((ImageView)helper.getView(R.id.my_Img));
    }
}
