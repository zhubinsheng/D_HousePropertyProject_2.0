package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean;

import java.util.List;

public class couponGetCouponListBean {

    /**
     * result : {"nowTime":"1574669526162","coupon":[{"created":"1574662847068","createdby":"1","updated":null,"updatedby":null,"id":"1","idInfo":"1","idOrder":null,"idUser":"1","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574749247052","suitable":"10","type":"1"},{"created":"1574663388358","createdby":"1","updated":null,"updatedby":null,"id":"2","idInfo":"2","idOrder":null,"idUser":"2","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575700188358","suitable":"11","type":"3"},{"created":"1574663397218","createdby":"1","updated":null,"updatedby":null,"id":"3","idInfo":"2","idOrder":null,"idUser":"3","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575700197202","suitable":"11","type":"3"},{"created":"1574663404515","createdby":"1","updated":null,"updatedby":null,"id":"4","idInfo":"2","idOrder":null,"idUser":"4","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575700204515","suitable":"11","type":"3"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"5","idInfo":"1","idOrder":null,"idUser":"1","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620951","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"6","idInfo":"1","idOrder":null,"idUser":"2","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"7","idInfo":"1","idOrder":null,"idUser":"3","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"8","idInfo":"1","idOrder":null,"idUser":"4","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"9","idInfo":"1","idOrder":null,"idUser":"5","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665488830","createdby":"1","updated":null,"updatedby":null,"id":"10","idInfo":"2","idOrder":null,"idUser":"7","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575702288814","suitable":"11","type":"3"},{"created":"1574665488830","createdby":"1","updated":null,"updatedby":null,"id":"11","idInfo":"2","idOrder":null,"idUser":"8","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575702288830","suitable":"11","type":"3"},{"created":"1574665488830","createdby":"1","updated":null,"updatedby":null,"id":"12","idInfo":"2","idOrder":null,"idUser":"9","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575702288830","suitable":"11","type":"3"}]}
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
         * nowTime : 1574669526162
         * coupon : [{"created":"1574662847068","createdby":"1","updated":null,"updatedby":null,"id":"1","idInfo":"1","idOrder":null,"idUser":"1","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574749247052","suitable":"10","type":"1"},{"created":"1574663388358","createdby":"1","updated":null,"updatedby":null,"id":"2","idInfo":"2","idOrder":null,"idUser":"2","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575700188358","suitable":"11","type":"3"},{"created":"1574663397218","createdby":"1","updated":null,"updatedby":null,"id":"3","idInfo":"2","idOrder":null,"idUser":"3","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575700197202","suitable":"11","type":"3"},{"created":"1574663404515","createdby":"1","updated":null,"updatedby":null,"id":"4","idInfo":"2","idOrder":null,"idUser":"4","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575700204515","suitable":"11","type":"3"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"5","idInfo":"1","idOrder":null,"idUser":"1","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620951","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"6","idInfo":"1","idOrder":null,"idUser":"2","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"7","idInfo":"1","idOrder":null,"idUser":"3","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"8","idInfo":"1","idOrder":null,"idUser":"4","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665220967","createdby":"1","updated":null,"updatedby":null,"id":"9","idInfo":"1","idOrder":null,"idUser":"5","price":1,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1574751620967","suitable":"10","type":"1"},{"created":"1574665488830","createdby":"1","updated":null,"updatedby":null,"id":"10","idInfo":"2","idOrder":null,"idUser":"7","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575702288814","suitable":"11","type":"3"},{"created":"1574665488830","createdby":"1","updated":null,"updatedby":null,"id":"11","idInfo":"2","idOrder":null,"idUser":"8","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575702288830","suitable":"11","type":"3"},{"created":"1574665488830","createdby":"1","updated":null,"updatedby":null,"id":"12","idInfo":"2","idOrder":null,"idUser":"9","price":19,"timeUsed":null,"fettle":"1","isactive":"1","timeOverdate":"1575702288830","suitable":"11","type":"3"}]
         */

        private String nowTime;
        private List<CouponBean> coupon;

        public String getNowTime() {
            return nowTime;
        }

        public void setNowTime(String nowTime) {
            this.nowTime = nowTime;
        }

        public List<CouponBean> getCoupon() {
            return coupon;
        }

        public void setCoupon(List<CouponBean> coupon) {
            this.coupon = coupon;
        }

        public static class CouponBean {
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
    }
}
