package com.stylefeng.guns.rest.modular.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.stylefeng.guns.rest.modular.consumer.service.ConsumerService;
import com.stylefeng.guns.rest.modular.consumer.vo.ErrorMap;
import com.stylefeng.guns.rest.modular.consumer.vo.ErrorVo;
import com.stylefeng.guns.rest.modular.consumer.vo.UserInfoModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.stylefeng.guns.rest.modular.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class ConsumerController {

    @Reference(check = false)
    ConsumerService consumerService;

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return consumerService.selectById(2).toString();
    }

    @PostMapping("register")
    @ResponseBody
    public ErrorVo register(@Param("username") String username, @Param("password") String password, String Email, String Phone, String Address){
        ErrorVo errorVo = new ErrorVo();
        int i = consumerService.register(username, password, Email, Phone, Address);
        if (i == 0){
            errorVo.setStatus(0);
            errorVo.setMsg("验证成功");
        }else if(i == 1){
            errorVo.setStatus(1);
            errorVo.setMsg("用户已存在");
        }else if (i == 999){
            errorVo.setStatus(999);
            errorVo.setMsg("系统出现异常，请联系管理员");
        }
        return errorVo;
    }

    @PostMapping("check")
    @ResponseBody
    public ErrorVo check(@Param("username") String username) {
        ErrorVo errorVo = new ErrorVo();
        int i = consumerService.check(username);
        if (i == 0) {
            errorVo.setStatus(0);
            errorVo.setMsg("验证成功");
        } else if (i == 1) {
            errorVo.setStatus(1);
            errorVo.setMsg("用户已存在");
        } else if (i == 999) {
            errorVo.setStatus(999);
            errorVo.setMsg("系统出现异常，请联系管理员");
        }
        return errorVo;
    }


    @PostMapping("updateUserInfo")
    @ResponseBody
    public Object updateUserInfo(UserInfoModel userInfoModel){
        ErrorMap errorMap = new ErrorMap();
        int i = consumerService.updateUserInfo(userInfoModel);
        UserInfoModel data = consumerService.queryUserById(userInfoModel.getUuid());
        if (i == 1){
            return ErrorMap.getfile1(data);
        }else if (i == 0){
            return ErrorMap.getfile2();
        }else if (i == 999){
            return ErrorMap.getfile3();
        }
        return errorMap;
    }
}
