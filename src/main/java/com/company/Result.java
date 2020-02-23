package com.company;

import java.util.ArrayList;

public class Result {
    private ArrayList<ResultItem> resultLines;
    private int dividend;
    private int divisor;
    private int result;
    private boolean isPositiveResult;



    public Result(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.isPositiveResult = !(dividend < 0 ^ divisor < 0);
        this.result = dividend/divisor;
        resultLines = new ArrayList<ResultItem>();
    }


    public void addResult(ResultItem item) {
        resultLines.add(item);
    }

    public ResultItem getLastResult() {
        return resultLines.get(resultLines.size()-1);
    }

    public ArrayList<ResultItem> getResultLines() {
        return resultLines;
    }

    public boolean isPositiveResult() {
        return isPositiveResult;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getResult() {
        return result;
    }
}
