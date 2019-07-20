package com.stylefeng.guns.rest.modular.order.service.impl;

import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {
    /*@Autowired
    MtimeOrderTMapper orderMapper;*/

    @Override
    public Boolean isTrueSeats(String fieldId, String seatId) {
        //1.根据filedId找到hallId
        //2.根据hallId找到seat的json文件存放位置
        //3.读取json文件封装到对象中
        return null;
    }
}
