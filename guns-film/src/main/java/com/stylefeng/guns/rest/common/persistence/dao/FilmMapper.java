package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.film.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmMapper {

    int selectHotFilmNum();

    List<HotFilmInfoVO> selectHotFilmInfo();

    int selectSoonFilmNum();

    List<SoonFilmInfoVO> selectSoonFilmInfo();

    List<BoxRankingFilmVO> selectBoxRankingFilms(@Param("limit") int limit);

    List<ExpectRankingFilmVO> selectExpectRankinFilms(@Param("limit") int limit);

    List<Top100FilmVO> selectTop100Films(@Param("limit") int limit);

    List<CatVO> selectCatById(@Param("catId") int catId);

    List<SourceVO> selectSourceById(@Param("sourceId") int sourceId);

    List<YearVo> selectYearById(@Param("yearId") int yearId);
}
