package com.example.d_housepropertyproject.bean;

public class MessageStatus {
    //1:会员支付成功！
    //2:会员支付失败！
    public MessageStatus(String status) {
        this.status = status;
    }

    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
