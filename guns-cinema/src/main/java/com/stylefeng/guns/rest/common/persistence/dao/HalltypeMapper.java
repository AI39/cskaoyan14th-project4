package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.cinema.vo.HallInfoVO;
import com.stylefeng.guns.rest.modular.cinema.vo.HallTypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HalltypeMapper {
    List<HallTypeVO> selectHalltypeByHallType(@Param("hall") Integer hallType);

}
