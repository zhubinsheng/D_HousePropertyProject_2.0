package com.example.d_housepropertyproject.bean;

public class GetAccessTokenBean {

    /**
     * errcode : 40125
     * errmsg : invalid appsecret, view more at http://t.cn/RAEkdVq, hints: [ req_id: ygOB97aLRa-4fHvna ]
     */

    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
