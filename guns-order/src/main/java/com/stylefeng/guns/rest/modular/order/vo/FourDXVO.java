package com.stylefeng.guns.rest.modular.order.vo;

import java.util.Arrays;

public class FourDXVO {
    private int limit;
    private String ids;
    private SeatVO[][] single;
    private SeatVO[][] couple;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public SeatVO[][] getSingle() {
        return single;
    }

    public void setSingle(SeatVO[][] single) {
        this.single = single;
    }

    public SeatVO[][] getCouple() {
        return couple;
    }

    public void setCouple(SeatVO[][] couple) {
        this.couple = couple;
    }

    @Override
    public String toString() {
        return "FourDXVO{" +
                "limit=" + limit +
                ", ids='" + ids + '\'' +
                ", single=" + Arrays.toString(single) +
                ", couple=" + Arrays.toString(couple) +
                '}';
    }
}
