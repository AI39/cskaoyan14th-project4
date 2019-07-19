package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class SourceVO implements Serializable {
    private static final long serialVersionUID = -4806191742764642868L;
    private int sourceId;
    private String sourceName;
    private boolean isActive = false;

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
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
