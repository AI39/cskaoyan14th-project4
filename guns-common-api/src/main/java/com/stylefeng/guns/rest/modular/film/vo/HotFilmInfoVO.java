package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class HotFilmInfoVO implements Serializable {
    private static final long serialVersionUID = -7302047375236722614L;
    private int filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private double filmScore;

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

    public double getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(double filmScore) {
        this.filmScore = filmScore;
    }
}
