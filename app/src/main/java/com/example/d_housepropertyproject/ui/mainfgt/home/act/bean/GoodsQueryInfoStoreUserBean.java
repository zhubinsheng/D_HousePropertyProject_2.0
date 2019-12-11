package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

import java.io.Serializable;
import java.util.List;

public class GoodsQueryInfoStoreUserBean implements Serializable {

    /**
     * result : {"id":"1165919053742575617","name":"0822优化后上架商品","pic":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1jpbaAVQmKAABocQWjFVQ641.png;","des":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1eYMiAD4UMAAECTDjYoCY392.jpg;http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1eYMuALRWJAAGX6vpbmRs153.jpg;","unit":"克","isFavorite":"0","vipPrice":null,"salePrice":130,"price":200,"firmId":"1158920004040638466","brandId":"1158920004107747329","brandName":"拉夏贝儿","brandLogo":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WYPmAH3ZrAAA6TunTdZE145.png","brandSale":202,"brandNum":5,"time":null,"proportion":null,"attrs":[{"mSubcategoryParamId":"1162182689754587138","mSubcategoryParamName":"色号","value":"5"},{"mSubcategoryParamId":"1162182739964600322","mSubcategoryParamName":"型号","value":"45"},{"mSubcategoryParamId":"1162182830129553409","mSubcategoryParamName":"规格","value":"5"}],"hot":[{"id":"1162278114532655105","name":"迪奥烈艳蓝金唇膏999 3.5g","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WZfqAX_9jAAMydvMZeak505.png","salePrice":315,"price":400,"unit":null,"newStatus":null,"stock":null},{"id":"1163327774349307905","name":"矿泉水1L农夫山泉","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOHaAH8EFAACPnzycM1s040.png","salePrice":0.01,"price":20,"unit":null,"newStatus":null,"stock":null},{"id":"1163348579523211266","name":"鞋子李林42码测试测测测","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOnWAYWnVAACJkGAOdbc457.png","salePrice":120,"price":201.5,"unit":null,"newStatus":null,"stock":null},{"id":"1166181118927409154","name":"测试002","pic":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1kmmSAObTjAACeipFOgNg439.png","salePrice":28,"price":30,"unit":null,"newStatus":null,"stock":null},{"id":"1198789932625047553","name":"商品4","pic":"http://192.168.2.201:8080/group1/M00/00/1D/wKgCyV3bNgCABz9kAACXC4kkxHU335.jpg","salePrice":43,"price":42,"unit":null,"newStatus":null,"stock":null}],"pAttrs":[{"id":"1158917809828134914","name":"厚度","attrs":[{"attrId":"1158975951456006146","value":"薄款"},{"attrId":"1158975951464394753","value":"加厚款"}]},{"id":"1158917967135506433","name":"领型","attrs":[{"attrId":"1158976185531723777","value":"圆领"},{"attrId":"1158976185535918081","value":"V领"}]},{"id":"1158924929076281345","name":"颜色","attrs":[{"attrId":"1158976094754402305","value":"红"},{"attrId":"1158976094754402306","value":"黄"},{"attrId":"1158976094758596610","value":"深蓝"}]},{"id":"1164469153444118529","name":"第四类","attrs":[{"attrId":"1164469153477672962","value":"选项1"},{"attrId":"1164469153494450177","value":"选项2"},{"attrId":"1164469153494450178","value":"选项3"}]}]}
     * message : 成功
     * code : 20000
     */

    private ResultBean result;
    private String message;
    private int code;
    private int Goodnum;

    public int getGoodnum() {
        return Goodnum;
    }

    public void setGoodnum(int goodnum) {
        Goodnum = goodnum;
    }

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

