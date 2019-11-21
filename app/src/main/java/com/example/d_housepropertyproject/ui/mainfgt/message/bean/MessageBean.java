package com.example.d_housepropertyproject.ui.mainfgt.message.bean;

import java.util.List;

public class MessageBean {

    /**
     * result : [{"created":"1557476249004","createdby":null,"updated":null,"updatedby":null,"id":"1126763171561852929","type":"3","userId":"1124911377344757762","orderId":"84","content":"您的订房单20190510161707WVMWWZ已完成预付，系统将指派置业顾问引导您完成后续操作，请保持电话畅通，谢谢！","isactive":"1","isread":"0"},{"created":"1557476191911","createdby":null,"updated":null,"updatedby":null,"id":"1126762932096454658","type":"3","userId":"1124911377344757762","orderId":"83","content":"您的订房单20190510161608R4XDXX已完成预付，系统将指派置业顾问引导您完成后续操作，请保持电话畅通，谢谢！","isactive":"1","isread":"0"}]
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
         * created : 1557476249004
         * createdby : null
         * updated : null
         * updatedby : null
         * id : 1126763171561852929
         * type : 3
         * userId : 1124911377344757762
         * orderId : 84
         * content : 您的订房单20190510161707WVMWWZ已完成预付，系统将指派置业顾问引导您完成后续操作，请保持电话畅通，谢谢！
         * isactive : 1
         * isread : 0
         */

        private String created;
        private Object createdby;
        private Object updated;
        private Object updatedby;
        private String id;
        private String type;
        private String userId;
        private String orderId;
        private String content;
        private String isactive;
        private String isread;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getIsactive() {
            return isactive;
        }

        public void setIsactive(String isactive) {
            this.isactive = isactive;
        }

        public String getIsread() {
            return isread;
        }

        public void setIsread(String isread) {
            this.isread = isread;
        }
    }
}
