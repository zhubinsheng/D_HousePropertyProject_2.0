package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

public class UserGetUserBean {

    /**
     * result : {"data":{"created":"1556176480727","createdby":null,"updated":"1557232546092","updatedby":null,"id":"1121311548278476801","username":"15708319320","isactive":"1","idnumber":null,"idname":null,"sname":null,"password":"e10adc3949ba59abbe56e057f20f883e","gender":null,"birthday":"1577203200000","startingdate":null,"joiningdate":null,"phone":"15708319320","qq":null,"wechat":null,"zip":null,"address":null,"email":null,"fax":null,"school":null,"pic":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzBbBiADq6ZAABdNan5UAY469.jpg","qrCodeId":null,"description":null,"type":null,"recommender":null,"loginTime":"1557232546092","recommenderPhone":null,"seeCount":null,"payCount":null,"qqKey":null,"wechatKey":null},"systemCode":null,"fileList":null}
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
         * data : {"created":"1556176480727","createdby":null,"updated":"1557232546092","updatedby":null,"id":"1121311548278476801","username":"15708319320","isactive":"1","idnumber":null,"idname":null,"sname":null,"password":"e10adc3949ba59abbe56e057f20f883e","gender":null,"birthday":"1577203200000","startingdate":null,"joiningdate":null,"phone":"15708319320","qq":null,"wechat":null,"zip":null,"address":null,"email":null,"fax":null,"school":null,"pic":"http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzBbBiADq6ZAABdNan5UAY469.jpg","qrCodeId":null,"description":null,"type":null,"recommender":null,"loginTime":"1557232546092","recommenderPhone":null,"seeCount":null,"payCount":null,"qqKey":null,"wechatKey":null}
         * systemCode : null
         * fileList : null
         */

        private DataBean data;
        private Object systemCode;
        private Object fileList;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public Object getSystemCode() {
            return systemCode;
        }

        public void setSystemCode(Object systemCode) {
            this.systemCode = systemCode;
        }

        public Object getFileList() {
            return fileList;
        }

        public void setFileList(Object fileList) {
            this.fileList = fileList;
        }

        public static class DataBean {
            /**
             * created : 1556176480727
             * createdby : null
             * updated : 1557232546092
             * updatedby : null
             * id : 1121311548278476801
             * username : 15708319320
             * isactive : 1
             * idnumber : null
             * idname : null
             * sname : null
             * password : e10adc3949ba59abbe56e057f20f883e
             * gender : null
             * birthday : 1577203200000
             * startingdate : null
             * joiningdate : null
             * phone : 15708319320
             * qq : null
             * wechat : null
             * zip : null
             * address : null
             * email : null
             * fax : null
             * school : null
             * pic : http://192.168.2.201:8080/group1/M00/00/00/wKgCyVzBbBiADq6ZAABdNan5UAY469.jpg
             * qrCodeId : null
             * description : null
             * type : null
             * recommender : null
             * loginTime : 1557232546092
             * recommenderPhone : null
             * seeCount : null
             * payCount : null
             * qqKey : null
             * wechatKey : null
             */

            private String created;
            private Object createdby;
            private String updated;
            private Object updatedby;
            private String id;
            private String username;
            private String isactive;
            private Object idnumber;
            private Object idname;
            private Object sname;
            private String password;
            private Object gender;
            private String birthday;
            private Object startingdate;
            private Object joiningdate;
            private String phone;
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
            private String loginTime;
            private Object recommenderPhone;
            private Object seeCount;
            private Object payCount;
            private Object qqKey;
            private Object wechatKey;

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

            public String getUpdated() {
                return updated;
            }

            public void setUpdated(String updated) {
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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
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

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
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

            public String getLoginTime() {
                return loginTime;
            }

            public void setLoginTime(String loginTime) {
                this.loginTime = loginTime;
            }

            public Object getRecommenderPhone() {
                return recommenderPhone;
            }

            public void setRecommenderPhone(Object recommenderPhone) {
                this.recommenderPhone = recommenderPhone;
            }

            public Object getSeeCount() {
                return seeCount;
            }

            public void setSeeCount(Object seeCount) {
                this.seeCount = seeCount;
            }

            public Object getPayCount() {
                return payCount;
            }

            public void setPayCount(Object payCount) {
                this.payCount = payCount;
            }

            public Object getQqKey() {
                return qqKey;
            }

            public void setQqKey(Object qqKey) {
                this.qqKey = qqKey;
            }

            public Object getWechatKey() {
                return wechatKey;
            }

            public void setWechatKey(Object wechatKey) {
                this.wechatKey = wechatKey;
            }
        }
    }
}
