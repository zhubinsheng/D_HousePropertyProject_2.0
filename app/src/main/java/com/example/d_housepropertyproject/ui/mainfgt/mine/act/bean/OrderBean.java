package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import java.io.Serializable;
import java.util.List;

public class OrderBean implements Serializable {

    /**
     * result : {"total":"14",
     * "list":[{"id_order":"30","num_order":"20190506094359PG0WZU","created":"1557107039427","status":"x",
     * "invalid":"1559699039427","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,
     * "tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},
     * {"id_order":"31","num_order":"20190506094557E0T8A6","created":"1557107157298","status":"f","invalid":"1559699157298","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"33","num_order":"20190506095228P0DXTG","created":"1557107548873","status":"t","invalid":"1559699548873","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"34","num_order":"20190506095342BZHHQI","created":"1557107622336","status":"s","invalid":"1559699622336","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"36","num_order":"201905061031218VEXVM","created":"1557109881380","status":"p","invalid":"1559701881380","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":"z","num_pay":null,"code":null,"des":null},{"id_order":"37","num_order":"20190506124749K4LFTC","created":"1557118069189","status":"p","invalid":"1559710069189","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":"w","num_pay":null,"code":null,"des":null},{"id_order":"38","num_order":"201905061448486J9DWZ","created":"1557125328989","status":"p","invalid":"1557127128989","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"39","num_order":"20190506145159XTE7HU","created":"1557125519546","status":"p","invalid":"1557127319546","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"40","num_order":"20190506145402IEUDPV","created":"1557125642419","status":"p","invalid":"1557127442419","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"47","num_order":"20190506172024FF5BZ9","created":"1557134424667","status":"d","invalid":"1557136224667","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":1.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null}],"pageNum":1,"pageSize":10,"size":10,"startRow":1,"endRow":10,"pages":2,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2}
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

    public static class ResultBean implements Serializable {
        /**
         * total : 14
         * list : [{"id_order":"30","num_order":"20190506094359PG0WZU","created":"1557107039427","status":"x","invalid":"1559699039427","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"31","num_order":"20190506094557E0T8A6","created":"1557107157298","status":"f","invalid":"1559699157298","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"33","num_order":"20190506095228P0DXTG","created":"1557107548873","status":"t","invalid":"1559699548873","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"34","num_order":"20190506095342BZHHQI","created":"1557107622336","status":"s","invalid":"1559699622336","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"36","num_order":"201905061031218VEXVM","created":"1557109881380","status":"p","invalid":"1559701881380","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":"z","num_pay":null,"code":null,"des":null},{"id_order":"37","num_order":"20190506124749K4LFTC","created":"1557118069189","status":"p","invalid":"1559710069189","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":"w","num_pay":null,"code":null,"des":null},{"id_order":"38","num_order":"201905061448486J9DWZ","created":"1557125328989","status":"p","invalid":"1557127128989","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"39","num_order":"20190506145159XTE7HU","created":"1557125519546","status":"p","invalid":"1557127319546","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"40","num_order":"20190506145402IEUDPV","created":"1557125642419","status":"p","invalid":"1557127442419","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":0.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null},{"id_order":"47","num_order":"20190506172024FF5BZ9","created":"1557134424667","status":"d","invalid":"1557136224667","name_user":"wydh","fanghao":null,"pic":null,"mianji":null,"jiage":null,"huxing":null,"tudi":null,"yangtai":null,"price":1.01,"phone":null,"name_adviser":null,"payway":null,"num_pay":null,"code":null,"des":null}]
         * pageNum : 1
         * pageSize : 10
         * size : 10
         * startRow : 1
         * endRow : 10
         * pages : 2
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
         * navigateFirstPage : 1
         * navigateLastPage : 2
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
             * id_order : 30
             * num_order : 20190506094359PG0WZU
             * created : 1557107039427
             * status : x
             * invalid : 1559699039427
             * name_user : wydh
             * fanghao : null
             * pic : null
             * mianji : null
             * jiage : null
             * huxing : null
             * tudi : null
             * yangtai : null
             * price : 0.01
             * phone : null
             * name_adviser : null
             * payway : null
             * num_pay : null
             * code : null
             * des : null
             */

            private String id_order;
            private String num_order;
            private String created;
            private String status;
            private String invalid;
            private String name_user;
            private Object fanghao;
            private Object pic;
            private Object mianji;
            private Object jiage;
            private Object huxing;
            private Object tudi;
            private Object yangtai;
            private double price;
            private Object phone;
            private Object name_adviser;
            private Object payway;
            private Object num_pay;
            private Object code;
            private Object des;

            public String getId_order() {
                return id_order;
            }

            public void setId_order(String id_order) {
                this.id_order = id_order;
            }

            public String getNum_order() {
                if (num_order == null||num_order.equals("null")) {
                    num_order = "";
                }
                return num_order;
            }

            public void setNum_order(String num_order) {
                this.num_order = num_order;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getInvalid() {
                return invalid;
            }

            public void setInvalid(String invalid) {
                this.invalid = invalid;
            }

            public String getName_user() {
                return name_user;
            }

            public void setName_user(String name_user) {
                this.name_user = name_user;
            }

            public Object getFanghao() {
                return fanghao;
            }

            public void setFanghao(Object fanghao) {
                this.fanghao = fanghao;
            }

            public Object getPic() {
                return pic;
            }

            public void setPic(Object pic) {
                this.pic = pic;
            }

            public Object getMianji() {
                return mianji;
            }

            public void setMianji(Object mianji) {
                this.mianji = mianji;
            }

            public Object getJiage() {
                return jiage;
            }

            public void setJiage(Object jiage) {
                this.jiage = jiage;
            }

            public Object getHuxing() {
                return huxing;
            }

            public void setHuxing(Object huxing) {
                this.huxing = huxing;
            }

            public Object getTudi() {
                return tudi;
            }

            public void setTudi(Object tudi) {
                this.tudi = tudi;
            }

            public Object getYangtai() {
                return yangtai;
            }

            public void setYangtai(Object yangtai) {
                this.yangtai = yangtai;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public Object getPhone() {
                if(phone==null){
                    phone="暂无";
                }
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
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

            public Object getPayway() {
                return payway;
            }

            public void setPayway(Object payway) {
                this.payway = payway;
            }

            public Object getNum_pay() {
                if(num_pay==null){
                    num_pay="";
                }

                return num_pay;
            }

            public void setNum_pay(Object num_pay) {
                this.num_pay = num_pay;
            }

            public Object getCode() {
                return code;
            }

            public void setCode(Object code) {
                this.code = code;
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
