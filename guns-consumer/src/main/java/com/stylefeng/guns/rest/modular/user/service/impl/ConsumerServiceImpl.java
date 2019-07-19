package com.stylefeng.guns.rest.modular.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.modular.consumer.service.ConsumerService;
import com.stylefeng.guns.rest.modular.consumer.vo.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-17-20:08
 */
@Service(interfaceClass = com.stylefeng.guns.rest.modular.consumer.service.ConsumerService.class)
@Component
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired(required = false)
    MtimeUserTMapper mtimeUserTMapper;

    @Override
    public Object selectById(int i) {
        return mtimeUserTMapper.selectById(i);
    }

    @Override
    public int register(String username, String password, String Email, String Phone, String Address) {
        String name = mtimeUserTMapper.queryUserByUsername(username);
        if (name != null){
            return 1;
        }
        int j = mtimeUserTMapper.register(username, password, Email, Phone, Address);
        if (j == 1){
            return 0;
        }else {
            return 999;
        }

    }

    @Override
    public int check(String username) {
        String name = mtimeUserTMapper.queryUserByUsername(username);
        if (name != null){
            return 1;
        }else if(name == null){
            return 0;
        }else{
            return 999;
        }
    }

    @Override
    public int updateUserInfo(UserInfoModel userInfoModel) {
        int i = mtimeUserTMapper.updateUserInfo(userInfoModel);
        return i;
    }

    @Override
    public UserInfoModel queryUserById(Integer uuid) {

        UserInfoModel userInfoModel = mtimeUserTMapper.queryUserById(uuid);

        return userInfoModel;
    }

    @Override
    public String queryPasswordByUserName(String username) {
        return mtimeUserTMapper.queryPasswordByUsername(username);
    }

    @Override
    public UserInfoModel queryUserByUsername(String username) {
        return mtimeUserTMapper.queryUserByusername(username);
    }
}
