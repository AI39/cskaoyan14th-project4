package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;
import java.util.List;

public class FilmConditionVO implements Serializable {
    private static final long serialVersionUID = -4395369553674700825L;
    private List<CatVO> catInfo;
    private List<SourceVO> sourceInfo;
    private List<YearVo> yearInfo;

    public List<CatVO> getCatInfo() {
        return catInfo;
    }

    public void setCatInfo(List<CatVO> catInfo) {
        this.catInfo = catInfo;
    }

    public List<SourceVO> getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(List<SourceVO> sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public List<YearVo> getYearInfo() {
        return yearInfo;
    }

    public void setYearInfo(List<YearVo> yearInfo) {
        this.yearInfo = yearInfo;
    }
}
