package com.example.d_housepropertyproject.ui.mainfgt.apartment.bean;

import com.google.gson.annotations.SerializedName;

public class TransactionWXUnifiedOrderBean {
    /**
     * result : {"package":"Sign=WXPay","appid":"wxd16726e67b213517","sign":"8B7531CDF0256166AD40D34A8945CC2A","partnerid":"1533425771","prepayid":"wx20190505111150763496","noncestr":"Jp6BGwIItvrfu4RcCVjfISSgmZqTbXh8","timestamp":"1557025911"}
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
         * package : Sign=WXPay
         * appid : wxd16726e67b213517
         * sign : 8B7531CDF0256166AD40D34A8945CC2A
         * partnerid : 1533425771
         * prepayid : wx20190505111150763496
         * noncestr : Jp6BGwIItvrfu4RcCVjfISSgmZqTbXh8
         * timestamp : 1557025911
         */

        @SerializedName("package")
        private String packageX;
        private String appid;
        private String sign;
        private String partnerid;
        private String prepayid;
        private String noncestr;
        private String timestamp;

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
