package com.stylefeng.guns.rest.modular.consumer.vo;

public class ErrorVo {
    private int status;    //异常状态码
    private String msg;       //异常信息

    public ErrorVo() {
    }

    public ErrorVo(int status, String msg) {
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
        return "ErrorVo{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
