package com.company;

import java.util.Objects;

public class ResultItem {
    private int dividend;
    private int divisor;
    private int result;
    private int reminder;

    public ResultItem() {}

    public ResultItem(int reminder) {
        this.reminder = reminder;
    }

    public ResultItem(int dividend, int divisor, int result, int reminder) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.result = result;
        this.reminder = reminder;
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
        return  dividend == that.dividend &&
                divisor == that.divisor &&
                reminder == that.reminder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, reminder);
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return this.result;
    }
}
