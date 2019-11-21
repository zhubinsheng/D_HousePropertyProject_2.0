package com.example.d_housepropertyproject.ui.mainfgt.message.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.message.bean.MessageBean;

import java.util.List;

public class MessageAdapter extends BaseQuickAdapter<MessageBean.ResultBean, BaseViewHolder> {
    private Context context;

    public MessageAdapter(List<MessageBean.ResultBean> data, Context context1) {
        super(R.layout.item_message, data);
        context = context1;
    }
    @Override
    protected void convert(BaseViewHolder helper, MessageBean.ResultBean item) {
        helper.setText(R.id.messge_context, item.getContent())
                .setText(R.id.messge_time, MyTimeUtils.stampToDate(item.getCreated(), "yyyy-MM-dd HH:mm:ss"));
        if (item.getIsread().equals("0")) {
            helper.getView(R.id.message_status).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.message_status).setVisibility(View.GONE);
        }
    }


}
