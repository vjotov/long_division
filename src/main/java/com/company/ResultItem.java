package com.company;

public class ResultItem {
    private int dividend;
    private int divisor;
    private int quotient;
    private int module;

    public ResultItem() {}
    public ResultItem(int dividend, int divisor, int quotient, int reminder) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.module = reminder;
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

    public int getModule() {
        return module;
    }

    public void setModule(int reminder) {
        this.module = reminder;
    }
}
