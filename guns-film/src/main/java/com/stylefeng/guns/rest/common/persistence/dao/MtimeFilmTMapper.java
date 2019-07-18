package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.vo.FilmActorVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-07-17
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {
    FilmActorVO[] selectAllActors(@Param("filmId") int filmId);

    MtimeFilmT selectFilmByFilmName(@Param("filmName") String filmName);

    int selectValidFilmCount(@Param("filmId")int filmId);

    int selectValidFilmCountByName(@Param("filmName")String filmName);
}
