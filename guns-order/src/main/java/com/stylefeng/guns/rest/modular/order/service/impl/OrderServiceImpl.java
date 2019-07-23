package com.stylefeng.guns.rest.modular.order.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageHelper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.OrderVOMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.order.util.MyJsonUtils;
import com.stylefeng.guns.rest.modular.order.vo.FourDXVO;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import com.stylefeng.guns.rest.modular.order.vo.SeatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service(interfaceClass= OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    MoocOrderTMapper orderTMapper;
    @Autowired
    MtimeFilmTMapper filmTMapper;
    @Autowired
    MtimeFieldTMapper fieldTMapper;
    @Autowired
    MtimeHallDictTMapper hallDictTMapper;
    @Autowired
    OrderVOMapper orderVOMapper;

    @Override
    public Boolean isTrueSeats(String fieldId, String seatId) {
        //检查数据合法
        if(seatId == null || seatId.length() == 0) {
            return false;
        }
        if(fieldId == null || fieldId.length() == 0) {
            return false;
        }
        FourDXVO fourDXVO = getFourDX(fieldId);

        //获得seat数组，判断是否存在
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

    private FourDXVO getFourDX(String fieldId) {
        FourDXVO fourDXVO = null;
        //1.根据filedId找到hallId
        MtimeFieldT mtimeFieldT = fieldTMapper.selectById(fieldId);
        if(mtimeFieldT != null) {
            Integer hallId = mtimeFieldT.getHallId();
            //2.根据hallId找到seat的json文件存放位置
            MtimeHallDictT mtimeHallDictT = hallDictTMapper.selectById(hallId);
            if(mtimeHallDictT != null) {
                String seatAddress = mtimeHallDictT.getSeatAddress();
                seatAddress = "static/" + seatAddress;
                //3.读取json文件封装到对象中
                try {
                    fourDXVO = MyJsonUtils.readJsonFromClassPath(seatAddress, FourDXVO.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return fourDXVO;
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

        OrderVO orderVO = getOrderByOrderId(moocOrderT.getUuid());
        return orderVO;
    }

    private OrderVO getOrderByOrderId(String orderId) {
        OrderVO orderVO = orderVOMapper.selectByOrderId(orderId);
        return orderVO;
    }

    @Override
    public List<OrderVO> getOrderByUserId(Integer userId, Integer pageNum ,Integer PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        List<OrderVO> list = orderVOMapper.selectByUserId(userId);
        return list;
    }

    @Override
    public String getSoldSeatsByFieldId(Integer fieldId) {
        List<String> seatsIds = orderTMapper.selectSeatsIdsByFieldId(fieldId);
        HashSet<String> set = new HashSet<>();
        for(String items : seatsIds) {
            String[] split = items.split(",");
            for(String seatId : split) {
                set.add(seatId);
            }
        }
        String s = set.toString();
        return s.replace("[","").replace("]", "");
    }

    @Override
    public String getSeatName(String fieldId, String seatId) {
        String[] arr = {"零","一","二","三","四","五","六","七","八","九","十"};
        Boolean isTrueSeats = isTrueSeats(fieldId, seatId);
        if(isTrueSeats) {
            FourDXVO fourDX = getFourDX(fieldId);
            SeatVO[][] single = fourDX.getSingle();
            SeatVO[][] couple = fourDX.getCouple();

            for (int i = 0; i < single.length; i++) {
                for (int j = 0; j < single[i].length; j++) {
                    SeatVO seat = single[i][j];
                    if(seatId.equals(seat.getSeatId()+"")){
                        return "第" + arr[seat.getRow()] + "排" + seat.getColumn() + "座";
                    }
                }

            }
            for (int i = 0; i < couple.length; i++) {
                for (int j = 0; j < couple[i].length; j++) {
                    SeatVO seat = couple[i][j];
                    if(seatId.equals(seat.getSeatId()+"")){
                        if(seat.getRow() <= 10) {
                            return "第" + arr[seat.getRow()] + "排" + seat.getColumn() + "座";
                        }
                        return "第" + seat.getRow() + "排" + seat.getColumn() + "座";
                    }
                }

            }

        }
        return null;
    }
}
