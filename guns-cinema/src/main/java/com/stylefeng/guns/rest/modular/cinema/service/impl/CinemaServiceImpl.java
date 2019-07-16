package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeAreaDictTMapper;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = com.stylefeng.guns.rest.modular.cinema.service.CinemaService.class)
@Component
public class CinemaServiceImpl implements CinemaService {
    @Autowired(required = false)
    MtimeAreaDictTMapper mtimeAreaDictTMapper;
    //下面的函数用于测试
    public Object selectById(int id) {
        return mtimeAreaDictTMapper.selectById(id);
    }

}
