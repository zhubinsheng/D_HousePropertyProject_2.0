package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ExchangeRecordsBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ExchangeRecordsAdapter  extends BaseQuickAdapter<ExchangeRecordsBean.ResultBean.ListBean, BaseViewHolder> {
    public ExchangeRecordsAdapter(List<ExchangeRecordsBean.ResultBean.ListBean> data) {
        super(R.layout.item_exchangerecords, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ExchangeRecordsBean.ResultBean.ListBean item) {
        helper.setText(R.id.price,item.getPrice()+"")
                .setText(R.id.tv_name,item.getName())
                .setText(R.id.time, MyTimeUtils.dateToStampTimeHH(item.getTime()))
                .setText(R.id.count,"x"+item.getCount());
        Glide.with(mContext).load(item.getPic()).into((RoundedImageView)helper.getView(R.id.image));
    }
}