package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class FilmCastVO implements Serializable {
    private static final long serialVersionUID = 8326581826915781954L;
    FilmDirectorVO director;
    FilmActorVO[] actors;

    public FilmCastVO() {
    }

    public FilmCastVO(FilmDirectorVO director, FilmActorVO[] actors) {
        this.director = director;
        this.actors = actors;
    }

    public FilmDirectorVO getDirector() {
        return director;
    }

    public void setDirector(FilmDirectorVO director) {
        this.director = director;
    }

    public FilmActorVO[] getActors() {
        return actors;
    }

    public void setActors(FilmActorVO[] actors) {
        this.actors = actors;
    }
}
