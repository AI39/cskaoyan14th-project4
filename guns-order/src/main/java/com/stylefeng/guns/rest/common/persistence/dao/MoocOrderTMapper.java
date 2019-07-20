package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author cskaoyan14th
 * @since 2019-07-20
 */
public interface MoocOrderTMapper extends BaseMapper<MoocOrderT> {
    List<String> selectSeatsIdsByFieldId(@Param("fieldid") int fieldid);

}
