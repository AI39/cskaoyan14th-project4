package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class CatVO implements Serializable {
    private static final long serialVersionUID = -5817433398594146215L;
    private String catId;
    private String catName;
    private boolean isActive = false;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
