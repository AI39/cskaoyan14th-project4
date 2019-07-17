package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class CinemaListVoData implements Serializable {
    private Integer uuid;
    private String cinemaName;
    private String address;
    private Integer minimumPrice;

    public CinemaListVoData() {
    }

    public CinemaListVoData(Integer uuid, String cinemaName, String address, Integer minimumPrice) {
        this.uuid = uuid;
        this.cinemaName = cinemaName;
        this.address = address;
        this.minimumPrice = minimumPrice;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Integer minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    @Override
    public String toString() {
        return "CinemaListVoData{" +
                "uuid=" + uuid +
                ", cinemaName='" + cinemaName + '\'' +
                ", address='" + address + '\'' +
                ", minimumPrice=" + minimumPrice +
                '}';
    }
}
