package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.cinema.vo.HallInfoVO;
import org.apache.ibatis.annotations.Param;

public interface HallMapper {
    HallInfoVO selectHallInfoVOByFieldId(@Param("fid") Integer fieldId);
}
