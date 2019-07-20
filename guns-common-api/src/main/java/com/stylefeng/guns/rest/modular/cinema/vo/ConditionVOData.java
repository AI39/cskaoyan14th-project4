package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;
import java.util.List;

public class ConditionVOData implements Serializable {

    private List<HallTypeVO> halltypeList;
    private List<BrandVO> brandList;
    private List<AreaVO> areaList;

    public ConditionVOData(List<HallTypeVO> halltypeList, List<BrandVO> brandList, List<AreaVO> areaList) {
        this.halltypeList = halltypeList;
        this.brandList = brandList;
        this.areaList = areaList;
    }

    public ConditionVOData() {
    }

    public List<HallTypeVO> getHalltypeList() {
        return halltypeList;
    }

    public void setHalltypeList(List<HallTypeVO> halltypeList) {
        this.halltypeList = halltypeList;
    }

    public List<BrandVO> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandVO> brandList) {
        this.brandList = brandList;
    }

    public List<AreaVO> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaVO> areaList) {
        this.areaList = areaList;
    }

    @Override
    public String toString() {
        return "ConditionVOData{" +
                "halltypeList=" + halltypeList +
                ", brandList=" + brandList +
                ", areaList=" + areaList +
                '}';
    }
}
