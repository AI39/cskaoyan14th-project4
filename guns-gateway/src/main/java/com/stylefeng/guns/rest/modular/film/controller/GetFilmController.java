package com.stylefeng.guns.rest.modular.film.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.film.service.GetFilmService;
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
    public Object getFilmList(Integer showType,Integer sortId,Integer catId,Integer sourceId,Integer yearId,Integer nowPage,Integer pageSize, Integer offset, String kw){
        if (showType == null) {
            showType = 1;
        }
        if (sortId == null) {
            sortId = 1;
        }
        if (catId == null) {
            catId = 99;
        }
        if (sourceId == null) {
            sourceId = 99;
        }
        if (yearId == null) {
            yearId = 99;
        }
        if (nowPage == null) {
            nowPage = 1;
        }
        if (pageSize == null) {
            pageSize = 18;
        }
        if(offset == null) {
            offset = 0;
        }
        return getFilmService.selectGetFilmDataListByIdId(showType,sortId,catId,sourceId,yearId,nowPage,pageSize,kw);
    }

}
