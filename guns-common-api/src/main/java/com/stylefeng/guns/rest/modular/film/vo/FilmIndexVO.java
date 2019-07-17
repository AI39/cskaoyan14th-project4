package com.stylefeng.guns.rest.modular.film.vo;


import java.io.Serializable;
import java.util.List;

public class FilmIndexVO implements Serializable {
    private static final long serialVersionUID = -4286824781052456850L;
    private List<BannerVO> banners;
    private FilmWrapper<HotFilmInfoVO> hotFilms;
    private FilmWrapper<SoonFilmInfoVO> soonFilms;
    private List<BoxRankingFilmVO> boxRanking;
    private List<ExpectRankingFilmVO> expectRanking;
    private List<Top100FilmVO> top100;

    public List<BannerVO> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerVO> banners) {
        this.banners = banners;
    }

    public FilmWrapper<HotFilmInfoVO> getHotFilms() {
        return hotFilms;
    }

    public void setHotFilms(FilmWrapper<HotFilmInfoVO> hotFilms) {
        this.hotFilms = hotFilms;
    }

    public FilmWrapper<SoonFilmInfoVO> getSoonFilms() {
        return soonFilms;
    }

    public void setSoonFilms(FilmWrapper<SoonFilmInfoVO> soonFilms) {
        this.soonFilms = soonFilms;
    }

    public List<BoxRankingFilmVO> getBoxRanking() {
        return boxRanking;
    }

    public void setBoxRanking(List<BoxRankingFilmVO> boxRanking) {
        this.boxRanking = boxRanking;
    }

    public List<ExpectRankingFilmVO> getExpectRanking() {
        return expectRanking;
    }

    public void setExpectRanking(List<ExpectRankingFilmVO> expectRanking) {
        this.expectRanking = expectRanking;
    }

    public List<Top100FilmVO> getTop100() {
        return top100;
    }

    public void setTop100(List<Top100FilmVO> top100) {
        this.top100 = top100;
    }
}
