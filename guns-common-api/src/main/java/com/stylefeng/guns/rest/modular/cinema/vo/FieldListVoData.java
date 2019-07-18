package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class FieldListVoData implements Serializable {
    private CinemaInfo cinemaInfo;
    private List<CinemaFilm> filmList;

    public FieldListVoData() {
    }

    public FieldListVoData(CinemaInfo cinemaInfo, List<CinemaFilm> filmList) {
        this.cinemaInfo = cinemaInfo;
        this.filmList = filmList;
    }

    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public List<CinemaFilm> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<CinemaFilm> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "FieldListVoData{" +
                "cinemaInfo=" + cinemaInfo +
                ", filmList=" + filmList +
                '}';
    }
}
