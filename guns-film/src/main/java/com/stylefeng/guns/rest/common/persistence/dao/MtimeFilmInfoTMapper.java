package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmInfoT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-07-17
 */
public interface MtimeFilmInfoTMapper extends BaseMapper<MtimeFilmInfoT> {
    MtimeFilmInfoT selectFilmInfoByFilmId(@Param("filmId") int filmId);
}
