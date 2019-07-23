package com.stylefeng.guns.rest.modular.order.service.impl;

import com.stylefeng.guns.rest.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service(interfaceClass= OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    MoocOrderTMapper orderTMapper;
    @Autowired
    MtimeFieldTMapper fieldTMapper;
    @Autowired
    MtimeFilmTMapper filmTMapper;

    @Override
    public Boolean isTrueSeats(String fieldId, String seatId) {
        //1.根据filedId找到hallId
        //2.根据hallId找到seat的json文件存放位置
        //3.读取json文件封装到对象中
        return null;
    }

    @Override
    public Boolean isSoldSeats(String fieldId, String seatId) {
        int fieldid=Integer.valueOf(fieldId);
        List<String> seatsIds = orderTMapper.selectSeatsIdsByFieldId(fieldid);
        ArrayList<String> seatsIdList=new ArrayList<>();
        for(String items:seatsIds){
            String[] split = items.split(",");
            for(int i=0;i<split.length;i++){
                seatsIdList.add(split[i]);
            }
        }
        boolean flag=false;
        for(String items:seatsIdList){
            if(items==seatId){
                flag=true;
                break;
            }
        }
        return flag;
    }

    @Override
    public OrderVO saveOrderInfo(String fieldId, String soldSeats, String seatsName, Integer userId) {
        OrderVO data = new OrderVO();
        String s = UUID.randomUUID().toString();
        String uuid = s.replace("-", "");
        String code=uuid.substring(0,18);
        MtimeFieldT mtimeFieldT = fieldTMapper.selectById(fieldId);
        Integer filmId = mtimeFieldT.getFilmId();
        Integer price = mtimeFieldT.getPrice();
        Integer cinemaId = mtimeFieldT.getCinemaId();
        MoocOrderT moocOrderT = new MoocOrderT();
        moocOrderT.setUuid(code);
        moocOrderT.setCinemaId(cinemaId);
        moocOrderT.setFieldId(Integer.valueOf(fieldId));
        moocOrderT.setFilmId(filmId);
        moocOrderT.setSeatsIds(soldSeats);
        moocOrderT.setSeatsName(seatsName);
        String[] split = soldSeats.split(",");
        moocOrderT.setFilmPrice(price*1.0);
        moocOrderT.setOrderPrice(price*split.length*1.0);
        moocOrderT.setOrderTime(new Date());
        moocOrderT.setOrderUser(userId);
        moocOrderT.setOrderStatus(0);
        orderTMapper.insert(moocOrderT);
        MtimeFilmT mtimeFilmT = filmTMapper.selectById(fieldId);
        return null;
    }

    @Override
    public String getSoldSeatsByFieldId(Integer fieldId) {
        return null;
    }

}
