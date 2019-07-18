package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class FilmActorVO implements Serializable {
    private static final long serialVersionUID = 8035300455275909161L;
    String imgAddress;
    String directorName;
    String roleName;

    public FilmActorVO() {
    }

    public FilmActorVO(String imgAddress, String directorName, String roleName) {
        this.imgAddress = imgAddress;
        this.directorName = directorName;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
