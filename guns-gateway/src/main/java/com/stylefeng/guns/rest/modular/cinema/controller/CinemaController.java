package com.stylefeng.guns.rest.modular.cinema.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cinema")
public class CinemaController {
    @Reference
    CinemaService cinemaService;

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return cinemaService.selectById(1).toString();
    }
}
