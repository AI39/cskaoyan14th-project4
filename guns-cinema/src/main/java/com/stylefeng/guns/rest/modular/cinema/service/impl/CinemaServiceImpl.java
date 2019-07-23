package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaService;
import com.stylefeng.guns.rest.modular.cinema.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(interfaceClass = com.stylefeng.guns.rest.modular.cinema.service.CinemaService.class)
@Component
public class CinemaServiceImpl implements CinemaService {
    @Autowired(required = false)
    CinemaMapper cinemaMapper;
    @Autowired(required = false)
    BrandMapper brandMapper;
    @Autowired(required = false)
    HalltypeMapper halltypeMapper;
    @Autowired(required = false)
    AreaMapper areaMapper;
    @Autowired(required = false)
    FilmMapper filmMapper;


    @Autowired(required = false)
    HallMapper hallMapper;
    @Override
    public CinemaListVo selectCinemaListVoDataListByBrandIdAndHallTypeAndAreaId(Integer brandId, Integer hallType, Integer areaId, Integer pageSize, Integer nowPage) {
        PageHelper.startPage(nowPage,pageSize);
        List<CinemaListVoData> CinemaListVoDataList = cinemaMapper.selectCinemaListVoDataListByBrandIdAndHallTypeAndAreaId(brandId, hallType, areaId);
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

    @Override
    public ConditionVo selectConditionByBrandIdAndHallTypeAndAreaId(Integer brandId, Integer hallType, Integer areaId) {

        List<HallTypeVO> halltypeList = halltypeMapper.selectHalltypeByHallType(hallType);
        List<BrandVO> brandList = brandMapper.selectBrandByBrandId(brandId);
        List<AreaVO>  areaList = areaMapper.selectAreaByAreaId(areaId);
        ConditionVOData conditionVOData = new ConditionVOData(halltypeList,brandList,areaList);
        ConditionVo conditionVo = new ConditionVo(0,"查询成功",conditionVOData);
        return  conditionVo;
    }

    @Override
    public FieldInfo selectFieldByCinemaIdAndFieldId(Integer cinemaId, Integer fieldId) {
        Integer filmId = cinemaMapper.selectCinemaFilmFieldByFieldId(fieldId);
        FilmInfoVO filmInfoVO = filmMapper.selectFilmInfoVOByFilmId(filmId);
        HallInfoVO hallInfoVO = hallMapper.selectHallInfoVOByFieldId(fieldId);

        Set<String> allSoldSeatsSet = new HashSet();
        List<String> soldSeatsList = cinemaMapper.selectSeatsIdsByFieldId(fieldId);
        System.out.println(soldSeatsList);
        String str = "";
        if (soldSeatsList != null && soldSeatsList.size() != 0) {
            for (String s : soldSeatsList) {
                String[] soldSeatsArray = s.split(",");
                Set<String> soldSeatsSet = new HashSet(Arrays.asList(soldSeatsArray));
                allSoldSeatsSet.addAll(soldSeatsSet);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String s : allSoldSeatsSet) {
                stringBuffer.append(s).append(",");
            }
            str = stringBuffer.toString();
            str = str.substring(0, str.length()-1);
        }
        else {
            str = "";
        }
        hallInfoVO.setSoldSeats(str);

        CinemaInfo cinemaInfo = cinemaMapper.selectCinemaInfoByCinemaId(cinemaId);
        FieldInfoData fieldInfoData = new FieldInfoData(filmInfoVO,cinemaInfo,hallInfoVO);
        FieldInfo fieldInfo = new FieldInfo(0,"http://img.meetingshop.cn/",fieldInfoData);
        return  fieldInfo ;
    }
}
