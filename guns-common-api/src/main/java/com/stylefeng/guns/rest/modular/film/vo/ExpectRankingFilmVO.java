package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class ExpectRankingFilmVO implements Serializable {
    private static final long serialVersionUID = -1327260650420379288L;
    private int filmId;
    private String imgAddress;
    private String filmName;
    private int expectNum;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
}
