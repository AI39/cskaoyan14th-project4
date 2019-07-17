package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class SourceVO implements Serializable {
    private String sourceId;
    private String sourceName;
    private boolean isActive = true;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
