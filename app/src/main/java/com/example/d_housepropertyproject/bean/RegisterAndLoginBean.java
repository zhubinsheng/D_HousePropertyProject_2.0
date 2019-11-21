package com.example.d_housepropertyproject.bean;

import java.io.Serializable;

public class RegisterAndLoginBean implements Serializable {

    /**
     * result : {"user":{"created":"1556605337714","createdby":null,"updated":null,"updatedby":null,"id":"1123110304854528002","username":"一个人的青春战役","isactive":"1","idnumber":null,"idname":null,"sname":null,"password":null,"gender":null,"birthday":null,"startingdate":null,"joiningdate":null,"phone":null,"qq":null,"wechat":null,"zip":null,"address":null,"email":null,"fax":null,"school":null,"pic":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzH6ZmASjbZAAAKjpYjBq4730.jpg","qrCodeId":null,"description":null,"type":null,"recommender":null,"loginTime":null},"orgId":null,"token":"c46b09e1-672d-4b28-8aea-841f34172dba"}
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
         * user : {"created":"1556605337714","createdby":null,"updated":null,"updatedby":null,"id":"1123110304854528002","username":"一个人的青春战役","isactive":"1","idnumber":null,"idname":null,"sname":null,"password":null,"gender":null,"birthday":null,"startingdate":null,"joiningdate":null,"phone":null,"qq":null,"wechat":null,"zip":null,"address":null,"email":null,"fax":null,"school":null,"pic":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzH6ZmASjbZAAAKjpYjBq4730.jpg","qrCodeId":null,"description":null,"type":null,"recommender":null,"loginTime":null}
         * orgId : null
         * token : c46b09e1-672d-4b28-8aea-841f34172dba
         */

        private UserBean user;
        private Object orgId;
        private String token;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserBean {
            /**
             * created : 1556605337714
             * createdby : null
             * updated : null
             * updatedby : null
             * id : 1123110304854528002
             * username : 一个人的青春战役
             * isactive : 1
             * idnumber : null
             * idname : null
             * sname : null
             * password : null
             * gender : null
             * birthday : null
             * startingdate : null
             * joiningdate : null
             * phone : null
             * qq : null
             * wechat : null
             * zip : null
             * address : null
             * email : null
             * fax : null
             * school : null
             * pic : http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzH6ZmASjbZAAAKjpYjBq4730.jpg
             * qrCodeId : null
             * description : null
             * type : null
             * recommender : null
             * loginTime : null
             */

            private String created;
            private Object createdby;
            private Object updated;
            private Object updatedby;
            private String id;
            private String username;
            private String isactive;
            private Object idnumber;
            private Object idname;
            private Object sname;
            private Object password;
            private Object gender;
            private Object birthday;
            private Object startingdate;
            private Object joiningdate;
            private Object phone;
            private Object qq;
            private Object wechat;
            private Object zip;
            private Object address;
            private Object email;
            private Object fax;
            private Object school;
            private String pic;
            private Object qrCodeId;
            private Object description;
            private Object type;
            private Object recommender;
            private Object loginTime;

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public Object getCreatedby() {
                return createdby;
            }

            public void setCreatedby(Object createdby) {
                this.createdby = createdby;
            }

            public Object getUpdated() {
                return updated;
            }

            public void setUpdated(Object updated) {
                this.updated = updated;
            }

            public Object getUpdatedby() {
                return updatedby;
            }

            public void setUpdatedby(Object updatedby) {
                this.updatedby = updatedby;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getIsactive() {
                return isactive;
            }

            public void setIsactive(String isactive) {
                this.isactive = isactive;
            }

            public Object getIdnumber() {
                return idnumber;
            }

            public void setIdnumber(Object idnumber) {
                this.idnumber = idnumber;
            }

            public Object getIdname() {
                return idname;
            }

            public void setIdname(Object idname) {
                this.idname = idname;
            }

            public Object getSname() {
                return sname;
            }

            public void setSname(Object sname) {
                this.sname = sname;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public Object getStartingdate() {
                return startingdate;
            }

            public void setStartingdate(Object startingdate) {
                this.startingdate = startingdate;
            }

            public Object getJoiningdate() {
                return joiningdate;
            }

            public void setJoiningdate(Object joiningdate) {
                this.joiningdate = joiningdate;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public Object getWechat() {
                return wechat;
            }

            public void setWechat(Object wechat) {
                this.wechat = wechat;
            }

            public Object getZip() {
                return zip;
            }

            public void setZip(Object zip) {
                this.zip = zip;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getFax() {
                return fax;
            }

            public void setFax(Object fax) {
                this.fax = fax;
            }

            public Object getSchool() {
                return school;
            }

            public void setSchool(Object school) {
                this.school = school;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public Object getQrCodeId() {
                return qrCodeId;
            }

            public void setQrCodeId(Object qrCodeId) {
                this.qrCodeId = qrCodeId;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getRecommender() {
                return recommender;
            }

            public void setRecommender(Object recommender) {
                this.recommender = recommender;
            }

            public Object getLoginTime() {
                return loginTime;
            }

            public void setLoginTime(Object loginTime) {
                this.loginTime = loginTime;
            }
        }
    }
}
