package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stylefeng.guns.rest.common.persistence.dao.GetFilmMapper;
import com.stylefeng.guns.rest.modular.film.service.GetFilmService;
import com.stylefeng.guns.rest.modular.film.vo.FilmDateVO;
import com.stylefeng.guns.rest.modular.film.vo.GetFilmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = GetFilmService.class)
public class GetFilmServiceImpl implements GetFilmService{

    @Autowired(required = false)
    GetFilmMapper getFilmMapper;

    @Override
    public FilmDateVO selectGetFilmDataListByIdId(Integer showType, Integer sortId, Integer catId, Integer sourceId, Integer yearId, Integer pageSize, Integer nowPage, String kw) {
        PageHelper.startPage(nowPage, pageSize);
        List<GetFilmVO> getFilmVO = getFilmMapper.selectGetFilmDataListByIdId(showType, sortId, catId, sourceId, yearId, kw);
        PageInfo<GetFilmVO> pageInfo = new PageInfo<>(getFilmVO);

        FilmDateVO filmDateVO = new FilmDateVO();
        filmDateVO.setData(pageInfo.getList());
        filmDateVO.setImgPre("http://img.meetingshop.cn/");
        filmDateVO.setNowPage(nowPage);
        filmDateVO.setTotalPage(pageInfo.getPages());
        return filmDateVO;
    }


}
