package com.stylefeng.guns.rest.modular.film.vo;

public class ConditionResponseVO<T> {
    int status;
    T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
