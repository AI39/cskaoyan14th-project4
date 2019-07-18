package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class FieldListVo implements Serializable {
    private int status;
    private String imgPre;
    private FieldListVoData data;

    public FieldListVo() {
    }

    public FieldListVo(int status, String imgPre, FieldListVoData data) {
        this.status = status;
        this.imgPre = imgPre;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public FieldListVoData getData() {
        return data;
    }

    public void setData(FieldListVoData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FieldListVo{" +
                "status=" + status +
                ", imgPre='" + imgPre + '\'' +
                ", data=" + data +
                '}';
    }
}
