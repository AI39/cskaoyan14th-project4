package com.stylefeng.guns.rest.modular.cinema.service;

import com.stylefeng.guns.rest.modular.cinema.vo.CinemaListVo;
import com.stylefeng.guns.rest.modular.cinema.vo.ConditionVo;
import com.stylefeng.guns.rest.modular.cinema.vo.FieldInfo;
import com.stylefeng.guns.rest.modular.cinema.vo.FieldListVoData;

public interface CinemaService {
    CinemaListVo selectCinemaListVoDataListByBrandIdAndHallTypeAndAreaId(Integer brandId, Integer hallType, Integer areaId, Integer pageSize, Integer nowPage);
    FieldListVoData selectFieldListVoDataByCinemaId(Integer cinemaId);

    ConditionVo selectConditionByBrandIdAndHallTypeAndAreaId(Integer brandId, Integer hallType, Integer areaId);

    FieldInfo selectFieldByCinemaIdAndFieldId(Integer cinemaId, Integer fieldId);
}
