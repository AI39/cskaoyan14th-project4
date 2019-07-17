package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.film.vo.BannerVO;

import java.util.List;

public interface BannerMapper {
    int selectValidBannerCount();

    List<BannerVO> selectValidBannerList();
}
