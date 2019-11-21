package com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.bean.ChoseBankBean;

import java.util.List;

/**
 * 银行选择适配器
 */
public class ChoseBankAdapter extends BaseQuickAdapter<ChoseBankBean, BaseViewHolder> {

    public ChoseBankAdapter(List<ChoseBankBean> data) {
        super(R.layout.item_chosebank, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ChoseBankBean item) {

    }


}
