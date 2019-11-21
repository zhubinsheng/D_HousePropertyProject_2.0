package com.example.d_housepropertyproject.ui.mainfgt.apartment.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class ScreenBean implements MultiItemEntity {
    public static final int Status1 = 1;
    public static final int Status2 = 2;
    private int itemType;
    public ScreenBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    /**
     * created : null
     * createdby : null
     * updated : null
     * updatedby : null
     * id : 1
     * isactive : null
     * code : orientedAttrCode
     * description : 朝向
     * mAttrCateVer : 1
     * attributeList : [{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"1","mAttrCategoryId":"1","isactive":null,"code":"oriented1","value":"东","description":"东"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"2","mAttrCategoryId":"1","isactive":null,"code":"oriented2","value":"南","description":"南"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"3","mAttrCategoryId":"1","isactive":null,"code":"oriented3","value":"西","description":"西"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"4","mAttrCategoryId":"1","isactive":null,"code":"oriented4","value":"北","description":"北"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"5","mAttrCategoryId":"1","isactive":null,"code":"oriented5","value":"南北","description":"南北"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"6","mAttrCategoryId":"1","isactive":null,"code":"oriented6","value":"东西","description":"东西"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"7","mAttrCategoryId":"1","isactive":null,"code":"oriented7","value":"东南","description":"东南"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"8","mAttrCategoryId":"1","isactive":null,"code":"oriented8","value":"西南","description":"西南"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"9","mAttrCategoryId":"1","isactive":null,"code":"oriented9","value":"东北","description":"东北"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"10","mAttrCategoryId":"1","isactive":null,"code":"oriented10","value":"西北","description":"西北"}]
     */

    private Object created;
    private Object createdby;
    private Object updated;
    private Object updatedby;
    private String id;
    private Object isactive;
    private String code;
    private String description;
    private String mAttrCateVer;
    private List<ScreenBean.AttributeListBean> attributeList;

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
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

    public Object getIsactive() {
        return isactive;
    }

    public void setIsactive(Object isactive) {
        this.isactive = isactive;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMAttrCateVer() {
        return mAttrCateVer;
    }

    public void setMAttrCateVer(String mAttrCateVer) {
        this.mAttrCateVer = mAttrCateVer;
    }

    public List<ScreenBean.AttributeListBean> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<ScreenBean.AttributeListBean> attributeList) {
        this.attributeList = attributeList;
    }

    public static class AttributeListBean {
        public boolean isChose() {
            return isChose;
        }

        public void setChose(boolean chose) {
            isChose = chose;
        }

        /**
         * created : null
         * createdby : null
         * updated : null
         * updatedby : null
         * id : 1
         * mAttrCategoryId : 1
         * isactive : null
         * code : oriented1
         * value : 东
         * description : 东
         */
        private boolean isChose;
        private Object created;
        private Object createdby;
        private Object updated;
        private Object updatedby;
        private String id;
        private String mAttrCategoryId;
        private Object isactive;
        private String code;
        private String value;
        private String description;

        public Object getCreated() {
            return created;
        }

        public void setCreated(Object created) {
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

        public String getMAttrCategoryId() {
            return mAttrCategoryId;
        }

        public void setMAttrCategoryId(String mAttrCategoryId) {
            this.mAttrCategoryId = mAttrCategoryId;
        }

        public Object getIsactive() {
            return isactive;
        }

        public void setIsactive(Object isactive) {
            this.isactive = isactive;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
