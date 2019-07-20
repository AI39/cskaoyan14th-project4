package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.cinema.vo.FilmInfoVO;
import org.apache.ibatis.annotations.Param;

public interface FilmMapper {
    FilmInfoVO selectFilmInfoVOByFilmId(@Param("fid") Integer filmId);
}
