package com.example.d_housepropertyproject.ui.mainfgt.apartment.dialog.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.ScreenBean;
import com.example.d_housepropertyproject.view.MyGridView;

import java.util.List;

public class ScreenAdatper extends BaseMultiItemQuickAdapter<ScreenBean, BaseViewHolder> {
    private Context context1;
    private backItem backItem;

    public ScreenAdatper(List<ScreenBean> data, Context context, backItem backItem1) {
        super(data);
        context1 = context;
        this.backItem = backItem1;
        addItemType(ScreenBean.Status1, R.layout.item_screen1);
        addItemType(ScreenBean.Status2, R.layout.item_screen2);
    }

    @Override
    protected void convert(BaseViewHolder helper, ScreenBean item) {
        switch (helper.getItemViewType()) {
            case ScreenBean.Status1:

                break;
            case ScreenBean.Status2:
                break;
        }
        MyGridView myGridView = helper.getView(R.id.my_screengridivew);
        ScreenGridviewAdapter gridviewAdapter = new ScreenGridviewAdapter(context1, item.getAttributeList());
        myGridView.setAdapter(gridviewAdapter);
        myGridView.setOnItemClickListener((parent, view, position, id) -> {
            backItem.backPosition(helper.getPosition(), position);
        });
        helper.setText(R.id.screen_title, item.getDescription());


    }

    public interface backItem {
        void backPosition(int position, int chlidePosition);

        void backEidtext(int position, int chlidePosition, String min, String max);
    }
}
