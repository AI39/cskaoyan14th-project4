package com.stylefeng.guns.rest.modular.film.service;

        import com.stylefeng.guns.rest.modular.cinema.vo.CinemaListVo;
        import com.stylefeng.guns.rest.modular.cinema.vo.FieldListVoData;
        import com.stylefeng.guns.rest.modular.film.vo.FilmDateVO;
        import com.stylefeng.guns.rest.modular.film.vo.FilmDetailVO;
        import com.stylefeng.guns.rest.modular.film.vo.GetFilmVO;

        import java.util.List;

public interface GetFilmService {
    /*影片详情*/
    FilmDateVO selectGetFilmDataListByIdId(Integer showType, Integer sortId, Integer catId, Integer sourceId, Integer yearId, Integer pageSize, Integer nowPage);

}
