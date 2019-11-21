package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean.HouseInspectionChlideBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class HouseInspectionChlideAdapter extends BaseQuickAdapter<HouseInspectionChlideBean.ResultBean.ListBean, BaseViewHolder> {
    private Context context;

    public HouseInspectionChlideAdapter(List<HouseInspectionChlideBean.ResultBean.ListBean> data, Context context1) {
        super(R.layout.item_houseinspectionchlide, data);
        context = context1;
    }
    @Override
    protected void convert(BaseViewHolder helper, HouseInspectionChlideBean.ResultBean.ListBean item) {
        helper.setText(R.id.title, item.getName_trip())
                .setText(R.id.zhiyeguwen, "置业顾问：" + item.getName_adviser())
                .setText(R.id.item_phone, "联系方式：" + item.getPhone())
                .setText(R.id.price, "需付款：￥" + item.getPrice());
        TextView status = helper.getView(R.id.item_status);
        Drawable drawable = null;
        Glide.with(context).load(item.getPic()).into((RoundedImageView) helper.getView(R.id.my_item_hader));
        switch (item.getStatus()) {
            case "d"://意向订单
                status.setText("意向");
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg1);
                helper.getView(R.id.item_order_cancel).setSelected(false);
                helper.getView(R.id.item_order_pay).setSelected(true);
                helper.getView(R.id.item_order_cancel).setVisibility(View.VISIBLE);
                helper.getView(R.id.item_order_pay).setVisibility(View.VISIBLE);
                helper.setText(R.id.item_order_pay, "联系顾问");
                helper.addOnClickListener(R.id.item_order_pay);
                helper.addOnClickListener(R.id.item_order_cancel);
                break;
            case "p"://待付款
                status.setText("待付款");
                helper.getView(R.id.item_order_cancel).setSelected(false);
                helper.getView(R.id.item_order_pay).setSelected(true);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg2);
                helper.getView(R.id.item_order_cancel).setVisibility(View.VISIBLE);
                helper.getView(R.id.item_order_pay).setVisibility(View.VISIBLE);
                helper.setText(R.id.item_order_pay, "立即付款");
                helper.addOnClickListener(R.id.item_order_pay);
                helper.addOnClickListener(R.id.item_order_cancel);
                break;
            case "t"://已付款
                status.setText("已付款");
                helper.getView(R.id.item_order_cancel).setSelected(false);
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_order_pay).setSelected(true);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg3);
                helper.setText(R.id.item_order_pay, "联系顾问");
                helper.addOnClickListener(R.id.item_order_pay);
                helper.addOnClickListener(R.id.item_order_cancel);
                break;
            case "f"://已取消
                status.setText("已取消");
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_order_pay).setVisibility(View.GONE);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg4);
                break;
            case "s"://已完成
                status.setText("已完成");
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_order_pay).setVisibility(View.GONE);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg4);
                break;
            case "x"://待退款
                status.setText("待退款");
                helper.getView(R.id.item_order_cancel).setVisibility(View.GONE);
                helper.getView(R.id.item_order_pay).setVisibility(View.GONE);
                drawable = context.getResources().getDrawable(R.drawable.houseinspectionchilde_bg4);
                break;
        }
        status.setBackground(drawable);
        helper.addOnClickListener(R.id.item_apptment_text);
    }
}
