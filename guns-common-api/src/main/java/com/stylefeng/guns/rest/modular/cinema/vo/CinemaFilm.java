package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class CinemaFilm implements Serializable {
    private int filmId;
    private String filmName;
    private int filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private List<CinemaFilmField> filmFields;

    public CinemaFilm() {
    }

    public CinemaFilm(int filmId, String filmName, int filmLength, String filmType, String filmCats, String actors, String imgAddress, List<CinemaFilmField> filmFields) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmLength = filmLength;
        this.filmType = filmType;
        this.filmCats = filmCats;
        this.actors = actors;
        this.imgAddress = imgAddress;
        this.filmFields = filmFields;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public List<CinemaFilmField> getFilmFields() {
        return filmFields;
    }

    public void setFilmFields(List<CinemaFilmField> filmFields) {
        this.filmFields = filmFields;
    }

    @Override
    public String toString() {
        return "CinemaFilm{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", filmLength=" + filmLength +
                ", filmType='" + filmType + '\'' +
                ", filmCats='" + filmCats + '\'' +
                ", actors='" + actors + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmFields=" + filmFields +
                '}';
    }
}
