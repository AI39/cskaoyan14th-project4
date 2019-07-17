package com.stylefeng.guns.rest.modular.cinema.service;

import com.stylefeng.guns.rest.modular.cinema.vo.CinemaListVo;
import com.stylefeng.guns.rest.modular.cinema.vo.FieldListVoData;

public interface CinemaService {
    CinemaListVo selectCinemaListVoDataListByBrandIdAndHallTypeAndDistrictId(Integer brandId, Integer hallType, Integer districtId, Integer pageSize, Integer nowPage);
    FieldListVoData selectFieldListVoDataByCinemaId(Integer cinemaId);

}