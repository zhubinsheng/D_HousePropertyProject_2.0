package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GoodsQueryInfoStoreUserBean;
import java.util.List;
public class GuiGeAdapter extends BaseQuickAdapter<GoodsQueryInfoStoreUserBean.ResultBean.AttrsBean, BaseViewHolder> {
    public GuiGeAdapter(List<GoodsQueryInfoStoreUserBean.ResultBean.AttrsBean> data) {
        super(R.layout.item_guige, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsQueryInfoStoreUserBean.ResultBean.AttrsBean item) {
        helper.setText(R.id.mSubcategoryParamName, item.getMSubcategoryParamName() + "")
                .setText(R.id.valueContext, item.getValue() + "");

    }
}