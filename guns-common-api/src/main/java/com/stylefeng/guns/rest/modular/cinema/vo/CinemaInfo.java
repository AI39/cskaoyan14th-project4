package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class CinemaInfo implements Serializable {
    private int cinemaId;
    private String imgUrl;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaPhone;

    public CinemaInfo() {
    }

    public CinemaInfo(int cinemaId, String imgUrl, String cinemaName, String cinemaAddress, String cinemaPhone) {
        this.cinemaId = cinemaId;
        this.imgUrl = imgUrl;
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
        this.cinemaPhone = cinemaPhone;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }

    @Override
    public String toString() {
        return "CinemaInfo{" +
                "cinemaId=" + cinemaId +
                ", imgUrl='" + imgUrl + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaAddress='" + cinemaAddress + '\'' +
                ", cinemaPhone='" + cinemaPhone + '\'' +
                '}';
    }
}
