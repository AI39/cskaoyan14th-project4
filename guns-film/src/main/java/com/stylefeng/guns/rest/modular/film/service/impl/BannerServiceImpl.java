package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.BannerMapper;
import com.stylefeng.guns.rest.modular.film.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = BannerService.class)
@Component
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public boolean selectValidBannerExist() {
        int count = bannerMapper.selectValidBannerCount();
        if(count > 0) {
            return true;
        }
        return false;
    }
}
