package com.stylefeng.guns.rest.modular.order.service;


import com.stylefeng.guns.rest.modular.order.vo.OrderVO;

public interface OrderService {
    //判断该场次是否有该座位
    Boolean isTrueSeats(String fieldId, String seatId);

    Boolean isSoldSeats (String fieldId,String seatId);

    OrderVO saveOrderInfo(String fieldId, String soldSeats, String seatsName, Integer userId);

    /*Page<OrderVO> getOrderByUserId(Integer userId,Page<OrderVO> page);*/

    String getSoldSeatsByFieldId(Integer fieldId);
}
