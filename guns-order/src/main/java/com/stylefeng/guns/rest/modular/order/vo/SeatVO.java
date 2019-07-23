package com.stylefeng.guns.rest.modular.order.vo;

public class SeatVO {
    private int seatId;
    private int row;
    private int column;

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "SeatVO{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
