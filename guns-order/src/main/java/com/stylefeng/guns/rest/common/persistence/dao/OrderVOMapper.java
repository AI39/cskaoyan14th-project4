package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderVOMapper extends BaseMapper<OrderVO> {
    List<OrderVO> selectByUserId(@Param("userId") Integer userId);
    List<OrderVO> selectByUserId2017(@Param("userId") Integer userId);
    List<OrderVO> selectByUserId2018(@Param("userId") Integer userId);

    OrderVO selectByOrderId(@Param("orderId") String orderId);
}
