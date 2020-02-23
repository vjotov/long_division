package com.company;

import java.util.Objects;

public class ResultItem {
    private int offset;
    private int dividend;
    private int divisor;
    private int reminder;

    public ResultItem() {}

    public ResultItem(int offset, int reminder) {
        this.offset = offset;
        this.reminder = reminder;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultItem that = (ResultItem) o;
        return offset == that.offset &&
                dividend == that.dividend &&
                divisor == that.divisor &&
                reminder == that.reminder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset, dividend, divisor, reminder);
    }
}
