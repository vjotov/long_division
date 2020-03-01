package com.company;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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

        int [] dividendNums = getArrayOfDigits(dividend);


        int tmpInt = dividendNums[0];

        for(int i = 0; i < dividendNums.length /*|| isContinue*/; i++) {
            if(tmpInt >= divisor) {
                ResultItem line = new ResultItem();
                line.setDividend(tmpInt);
                line.setDivisor(divisor);
                line.setResult(tmpInt/divisor);
                int remDiv = tmpInt % divisor;
                line.setReminder(remDiv);
                result.addResult(line);
                if (remDiv != 0 && i != dividendNums.length - 1) { //1
                   tmpInt = remDiv * 10 + dividendNums[i+1];
                   continue;
                }
                if (i < dividendNums.length-1) {
                    tmpInt = dividendNums[i+1];
                }
                continue;
            } else {
                if (tmpInt == 0) {
                    ResultItem line = new ResultItem(0);
                    result.addResult(line);
                    if (i < dividendNums.length-1) {
                        tmpInt = dividendNums[i+1];
                    }
                    continue;
                }
                if (tmpInt < divisor) {
                    if (i < dividendNums.length -1 ) {
                        tmpInt = tmpInt * 10 + dividendNums[i+1];
                        continue;
                    } else {
                        ResultItem line = new ResultItem(tmpInt);
                        result.addResult(line);
                    }
                }
            }

        }

        return result;
    }

    private static int[] getArrayOfDigits (int number) {
        int numberLength = (int) Math.log10(number) + 1;
        int[] result = new int[numberLength];

        AtomicInteger tempNum = new AtomicInteger(number);
        result = Arrays.stream(result)
                .map( (m) -> {
                    int tt = tempNum.get();
                    tempNum.set( tt / 10);
                    return tt % 10;
                })
                .toArray();
        invertIntArray(result);

        return result;
    }
    private static void invertIntArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
