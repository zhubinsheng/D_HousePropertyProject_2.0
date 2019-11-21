package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import java.util.List;

public class judgeinitBean {

    /**
     * result : {"pic":"http://192.168.2.201:8080/group1/M00/00/02/wKgCyVzt2pGAObsWAAMHAokRBNs66.jpeg","userName":"测试","busScaleName":"高级","serScaleName":"金牌","busScaleLogo":null,"serScaleLogo":null,"pJudgeItemList":[{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"1","isactive":"1","title":"","type":"1"}]}
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
         * pic : http://192.168.2.201:8080/group1/M00/00/02/wKgCyVzt2pGAObsWAAMHAokRBNs66.jpeg
         * userName : 测试
         * busScaleName : 高级
         * serScaleName : 金牌
         * busScaleLogo : null
         * serScaleLogo : null
         * pJudgeItemList : [{"created":null,"createdby":null,"updated":null,"updatedby":null,"id":"1","isactive":"1","title":"","type":"1"}]
         */

        private String pic;
        private String userName;
        private String busScaleName;
        private String serScaleName;
        private Object busScaleLogo;
        private Object serScaleLogo;
        private List<PJudgeItemListBean> pJudgeItemList;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getBusScaleName() {
            return busScaleName;
        }

        public void setBusScaleName(String busScaleName) {
            this.busScaleName = busScaleName;
        }

        public String getSerScaleName() {
            return serScaleName;
        }

        public void setSerScaleName(String serScaleName) {
            this.serScaleName = serScaleName;
        }

        public Object getBusScaleLogo() {
            return busScaleLogo;
        }

        public void setBusScaleLogo(Object busScaleLogo) {
            this.busScaleLogo = busScaleLogo;
        }

        public Object getSerScaleLogo() {
            return serScaleLogo;
        }

        public void setSerScaleLogo(Object serScaleLogo) {
            this.serScaleLogo = serScaleLogo;
        }

        public List<PJudgeItemListBean> getPJudgeItemList() {
            return pJudgeItemList;
        }

        public void setPJudgeItemList(List<PJudgeItemListBean> pJudgeItemList) {
            this.pJudgeItemList = pJudgeItemList;
        }

        public static class PJudgeItemListBean {
            /**
             * created : null
             * createdby : null
             * updated : null
             * updatedby : null
             * id : 1
             * isactive : 1
             * title :
             * type : 1
             */

            private Object created;
            private Object createdby;
            private Object updated;
            private Object updatedby;
            private String id;
            private String isactive;
            private String title;
            private String type;

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

            public String getIsactive() {
                return isactive;
            }

            public void setIsactive(String isactive) {
                this.isactive = isactive;
            }

            public String getTitle() {
                if(title==null){
                    title="";
                }
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
