package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class ImageVO implements Serializable {
    private static final long serialVersionUID = 7777329370192255366L;
    String mainImg;
    String img01;
    String img02;
    String img03;
    String img04;

    public ImageVO() {
    }

    public ImageVO(String mainImg, String img01, String img02, String img03, String img04) {
        this.mainImg = mainImg;
        this.img01 = img01;
        this.img02 = img02;
        this.img03 = img03;
        this.img04 = img04;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getImg01() {
        return img01;
    }

    public void setImg01(String img01) {
        this.img01 = img01;
    }

    public String getImg02() {
        return img02;
    }

    public void setImg02(String img02) {
        this.img02 = img02;
    }

    public String getImg03() {
        return img03;
    }

    public void setImg03(String img03) {
        this.img03 = img03;
    }

    public String getImg04() {
        return img04;
    }

    public void setImg04(String img04) {
        this.img04 = img04;
    }
}
