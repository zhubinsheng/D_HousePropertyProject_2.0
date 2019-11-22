package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

public class pmsgoodsqueryproductinfoBean {


    /**
     * result : {"id":"1164470177361805316","name":"0822优化后上架商品","code":"sp2019822001","description":null,"albumPics":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1eYPKAT_f1AAACWSmnrIs816.png","stock":100,"salePrice":27}
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
         * id : 1164470177361805316
         * name : 0822优化后上架商品
         * code : sp2019822001
         * description : null
         * albumPics : http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1eYPKAT_f1AAACWSmnrIs816.png
         * stock : 100
         * salePrice : 27.0
         */

        private String id;
        private String name;
        private String code;
        private Object description;
        private String albumPics;
        private int stock;
        private double salePrice;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getAlbumPics() {
            return albumPics;
        }

        public void setAlbumPics(String albumPics) {
            this.albumPics = albumPics;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public double getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(double salePrice) {
            this.salePrice = salePrice;
        }
    }
}
