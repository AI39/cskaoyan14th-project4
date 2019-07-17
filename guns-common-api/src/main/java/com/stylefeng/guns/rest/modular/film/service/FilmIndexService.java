package com.stylefeng.guns.rest.modular.film.service;

import com.stylefeng.guns.rest.modular.film.vo.FilmConditionVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;

public interface FilmIndexService {
    FilmIndexVO selectFilmIndexData();

    FilmConditionVO selectFilmConditionData(int catId, int sourceId, int yearId);
}
