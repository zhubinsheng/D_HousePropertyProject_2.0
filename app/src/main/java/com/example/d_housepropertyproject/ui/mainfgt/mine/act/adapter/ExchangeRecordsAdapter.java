package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ExchangeRecordsBean;

import java.util.List;

public class ExchangeRecordsAdapter  extends BaseQuickAdapter<ExchangeRecordsBean, BaseViewHolder> {
    public ExchangeRecordsAdapter(List<ExchangeRecordsBean> data) {
        super(R.layout.item_exchangerecords, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ExchangeRecordsBean item) {
    }
}