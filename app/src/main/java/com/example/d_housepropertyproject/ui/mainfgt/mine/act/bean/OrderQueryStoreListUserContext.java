package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class OrderQueryStoreListUserContext implements MultiItemEntity {
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    /**
     * id : 1198800242564014082
     * firmId : 1158920004040638466
     * firmName : 成都青白江分拣中心
     * no : ZSC191125110705115651
     * time : 1574651225115
     * time_send : null
     * time_arr : null
     * status : d
     * pay_status : s
     * pay_type : w
     * linkman : 李行程
     * phone : 15865636323
     * address : 四川省新都区128号李家大院
     * total : 129.0
     * products : [{"id":"1198789932625047557","albumPics":"http://192.168.2.201:8080/group1/M00/00/1D/wKgCyV3bNi-AR6DzAAB-15HRbOA69.jpeg","name":"商品4","num":3,"unit":"个","price":42,"salePrice":43}]
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
    private String pay_type;
    private String linkman;
    private String phone;
    private String address;
    private double total;
    private List<ProductsBean> products;

    public OrderQueryStoreListUserContext(int itemType) {
        this.itemType = itemType;
    }

    private int itemType;

    @Override
    public int getItemType() {
        return itemType;
    }

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

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
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
         * id : 1198789932625047557
         * albumPics : http://192.168.2.201:8080/group1/M00/00/1D/wKgCyV3bNi-AR6DzAAB-15HRbOA69.jpeg
         * name : 商品4
         * num : 3
         * unit : 个
         * price : 42.0
         * salePrice : 43.0
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
