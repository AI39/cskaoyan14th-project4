package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
import com.stylefeng.guns.rest.modular.film.service.FilmDetailService;
import com.stylefeng.guns.rest.modular.film.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Service(interfaceClass= FilmDetailService.class)
@Component
public class FilmDetailServiceImpl implements FilmDetailService{
    @Autowired
    MtimeActorTMapper actorTMapper;
    @Autowired
    MtimeBannerTMapper bannerTMapper;
    @Autowired
    MtimeCatDictTMapper catDictTMapper;
    @Autowired
    MtimeFilmActorTMapper filmActorTMapper;
    @Autowired
    MtimeFilmInfoTMapper filmInfoTMapper;
    @Autowired
    MtimeFilmTMapper filmTMapper;
    @Autowired
    MtimeSourceDictTMapper sourceDictTMapper;
    @Autowired
    MtimeYearDictTMapper yearDictTMapper;

    @Override
    public FilmDetailVO queryFilmDetailById(int filmId) {
        MtimeFilmT filmT = filmTMapper.selectById(filmId);
        FilmDetailVO filmDetail = new FilmDetailVO();
        filmDetail.setFilmId(""+filmId);
        filmDetail.setFilmName(filmT.getFilmName());
        filmDetail.setImgAddress(filmT.getImgAddress());
        filmDetail.setScore(filmT.getFilmScore());
        MtimeFilmInfoT filmInfoT = filmInfoTMapper.selectFilmInfoByFilmId(filmId);
        filmDetail.setFilmEnName(filmInfoT.getFilmEnName());
        filmDetail.setScoreNum(filmInfoT.getFilmScoreNum()+"万人评分");
        Integer filmBox = filmT.getFilmBoxOffice();
        String box=String.valueOf(filmBox/10000);
        filmDetail.setTotalBox(box+"亿");


        String info01 = "";
        String filmCats = filmT.getFilmCats();
        filmCats=filmCats.substring(1,filmCats.length()-1);
        String[] arr=filmCats.split("#");
        int[] arr2=new int[arr.length];
        for(int j=0;j<arr.length;j++){
            arr2[j]=Integer.valueOf(arr[j]);
            MtimeCatDictT catDictT = catDictTMapper.selectById(arr2[j]);
            String showName = catDictT.getShowName();
            if(j<arr2.length-1){
                info01=info01+showName+",";
            } else {
                info01=info01+showName;
            }
        }
        System.out.println(info01);
        filmDetail.setInfo01(info01);



        Integer filmArea = filmT.getFilmArea();
        MtimeSourceDictT area = sourceDictTMapper.selectById(filmArea);
        Integer filmLength = filmInfoT.getFilmLength();
        filmDetail.setInfo02(area.getShowName()+"/"+filmLength+"分钟");
        Date filmTime = filmT.getFilmTime();
        filmDetail.setInfo03(""+filmTime+area.getShowName()+"上映");

        FilmDetailInfoVO filmDetailInfo = new FilmDetailInfoVO();
        filmDetailInfo.setBiography(filmInfoT.getBiography());

        FilmCastVO filmCast = new FilmCastVO();

        FilmDirectorVO filmDirector = new FilmDirectorVO();
        int directorId = filmInfoT.getDirectorId();
        MtimeActorT director = actorTMapper.selectById(directorId);
        filmDirector.setDirectorName(director.getActorName());
        filmDirector.setImgAddress(director.getActorImg());

        FilmActorVO[] filmActors = filmTMapper.selectAllActors(filmId);

        filmCast.setDirector(filmDirector);
        filmCast.setActors(filmActors);

        filmDetailInfo.setActors(filmCast);

        filmDetail.setInfo04(filmDetailInfo);

        String filmImgs = filmInfoT.getFilmImgs();
        String[] filmImages=filmImgs.split(",");
        ImageVO imageVo = new ImageVO(filmImages[0],filmImages[1],filmImages[2],filmImages[3],filmImages[4]);
        filmDetail.setImgVO(imageVo);


        return filmDetail;
    }

    @Override
    public FilmDetailVO queryFilmDetailByName(String filmName) {
        MtimeFilmT filmT = filmTMapper.selectFilmByFilmName(filmName);
        FilmDetailVO filmDetail = new FilmDetailVO();
        filmDetail.setFilmId(""+filmT.getUuid());
        filmDetail.setFilmName(filmT.getFilmName());
        filmDetail.setImgAddress(filmT.getImgAddress());
        filmDetail.setScore(filmT.getFilmScore());
        MtimeFilmInfoT filmInfoT = filmInfoTMapper.selectFilmInfoByFilmId(filmT.getUuid());
        filmDetail.setFilmEnName(filmInfoT.getFilmEnName());
        filmDetail.setScoreNum(filmInfoT.getFilmScoreNum()+"万人评分");
        Integer filmBox = filmT.getFilmBoxOffice();
        String box=String.valueOf(filmBox/10000);
        filmDetail.setTotalBox(box+"亿");


        String info01 = "";
        String filmCats = filmT.getFilmCats();
        filmCats=filmCats.substring(1,filmCats.length()-1);
        String[] arr=filmCats.split("#");
        int[] arr2=new int[arr.length];
        for(int j=0;j<arr.length;j++){
            arr2[j]=Integer.valueOf(arr[j]);
            MtimeCatDictT catDictT = catDictTMapper.selectById(arr2[j]);
            String showName = catDictT.getShowName();
            if(j<arr2.length-1){
                info01=info01+showName+",";
            } else {
                info01=info01+showName;
            }
        }
        System.out.println(info01);
        filmDetail.setInfo01(info01);



        Integer filmArea = filmT.getFilmArea();
        MtimeSourceDictT area = sourceDictTMapper.selectById(filmArea);
        Integer filmLength = filmInfoT.getFilmLength();
        filmDetail.setInfo02(area.getShowName()+"/"+filmLength+"分钟");
        Date filmTime = filmT.getFilmTime();
        filmDetail.setInfo03(""+filmTime+area.getShowName()+"上映");

        FilmDetailInfoVO filmDetailInfo = new FilmDetailInfoVO();
        filmDetailInfo.setBiography(filmInfoT.getBiography());

        FilmCastVO filmCast = new FilmCastVO();

        FilmDirectorVO filmDirector = new FilmDirectorVO();
        int directorId = filmInfoT.getDirectorId();
        MtimeActorT director = actorTMapper.selectById(directorId);
        filmDirector.setDirectorName(director.getActorName());
        filmDirector.setImgAddress(director.getActorImg());

        FilmActorVO[] filmActors = filmTMapper.selectAllActors(filmT.getUuid());

        filmCast.setDirector(filmDirector);
        filmCast.setActors(filmActors);

        filmDetailInfo.setActors(filmCast);

        filmDetail.setInfo04(filmDetailInfo);

        String filmImgs = filmInfoT.getFilmImgs();
        String[] filmImages=filmImgs.split(",");
        ImageVO imageVo = new ImageVO(filmImages[0],filmImages[1],filmImages[2],filmImages[3],filmImages[4]);
        filmDetail.setImgVO(imageVo);


        return filmDetail;
    }

    @Override
    public boolean selectValidFilmExist(int filmId) {
        int count= filmTMapper.selectValidFilmCount(filmId);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean selectValidFilmExistByName(String filmName) {
        int count = filmTMapper.selectValidFilmCountByName(filmName);
        if(count>0){
            return true;
        }
        return false;
    }

}
