package com.example.d_housepropertyproject.net;

import com.zhouyou.http.model.ApiResult;



public class CustomApiResult<T> extends ApiResult<T> {

   @Override
    public boolean isOk() {
        return getCode()==0;//如果不是0表示成功，请重写isOk()方法。
    }

    @Override
    public T getData() {
        return super.getData();
    }
}


