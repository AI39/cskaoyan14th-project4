package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;
import java.util.List;

public class FilmDateVO implements Serializable {

    private static final long serialVersionUID = -4889600419788677595L;

    private int status;
    private String imgPre;
    private int nowPage;
    private int totalPage;
    private List<GetFilmVO> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<GetFilmVO> getData() {
        return data;
    }

    public void setData(List<GetFilmVO> data) {
        this.data = data;
    }
}
