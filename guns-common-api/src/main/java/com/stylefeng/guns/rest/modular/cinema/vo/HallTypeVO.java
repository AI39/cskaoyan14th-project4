package com.stylefeng.guns.rest.modular.cinema.vo;

import java.io.Serializable;

public class HallTypeVO implements Serializable {

    private String halltypeId;
    private String halltypeName;
    private boolean isActive;

    public HallTypeVO(String halltypeId, String halltypeName, boolean isActive) {
        this.halltypeId = halltypeId;
        this.halltypeName = halltypeName;
        this.isActive = isActive;
    }

    public HallTypeVO() {
    }

    public String getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(String halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "HallTypeVO{" +
                "halltypeId='" + halltypeId + '\'' +
                ", halltypeName='" + halltypeName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

