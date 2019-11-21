package com.example.d_housepropertyproject.ui.mainfgt.home.bean;

import java.util.List;

public class RecommendingCommoditiesBean {

    /**
     * result : {"total":"5","list":[{"id":"1166181118927409154","name":"测试002","pic":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1kmmSAObTjAACeipFOgNg439.png","salePrice":28,"price":30,"unit":"个","newStatus":"0"},{"id":"1165919053742575617","name":"0822优化后上架商品","pic":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1jpbaAVQmKAABocQWjFVQ641.png","salePrice":130,"price":200,"unit":"克","newStatus":"1"},{"id":"1163348579523211266","name":"鞋子李林42码测试测测测","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOnWAYWnVAACJkGAOdbc457.png","salePrice":120,"price":201.5,"unit":"双","newStatus":"1"},{"id":"1163327774349307905","name":"矿泉水1L农夫山泉","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOHaAH8EFAACPnzycM1s040.png","salePrice":3,"price":20,"unit":"瓶","newStatus":"0"},{"id":"1162278114532655105","name":"迪奥烈艳蓝金唇膏999 3.5g","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WZfqAX_9jAAMydvMZeak505.png","salePrice":315,"price":400,"unit":"支","newStatus":"1"}],"pageNum":1,"pageSize":10,"size":5,"startRow":1,"endRow":5,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 5
         * list : [{"id":"1166181118927409154","name":"测试002","pic":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1kmmSAObTjAACeipFOgNg439.png","salePrice":28,"price":30,"unit":"个","newStatus":"0"},{"id":"1165919053742575617","name":"0822优化后上架商品","pic":"http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1jpbaAVQmKAABocQWjFVQ641.png","salePrice":130,"price":200,"unit":"克","newStatus":"1"},{"id":"1163348579523211266","name":"鞋子李林42码测试测测测","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOnWAYWnVAACJkGAOdbc457.png","salePrice":120,"price":201.5,"unit":"双","newStatus":"1"},{"id":"1163327774349307905","name":"矿泉水1L农夫山泉","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1aOHaAH8EFAACPnzycM1s040.png","salePrice":3,"price":20,"unit":"瓶","newStatus":"0"},{"id":"1162278114532655105","name":"迪奥烈艳蓝金唇膏999 3.5g","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WZfqAX_9jAAMydvMZeak505.png","salePrice":315,"price":400,"unit":"支","newStatus":"1"}]
         * pageNum : 1
         * pageSize : 10
         * size : 5
         * startRow : 1
         * endRow : 5
         * pages : 1
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         */

        private String total;
        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * id : 1166181118927409154
             * name : 测试002
             * pic : http://116.62.242.76:8080/group1/M00/00/06/rBA9Jl1kmmSAObTjAACeipFOgNg439.png
             * salePrice : 28.0
             * price : 30.0
             * unit : 个
             * newStatus : 0
             */

            private String id;
            private String name;
            private String pic;
            private double salePrice;
            private double price;
            private String unit;
            private String newStatus;

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

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getNewStatus() {
                return newStatus;
            }

            public void setNewStatus(String newStatus) {
                this.newStatus = newStatus;
            }
        }
    }
}
