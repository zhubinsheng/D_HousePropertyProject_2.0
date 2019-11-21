package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean.HouseInspectionChlideStatusBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class HouseInspectionChlideBaseAdapter extends BaseMultiItemQuickAdapter<HouseInspectionChlideStatusBean, BaseViewHolder> {
    private Context context;

    public HouseInspectionChlideBaseAdapter(List<HouseInspectionChlideStatusBean> data, Context context1) {
        super(data);
        context = context1;
        addItemType(HouseInspectionChlideStatusBean.CONTACT, R.layout.item_contact);//待联系
        addItemType(HouseInspectionChlideStatusBean.INTENTION, R.layout.item_intention);//意向订单
        addItemType(HouseInspectionChlideStatusBean.INTENTION2, R.layout.item_intention2);//意向订单第二种
        addItemType(HouseInspectionChlideStatusBean.AWAIT, R.layout.item_await);//待付款
        addItemType(HouseInspectionChlideStatusBean.PAID, R.layout.item_paid);//已付款
        addItemType(HouseInspectionChlideStatusBean.APPRAISE, R.layout.item_appraise);//待评价
        addItemType(HouseInspectionChlideStatusBean.OTHER, R.layout.item_other);//待退款/已完成/已取消
    }

    @Override
    protected void convert(BaseViewHolder helper, HouseInspectionChlideStatusBean item) {
        switch (helper.getItemViewType()) {
            case HouseInspectionChlideStatusBean.CONTACT://待联系
                helper.addOnClickListener(R.id.item_Contact_cancel);//取消订单
                helper.addOnClickListener(R.id.item_Contact_evaluate);//评价邀请人
                helper.addOnClickListener(R.id.item_Contact_customerService);//联系客服
                if (item.getListBean().getId_rate_r() != null) {
                    helper.getView(R.id.item_Contact_evaluate).setVisibility(View.GONE);
                } else {
                    helper.getView(R.id.item_Contact_evaluate).setVisibility(View.VISIBLE);
                }
                if (item.getListBean().getId_recommend() != null) {
                    helper.getView(R.id.item_Contact_evaluate).setVisibility(View.VISIBLE);
                } else {
                    helper.getView(R.id.item_Contact_evaluate).setVisibility(View.GONE);
                }
                if (item.getListBean().getName_ins() != null) {
                    helper.setText(R.id.item_phone, "系统正在为您安排置业顾问");
                } else {
                    helper.setText(R.id.item_phone, "保持联系电话畅通，等待客服与您联系！");
                }
                break;
            case HouseInspectionChlideStatusBean.INTENTION://意向订单
                if (item.getListBean().getName_ins() != null) {
                    helper.setText(R.id.item_phone, "系统正在为您安排置业顾问");
                } else {
                    helper.setText(R.id.item_phone, "保持联系电话畅通，等待客服与您联系！");
                }
                helper.addOnClickListener(R.id.item_INTENTION_evaluate);//评价邀请人
                helper.addOnClickListener(R.id.item_INTENTION_customerService);//联系客服
                helper.addOnClickListener(R.id.item_INTENTION_cancel);//取消订单
                if (item.getListBean().getId_recommend() != null) {
                    helper.getView(R.id.item_INTENTION_evaluate).setVisibility(View.VISIBLE);
                } else {
                    helper.getView(R.id.item_INTENTION_evaluate).setVisibility(View.GONE);
                }
                break;
            case HouseInspectionChlideStatusBean.INTENTION2://意向订单第二种
                helper.getView(R.id.item_INTENTION2_GUWEN).setSelected(true);
                helper.addOnClickListener(R.id.item_INTENTION2_GUWEN);//联系置业顾问
                helper.addOnClickListener(R.id.item_INTENTION2_cancel);//取消订单
                helper.setText(R.id.zhiyeguwen, "置业顾问：" + item.getListBean().getName_adviser())
                        .setText(R.id.item_phone, "联系方式：" + item.getListBean().getPhone());
                break;
            case HouseInspectionChlideStatusBean.AWAIT://待付款
                helper.getView(R.id.item_order_pay).setSelected(true);
                helper.addOnClickListener(R.id.item_order_cancel);//取消订单
                helper.addOnClickListener(R.id.item_order_pay);//联系置业顾问
                helper.setText(R.id.price, "需付款：￥" + item.getListBean().getPrice())
                        .setText(R.id.zhiyeguwen, "置业顾问：" + item.getListBean().getName_adviser())
                        .setText(R.id.item_phone, "联系方式：" + item.getListBean().getPhone());
                break;
            case HouseInspectionChlideStatusBean.PAID://已付款
                helper.addOnClickListener(R.id.item_PAID_evaluate);
                helper.getView(R.id.item_PAID_GUWEN).setSelected(true);
                helper.addOnClickListener(R.id.item_PAID_GUWEN);//联系置业顾问
                helper.addOnClickListener(R.id.item_PAID_cancel);//申请退款
                helper
//                        .setText(R.id.price, "" + item.getListBean().getPrice())
                        .setText(R.id.zhiyeguwen, "置业顾问：" + item.getListBean().getName_adviser())
                        .setText(R.id.item_phone, "联系方式：" + item.getListBean().getPhone());
                break;
            case HouseInspectionChlideStatusBean.APPRAISE://待评价
                helper.getView(R.id.item_APPRAISE_GUWEN).setSelected(true);
                helper.addOnClickListener(R.id.item_APPRAISE_GUWEN);//置业顾问
                if (item.getListBean().getId_rate_c() != null) {
                    helper.getView(R.id.item_APPRAISE_GUWEN).setVisibility(View.GONE);
                } else {
                    helper.getView(R.id.item_APPRAISE_GUWEN).setVisibility(View.VISIBLE);
                }
                helper.getView(R.id.item_APPRAISE_APPRAISEGUWEN).setSelected(true);
                helper.addOnClickListener(R.id.item_APPRAISE_APPRAISEGUWEN);//评价置业顾问
                helper.setText(R.id.zhiyeguwen, "置业顾问：" + item.getListBean().getName_adviser())
                        .setText(R.id.item_phone, "联系方式：" + item.getListBean().getPhone());
                break;
            case HouseInspectionChlideStatusBean.OTHER://待退款/已完成/已取消
                TextView status = helper.getView(R.id.item_status);
                switch (item.getListBean().getStatus()) {
                    case "f"://已取消
                        status.setText("已取消");
                        break;
                    case "s"://已完成
                        TextView pingjia = helper.getView(R.id.item_OTHER_evaluate);
                        pingjia.setVisibility(View.VISIBLE);
                        helper.addOnClickListener(R.id.item_OTHER_evaluate);
                        status.setText("已完成");
                        break;
                    case "x"://待退款
                        status.setText("待退款");
                        break;
                }
                helper.setText(R.id.title_Time, MyTimeUtils.stampToDate(item.getListBean().getTime_begin(), "yyyy年MM月dd日") + "看房团报名");
//                helper.setText(R.id.zhiyeguwen, "置业顾问：" + item.getListBean().getName_adviser());
                break;
        }
        helper.addOnClickListener(R.id.item_apptment_text);
        Glide.with(context).load(item.getListBean().getPic()).into((RoundedImageView) helper.getView(R.id.my_item_hader));
        helper.setText(R.id.title, item.getListBean().getName_trip());
    }
}
