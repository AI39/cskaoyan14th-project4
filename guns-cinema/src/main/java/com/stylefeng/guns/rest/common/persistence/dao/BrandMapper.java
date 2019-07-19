package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.cinema.vo.BrandVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<BrandVO> selectBrandByBrandId(@Param("bId") Integer brandId);
}
