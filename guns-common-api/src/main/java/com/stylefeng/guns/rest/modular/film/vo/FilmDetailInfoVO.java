package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class FilmDetailInfoVO implements Serializable {
    private static final long serialVersionUID = -6156014623185788606L;
    String biography;
    FilmCastVO actors;
    ImageVO imgVO;
    String filmId;

    public FilmDetailInfoVO() {
    }

    public FilmDetailInfoVO(String biography, FilmCastVO actors, ImageVO imgVO, String filmId) {
        this.biography = biography;
        this.actors = actors;
        this.imgVO = imgVO;
        this.filmId = filmId;
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

    public ImageVO getImgVO() {
        return imgVO;
    }

    public void setImgVO(ImageVO imgVO) {
        this.imgVO = imgVO;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }
}
