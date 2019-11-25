package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

import java.util.List;

public class PostBasketBean {

    /**
     * basket : [{"basketId":[0],"firmId":0,"remark":"string"}]
     * couponId : 0
     * linkmanId : 0
     */

    private String couponId;
    private String linkmanId;
    private List<BasketBean> basket;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getLinkmanId() {
        return linkmanId;
    }

    public void setLinkmanId(String linkmanId) {
        this.linkmanId = linkmanId;
    }

    public List<BasketBean> getBasket() {
        return basket;
    }

    public void setBasket(List<BasketBean> basket) {
        this.basket = basket;
    }

    public static class BasketBean {
        /**
         * basketId : [0]
         * firmId : 0
         * remark : string
         */

        private Long firmId;
        private String remark;
        private List<String> basketId;

        public Long getFirmId() {
            return firmId;
        }

        public void setFirmId(Long firmId) {
            this.firmId = firmId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public List<String> getBasketId() {
            return basketId;
        }

        public void setBasketId(List<String> basketId) {
            this.basketId = basketId;
        }
    }
}
