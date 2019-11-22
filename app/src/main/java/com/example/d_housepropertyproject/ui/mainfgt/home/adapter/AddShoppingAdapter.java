package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GoodsQueryInfoStoreUserBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

public class AddShoppingAdapter extends BaseQuickAdapter<GoodsQueryInfoStoreUserBean.ResultBean.PAttrsBean, BaseViewHolder> {
    private Context mContext;
    private onBackItem onBackItem;

    public void setOnBackItem(AddShoppingAdapter.onBackItem onBackItem) {
        this.onBackItem = onBackItem;
    }

    public AddShoppingAdapter(Context context, List<GoodsQueryInfoStoreUserBean.ResultBean.PAttrsBean> data) {
        super(R.layout.item_addshopping, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsQueryInfoStoreUserBean.ResultBean.PAttrsBean item) {
        helper.setText(R.id.name, item.getName());
        TagFlowLayout mFlowLayout = helper.getView(R.id.id_flowlayout);
        final LayoutInflater mInflater = LayoutInflater.from(mContext);
        mFlowLayout.setAdapter(new TagAdapter<GoodsQueryInfoStoreUserBean.ResultBean.PAttrsBean.AttrsBeanX>(item.getAttrs()) {
            @Override
            public View getView(FlowLayout parent, int position, GoodsQueryInfoStoreUserBean.ResultBean.PAttrsBean.AttrsBeanX item) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                        mFlowLayout, false);
                tv.setText(item.getValue());
                return tv;
            }
        });
        mFlowLayout.setOnTagClickListener((view, position, parent) -> {
            onBackItem.onItem(helper.getPosition(),position);
            return true;
        });
    }

    public interface onBackItem {
        void onItem(int position, int chlidePosition);
    }
}