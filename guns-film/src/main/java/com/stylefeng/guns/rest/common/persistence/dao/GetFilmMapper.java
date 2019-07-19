package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.film.vo.BannerVO;
import com.stylefeng.guns.rest.modular.film.vo.GetFilmVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GetFilmMapper {

    List<GetFilmVO> selectGetFilmDataListByIdId(@Param("showType") int showType, @Param("sortId") int sortId, @Param("catId") int catId,@Param("sourceId") int sourceId, @Param("yearId") int yearId );


}
