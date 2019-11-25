package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import android.text.TextUtils;

public class GoodsQueryInfoIntegralUserBean {

    /**
     * result : {"id":"1162279429627314178","name":"索尼合资 MTA16 Pro","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaEOAJzxSAAG411yIEPs750.png;","des":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaK6AL522AAG411yIEPs652.png;","unit":"台","stock":99997,"salePrice":1678,"linkmanId":"1156027938771980289","linkman":"李新成","phone":"15865636323","address":"四川省新都区128号大院"}
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
         * id : 1162279429627314178
         * name : 索尼合资 MTA16 Pro
         * pic : http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaEOAJzxSAAG411yIEPs750.png;
         * des : http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaK6AL522AAG411yIEPs652.png;
         * unit : 台
         * stock : 99997
         * salePrice : 1678.0
         * linkmanId : 1156027938771980289
         * linkman : 李新成
         * phone : 15865636323
         * address : 四川省新都区128号大院
         */

        private String id;
        private String name;
        private String pic;
        private String des;
        private String unit;
        private int stock;
        private int salePrice;
        private String linkmanId;
        private String linkman;
        private String phone;
        private String address;

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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(int salePrice) {
            this.salePrice = salePrice;
        }

        public String getLinkmanId() {
            return linkmanId;
        }

        public void setLinkmanId(String linkmanId) {
            this.linkmanId = linkmanId;
        }

        public String getLinkman() {
            if (linkman == null || linkman.equals("")) {
                linkman = "";
            }
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public String getPhone() {
            if (phone == null || phone.equals("")) {
                phone = "";
            }
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            if (!TextUtils.isEmpty(address)) {
                address = "";
            }
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
