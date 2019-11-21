package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class HouseInspectionChlideStatusBean implements MultiItemEntity {
    public static final int CONTACT = 1;//待联系
    public static final int INTENTION = 2;//意向订单
    public static final int INTENTION2 = 3;//意向订单第二种
    public static final int AWAIT = 4;//待付款
    public static final int PAID = 5;//已付款
    public static final int APPRAISE = 6;//待评价
    public static final int OTHER = 7;//待退款/已完成/已取消
    private int itemType;
    private HouseInspectionChlideBean.ResultBean.ListBean listBean;

    public HouseInspectionChlideStatusBean(int itemType, HouseInspectionChlideBean.ResultBean.ListBean listBean) {
        this.itemType = itemType;
        this.listBean = listBean;
    }

    public HouseInspectionChlideBean.ResultBean.ListBean getListBean() {
        return listBean;
    }

    public void setListBean(HouseInspectionChlideBean.ResultBean.ListBean listBean) {
        this.listBean = listBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
