package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class ConditionVo implements Serializable {
    private int status;
    private String msg;
    private ConditionVOData data;

    public ConditionVo(int status, String msg, ConditionVOData data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ConditionVo() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ConditionVOData getData() {
        return data;
    }

    public void setData(ConditionVOData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ConditionVo{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
