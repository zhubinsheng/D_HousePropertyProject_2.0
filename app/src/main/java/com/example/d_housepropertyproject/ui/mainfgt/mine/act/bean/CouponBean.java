package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class CouponBean implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    private int itemType;
    /**
     * created : 1574662847068
     * createdby : 1
     * updated : null
     * updatedby : null
     * id : 1
     * idInfo : 1
     * idOrder : null
     * idUser : 1
     * price : 1.0
     * timeUsed : null
     * fettle : 1
     * isactive : 1
     * timeOverdate : 1574749247052
     * suitable : 10
     * type : 1
     */

    private String created;
    private String createdby;
    private Object updated;
    private Object updatedby;
    private String id;
    private String idInfo;
    private Object idOrder;
    private String idUser;
    private String price;
    private Object timeUsed;
    private String fettle;
    private String isactive;
    private String timeOverdate;
    private String suitable;
    private String type;

    public CouponBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Object getUpdated() {
        return updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public Object getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Object updatedby) {
        this.updatedby = updatedby;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(String idInfo) {
        this.idInfo = idInfo;
    }

    public Object getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Object idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Object getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Object timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getFettle() {
        return fettle;
    }

    public void setFettle(String fettle) {
        this.fettle = fettle;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getTimeOverdate() {
        return timeOverdate;
    }

    public void setTimeOverdate(String timeOverdate) {
        this.timeOverdate = timeOverdate;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
