package com.example.d_housepropertyproject.ui.mainfgt.apartment.bean;

public class OrderHouseBean {

    /**
     * result : {"id_order":"15","num_order":"20190505103523M5DXWS","price":1.01}
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
         * id_order : 15
         * num_order : 20190505103523M5DXWS
         * price : 1.01
         */

        private String id_order;
        private String num_order;
        private double price;

        public String getId_order() {
            return id_order;
        }

        public void setId_order(String id_order) {
            this.id_order = id_order;
        }

        public String getNum_order() {
            return num_order;
        }

        public void setNum_order(String num_order) {
            this.num_order = num_order;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
