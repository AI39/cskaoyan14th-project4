package com.stylefeng.guns.rest.modular.film.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.film.service.FilmDetailService;
import com.stylefeng.guns.rest.modular.film.vo.ExceptionResponseVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmDetailVO;
import com.stylefeng.guns.rest.modular.film.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film/films")
public class FilmDetailController {
    @Reference
    FilmDetailService filmDetailService;


    @Reference(interfaceClass = FilmDetailService.class,check = false)
    @RequestMapping(value ={"/{data}"},method = {RequestMethod.GET})
    public Object queryFilmDetail(int searchType, @PathVariable String data){

        ResponseVo<FilmDetailVO> responseVo = new ResponseVo<>();
        ExceptionResponseVO exceptionResponseVo = new ExceptionResponseVO();
        boolean flag=true;
        if(searchType==0){
            int filmId = Integer.valueOf(data);
            flag=filmDetailService.selectValidFilmExist(filmId);
        } else if(searchType == 1){
            String filmName = data;
            flag = filmDetailService.selectValidFilmExistByName(filmName);
        }
        if(!flag) {
            exceptionResponseVo.setMsg("查询失败，无影片可加载");
            exceptionResponseVo.setStatus(1);
            return exceptionResponseVo;
        }

        FilmDetailVO filmDetailVO = new FilmDetailVO();
        try {
            if (searchType == 0) {
                int filmId = Integer.valueOf(data);
                filmDetailVO = filmDetailService.queryFilmDetailById(filmId);
            } else if (searchType == 1) {
                String filmName = data;
                filmDetailVO = filmDetailService.queryFilmDetailByName(filmName);
            }
        } catch (Exception e){
            e.printStackTrace();
            exceptionResponseVo.setMsg("系统出现异常，请联系管理员");
            exceptionResponseVo.setStatus(999);
            return exceptionResponseVo;
        }
        responseVo.setStatus(0);
        responseVo.setImgPre("http://img.meetingshop.cn/");
        responseVo.setData(filmDetailVO);
        return responseVo;
    }
}
