package com.example.d_housepropertyproject.bean;

public class BindPhoneNumber {

    /**
     * result : null
     * message : 用户已存在
     * code : 20005
     */

    private Object result;
    private String message;
    private int code;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
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
}
