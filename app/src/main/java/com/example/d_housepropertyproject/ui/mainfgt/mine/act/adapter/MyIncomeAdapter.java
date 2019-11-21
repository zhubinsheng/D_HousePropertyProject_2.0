package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.MyIncomeBean;

import java.util.List;

public class MyIncomeAdapter extends BaseQuickAdapter<MyIncomeBean, BaseViewHolder> {
    public MyIncomeAdapter(List<MyIncomeBean> data) {
        super(R.layout.item_myincome, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, MyIncomeBean item) {
    }
}
