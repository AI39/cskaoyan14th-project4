package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;
import java.util.List;

public class FilmWrapper<T> implements Serializable {
    private static final long serialVersionUID = -2751364781023665518L;
    int filmNum;
    List<T> filmInfo;

    public int getFilmNum() {
        return filmNum;
    }

    public void setFilmNum(int filmNum) {
        this.filmNum = filmNum;
    }

    public List<T> getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(List<T> filmInfo) {
        this.filmInfo = filmInfo;
    }
}
