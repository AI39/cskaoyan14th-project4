package com.stylefeng.guns.rest.modular.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.modular.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yuechao Yang
 * @version 2019-07-16-22:18
 */
@Service(interfaceClass = com.stylefeng.guns.rest.modular.user.service.UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;
    @Override
    public Object selectById(int i) {
        return userMapper.selectById(i);
    }
}
