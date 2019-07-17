package com.stylefeng.guns.rest.modular.film.vo;


import java.io.Serializable;

public class SoonFilmInfoVO implements Serializable {
    private int filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private int expectNum;
    private String showtime;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getFilmType() {
        return filmType;
    }

    public void setFilmType(int filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        if(showtime != null) {
            this.showtime = showtime.substring(0, 10);
        }
    }
}
