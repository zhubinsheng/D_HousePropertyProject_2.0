package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

public class CheckUserBean {

    /**
     * result : {"id_user":"1120140647004512257","has":false,"token":"4c7f50c0-0374-47b2-9d3c-7e6eebaef580"}
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
         * id_user : 1120140647004512257
         * has : false
         * token : 4c7f50c0-0374-47b2-9d3c-7e6eebaef580
         */

        private String id_user;
        private boolean has;
        private String token;

        public String getId_user() {
            return id_user;
        }

        public void setId_user(String id_user) {
            this.id_user = id_user;
        }

        public boolean isHas() {
            return has;
        }

        public void setHas(boolean has) {
            this.has = has;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
