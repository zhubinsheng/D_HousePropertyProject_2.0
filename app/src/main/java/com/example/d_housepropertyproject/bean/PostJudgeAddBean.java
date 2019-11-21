package com.example.d_housepropertyproject.bean;

import java.util.List;

public class PostJudgeAddBean {

    /**
     * content : string
     * judgedUserId : 0
     * orderId : 0
     * pJudgeInfoVOArray : [{"pJudgeItemId":0,"pJudgeItemName":"string","score":0}]
     */

    private String content;
    private String judgedUserId;
    private String orderId;
    private List<PJudgeInfoVOArrayBean> pJudgeInfoVOArray;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getJudgedUserId() {
        return judgedUserId;
    }

    public void setJudgedUserId(String judgedUserId) {
        this.judgedUserId = judgedUserId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<PJudgeInfoVOArrayBean> getPJudgeInfoVOArray() {
        return pJudgeInfoVOArray;
    }

    public void setPJudgeInfoVOArray(List<PJudgeInfoVOArrayBean> pJudgeInfoVOArray) {
        this.pJudgeInfoVOArray = pJudgeInfoVOArray;
    }

    public static class PJudgeInfoVOArrayBean {
        /**
         * pJudgeItemId : 0
         * pJudgeItemName : string
         * score : 0
         */

        private String pJudgeItemId;
        private String pJudgeItemName;
        private String score;

        public String getPJudgeItemId() {
            return pJudgeItemId;
        }

        public void setPJudgeItemId(String pJudgeItemId) {
            this.pJudgeItemId = pJudgeItemId;
        }

        public String getPJudgeItemName() {
            return pJudgeItemName;
        }

        public void setPJudgeItemName(String pJudgeItemName) {
            this.pJudgeItemName = pJudgeItemName;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }
    }
}
