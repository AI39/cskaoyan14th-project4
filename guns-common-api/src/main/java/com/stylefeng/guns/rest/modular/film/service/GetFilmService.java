package com.stylefeng.guns.rest.modular.film.service;

import com.stylefeng.guns.rest.modular.film.vo.FilmDetailVO;
import com.stylefeng.guns.rest.modular.film.vo.GetFilmVO;

public interface GetFilmService {
    /*影片详情*/
    GetFilmVO queryGetFilmVOById(int filmId);

    GetFilmVO queryGetFilmVOByName(String filmName);

    boolean selectGetFilmVOExist(int filmId);

    boolean selectGetFilmVOByName(String filmName);


}
