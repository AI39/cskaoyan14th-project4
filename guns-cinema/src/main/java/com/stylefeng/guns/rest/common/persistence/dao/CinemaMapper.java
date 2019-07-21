package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.cinema.vo.CinemaFilm;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaInfo;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaListVoData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaMapper {
    List<CinemaListVoData> selectCinemaListVoDataListByBrandIdAndHallTypeAndAreaId(@Param("brandId") int brandId, @Param("hallType") int hallType, @Param("areaId") int areaId);
//    FieldListVoData selectFieldListVoDataByCinemaId(@Param("cinemaId") int cinemaId);
    CinemaInfo selectCinemaInfoByCinemaId(@Param("cinemaId") int cinemaId);
    List<CinemaFilm> selectCinemaFilmByCinemaId(@Param("cinemaId") int cinemaId);

    Integer[] selectFilmIdByCinemaId(@Param("cid")Integer cinemaId);

    Integer selectCinemaFilmFieldByFieldId(@Param("fid") Integer fieldId);

    List<String> selectSeatsIdsByFieldId(@Param("fieldId") Integer fieldId);
}
