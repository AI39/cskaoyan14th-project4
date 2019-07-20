package com.stylefeng.guns.rest.modular.order.service.impl;

import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.order.util.MyJsonUtils;
import com.stylefeng.guns.rest.modular.order.vo.FourDXVO;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Service(interfaceClass= OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    MtimeFieldTMapper fieldTMapper;
    @Autowired
    MtimeHallDictTMapper hallDictTMapper;

    @Override
    public Boolean isTrueSeats(String fieldId, String seatId) {
        //检查数据合法
        if(seatId == null || seatId.length() == 0) {
            return false;
        }
        if(fieldId == null || fieldId.length() == 0) {
            return false;
        }
        //1.根据filedId找到hallId
        MtimeFieldT mtimeFieldT = fieldTMapper.selectById(fieldId);
        if(mtimeFieldT == null) {
            return false;
        }
        Integer hallId = mtimeFieldT.getHallId();
        //2.根据hallId找到seat的json文件存放位置
        MtimeHallDictT mtimeHallDictT = hallDictTMapper.selectById(hallId);
        if(mtimeHallDictT == null) {
            return false;
        }
        String seatAddress = mtimeHallDictT.getSeatAddress();
        seatAddress = "static/" + seatAddress;
        //3.读取json文件封装到对象中
        FourDXVO fourDXVO = null;
        try {
            fourDXVO = MyJsonUtils.readJsonFromClassPath(seatAddress, FourDXVO.class);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        //4.获得seat数组，判断是否存在
        if(fourDXVO != null) {
            String ids = fourDXVO.getIds();
            if(ids != null) {
                String[] split = ids.split(",");
                for(String s : split) {
                    if(seatId.equals(s)) {
                        return true;
                    }
                }
            }
        }

        return false;
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
