package com.stylefeng.guns.rest.modular.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderTestController {
    @Reference
    OrderService orderService;

    @GetMapping("test")
    public Object test1(String fieldId, String seatId) {
        Boolean trueSeats = orderService.isTrueSeats(fieldId, seatId);
        return trueSeats;
    }
}
