package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class CinemaListVo implements Serializable {
    private int status;
    private int nowPage;
    private int totalPage;
    private List<CinemaListVoData> data;

    public CinemaListVo() {
    }

    public CinemaListVo(int status, int nowPage, int totalPage, List<CinemaListVoData> data) {
        this.status = status;
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public List<CinemaListVoData> getData() {
        return data;
    }

    public void setData(List<CinemaListVoData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CinemaListVo{" +
                "status=" + status +
                ", nowPage=" + nowPage +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }

}
