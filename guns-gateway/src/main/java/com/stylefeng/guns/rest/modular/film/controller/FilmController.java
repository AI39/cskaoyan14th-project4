package com.stylefeng.guns.rest.modular.film.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.film.exception.NullConditionException;
import com.stylefeng.guns.rest.modular.film.vo.FilmConditionVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.film.service.BannerService;
import com.stylefeng.guns.rest.modular.film.service.FilmIndexService;
import com.stylefeng.guns.rest.modular.film.vo.ConditionResponseVO;
import com.stylefeng.guns.rest.modular.film.vo.ExceptionResponseVO;
import com.stylefeng.guns.rest.modular.film.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("film")
public class FilmController {

    @Reference
    FilmIndexService filmIndexService;
    @Reference
    BannerService bannerService;
    private static final String IMG_PRE = "http://img.meetingshop.cn/";

    @RequestMapping(value = {"getIndex"}, method = {RequestMethod.GET})
    public Object getIndex() {
        ResponseVo<FilmIndexVO> responseVo = new ResponseVo<>();
        ExceptionResponseVO exceptionResponseVo = new ExceptionResponseVO();
        //查询有无banner可加载
        boolean flag = bannerService.selectValidBannerExist();
        if(!flag) {
            exceptionResponseVo.setMsg("查询失败，无影片可加载");
            exceptionResponseVo.setStatus(1);
            return exceptionResponseVo;
        }

        //显示主页
        FilmIndexVO filmIndexData = null;
        try {
            filmIndexData = filmIndexService.selectFilmIndexData();
        } catch (Exception e) {
            e.printStackTrace();
            exceptionResponseVo.setMsg("系统出现异常，请联系管理员");
            exceptionResponseVo.setStatus(999);
            return exceptionResponseVo;
        }
        responseVo.setData(filmIndexData);
        responseVo.setImgPre(IMG_PRE);
        responseVo.setStatus(0);
        return responseVo;
    }

    @RequestMapping(value = {"getConditionList"}, method = {RequestMethod.GET})
    public Object getConditionList(int catId, int sourceId, int yearId) {
        ConditionResponseVO<FilmConditionVO> responseVo = new ConditionResponseVO<>();
        ExceptionResponseVO exceptionResponseVo = new ExceptionResponseVO();
        FilmConditionVO filmConditionVO = null;
        try {
            filmConditionVO = filmIndexService.selectFilmConditionData(catId, sourceId, yearId);
        } catch (NullConditionException nullConditionException) {
            nullConditionException.printStackTrace();
            exceptionResponseVo.setMsg("查询失败，无条件可加载");
            exceptionResponseVo.setStatus(1);
            return exceptionResponseVo;
        }
        catch (Exception e) {
            e.printStackTrace();
            exceptionResponseVo.setMsg("系统出现异常，请联系管理员");
            exceptionResponseVo.setStatus(999);
            return exceptionResponseVo;
        }
        responseVo.setData(filmConditionVO);
        responseVo.setStatus(0);
        return responseVo;
    }
}
