package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.AccumulationBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.lykj.aextreme.afinal.utils.Debug;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class AccumulationAdapter extends BaseQuickAdapter<RecommendingCommoditiesBean.ResultBean.ListBean, BaseViewHolder> {
    public AccumulationAdapter(List<RecommendingCommoditiesBean.ResultBean.ListBean> data) {
        super(R.layout.item_accumulation, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendingCommoditiesBean.ResultBean.ListBean item) {
        Glide.with(mContext).load(item.getPic()).into((RoundedImageView) helper.getView(R.id.image));
        int jifen = (int) item.getSalePrice();
        String shenyu=item.getStock();
        helper.setText(R.id.title, item.getName())
                .setText(R.id.costPrice, jifen + " 积分")
                .setText(R.id.shenyuduos, "剩余" + shenyu+ item.getUnit());
    }
}
