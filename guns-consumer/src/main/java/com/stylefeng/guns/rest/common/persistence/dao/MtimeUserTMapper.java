package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.modular.consumer.vo.UserInfoModel;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author cskaoyan14th
 * @since 2019-07-17
 */
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {

    String queryUserByUsername(String username);

    int register(String username, String password, String Email, String Phone, String Address);

    int updateUserInfo(UserInfoModel userInfoModel);

    UserInfoModel queryUserById(Integer uuid);

    String queryPasswordByUsername(String username);

    UserInfoModel queryUserByusername(String username);
}
