package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.PreferentialInformationBean;
import com.example.d_housepropertyproject.view.ResizableImageView;

import java.util.List;

public class PreferentialInformationAdapter extends BaseQuickAdapter<PreferentialInformationBean.ResultBean.FileListBean.Qualification06Bean, BaseViewHolder> {
    private Context context;

    public PreferentialInformationAdapter(List<PreferentialInformationBean.ResultBean.FileListBean.Qualification06Bean> data, Context context1) {
        super(R.layout.item_preferentialinformation, data);
        context = context1;
    }
    @Override
    protected void convert(BaseViewHolder helper,PreferentialInformationBean.ResultBean.FileListBean.Qualification06Bean item) {
        Glide.with(context).load(item.getPath()).into((ResizableImageView)helper.getView(R.id.oader_img));
    }
}
