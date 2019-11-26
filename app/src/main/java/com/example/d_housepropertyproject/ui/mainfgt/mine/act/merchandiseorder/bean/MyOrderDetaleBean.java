package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean;

import java.util.List;

public class MyOrderDetaleBean {

    /**
     * result : {"id":"1158677901771407362","firmId":"1151758373284909058","firmName":"大众","no":"GM1908061755136333281","time":"1565085313633","time_send":null,"time_arr":null,"status":"d","pay_status":"p","dianpu":"dddd","account":"19222222222","linkman":"高爽文","phone":"13094848371","address":"dddd","total":2800,"products":[{"id":"1153948051886305282","albumPics":"http://192.168.2.201:8080/group1/M00/00/0E/wKgCyV04DYyAL5eQAABHbAbofBQ936.jpg","name":"商品名称就是这样的最多两行","num":1,"unit":"桶","price":1600,"salePrice":1400},{"id":"1153912470632280067","albumPics":"http://192.168.2.201:8080/group1/M00/00/0E/wKgCyV04DYyAL5eQAABHbAbofBQ936.jpg","name":"商品名称就是这样的最多两行","num":1,"unit":"桶","price":1600,"salePrice":1400}]}
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
         * id : 1158677901771407362
         * firmId : 1151758373284909058
         * firmName : 大众
         * no : GM1908061755136333281
         * time : 1565085313633
         * time_send : null
         * time_arr : null
         * status : d
         * pay_status : p
         * dianpu : dddd
         * account : 19222222222
         * linkman : 高爽文
         * phone : 13094848371
         * address : dddd
         * total : 2800.0
         * products : [{"id":"1153948051886305282","albumPics":"http://192.168.2.201:8080/group1/M00/00/0E/wKgCyV04DYyAL5eQAABHbAbofBQ936.jpg","name":"商品名称就是这样的最多两行","num":1,"unit":"桶","price":1600,"salePrice":1400},{"id":"1153912470632280067","albumPics":"http://192.168.2.201:8080/group1/M00/00/0E/wKgCyV04DYyAL5eQAABHbAbofBQ936.jpg","name":"商品名称就是这样的最多两行","num":1,"unit":"桶","price":1600,"salePrice":1400}]
         */

        private String id;
        private String firmId;
        private String firmName;
        private String no;
        private String time;
        private Object time_send;
        private Object time_arr;
        private String status;
        private String pay_status;
        private String dianpu;
        private String account;
        private String linkman;
        private String phone;
        private String address;
        private double total;
        private List<ProductsBean> products;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirmId() {
            return firmId;
        }

        public void setFirmId(String firmId) {
            this.firmId = firmId;
        }

        public String getFirmName() {
            return firmName;
        }

        public void setFirmName(String firmName) {
            this.firmName = firmName;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Object getTime_send() {
            return time_send;
        }

        public void setTime_send(Object time_send) {
            this.time_send = time_send;
        }

        public Object getTime_arr() {
            return time_arr;
        }

        public void setTime_arr(Object time_arr) {
            this.time_arr = time_arr;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getDianpu() {
            return dianpu;
        }

        public void setDianpu(String dianpu) {
            this.dianpu = dianpu;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getLinkman() {
            if(linkman==null){
                linkman="";
            }
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public String getPhone() {
            if(phone==null){
                phone="";
            }
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

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * id : 1153948051886305282
             * albumPics : http://192.168.2.201:8080/group1/M00/00/0E/wKgCyV04DYyAL5eQAABHbAbofBQ936.jpg
             * name : 商品名称就是这样的最多两行
             * num : 1
             * unit : 桶
             * price : 1600.0
             * salePrice : 1400.0
             */

            private String id;
            private String albumPics;
            private String name;
            private int num;
            private String unit;
            private double price;
            private double salePrice;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAlbumPics() {
                return albumPics;
            }

            public void setAlbumPics(String albumPics) {
                this.albumPics = albumPics;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getSalePrice() {
                return salePrice;
            }

            public void setSalePrice(double salePrice) {
                this.salePrice = salePrice;
            }
        }
    }
}

