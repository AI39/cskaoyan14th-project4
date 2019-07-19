package com.stylefeng.guns.rest.modular.film.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.film.service.GetFilmService;
import com.stylefeng.guns.rest.modular.film.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("film")
public class GetFilmController {

    @Reference
    GetFilmService getFilmService;

    private static final String IMG_PRE = "http://img.meetingshop.cn/";

    @RequestMapping(value = {"getFilms"},method = {RequestMethod.GET})
    public Object getFilmList(int showType,int sortId,int catId,int sourceId,int yearId,int nowPage,int pageSize){

        return getFilmService.selectGetFilmDataListByIdId(showType,sortId,catId,sourceId,yearId,nowPage,pageSize);
    }

}