    public static class ResultBean  implements Serializable {
        /**
         * id : 1165919053742575617
         * name : 0822优化后上架商品
         * pic : http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1jpbaAVQmKAABocQWjFVQ641.png;
         * des : http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1eYMiAD4UMAAECTDjYoCY392.jpg;http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1eYMuALRWJAAGX6vpbmRs153.jpg;
         * unit : 克
         * isFavorite : 0
         * vipPrice : null
         * salePrice : 130.0
         * price : 200.0
         * firmId : 1158920004040638466
         * brandId : 1158920004107747329
         * brandName : 拉夏贝儿
         * brandLogo : http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WYPmAH3ZrAAA6TunTdZE145.png
         * brandSale : 202
         * brandNum : 5
         * time : null
         * proportion : null
         * attrs : [{"mSubcategoryParamId":"1162182689754587138","mSubcategoryParamName":"色号","value":"5"},{"mSubcategoryParamId":"1162182739964600322","mSubcategoryParamName":"型号","value":"45"},{"mSubcategoryParamId":"1162182830129553409","mSubcategoryParamName":"规格","value":"5"}]
         * hot : [{"id":"1162278114532655105","name":"迪奥烈艳蓝金唇膏999 3.5g","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WZfqAX_9jAAMydvMZeak505.png","salePrice":315,"price":400,"unit":null,"newStatus":null,"stock":null},{"id":"1163327774349307905","name":"矿泉水1L农夫山泉","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOHaAH8EFAACPnzycM1s040.png","salePrice":0.01,"price":20,"unit":null,"newStatus":null,"stock":null},{"id":"1163348579523211266","name":"鞋子李林42码测试测测测","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOnWAYWnVAACJkGAOdbc457.png","salePrice":120,"price":201.5,"unit":null,"newStatus":null,"stock":null},{"id":"1166181118927409154","name":"测试002","pic":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1kmmSAObTjAACeipFOgNg439.png","salePrice":28,"price":30,"unit":null,"newStatus":null,"stock":null},{"id":"1198789932625047553","name":"商品4","pic":"http://192.168.2.201:8080/group1/M00/00/1D/wKgCyV3bNgCABz9kAACXC4kkxHU335.jpg","salePrice":43,"price":42,"unit":null,"newStatus":null,"stock":null}]
         * pAttrs : [{"id":"1158917809828134914","name":"厚度","attrs":[{"attrId":"1158975951456006146","value":"薄款"},{"attrId":"1158975951464394753","value":"加厚款"}]},{"id":"1158917967135506433","name":"领型","attrs":[{"attrId":"1158976185531723777","value":"圆领"},{"attrId":"1158976185535918081","value":"V领"}]},{"id":"1158924929076281345","name":"颜色","attrs":[{"attrId":"1158976094754402305","value":"红"},{"attrId":"1158976094754402306","value":"黄"},{"attrId":"1158976094758596610","value":"深蓝"}]},{"id":"1164469153444118529","name":"第四类","attrs":[{"attrId":"1164469153477672962","value":"选项1"},{"attrId":"1164469153494450177","value":"选项2"},{"attrId":"1164469153494450178","value":"选项3"}]}]
         */
        private int Goodnum;
        private String id;

        public int getGoodnum() {
            return Goodnum;
        }

        public void setGoodnum(int goodnum) {
            Goodnum = goodnum;
        }

        private String name;
        private String pic;
        private String des;
        private String unit;
        private String isFavorite;
        private Object vipPrice;
        private double salePrice;
        private double price;
        private String firmId;
        private String brandId;
        private String brandName;
        private String brandLogo;
        private int brandSale;
        private int brandNum;
        private String time;
        private Object proportion;
        private List<AttrsBean> attrs;
        private List<HotBean> hot;
        private List<PAttrsBean> pAttrs;

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

        public String getIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(String isFavorite) {
            this.isFavorite = isFavorite;
        }

        public Object getVipPrice() {
            return vipPrice;
        }

        public void setVipPrice(Object vipPrice) {
            this.vipPrice = vipPrice;
        }

