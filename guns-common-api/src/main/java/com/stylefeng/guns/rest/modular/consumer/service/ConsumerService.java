package com.stylefeng.guns.rest.modular.consumer.service;

import com.stylefeng.guns.rest.modular.consumer.vo.UserInfoModel;

import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-17-20:03
 */
public interface ConsumerService {
    public Object selectById(int i);

    int register(String username, String password, String Email, String Phone, String Address);

    int check(String username);

    int updateUserInfo(UserInfoModel userInfoModel);

    UserInfoModel queryUserById(Integer uuid);

    String queryPasswordByUserName(String username);

    UserInfoModel queryUserByUsername(String username);
}
