package com.stylefeng.guns.rest.modular.order.service.impl;

import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import org.springframework.stereotype.Component;


@Service(interfaceClass= OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {

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

    @Override
    public Boolean isTrueSeats(String fieldId, String seatId) {
        //1.根据filedId找到hallId
        //2.根据hallId找到seat的json文件存放位置
        //3.读取json文件封装到对象中
        return null;
    }
}
