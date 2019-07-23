package com.stylefeng.guns.rest.modular.order.vo;

public class ExceptionResponseVO {
    int status;
    String msg;

    public ExceptionResponseVO() {
    }

    public ExceptionResponseVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
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

    @Override
    public String toString() {
        return "ExceptionResponseVo{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
