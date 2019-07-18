package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stylefeng.guns.rest.common.persistence.dao.CinemaMapper;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaService;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaListVo;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaListVoData;
import com.stylefeng.guns.rest.modular.cinema.vo.FieldListVoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = com.stylefeng.guns.rest.modular.cinema.service.CinemaService.class)
@Component
public class CinemaServiceImpl implements CinemaService {
    @Autowired(required = false)
    CinemaMapper cinemaMapper;

    @Override
    public CinemaListVo selectCinemaListVoDataListByBrandIdAndHallTypeAndDistrictId(Integer brandId, Integer hallType, Integer districtId, Integer pageSize, Integer nowPage) {
        PageHelper.startPage(nowPage,pageSize);
        List<CinemaListVoData> CinemaListVoDataList = cinemaMapper.selectCinemaListVoDataListByBrandIdAndHallTypeAndDistrictId(brandId, hallType, districtId);
        PageInfo<CinemaListVoData> pageInfo = new PageInfo<>(CinemaListVoDataList);
        CinemaListVo cinemaListVo = new CinemaListVo();
        cinemaListVo.setData(pageInfo.getList());
        cinemaListVo.setNowPage(nowPage);
        cinemaListVo.setTotalPage(pageInfo.getPages());

        return cinemaListVo;
    }

/*    @Override
    public FieldListVoData selectFieldListVoDataByCinemaId(Integer cinemaId) {
        FieldListVoData fieldListVoData = cinemaMapper.selectFieldListVoDataByCinemaId(cinemaId);

        return fieldListVoData;
    }*/

    @Override
    public FieldListVoData selectFieldListVoDataByCinemaId(Integer cinemaId) {
        FieldListVoData fieldListVoData = new FieldListVoData();
        fieldListVoData.setCinemaInfo(cinemaMapper.selectCinemaInfoByCinemaId(cinemaId));
        fieldListVoData.setFilmList(cinemaMapper.selectCinemaFilmByCinemaId(cinemaId));

        return fieldListVoData;
    }
}
