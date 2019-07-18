package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class FilmDirectorVO implements Serializable {
    private static final long serialVersionUID = 156708780541735065L;
    String imgAddress;
    String directorName;
    public FilmDirectorVO() {
    }

    public FilmDirectorVO(String imgAddress, String directorName) {
        this.imgAddress = imgAddress;
        this.directorName = directorName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
