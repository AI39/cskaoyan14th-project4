package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class YearVo implements Serializable {
    private String yearId;
    private String yearName;
    private boolean isActive;

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
