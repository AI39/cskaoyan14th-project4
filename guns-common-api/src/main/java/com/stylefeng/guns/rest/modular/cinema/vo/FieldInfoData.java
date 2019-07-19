package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FieldInfoData implements Serializable {

    private FilmInfoVO filmInfo;
    private CinemaInfo cinemaInfo;
    private HallInfoVO hallInfo;

    public FieldInfoData(FilmInfoVO filmInfo, CinemaInfo cinemaInfo, HallInfoVO hallInfo) {
        this.filmInfo = filmInfo;
        this.cinemaInfo = cinemaInfo;
        this.hallInfo = hallInfo;
    }

    public FieldInfoData() {
    }

    public FilmInfoVO getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(FilmInfoVO filmInfo) {
        this.filmInfo = filmInfo;
    }

    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public HallInfoVO getHallInfo() {
        return hallInfo;
    }

    public void setHallInfo(HallInfoVO hallInfo) {
        this.hallInfo = hallInfo;
    }

    @Override
    public String toString() {
        return "FieldInfoData{" +
                "filmInfo=" + filmInfo +
                ", cinemaInfo=" + cinemaInfo +
                ", hallInfo=" + hallInfo +
                '}';
    }
}
