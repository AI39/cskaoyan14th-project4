package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class AreaVO implements Serializable {

    private String areaId;
    private String areaName;
    private boolean isActive;

    public AreaVO() {
    }

    public AreaVO(String areaId, String areaName, boolean isActive) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.isActive = isActive;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "AreaVO{" +
                "areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

