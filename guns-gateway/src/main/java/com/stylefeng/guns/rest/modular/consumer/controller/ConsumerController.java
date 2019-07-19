package com.stylefeng.guns.rest.modular.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.consumer.service.ConsumerService;
import com.stylefeng.guns.rest.modular.consumer.vo.ErrorMap;
import com.stylefeng.guns.rest.modular.consumer.vo.ErrorVo;
import com.stylefeng.guns.rest.modular.consumer.vo.UserInfoModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;

import com.stylefeng.guns.rest.modular.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController

public class ConsumerController {

    @Reference(check = false)
    ConsumerService consumerService;

    @RequestMapping("/user/test")
    @ResponseBody
    public String test() {
        return consumerService.selectById(2).toString();
    }

    @PostMapping("/user/register")
    @ResponseBody
    public ErrorVo register(@Param("username") String username, @Param("password") String password, String Email, String Phone, String Address){
        ErrorVo errorVo = new ErrorVo();
        String encrypt = MD5Util.encrypt(password);
        int i = consumerService.register(username, encrypt, Email, Phone, Address);
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

    @PostMapping("/user/check")
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


    @PostMapping("/user/updateUserInfo")
    @ResponseBody
    public Object updateUserInfo(UserInfoModel userInfoModel){
        ErrorMap errorMap = new ErrorMap();
        int i = consumerService.updateUserInfo(userInfoModel);
        UserInfoModel data = consumerService.queryUserById(userInfoModel.getUuid());
        if (i == 1){
            return ErrorMap.getfile1(data);
        }else if (i == 0){
            return ErrorMap.getfile2(1, "用户信息修改失败");
        }else if (i == 999){
            return ErrorMap.getfile2(999, "系统出现异常，请联系管理员");
        }
        return errorMap;
    }

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @PostMapping("/auth")
    @ResponseBody
    public Object login(@Param("username") String userName, @Param("password")String password){
        Jedis jedis = new Jedis();
        try {
            String pws = consumerService.queryPasswordByUserName(userName);                                     //根据username查询password（MD5加密过的，在注册的时候加密）
            String encrypt = MD5Util.encrypt(password);                                                         //把从前端得到的密码加密


            String randomKey = jwtTokenUtil.getRandomKey();                                                     //根据jwt工具类得到randomkey
            String token = jwtTokenUtil.generateToken(userName, randomKey);                                     //然后得到token
            Map<String,Object> data = new HashMap<>();
            data.put("randomKey", randomKey);
            data.put("token", token);
            if (encrypt.equals(pws)){
                jedis.set(userName, token);                                                                     //如果账号密码匹配，就把token给jedis
                return ErrorMap.getfile1(data);
            }else{
                return ErrorMap.getfile2(1, "用户名或密码错误");
            }
        }catch (Exception e){
            return ErrorMap.getfile2(999, "系统出现异常，请联系管理员");
        }
    }

    @GetMapping("/user/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request){
        String token = request.getHeader("Authorization");                                                  //从头文件中得到token
        token = token.substring(7, token.length());                                                             //去掉token的前缀
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Jedis jedis = new Jedis();

        try {
            if (username == null || username.equals("")){
                return ErrorMap.getfile2(1,"退出失败，用户尚未登陆");
            } else {
                jedis.del(username);                                                                           //把之前存在jedis中的关于token的键值对删除
                return ErrorMap.getfile2(0,"成功退出");
            }
        } catch (Exception e){
            return ErrorMap.getfile2(999,"系统出现异常，请联系管理员");
        }
    }

    @GetMapping("/user/getUserInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request){
        String token = request.getHeader("Authorization");                                                  //从头文件中得到token
        token = token.substring(7, token.length());                                                             //去掉token的前缀
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserInfoModel data = consumerService.queryUserByUsername(username);
        try {
            if (data != null){
                return ErrorMap.getfile1(data);
            }else {
                return ErrorMap.getfile2(1,"查询失败，用户尚未登陆");
            }
        } catch (Exception e){
            return ErrorMap.getfile2(999,"系统出现异常，请联系管理员");
        }

    }

}
