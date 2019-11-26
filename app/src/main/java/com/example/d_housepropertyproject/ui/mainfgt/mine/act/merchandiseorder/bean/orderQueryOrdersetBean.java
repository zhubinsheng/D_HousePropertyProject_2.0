package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean;

import java.util.List;

public class orderQueryOrdersetBean {

    /**
     * result : [{"id":"1","code":"o","type":"p","des":"自动收货时间","timeLimit":7,"desUnit":"天"},{"id":"2","code":"o","type":"j","des":"自动收货时间","timeLimit":14,"desUnit":"天"},{"id":"3","code":"l","type":"p","des":"订单失效时间","timeLimit":30,"desUnit":"分钟"},{"id":"4","code":"l","type":"j","des":"订单失效时间","timeLimit":1,"desUnit":"分钟"}]
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
         * id : 1
         * code : o
         * type : p
         * des : 自动收货时间
         * timeLimit : 7
         * desUnit : 天
         */

        private String id;
        private String code;
        private String type;
        private String des;
        private int timeLimit;
        private String desUnit;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public int getTimeLimit() {
            return timeLimit;
        }

        public void setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        public String getDesUnit() {
            return desUnit;
        }

        public void setDesUnit(String desUnit) {
            this.desUnit = desUnit;
        }
    }
}
