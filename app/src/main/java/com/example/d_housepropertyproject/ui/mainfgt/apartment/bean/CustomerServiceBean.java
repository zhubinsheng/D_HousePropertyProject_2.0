package com.example.d_housepropertyproject.ui.mainfgt.apartment.bean;

import java.io.Serializable;
import java.util.List;

public class CustomerServiceBean implements Serializable{

    /**
     * result : [{"created":null,"createdby":null,"updated":"1556527788255","updatedby":"1","id":"3","name":"问题1","content":"<p><strong style=\"color: rgb(230, 0, 0);\">测试1﻿<\/strong><\/p><p>测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿<\/p>","type":"3","edition":null,"isactive":"1"},{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"4","name":"问题2","content":"测试","type":"3","edition":null,"isactive":"1"}]
     * message : 成功
     * code : 20000
     */

    private String message;
    private int code;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * created : null
         * createdby : null
         * updated : 1556527788255
         * updatedby : 1
         * id : 3
         * name : 问题1
         * content : <p><strong style="color: rgb(230, 0, 0);">测试1﻿</strong></p><p>测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿测试1﻿</p>
         * type : 3
         * edition : null
         * isactive : 1
         */

        private Object created;
        private Object createdby;
        private String updated;
        private String updatedby;
        private String id;
        private String name;
        private String content;
        private String type;
        private Object edition;
        private String isactive;

        public Object getCreated() {
            return created;
        }

        public void setCreated(Object created) {
            this.created = created;
        }

        public Object getCreatedby() {
            return createdby;
        }

        public void setCreatedby(Object createdby) {
            this.createdby = createdby;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getUpdatedby() {
            return updatedby;
        }

        public void setUpdatedby(String updatedby) {
            this.updatedby = updatedby;
        }

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getEdition() {
            return edition;
        }

        public void setEdition(Object edition) {
            this.edition = edition;
        }

        public String getIsactive() {
            return isactive;
        }

        public void setIsactive(String isactive) {
            this.isactive = isactive;
        }
    }
}
