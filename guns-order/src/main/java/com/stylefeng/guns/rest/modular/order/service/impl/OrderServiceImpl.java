package com.stylefeng.guns.rest.modular.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.film.service.OrderService;
import com.stylefeng.guns.rest.modular.film.vo.OrderVO;
import org.springframework.stereotype.Component;


@Service(interfaceClass= OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {


    @Override
    public Boolean isTrueSeats(String fieldId, String seatId) {
        return null;
    }

    @Override
    public Boolean isSoldSeats(String fieldId, String seatId) {
        /*int fieldid=Integer.valueOf(fieldId);
        List<OrderVO> orderVOS = orderMapper.selectOrdersByFieldId(fieldid);
        ArrayList<String> seatIds;
        for(OrderVO items:orderVOS){


        }*/

        return null;
    }

    @Override
    public OrderVO saveOrderInfo(String fieldId, String soldSeats, String seatsName, Integer userId) {
        return null;
    }

    @Override
    public String getSoldSeatsByFieldId(Integer fieldId) {
        return null;
    }
}
