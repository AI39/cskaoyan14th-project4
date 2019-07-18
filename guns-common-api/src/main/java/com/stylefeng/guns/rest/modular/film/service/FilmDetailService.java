package com.stylefeng.guns.rest.modular.film.service;

import com.stylefeng.guns.rest.modular.film.vo.FilmDetailVO;

public interface FilmDetailService {
    FilmDetailVO queryFilmDetailById(int filmId);

    FilmDetailVO queryFilmDetailByName(String filmName);

    boolean selectValidFilmExist(int filmId);

    boolean selectValidFilmExistByName(String filmName);
}
