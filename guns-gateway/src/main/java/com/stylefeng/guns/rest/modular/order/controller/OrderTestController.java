package com.stylefeng.guns.rest.modular.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderTestController {
    @Reference(check = false)
    OrderService orderService;

    @GetMapping("test1")
    public Object test1(String fieldId, String seatId) {
        Boolean trueSeats = orderService.isTrueSeats(fieldId, seatId);
        return trueSeats;
    }

    @GetMapping("test2")
    public Object test2() {
        List<OrderVO> list = orderService.getOrderByUserId(1, 3, 5);
        return list;
    }

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @GetMapping("test3")
    public Object test3() {
        Jedis jedis = new Jedis();

        String usernameFromToken = jwtTokenUtil.getUsernameFromToken("eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJkc3VmNWIiLCJzdWIiOiJhZG1pbiIsImV4cCI6MTU2NDMyNjkyMywiaWF0IjoxNTYzNzIyMTIzfQ.K6NTHaz7aK9hZ6ac1_-x72inXhmPUEe2EYmKG79QWfDNsvElRKM39Ra19hirWY0DSDilN0qBkcBFcJgkFdY64Q");
        String token = jedis.get(usernameFromToken);

        return token;
    }

    @GetMapping("test4")
    public Object test4() {
        String soldSeatsByFieldId = orderService.getSoldSeatsByFieldId(1);
        return soldSeatsByFieldId;
    }
}
