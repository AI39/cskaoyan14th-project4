package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.cinema.vo.AreaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    List<AreaVO> selectAreaByAreaId(@Param("area") Integer areaId);
}
