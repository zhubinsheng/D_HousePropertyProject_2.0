package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.AccumulationBean;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
public class AccumulationAdapter extends BaseQuickAdapter<AccumulationBean, BaseViewHolder> {
    public AccumulationAdapter(List<AccumulationBean> data) {
        super(R.layout.item_accumulation, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, AccumulationBean item) {
        Glide.with(mContext).load(R.mipmap.icon_test).into((RoundedImageView) helper.getView(R.id.image));
    }
}
