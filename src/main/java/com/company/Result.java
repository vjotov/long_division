package com.company;

import java.util.ArrayList;

public class Result {
    private ArrayList<ResultItem> result;
    private boolean isPositiveResult;

    public Result(boolean isPositiveResult) {
        this.isPositiveResult = isPositiveResult;
        result = new ArrayList<ResultItem>();
    }
    public void addResult(ResultItem item) {
        result.add(item);
    }

    public ResultItem getLastResult() {
        return result.get(result.size()-1);
    }

    public ArrayList<ResultItem> getResult() {
        return result;
    }

    public void setResult(ArrayList<ResultItem> result) {
        this.result = result;
    }

    public boolean isPositiveResult() {
        return isPositiveResult;
    }

    public void setPositiveResult(boolean nagativeResult) {
        isPositiveResult = nagativeResult;
    }
}
