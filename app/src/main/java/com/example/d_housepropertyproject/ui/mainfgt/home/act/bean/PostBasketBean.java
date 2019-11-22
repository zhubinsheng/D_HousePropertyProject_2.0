package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

import java.util.List;

public class PostBasketBean {
    /**
     * basket : [{"basketId":["1158298627172454401"],"firmId":"1151758373284909058","remark":""},
     * {"basketId":["1158298744101261313"],"firmId":"1152105237146431490","remark":""}]
     * linkman : 1156817021685456897
     */

    private String linkman;
    private List<BasketBean> basket;

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public List<BasketBean> getBasket() {
        return basket;
    }

    public void setBasket(List<BasketBean> basket) {
        this.basket = basket;
    }

    public static class BasketBean {
        /**
         * basketId : ["1158298627172454401"]
         * firmId : 1151758373284909058
         * remark :
         */

        private String firmId;
        private String remark;
        private List<String> basketId;

        public String getFirmId() {
            return firmId;
        }

        public void setFirmId(String firmId) {
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
