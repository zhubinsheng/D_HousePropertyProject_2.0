package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

public class IntegralGetMyIntegralBean {

    /**
     * result : {"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"1","isactive":"1","totalIntegral":1,"pUserId":"1"}
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
         * isactive : 1
         * totalIntegral : 1
         * pUserId : 1
         */

        private Object created;
        private Object createdby;
        private Object updated;
        private Object updatedby;
        private String id;
        private String isactive;
        private int totalIntegral;
        private String pUserId;

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

        public String getIsactive() {
            return isactive;
        }

        public void setIsactive(String isactive) {
            this.isactive = isactive;
        }

        public int getTotalIntegral() {
            return totalIntegral;
        }

        public void setTotalIntegral(int totalIntegral) {
            this.totalIntegral = totalIntegral;
        }

        public String getPUserId() {
            return pUserId;
        }

        public void setPUserId(String pUserId) {
            this.pUserId = pUserId;
        }
    }
}
