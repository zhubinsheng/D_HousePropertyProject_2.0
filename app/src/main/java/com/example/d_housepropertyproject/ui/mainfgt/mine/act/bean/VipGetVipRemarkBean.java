package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

public class VipGetVipRemarkBean {

    /**
     * result : {"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"1","remark":"这个是会员权益描述","price":10}
     * message : 成功
     * code : 20000
     */

    private ResultBean result;
    private String message;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * created : null
         * createdby : null
         * updated : null
         * updatedby : null
         * id : 1
         * remark : 这个是会员权益描述
         * price : 10.0
         */

        private Object created;
        private Object createdby;
        private Object updated;
        private Object updatedby;
        private String id;
        private String remark;
        private double price;

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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
