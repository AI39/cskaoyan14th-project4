package com.stylefeng.guns.rest.modular.cinema.vo;

public class ErrorVo {
    private String status;    //异常状态码
    private String msg;       //异常信息

    public ErrorVo() {
    }

    public ErrorVo(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
