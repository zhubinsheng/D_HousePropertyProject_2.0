package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import java.io.Serializable;
import java.util.List;

public class ReceivingAddressBean implements Serializable {

    /**
     * result : [{"created":"1","createdby":"1","updated":"1","updatedby":"1","id":"1","pUserId":"1","linkman":"李行程","phone":"15865636323","address":"四川省新都区128号李家大院","isactive":"1","isdefault":"1"},{"created":"1574911691638","createdby":"1","updated":null,"updatedby":null,"id":"1199892718339903489","pUserId":"1","linkman":"联系人","phone":"联系电话","address":"收货地址","isactive":"1","isdefault":"0"}]
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

    public static class ResultBean implements Serializable{
        /**
         * created : 1
         * createdby : 1
         * updated : 1
         * updatedby : 1
         * id : 1
         * pUserId : 1
         * linkman : 李行程
         * phone : 15865636323
         * address : 四川省新都区128号李家大院
         * isactive : 1
         * isdefault : 1
         */

        private String created;
        private String createdby;
        private String updated;
        private String updatedby;
        private String id;
        private String pUserId;
        private String linkman;
        private String phone;
        private String address;
        private String isactive;
        private String isdefault;

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

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getUpdatedby() {
            return updatedby;
        }

        public void setUpdatedby(String updatedby) {
            this.updatedby = updatedby;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPUserId() {
            return pUserId;
        }

        public void setPUserId(String pUserId) {
            this.pUserId = pUserId;
        }

        public String getLinkman() {
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIsactive() {
            return isactive;
        }

        public void setIsactive(String isactive) {
            this.isactive = isactive;
        }

        public String getIsdefault() {
            return isdefault;
        }

        public void setIsdefault(String isdefault) {
            this.isdefault = isdefault;
        }
    }
}
