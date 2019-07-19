package com.stylefeng.guns.rest.modular.film.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.BannerMapper;
import com.stylefeng.guns.rest.common.persistence.dao.FilmMapper;
import com.stylefeng.guns.rest.modular.film.exception.NullConditionException;
import com.stylefeng.guns.rest.modular.film.service.FilmIndexService;
import com.stylefeng.guns.rest.modular.film.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Service(interfaceClass = FilmIndexService.class)
@Component
public class FilmIndexServiceImpl implements FilmIndexService {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private FilmMapper filmMapper;

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
        int boxRankingLimit = 9;
        List<BoxRankingFilmVO> boxRanking = filmMapper.selectBoxRankingFilms(boxRankingLimit);
        filmIndexData.setBoxRanking(boxRanking);

        //获得expectRanking
        int expectRankingLimit = 7;
        List<ExpectRankingFilmVO> expectRanking = filmMapper.selectExpectRankinFilms(expectRankingLimit);
        filmIndexData.setExpectRanking(expectRanking);

        //获得top100
        int top100Limit = 9;
        List<Top100FilmVO> top100 = filmMapper.selectTop100Films(top100Limit);
        filmIndexData.setTop100(top100);

        return filmIndexData;
    }

    @Override
    public FilmConditionVO selectFilmConditionData(int catId, int sourceId, int yearId) throws NullConditionException {
        FilmConditionVO filmConditionVo = new FilmConditionVO();
        //获取cat
        List<CatVO> catInfo = filmMapper.selectCatById(99);

        for (int i = 0; i < catInfo.size(); i++) {
            CatVO catVO = catInfo.get(i);
            if(catVO.getCatId() == catId) {
                catVO.setIsActive(true);
                catInfo.set(i, catVO);
                break;
            }
        }

        filmConditionVo.setCatInfo(catInfo);

        //获取source
        List<SourceVO> sourceInfo = filmMapper.selectSourceById(99);

        for (int i = 0; i < sourceInfo.size(); i++) {
            SourceVO sourceVO = sourceInfo.get(i);
            if(sourceVO.getSourceId() == sourceId) {
                sourceVO.setIsActive(true);
                sourceInfo.set(i, sourceVO);
                break;
            }
        }

        filmConditionVo.setSourceInfo(sourceInfo);

        //获取year
        List<YearVo> yearInfo = filmMapper.selectYearById(99);

        for (int i = 0; i < yearInfo.size(); i++) {
            YearVo yearVo = yearInfo.get(i);
            if(yearVo.getYearId() == yearId) {
                yearVo.setIsActive(true);
                yearInfo.set(i, yearVo);
                break;
            }
        }

        filmConditionVo.setYearInfo(yearInfo);

        if((catInfo == null || catInfo.size() == 0) && (sourceInfo == null || sourceInfo.size() == 0) && (yearInfo == null || yearInfo.size() == 0)) {
            throw new NullConditionException("查询失败，无条件可加载");
        }

        return filmConditionVo;
    }


    }

