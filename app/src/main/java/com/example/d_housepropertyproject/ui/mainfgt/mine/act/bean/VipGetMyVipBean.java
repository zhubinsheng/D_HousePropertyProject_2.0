package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

public class VipGetMyVipBean {

    /**
     * result : {"created":"1575267545655","createdby":"1148857755712253955","updated":null,"updatedby":null,"id":"1201385278270214145","isactive":"1","startTime":"1575267545655","endTime":"1606889945655","payment":null,"status":null,"pUserId":null}
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
         * created : 1575267545655
         * createdby : 1148857755712253955
         * updated : null
         * updatedby : null
         * id : 1201385278270214145
         * isactive : 1
         * startTime : 1575267545655
         * endTime : 1606889945655
         * payment : null
         * status : null
         * pUserId : null
         */

        private String created;
        private String createdby;
        private Object updated;
        private Object updatedby;
        private String id;
        private String isactive;
        private String startTime;
        private String endTime;
        private Object payment;
        private Object status;
        private Object pUserId;

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

        public String getIsactive() {
            return isactive;
        }

        public void setIsactive(String isactive) {
            this.isactive = isactive;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public Object getPayment() {
            return payment;
        }

        public void setPayment(Object payment) {
            this.payment = payment;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getPUserId() {
            return pUserId;
        }

        public void setPUserId(Object pUserId) {
            this.pUserId = pUserId;
        }
    }
}
