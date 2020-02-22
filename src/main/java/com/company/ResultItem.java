package com.company;

public class ResultItem {
    private int offset;
    private int dividend;
    private int divisor;
    private int quotient;
    private int reminder;

    public ResultItem() {}
    public ResultItem(int offset, int dividend, int divisor, int quotient, int reminder) {
        this.offset = offset;
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
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

    public int getQuotient() {
        return quotient;
    }

    public void setQuotient(int intResult) {
        this.quotient = intResult;
    }

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }
}
