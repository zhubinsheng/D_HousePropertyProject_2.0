package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class CouponBean implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    private int itemType;

    public CouponBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
