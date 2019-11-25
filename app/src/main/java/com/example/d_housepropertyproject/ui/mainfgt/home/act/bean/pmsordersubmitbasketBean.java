package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

public class pmsordersubmitbasketBean {

    /**
     * result : {"no":"ZSC19112510564111298","id_order":"1198797625305735170","total":43,"id_sub":"1198797625305735171"}
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
         * no : ZSC19112510564111298
         * id_order : 1198797625305735170
         * total : 43.0
         * id_sub : 1198797625305735171
         */

        private String no;
        private String id_order;
        private double total;
        private String id_sub;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getId_order() {
            return id_order;
        }

        public void setId_order(String id_order) {
            this.id_order = id_order;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getId_sub() {
            return id_sub;
        }

        public void setId_sub(String id_sub) {
            this.id_sub = id_sub;
        }
    }
}
