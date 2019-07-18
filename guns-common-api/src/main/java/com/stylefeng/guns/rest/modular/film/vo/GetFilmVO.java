package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

//implements Serializable：实现序列化

public class GetFilmVO implements Serializable {

    /*通过流来传递，底层通信*/
    private static final long serialVersionUID = -1007998700983035597L;


    /*影片详情*/

    private int filmId;
    private String filmType;
    private String imgAddress;
    private String filmName;
    private double filmScore;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
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
