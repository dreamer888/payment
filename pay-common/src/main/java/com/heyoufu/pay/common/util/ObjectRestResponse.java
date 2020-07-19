package com.heyoufu.pay.common.util;

/**
 * Created by Ace on 2020-05-19
 */
public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    boolean rel=true;

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }


    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
