package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import java.io.Serializable;
import java.util.List;

public class ExchangeRecordsBean  implements Serializable {

    /**
     * result : {"total":"3","list":[{"id":"1197698214756605955","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaKSALJSLAAG411yIEPs384.png","name":"索尼合资 MTA16 Pro","no":"GM1911221008012112641","time":"1574388481211","status":null,"linkman":"李行程","phone":"15865636323","address":"四川省新都区128号李家大院","price":8390,"unit":"台","count":5},{"id":"1197697365103861762","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaKSALJSLAAG411yIEPs384.png","name":"索尼合资 MTA16 Pro","no":"GM1911221004386234851","time":"1574388278623","status":null,"linkman":"李行程","phone":"15865636323","address":"四川省新都区128号李家大院","price":8390,"unit":"台","count":5},{"id":"1197697283243630594","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaKSALJSLAAG411yIEPs384.png","name":"索尼合资 MTA16 Pro","no":"GM1911221004191062901","time":"1574388259106","status":null,"linkman":"李行程","phone":"15865636323","address":"四川省新都区128号李家大院","price":20136,"unit":"台","count":12}],"pageNum":1,"pageSize":10,"size":3,"startRow":1,"endRow":3,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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

    public static class ResultBean  implements Serializable {
        /**
         * total : 3
         * list : [{"id":"1197698214756605955","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaKSALJSLAAG411yIEPs384.png","name":"索尼合资 MTA16 Pro","no":"GM1911221008012112641","time":"1574388481211","status":null,"linkman":"李行程","phone":"15865636323","address":"四川省新都区128号李家大院","price":8390,"unit":"台","count":5},{"id":"1197697365103861762","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaKSALJSLAAG411yIEPs384.png","name":"索尼合资 MTA16 Pro","no":"GM1911221004386234851","time":"1574388278623","status":null,"linkman":"李行程","phone":"15865636323","address":"四川省新都区128号李家大院","price":8390,"unit":"台","count":5},{"id":"1197697283243630594","pic":"http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaKSALJSLAAG411yIEPs384.png","name":"索尼合资 MTA16 Pro","no":"GM1911221004191062901","time":"1574388259106","status":null,"linkman":"李行程","phone":"15865636323","address":"四川省新都区128号李家大院","price":20136,"unit":"台","count":12}]
         * pageNum : 1
         * pageSize : 10
         * size : 3
         * startRow : 1
         * endRow : 3
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

        public static class ListBean implements Serializable {
            /**
             * id : 1197698214756605955
             * pic : http://116.62.242.76:8080/group1/M00/00/05/rBA9Jl1WaKSALJSLAAG411yIEPs384.png
             * name : 索尼合资 MTA16 Pro
             * no : GM1911221008012112641
             * time : 1574388481211
             * status : null
             * linkman : 李行程
             * phone : 15865636323
             * address : 四川省新都区128号李家大院
             * price : 8390.0
             * unit : 台
             * count : 5
             */

            private String id;
            private String pic;
            private String name;
            private String no;
            private String time;
            private Object status;
            private String linkman;
            private String phone;
            private String address;
            private int price;
            private String unit;
            private int count;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPic() {


                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
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

            public int  getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
