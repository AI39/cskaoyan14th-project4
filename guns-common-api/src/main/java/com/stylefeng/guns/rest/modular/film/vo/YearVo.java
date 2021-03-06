package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class YearVo implements Serializable {
    private static final long serialVersionUID = 3440714017696407284L;
    private int yearId;
    private String yearName;
    private boolean isActive = false;

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
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
