package com.stylefeng.guns.rest.modular.film.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.BannerMapper;
import com.stylefeng.guns.rest.common.persistence.dao.FilmMapper;
import com.stylefeng.guns.rest.modular.film.exception.NullConditionException;
import com.stylefeng.guns.rest.modular.film.service.FilmIndexService;
import com.stylefeng.guns.rest.modular.film.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = FilmIndexService.class)
@Component
public class FilmIndexServiceImpl implements FilmIndexService {
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    FilmMapper filmMapper;

    @Override
    public FilmIndexVO selectFilmIndexData() {
        FilmIndexVO filmIndexData = new FilmIndexVO();
        //获得banners
        List<BannerVO> banners = bannerMapper.selectValidBannerList();
        filmIndexData.setBanners(banners);

        //获得hotFilms
        FilmWrapper<HotFilmInfoVO> hotFilms = new FilmWrapper<>();
        hotFilms.setFilmNum(filmMapper.selectHotFilmNum());
        List<HotFilmInfoVO> hotFilmInfos = filmMapper.selectHotFilmInfo();
        hotFilms.setFilmInfo(hotFilmInfos);
        filmIndexData.setHotFilms(hotFilms);

        //获得soonFilms
        FilmWrapper<SoonFilmInfoVO> soonFilms = new FilmWrapper<>();
        soonFilms.setFilmNum(filmMapper.selectSoonFilmNum());
        List<SoonFilmInfoVO> soonFilmInfos = filmMapper.selectSoonFilmInfo();
        soonFilms.setFilmInfo(soonFilmInfos);
        filmIndexData.setSoonFilms(soonFilms);

        //获得boxRanking
        List<BoxRankingFilmVO> boxRanking = filmMapper.selectBoxRankingFilms();
        filmIndexData.setBoxRanking(boxRanking);

        //获得expectRanking
        List<ExpectRankingFilmVO> expectRanking = filmMapper.selectExpectRankinFilms();
        filmIndexData.setExpectRanking(expectRanking);

        //获得top100
        List<Top100FilmVO> top100 = filmMapper.selectTop100Films();
        filmIndexData.setTop100(top100);

        return filmIndexData;
    }

    @Override
    public FilmConditionVO selectFilmConditionData(int catId, int sourceId, int yearId) throws NullConditionException {
        FilmConditionVO filmConditionVo = new FilmConditionVO();
        //获取cat
        List<CatVO> catInfo = filmMapper.selectCatById(catId);
        filmConditionVo.setCatInfo(catInfo);

        //获取source
        List<SourceVO> sourceInfo = filmMapper.selectSourceById(sourceId);
        filmConditionVo.setSourceInfo(sourceInfo);

        //获取year
        List<YearVo> yearInfo = filmMapper.selectYearById(yearId);
        filmConditionVo.setYearInfo(yearInfo);

        if((catInfo == null || catInfo.size() == 0) && (sourceInfo == null || sourceInfo.size() == 0) && (yearInfo == null || yearInfo.size() == 0)) {
            throw new NullConditionException("查询失败，无条件可加载");
        }

        return filmConditionVo;
    }
}
