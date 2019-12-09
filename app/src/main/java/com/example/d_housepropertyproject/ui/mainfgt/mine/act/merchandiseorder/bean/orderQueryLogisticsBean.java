package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean;

import java.util.List;

public class orderQueryLogisticsBean {

    /**
     * result : {"created":"1569747347178","createdby":"1151383541199572994","updated":"1574237505023","updatedby":"6","id":"1178231887717335041","isactive":"1","wSuborderId":"1202826744591020035","no":"1234561","status":"3","companyName":"中通快递","companyCode":"ZTO","deliverTime":"1569747347174","arriveTime":"1574237460000","subscribeStatus":0,"wLogisticsInfoList":[{"created":"1574237505031","createdby":null,"updated":null,"updatedby":null,"id":"1197064974760701953","isactive":"1","des":"货物已经被张三签收了","status":null,"date":"2019-11-20 16:11:304","wLogisticsId":"1178231887717335041","seq":109},{"created":"1574237505030","createdby":null,"updated":null,"updatedby":null,"id":"1197064974756507649","isactive":"1","des":"货物到达福田保税区网点","status":null,"date":"2019-11-20 16:11:303","wLogisticsId":"1178231887717335041","seq":108},{"created":"1574237505029","createdby":null,"updated":null,"updatedby":null,"id":"1197064974752313345","isactive":"1","des":"货物已经到达深圳","status":null,"date":"2019-11-20 16:11:302","wLogisticsId":"1178231887717335041","seq":107},{"created":"1574237505027","createdby":null,"updated":null,"updatedby":null,"id":"1197064974743924737","isactive":"1","des":"顺丰速运已收取快件","status":null,"date":"2019-11-20 16:11:30","wLogisticsId":"1178231887717335041","seq":106}]}
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
         * created : 1569747347178
         * createdby : 1151383541199572994
         * updated : 1574237505023
         * updatedby : 6
         * id : 1178231887717335041
         * isactive : 1
         * wSuborderId : 1202826744591020035
         * no : 1234561
         * status : 3
         * companyName : 中通快递
         * companyCode : ZTO
         * deliverTime : 1569747347174
         * arriveTime : 1574237460000
         * subscribeStatus : 0
         * wLogisticsInfoList : [{"created":"1574237505031","createdby":null,"updated":null,"updatedby":null,"id":"1197064974760701953","isactive":"1","des":"货物已经被张三签收了","status":null,"date":"2019-11-20 16:11:304","wLogisticsId":"1178231887717335041","seq":109},{"created":"1574237505030","createdby":null,"updated":null,"updatedby":null,"id":"1197064974756507649","isactive":"1","des":"货物到达福田保税区网点","status":null,"date":"2019-11-20 16:11:303","wLogisticsId":"1178231887717335041","seq":108},{"created":"1574237505029","createdby":null,"updated":null,"updatedby":null,"id":"1197064974752313345","isactive":"1","des":"货物已经到达深圳","status":null,"date":"2019-11-20 16:11:302","wLogisticsId":"1178231887717335041","seq":107},{"created":"1574237505027","createdby":null,"updated":null,"updatedby":null,"id":"1197064974743924737","isactive":"1","des":"顺丰速运已收取快件","status":null,"date":"2019-11-20 16:11:30","wLogisticsId":"1178231887717335041","seq":106}]
         */

        private String created;
        private String createdby;
        private String updated;
        private String updatedby;
        private String id;
        private String isactive;
        private String wSuborderId;
        private String no;
        private String status;
        private String companyName;
        private String companyCode;
        private String deliverTime;
        private String arriveTime;
        private int subscribeStatus;
        private List<WLogisticsInfoListBean> wLogisticsInfoList;

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getCreatedby() {
            return createdby;
        }

        public void setCreatedby(String createdby) {
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

        public String getIsactive() {
            return isactive;
        }

        public void setIsactive(String isactive) {
            this.isactive = isactive;
        }

        public String getWSuborderId() {
            return wSuborderId;
        }

        public void setWSuborderId(String wSuborderId) {
            this.wSuborderId = wSuborderId;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public String getDeliverTime() {
            return deliverTime;
        }

        public void setDeliverTime(String deliverTime) {
            this.deliverTime = deliverTime;
        }

        public String getArriveTime() {
            return arriveTime;
        }

        public void setArriveTime(String arriveTime) {
            this.arriveTime = arriveTime;
        }

        public int getSubscribeStatus() {
            return subscribeStatus;
        }

        public void setSubscribeStatus(int subscribeStatus) {
            this.subscribeStatus = subscribeStatus;
        }

        public List<WLogisticsInfoListBean> getWLogisticsInfoList() {
            return wLogisticsInfoList;
        }

        public void setWLogisticsInfoList(List<WLogisticsInfoListBean> wLogisticsInfoList) {
            this.wLogisticsInfoList = wLogisticsInfoList;
        }

        public static class WLogisticsInfoListBean {
            /**
             * created : 1574237505031
             * createdby : null
             * updated : null
             * updatedby : null
             * id : 1197064974760701953
             * isactive : 1
             * des : 货物已经被张三签收了
             * status : null
             * date : 2019-11-20 16:11:304
             * wLogisticsId : 1178231887717335041
             * seq : 109
             */

            private String created;
            private Object createdby;
            private Object updated;
            private Object updatedby;
            private String id;
            private String isactive;
            private String des;
            private Object status;
            private String date;
            private String wLogisticsId;
            private int seq;

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

            public String getIsactive() {
                return isactive;
            }

            public void setIsactive(String isactive) {
                this.isactive = isactive;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWLogisticsId() {
                return wLogisticsId;
            }

            public void setWLogisticsId(String wLogisticsId) {
                this.wLogisticsId = wLogisticsId;
            }

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }
        }
    }
}
