package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class FilmDetailInfoVO implements Serializable {
    private static final long serialVersionUID = -6156014623185788606L;
    String biography;
    FilmCastVO actors;

    public FilmDetailInfoVO() {
    }

    public FilmDetailInfoVO(String biography, FilmCastVO actors) {
        this.biography = biography;
        this.actors = actors;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public FilmCastVO getActors() {
        return actors;
    }

    public void setActors(FilmCastVO actors) {
        this.actors = actors;
    }
}
