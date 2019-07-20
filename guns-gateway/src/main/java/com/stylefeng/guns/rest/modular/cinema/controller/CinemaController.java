package com.stylefeng.guns.rest.modular.cinema.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaService;
import com.stylefeng.guns.rest.modular.cinema.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "cinema", method = RequestMethod.GET)
public class CinemaController {
    @Reference(check = false)
    CinemaService cinemaService;

    @RequestMapping(value = "getCinemas")
    @ResponseBody
    public CinemaListVo getCinemas(Integer brandId, Integer hallType, Integer districtId, Integer pageSize, Integer nowPage) {
        CinemaListVo cinemaListVo = cinemaService.selectCinemaListVoDataListByBrandIdAndHallTypeAndDistrictId(brandId, hallType, districtId, pageSize, nowPage);
        cinemaListVo.setStatus(0);
        return cinemaListVo;
        //异常情况暂未处理
    }

    @RequestMapping(value = "getFields", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public FieldListVo getFieldsgetFields(Integer cinemaId) {
        FieldListVoData fieldListVoData = cinemaService.selectFieldListVoDataByCinemaId(cinemaId);

        FieldListVo fieldListVo = new FieldListVo();
        fieldListVo.setStatus(0);
        fieldListVo.setImgPre("http://img.meetingshop.cn/");
        fieldListVo.setData(fieldListVoData);
        return fieldListVo;
        //异常情况暂未处理
    }

    @RequestMapping(value = "getCondition" ,method = RequestMethod.GET)
    @ResponseBody
    public ConditionVo getCondition(Integer brandId, Integer hallType, Integer areaId){
        ConditionVo conditionVO = cinemaService.selectConditionByBrandIdAndHallTypeAndAreaId(brandId,hallType,areaId);
        return conditionVO;
    }

    @RequestMapping(value = "getFieldInfo",method = RequestMethod.POST)
    @ResponseBody
    public FieldInfo getFieldInfo(Integer cinemaId,Integer fieldId){
        FieldInfo fieldInfo = cinemaService.selectFieldByCinemaIdAndFieldId(cinemaId,fieldId);
        return fieldInfo;
    }
}
