package com.stylefeng.guns.rest.modular.film.service;

        import com.stylefeng.guns.rest.modular.film.vo.FilmDateVO;

public interface GetFilmService {
    /*影片详情*/
    FilmDateVO selectGetFilmDataListByIdId(Integer showType, Integer sortId, Integer catId, Integer sourceId, Integer yearId, Integer pageSize, Integer nowPage, String kw);

}
