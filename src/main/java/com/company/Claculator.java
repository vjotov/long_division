package com.company;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Claculator {
    public static Result divide(int dividend, int divisor ){
        if(divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        boolean isNagativeResult;
        if(dividend < 0 ^ divisor < 0)
            isNagativeResult = true;
        else
            isNagativeResult = false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        Result result = new Result();

        if (dividend < divisor) {
            ResultItem line = new ResultItem(dividend, divisor, 0, 0);
            result.addResult(line);
            return result;
        }

        int divisorLength = (int) (Math.log10(divisor) + 1);
        int dividendLength = (int) Math.log10(dividend) + 1;

        int [] dividendNums = getArrayOfDigits(dividendLength);

        int tmpInt;
        int multiplyResult;
        int remDiv = 0;

        for (int i = 0; i < dividendNums.length; i++) {
            tmpInt = (remDiv * 10) +dividendNums[i];

            if(tmpInt >= divisor) {
                ResultItem line = new ResultItem();
                line.setQuotient(tmpInt / divisor);
                remDiv = tmpInt % divisor;
                line.setModule(remDiv);
                if (remDiv != 0 && i != dividendNums.length - 1) { //1
                    tmpInt = remDiv * 10 + dividendNums[i];
                    result.addResult(line);
                    continue;
                }
                if (i < dividendNums.length -1){//2
                    tmpInt = dividendNums[++i];
                }
                continue;
            } else {
                if ( tmpInt == 0) {
                    result += tmpInt;
                    if (i < dividendNums.length){
                        tmpInt = i;
                    }
                    isContinue = false;
                    continue;
                }
                if (tmpInt < divisor){
                    tmpInt = dividendNums[i]*10 + dividendNums[++i];
                    isContinue = true;
                    continue;
                }
            }
        }

        //int divPart = (int) (dividend / (Math.pow(10,divisorLength)));
        //int divReminded = (int) ( dividend - divPart * (Math.pow(10,divisorLength)));

        System.out.println();
        return null;
    }

    private static int getLeftNumber(int i, int[] dividendNums, int divisor) {
        int result = dividendNums[i];
        if (result < divisor)
            return result;
        else
            return 0;
    }

    private static int[] getArrayOfDigits (int number) {
// from mentor to refactor later
        //        List<Integer> collect = Stream.iterate(number, i -> i / 10)
//                .map(i -> i % 10)
//                .limit((int) (Math.log10(number) + 1))
//                .collect(Collectors.toList());
//        printArray( collect.toArray());

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
        // Cycles - working case
        //        for(int i =dividentLength -1, tempNum = dividend; i  >= 0 ; i--, tempNum /= 10) {
        //            dividendNums[i] = tempNum % 10;
        ////            System.out.print(i + "->");
        //            System.out.println(dividendNums[i]);
        //        }
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

    private static void printIntArray(int[] array) {
        for ( int i=0; i < array.length ;i++) {
            System.out.println(i+" -> "+array[i]);

        }
    }
}
