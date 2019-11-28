package com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean;

import java.util.List;

public class MyIncomeBean {

    /**
     * result : {"integral":1,"integralInfoList":[{"created":"1","createdby":"1","updated":"1","updatedby":"1","id":"1","isactive":"1","pUserIntegralId":"1","integral":1,"source":"1","type":"1"}],"integralSum":1}
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
         * integral : 1
         * integralInfoList : [{"created":"1","createdby":"1","updated":"1","updatedby":"1","id":"1","isactive":"1","pUserIntegralId":"1","integral":1,"source":"1","type":"1"}]
         * integralSum : 1
         */

        private int integral;
        private int integralSum;
        private List<IntegralInfoListBean> integralInfoList;

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public int getIntegralSum() {
            return integralSum;
        }

        public void setIntegralSum(int integralSum) {
            this.integralSum = integralSum;
        }

        public List<IntegralInfoListBean> getIntegralInfoList() {
            return integralInfoList;
        }

        public void setIntegralInfoList(List<IntegralInfoListBean> integralInfoList) {
            this.integralInfoList = integralInfoList;
        }

        public static class IntegralInfoListBean {
            /**
             * created : 1
             * createdby : 1
             * updated : 1
             * updatedby : 1
             * id : 1
             * isactive : 1
             * pUserIntegralId : 1
             * integral : 1
             * source : 1
             * type : 1
             */

            private String created;
            private String createdby;
            private String updated;
            private String updatedby;
            private String id;
            private String isactive;
            private String pUserIntegralId;
            private int integral;
            private String source;
            private String type;

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

            public String getPUserIntegralId() {
                return pUserIntegralId;
            }

            public void setPUserIntegralId(String pUserIntegralId) {
                this.pUserIntegralId = pUserIntegralId;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
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
