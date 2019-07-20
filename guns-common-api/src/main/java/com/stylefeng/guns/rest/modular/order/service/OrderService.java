package com.stylefeng.guns.rest.modular.order.service;

public interface OrderService {
    //判断该场次是否有该座位
    Boolean isTrueSeats(String fieldId, String seatId);
}
