package com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.MyIncomeBean;

import java.util.List;

public class MyIncomeAdapter extends BaseQuickAdapter<MyIncomeBean.ResultBean.IntegralInfoListBean, BaseViewHolder> {
    public MyIncomeAdapter(List<MyIncomeBean.ResultBean.IntegralInfoListBean> data) {
        super(R.layout.item_myincome, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyIncomeBean.ResultBean.IntegralInfoListBean item) {
        helper.setText(R.id.tv_source, item.getSource())
                .setText(R.id.tv_integral, "-" + item.getIntegral());
        if (item.getCreated().length() >= 10) {
            helper.setText(R.id.tv_created, MyTimeUtils.dateToStampTimeHH(item.getCreated() + ""));
        }
    }
}
