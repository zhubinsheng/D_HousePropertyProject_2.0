package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

import java.util.List;

public class QueryInfoBean {


    /**
     * result : {"id_event":"1","id_build":"1115183033255329793","count":25,"name":"三百峰 第一期 看房团","name_build":"泰国 \u2022 华欣 \u2022 三百峰皇家国际旅游度假区","pic":"http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrEsCAMRihAAgrE8QP5RY547.png","phone":null,"time_begin":"1555171200000","time_end":"1555689600000","time":[{"id":"1","time_begin":"1555171200000","time_end":"1555430400000"},{"id":"2","time_begin":"1555430400000","time_end":"1555689600000"}]}
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
         * id_event : 1
         * id_build : 1115183033255329793
         * count : 25
         * name : 三百峰 第一期 看房团
         * name_build : 泰国 • 华欣 • 三百峰皇家国际旅游度假区
         * pic : http://116.62.242.76:8080/group1/M00/00/00/rBA9JlyrEsCAMRihAAgrE8QP5RY547.png
         * phone : null
         * time_begin : 1555171200000
         * time_end : 1555689600000
         * time : [{"id":"1","time_begin":"1555171200000","time_end":"1555430400000"},{"id":"2","time_begin":"1555430400000","time_end":"1555689600000"}]
         */

        private String id_event;
        private String id_build;
        private int count;
        private String name;
        private String name_build;
        private String pic;
        private Object phone;
        private String time_begin;
        private String time_end;
        private List<TimeBean> time;

        public String getId_event() {
            return id_event;
        }

        public void setId_event(String id_event) {
            this.id_event = id_event;
        }

        public String getId_build() {
            return id_build;
        }

        public void setId_build(String id_build) {
            this.id_build = id_build;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_build() {
            return name_build;
        }

        public void setName_build(String name_build) {
            this.name_build = name_build;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
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

        public List<TimeBean> getTime() {
            return time;
        }

        public void setTime(List<TimeBean> time) {
            this.time = time;
        }

        public static class TimeBean {
            /**
             * id : 1
             * time_begin : 1555171200000
             * time_end : 1555430400000
             */

            private String id;
            private String time_begin;
            private String time_end;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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
        }
    }
}
