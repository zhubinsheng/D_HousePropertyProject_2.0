package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserContext;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryLogisticsContext;

import java.util.List;

public class LogisticsInformationAdapter extends BaseMultiItemQuickAdapter<orderQueryLogisticsContext, BaseViewHolder> {

    public LogisticsInformationAdapter(List<orderQueryLogisticsContext> data) {
        super(data);
        addItemType(OrderQueryStoreListUserContext.TYPE1, R.layout.item_logisticsinformation1);//物流状态1
        addItemType(OrderQueryStoreListUserContext.TYPE2, R.layout.item_logisticsinformation2);//物流状态2
    }

    @Override
    protected void convert(BaseViewHolder helper, orderQueryLogisticsContext item) {
        helper.setText(R.id.tv_date, item.getDate())
                .setText(R.id.tv_des, item.getDes());
    }
}