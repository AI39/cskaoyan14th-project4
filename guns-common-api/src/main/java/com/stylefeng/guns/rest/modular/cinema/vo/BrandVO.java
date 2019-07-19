package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class BrandVO implements Serializable {

    private String brandId;
    private String brandName;
    private boolean isActive;

    public BrandVO() {
    }

    public BrandVO(String brandId, String brandName, boolean isActive) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.isActive = isActive;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "BrandVO{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
