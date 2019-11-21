package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean;

import java.util.List;

public class HouseInspectionChlideBean {

    /**
     * result : {"total":"1","list":[{"id_seeuser":"2","id_user":null,"id_order":"91","id_order_log":null,"id_recommend":null,"id_adviser":null,"id_rate_r":null,"id_rate_c":null,"num_order":"20190618102408IBUWXB","count":55,"name_user":"18383123580","name_visitor":"李经理","name_adviser":null,"name_trip":"三百峰 第一期 看房团","name_build":"泰国 \u2022 华欣 \u2022 三百峰皇家国际旅游度假区","name_ins":null,"phone":null,"phone_u":"18383123580","status":"d","pic":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrEsCAMRihAAgrE8QP5RY547.png","price":0,"time_begin":"1625708800000","time_end":"1657244800000","time_created":"1560824648406","des":null}],"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 1
         * list : [{"id_seeuser":"2","id_user":null,"id_order":"91","id_order_log":null,"id_recommend":null,"id_adviser":null,"id_rate_r":null,"id_rate_c":null,"num_order":"20190618102408IBUWXB","count":55,"name_user":"18383123580","name_visitor":"李经理","name_adviser":null,"name_trip":"三百峰 第一期 看房团","name_build":"泰国 \u2022 华欣 \u2022 三百峰皇家国际旅游度假区","name_ins":null,"phone":null,"phone_u":"18383123580","status":"d","pic":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrEsCAMRihAAgrE8QP5RY547.png","price":0,"time_begin":"1625708800000","time_end":"1657244800000","time_created":"1560824648406","des":null}]
         * pageNum : 1
         * pageSize : 10
         * size : 1
         * startRow : 1
         * endRow : 1
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
             * id_seeuser : 2
             * id_user : null
             * id_order : 91
             * id_order_log : null
             * id_recommend : null
             * id_adviser : null
             * id_rate_r : null
             * id_rate_c : null
             * num_order : 20190618102408IBUWXB
             * count : 55
             * name_user : 18383123580
             * name_visitor : 李经理
             * name_adviser : null
             * name_trip : 三百峰 第一期 看房团
             * name_build : 泰国 • 华欣 • 三百峰皇家国际旅游度假区
             * name_ins : null
             * phone : null
             * phone_u : 18383123580
             * status : d
             * pic : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrEsCAMRihAAgrE8QP5RY547.png
             * price : 0.0
             * time_begin : 1625708800000
             * time_end : 1657244800000
             * time_created : 1560824648406
             * des : null
             */

            private String id_seeuser;
            private Object id_user;
            private String id_order;
            private Object id_order_log;
            private Object id_recommend;
            private Object id_adviser;
            private Object id_rate_r;
            private Object id_rate_c;
            private String num_order;
            private int count;
            private String name_user;
            private String name_visitor;
            private Object name_adviser;
            private String name_trip;
            private String name_build;
            private Object name_ins;
            private Object phone;
            private String phone_u;
            private String status;
            private String pic;
            private double price;
            private String time_begin;
            private String time_end;
            private String time_created;
            private Object des;

            public String getId_seeuser() {
                return id_seeuser;
            }

            public void setId_seeuser(String id_seeuser) {
                this.id_seeuser = id_seeuser;
            }

            public Object getId_user() {
                return id_user;
            }

            public void setId_user(Object id_user) {
                this.id_user = id_user;
            }

            public String getId_order() {
                return id_order;
            }

            public void setId_order(String id_order) {
                this.id_order = id_order;
            }

            public Object getId_order_log() {
                return id_order_log;
            }

            public void setId_order_log(Object id_order_log) {
                this.id_order_log = id_order_log;
            }

            public Object getId_recommend() {
                return id_recommend;
            }

            public void setId_recommend(Object id_recommend) {
                this.id_recommend = id_recommend;
            }

            public Object getId_adviser() {
                return id_adviser;
            }

            public void setId_adviser(Object id_adviser) {
                this.id_adviser = id_adviser;
            }

            public Object getId_rate_r() {
                return id_rate_r;
            }

            public void setId_rate_r(Object id_rate_r) {
                this.id_rate_r = id_rate_r;
            }

            public Object getId_rate_c() {
                return id_rate_c;
            }

            public void setId_rate_c(Object id_rate_c) {
                this.id_rate_c = id_rate_c;
            }

            public String getNum_order() {
                return num_order;
            }

            public void setNum_order(String num_order) {
                this.num_order = num_order;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getName_user() {
                return name_user;
            }

            public void setName_user(String name_user) {
                this.name_user = name_user;
            }

            public String getName_visitor() {
                return name_visitor;
            }

            public void setName_visitor(String name_visitor) {
                this.name_visitor = name_visitor;
            }

            public Object getName_adviser() {
                if (name_adviser == null) {
                    name_adviser = "";
                }
                return name_adviser;
            }

            public void setName_adviser(Object name_adviser) {
                this.name_adviser = name_adviser;
            }

            public String getName_trip() {
                if (name_trip == null) {
                    name_trip = "";
                }
                return name_trip;
            }

            public void setName_trip(String name_trip) {
                this.name_trip = name_trip;
            }

            public String getName_build() {
                return name_build;
            }

            public void setName_build(String name_build) {
                this.name_build = name_build;
            }

            public Object getName_ins() {
                return name_ins;
            }

            public void setName_ins(Object name_ins) {
                this.name_ins = name_ins;
            }

            public Object getPhone() {
                if (phone == null) {
                    phone = "";
                }
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public String getPhone_u() {
                return phone_u;
            }

            public void setPhone_u(String phone_u) {
                this.phone_u = phone_u;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getTime_begin() {
                return time_begin;
            }

            public void setTime_begin(String time_begin) {
                this.time_begin = time_begin;
            }

            public String getTime_end() {
                return time_end;
            }

            public void setTime_end(String time_end) {
                this.time_end = time_end;
            }

            public String getTime_created() {
                return time_created;
            }

            public void setTime_created(String time_created) {
                this.time_created = time_created;
            }

            public Object getDes() {
                return des;
            }

            public void setDes(Object des) {
                this.des = des;
            }
        }
    }
}
