package com.example.d_housepropertyproject.bean;

public class SySAppVersionBean {

    /**
     * result : {"app_url":"http://www.dingduoduo.net.cn/vue/download/app.apk","app_version":"v1.0.1"}
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
         * app_url : http://www.dingduoduo.net.cn/vue/download/app.apk
         * app_version : v1.0.1
         */

        private String app_url;
        private String app_version;

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public String getApp_version() {
            return app_version;
        }

        public void setApp_version(String app_version) {
            this.app_version = app_version;
        }
    }
}
