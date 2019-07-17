package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class CinemaFilmField implements Serializable {
    private int fieldId;
    private String beginTime;
    private String endTime;
    private String language;
    private String hallName;
    private int price;

    public CinemaFilmField() {
    }

    public CinemaFilmField(int fieldId, String beginTime, String endTime, String language, String hallName, int price) {
        this.fieldId = fieldId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.language = language;
        this.hallName = hallName;
        this.price = price;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CinemaFilmField{" +
                "fieldId=" + fieldId +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", language='" + language + '\'' +
                ", hallName='" + hallName + '\'' +
                ", price=" + price +
                '}';
    }
}
