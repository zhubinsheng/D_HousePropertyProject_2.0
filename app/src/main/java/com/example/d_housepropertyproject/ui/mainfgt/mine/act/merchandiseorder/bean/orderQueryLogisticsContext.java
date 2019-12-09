package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class orderQueryLogisticsContext implements MultiItemEntity {
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;

    public orderQueryLogisticsContext(int itemType) {
        this.itemType = itemType;
    }
    private int itemType;

    @Override
    public int getItemType() {
        return itemType;
    }

    private String created;
    private Object createdby;
    private Object updated;
    private Object updatedby;
    private String id;
    private String isactive;
    private String des;
    private Object status;
    private String date;
    private String wLogisticsId;
    private int seq;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Object getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Object createdby) {
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

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWLogisticsId() {
        return wLogisticsId;
    }

    public void setWLogisticsId(String wLogisticsId) {
        this.wLogisticsId = wLogisticsId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
