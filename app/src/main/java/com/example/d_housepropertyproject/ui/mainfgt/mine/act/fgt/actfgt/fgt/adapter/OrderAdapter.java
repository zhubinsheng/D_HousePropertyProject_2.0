package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgt.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class OrderAdapter extends BaseQuickAdapter<OrderBean.ResultBean.ListBean, BaseViewHolder> {
    private Context context;

    public OrderAdapter(List<OrderBean.ResultBean.ListBean> data, Context context1) {
        super(R.layout.item_order, data);
        context = context1;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean.ResultBean.ListBean item) {
        Glide.with(context).load(item.getPic()).into((RoundedImageView) helper.getView(R.id.title_hader));
        helper.setText(R.id.title, item.getName_adviser() + "" + item.getHuxing())
                .setText(R.id.item_fanghao, item.getFanghao() + " "  + item.getMianji() + "m²")
                .setText(R.id.item_des, "户型解读：" + item.getDes() + "")
                .setText(R.id.item_price, "需付款：￥" + item.getPrice() + "");
        TextView status = helper.getView(R.id.item_status);
        helper.addOnClickListener(R.id.item_apptment_text);
        Drawable drawable = null;
        switch (item.getStatus()) {
            case "p"://待付款
                status.setText("待付款");
                helper.getView(R.id.item_order_pay).setSelected(true);
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_order_pay).setVisibility(View.VISIBLE);
                helper.getView(R.id.item_price).setVisibility(View.VISIBLE);
                helper.setText(R.id.item_price,"需付款：￥"+item.getPrice()+"");
                helper.setText(R.id.item_order_pay, "去支付");
                helper.addOnClickListener(R.id.item_order_pay);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg2);
                break;
            case "s"://已预订
                status.setText("已预订");
                helper.setText(R.id.item_price,"置业顾问："+item.getPhone());
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_order_pay).setSelected(true);
                helper.setText(R.id.item_order_pay, "联系顾问");
                helper.getView(R.id.item_price).setVisibility(View.VISIBLE);
                helper.addOnClickListener(R.id.item_order_pay);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg5);
                break;
            case "f"://已取消
                status.setText("已取消");
                helper.getView(R.id.item_order_pay).setVisibility(View.GONE);
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_price).setVisibility(View.GONE);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg4);
                break;
            case "x"://待退款
                status.setText("待退款");
                helper.getView(R.id.item_order_pay).setVisibility(View.GONE);
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_price).setVisibility(View.GONE);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg4);
                break;
        }
        status.setBackground(drawable);
    }


}
