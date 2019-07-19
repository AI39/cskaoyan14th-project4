package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class FieldInfo implements Serializable {

    private Integer status;
    private String imgpre;
    private FieldInfoData data;

    public FieldInfo(Integer status, String imgpre, FieldInfoData data) {
        this.status = status;
        this.imgpre = imgpre;
        this.data = data;
    }

    public FieldInfo() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgpre() {
        return imgpre;
    }

    public void setImgpre(String imgpre) {
        this.imgpre = imgpre;
    }

    public FieldInfoData getData() {
        return data;
    }

    public void setData(FieldInfoData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "status=" + status +
                ", imgpre='" + imgpre + '\'' +
                ", data=" + data +
                '}';
    }
}
