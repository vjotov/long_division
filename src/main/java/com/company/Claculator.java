package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Claculator {
    public static Result divide(int dividend, int divisor ) {
        if(divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        Result result = new Result(dividend,divisor);

        if (dividend < divisor) {
            ResultItem line = new ResultItem(divisor);
            result.addResult(line);
            return result;
        }

        List<Integer> dividendNums =  getListOfDigits(dividend);


        int tmpInt = dividendNums.get(0);

        for(int i = 0; i < dividendNums.size(); i++) {
            if(tmpInt >= divisor) {
                ResultItem line = new ResultItem();
                line.setDividend(tmpInt);
                line.setDivisor(divisor);
                line.setResult(tmpInt/divisor);
                int remDiv = tmpInt % divisor;
                line.setReminder(remDiv);
                result.addResult(line);
                if (remDiv != 0 && i != dividendNums.size() - 1) { //1
                   tmpInt = remDiv * 10 + dividendNums.get(i+1);
                   continue;
                }
                if (i < dividendNums.size()-1) {
                    tmpInt = dividendNums.get(i+1);
                }
            } else {
                if (tmpInt == 0) {
                    ResultItem line = new ResultItem(0);
                    result.addResult(line);
                    if (i < dividendNums.size()-1) {
                        tmpInt = dividendNums.get(i+1);
                    }
                }
                if (tmpInt < divisor) {
                    if (i < dividendNums.size() -1 ) {
                        tmpInt = tmpInt * 10 + dividendNums.get(i+1);
                    } else {
                        ResultItem line = new ResultItem(tmpInt);
                        result.addResult(line);
                    }
                }
            }

        }

        return result;
    }

    private static List<Integer> getListOfDigits (int number) {
        int numberLength = (int) Math.log10(number) + 1;
        List<Integer>  result = new LinkedList<Integer>();
        AtomicInteger tempNum = new AtomicInteger(number);

        result = Stream.generate(() -> "")
                .limit(numberLength)
                .map( (m) -> {
                    Integer tt = tempNum.get();
                    tempNum.set( tt / 10);
                    return tt % 10;
                }).collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }
}
