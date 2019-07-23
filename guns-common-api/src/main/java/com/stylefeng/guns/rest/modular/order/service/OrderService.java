package com.stylefeng.guns.rest.modular.order.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;

import java.util.List;

public interface OrderService {
    //判断该场次是否有该座位
    Boolean isTrueSeats(String fieldId, String seatId);

    Boolean isSoldSeats (String fieldId,String seatId);

    OrderVO saveOrderInfo(String fieldId, String soldSeats, String seatsName, Integer userId);

    List<OrderVO> getOrderByUserId(Integer userId, Integer pageNum , Integer PageSize);

    String getSoldSeatsByFieldId(Integer fieldId);

    //根据fieldId和seatId获取seatName
    String getSeatName(String fieldId, String seatId);
}
