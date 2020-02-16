package com.company;

import java.util.ArrayList;

public class Result {
    private ArrayList<ResultItem> result;

    public Result() {
        result = new ArrayList<ResultItem>();
    }
    public void addResult(ResultItem item) {
        result.add(item);
    }

}
