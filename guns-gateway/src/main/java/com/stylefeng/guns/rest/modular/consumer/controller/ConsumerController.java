package com.stylefeng.guns.rest.modular.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ConsumerController {
    @Reference
    UserService userService;
    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return userService.selectById(2).toString();
    }

}
