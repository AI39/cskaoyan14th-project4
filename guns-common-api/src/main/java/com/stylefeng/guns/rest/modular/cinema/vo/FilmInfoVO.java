package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class FilmInfoVO implements Serializable {

    private String filmId;
    private String filmName;
    private String filmType;

    private String imgAddress;
    private String filmCats;
    private String actors;

    private String filmLength;
//    private List<FilmFiledVO>


    public FilmInfoVO(String filmId, String filmName, String filmType, String imgAddress, String filmCats, String actors, String filmLength) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmType = filmType;
        this.imgAddress = imgAddress;
        this.filmCats = filmCats;
        this.actors = actors;
        this.filmLength = filmLength;
    }

    public FilmInfoVO() {
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
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

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    @Override
    public String toString() {
        return "FilmInfoVO{" +
                "filmId='" + filmId + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmType='" + filmType + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmCats='" + filmCats + '\'' +
                ", actors='" + actors + '\'' +
                ", filmLength='" + filmLength + '\'' +
                '}';
    }
}
