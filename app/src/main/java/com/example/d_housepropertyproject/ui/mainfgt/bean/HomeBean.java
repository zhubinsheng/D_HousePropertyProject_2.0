package com.example.d_housepropertyproject.ui.mainfgt.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class HomeBean implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    private int itemType;
    /**
     * created : 1554715331691
     * createdby : null
     * updated : null
     * updatedby : null
     * id : 1115183045032935426
     * mProject : 1115183033255329793
     * name : SELLING_POINT
     * description :
     * picUrl : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrEsKAMouhABqw0BMfDbk381.png
     * type : sellingPoint
     * isactive : 1
     */

    private String created;
    private Object createdby;
    private Object updated;
    private Object updatedby;
    private String id;
    private String mProject;
    private String name;
    private String description;
    private String picUrl;
    private String type;
    private String isactive;

    public HomeBean(int itemType) {
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

    public String getMProject() {
        return mProject;
    }

    public void setMProject(String mProject) {
        this.mProject = mProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }
}