        public double getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(double salePrice) {
            this.salePrice = salePrice;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getFirmId() {
            return firmId;
        }

        public void setFirmId(String firmId) {
            this.firmId = firmId;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getBrandLogo() {
            return brandLogo;
        }

        public void setBrandLogo(String brandLogo) {
            this.brandLogo = brandLogo;
        }

        public int getBrandSale() {
            return brandSale;
        }

        public void setBrandSale(int brandSale) {
            this.brandSale = brandSale;
        }

        public int getBrandNum() {
            return brandNum;
        }

        public void setBrandNum(int brandNum) {
            this.brandNum = brandNum;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Object getProportion() {
            return proportion;
        }

        public void setProportion(Object proportion) {
            this.proportion = proportion;
        }

        public List<AttrsBean> getAttrs() {
            return attrs;
        }

        public void setAttrs(List<AttrsBean> attrs) {
            this.attrs = attrs;
        }

        public List<HotBean> getHot() {
            return hot;
        }

        public void setHot(List<HotBean> hot) {
            this.hot = hot;
        }

        public List<PAttrsBean> getPAttrs() {
            return pAttrs;
        }

        public void setPAttrs(List<PAttrsBean> pAttrs) {
            this.pAttrs = pAttrs;
        }

        public static class AttrsBean  implements Serializable {
            /**
             * mSubcategoryParamId : 1162182689754587138
             * mSubcategoryParamName : 色号
             * value : 5
             */

            private String mSubcategoryParamId;
            private String mSubcategoryParamName;
            private String value;

            public String getMSubcategoryParamId() {
                return mSubcategoryParamId;
            }

            public void setMSubcategoryParamId(String mSubcategoryParamId) {
                this.mSubcategoryParamId = mSubcategoryParamId;
            }

            public String getMSubcategoryParamName() {
                return mSubcategoryParamName;
            }

            public void setMSubcategoryParamName(String mSubcategoryParamName) {
                this.mSubcategoryParamName = mSubcategoryParamName;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class HotBean  implements Serializable {
            /**
             * id : 1162278114532655105
             * name : 迪奥烈艳蓝金唇膏999 3.5g
             * pic : http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WZfqAX_9jAAMydvMZeak505.png
             * salePrice : 315.0
             * price : 400.0
             * unit : null
             * newStatus : null
             * stock : null
             */

            private String id;
            private String name;
            private String pic;
            private double salePrice;
            private double price;
            private Object unit;
            private Object newStatus;
            private Object stock;

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

            public double getSalePrice() {
                return salePrice;
            }

            public void setSalePrice(double salePrice) {
                this.salePrice = salePrice;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public Object getUnit() {
                return unit;
            }

            public void setUnit(Object unit) {
                this.unit = unit;
            }

            public Object getNewStatus() {
                return newStatus;
            }

            public void setNewStatus(Object newStatus) {
                this.newStatus = newStatus;
            }

            public Object getStock() {
                return stock;
            }

            public void setStock(Object stock) {
                this.stock = stock;
            }
        }

        public static class PAttrsBean  implements Serializable {
            /**
             * id : 1158917809828134914
             * name : 厚度
             * attrs : [{"attrId":"1158975951456006146","value":"薄款"},{"attrId":"1158975951464394753","value":"加厚款"}]
             */

            private String id;
            private String name;
            private List<AttrsBeanX> attrs;

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

            public List<AttrsBeanX> getAttrs() {
                return attrs;
            }

            public void setAttrs(List<AttrsBeanX> attrs) {
                this.attrs = attrs;
            }

            public static class AttrsBeanX {
                /**
                 * attrId : 1158975951456006146
                 * value : 薄款
                 */

                private String attrId;
                private String value;

                public boolean isStatus() {
                    return Status;
                }

                public void setStatus(boolean status) {
                    Status = status;
                }

                private boolean Status;
                public String getAttrId() {
                    return attrId;
                }

                public void setAttrId(String attrId) {
                    this.attrId = attrId;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}