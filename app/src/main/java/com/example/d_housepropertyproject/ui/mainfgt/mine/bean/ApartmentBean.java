package com.example.d_housepropertyproject.ui.mainfgt.mine.bean;

import java.util.List;

public class ApartmentBean {

    /**
     * result : [{"created":"1554714008015","createdby":null,"updated":null,"updatedby":null,"id":"1115177493125873666","name":"1室1厅单卫大阳台","code":"A1","imgurl":"http://116.62.242.76:8080/group1/M00/00/01/rBA9Jlyu5FuAKESQAAF57srmNcs234.jpg","description":"全明设计，采光充足。分区明显，布局合理。嵌入衣柜，关注生活。宽敞公卫，旅居概念。按摩浴缸，高端享受。观光躺椅，家庭SPA。阔景阳台，凭栏远眺。","mProjectId":"1115183033255329793","mProjectPeriodId":null,"carpetArea":37.39,"balconyArea":6.3,"lanArea":1.08,"referenceRmbPrice":"未知","referenceForeignPrice":null},{"created":"1554714436349","createdby":null,"updated":null,"updatedby":null,"id":"1115179289693077505","name":"1室单卫大阳台","code":"A1g","imgurl":"http://116.62.242.76:8080/group1/M00/00/01/rBA9Jlyu5OCADov2AAECmD7JTC8466.jpg","description":"全明设计，采光充足。分区明显，布局合理。嵌入衣柜，关注生活。宽敞公卫，旅居概念。按摩浴缸，高端享受。观光躺椅，家庭SPA。阔景阳台，凭栏远眺。","mProjectId":"1115183033255329793","mProjectPeriodId":null,"carpetArea":28.08,"balconyArea":0,"lanArea":0.92,"referenceRmbPrice":"未知","referenceForeignPrice":null}]
     * message : 成功
     * code : 20000
     */

    private String message;
    private int code;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * created : 1554714008015
         * createdby : null
         * updated : null
         * updatedby : null
         * id : 1115177493125873666
         * name : 1室1厅单卫大阳台
         * code : A1
         * imgurl : http://116.62.242.76:8080/group1/M00/00/01/rBA9Jlyu5FuAKESQAAF57srmNcs234.jpg
         * description : 全明设计，采光充足。分区明显，布局合理。嵌入衣柜，关注生活。宽敞公卫，旅居概念。按摩浴缸，高端享受。观光躺椅，家庭SPA。阔景阳台，凭栏远眺。
         * mProjectId : 1115183033255329793
         * mProjectPeriodId : null
         * carpetArea : 37.39
         * balconyArea : 6.3
         * lanArea : 1.08
         * referenceRmbPrice : 未知
         * referenceForeignPrice : null
         */

        private String created;
        private Object createdby;
        private Object updated;
        private Object updatedby;
        private String id;
        private String name;
        private String code;
        private String imgurl;
        private String description;
        private String mProjectId;
        private Object mProjectPeriodId;
        private double carpetArea;
        private double balconyArea;
        private double lanArea;
        private String referenceRmbPrice;
        private String referenceForeignPrice;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMProjectId() {
            return mProjectId;
        }

        public void setMProjectId(String mProjectId) {
            this.mProjectId = mProjectId;
        }

        public Object getMProjectPeriodId() {
            return mProjectPeriodId;
        }

        public void setMProjectPeriodId(Object mProjectPeriodId) {
            this.mProjectPeriodId = mProjectPeriodId;
        }

        public double getCarpetArea() {
            return carpetArea;
        }

        public void setCarpetArea(double carpetArea) {
            this.carpetArea = carpetArea;
        }

        public double getBalconyArea() {
            return balconyArea;
        }

        public void setBalconyArea(double balconyArea) {
            this.balconyArea = balconyArea;
        }

        public double getLanArea() {
            return lanArea;
        }

        public void setLanArea(double lanArea) {
            this.lanArea = lanArea;
        }

        public String getReferenceRmbPrice() {
            if (referenceRmbPrice == null || referenceRmbPrice.equals("null")) {
                referenceRmbPrice = "未知";
            }
            return referenceRmbPrice;
        }

        public void setReferenceRmbPrice(String referenceRmbPrice) {
            this.referenceRmbPrice = referenceRmbPrice;
        }

        public String getReferenceForeignPrice() {
            if (referenceForeignPrice == null || referenceForeignPrice.equals("null")) {
                referenceForeignPrice = "未知";
            }
            return referenceForeignPrice;
        }

        public void setReferenceForeignPrice(String referenceForeignPrice) {
            this.referenceForeignPrice = referenceForeignPrice;
        }
    }
}
