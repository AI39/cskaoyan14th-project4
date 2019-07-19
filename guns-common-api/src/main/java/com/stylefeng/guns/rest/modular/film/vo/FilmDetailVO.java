package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class FilmDetailVO implements Serializable {
    private static final long serialVersionUID = -6313959056935942962L;
    String filmName;
    String filmEnName;
    String imgAddress;
    String score;
    String scoreNum;
    String totalBox;
    String info01;
    String info02;
    String info03;
    FilmDetailInfoVO info04;
    String filmId;

    public FilmDetailVO() {
    }

    public FilmDetailVO(String filmName, String filmEnName, String imgAddress, String score, String scoreNum, String totalBox, String info01, String info02, String info03, FilmDetailInfoVO info04, String filmId) {
        this.filmName = filmName;
        this.filmEnName = filmEnName;
        this.imgAddress = imgAddress;
        this.score = score;
        this.scoreNum = scoreNum;
        this.totalBox = totalBox;
        this.info01 = info01;
        this.info02 = info02;
        this.info03 = info03;
        this.info04 = info04;
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(String scoreNum) {
        this.scoreNum = scoreNum;
    }

    public String getTotalBox() {
        return totalBox;
    }

    public void setTotalBox(String totalBox) {
        this.totalBox = totalBox;
    }

    public String getInfo01() {
        return info01;
    }

    public void setInfo01(String info01) {
        this.info01 = info01;
    }

    public String getInfo02() {
        return info02;
    }

    public void setInfo02(String info02) {
        this.info02 = info02;
    }

    public String getInfo03() {
        return info03;
    }

    public void setInfo03(String info03) {
        this.info03 = info03;
    }

    public FilmDetailInfoVO getInfo04() {
        return info04;
    }

    public void setInfo04(FilmDetailInfoVO info04) {
        this.info04 = info04;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }
}
