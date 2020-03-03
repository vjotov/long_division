package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Claculator {
    public static Result divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        Result result = new Result(dividend, divisor);
        dividend = result.getDividend();
        divisor = result.getDivisor();

        if (dividend < divisor) {
            ResultItem line = new ResultItem(0,divisor,0,dividend);
            result.addResult(line);
            return result;
        }

        List<Integer> dividendNums = getListOfDigits(dividend);


        int reminder = 0;

        for (int i = 0; i < dividendNums.size(); i++) {
            reminder = reminder * 10 + dividendNums.get(i);
            if (reminder >= divisor) {
                int nextReminder = reminder % divisor;
                ResultItem line = new ResultItem(
                        reminder,
                        divisor,
                        reminder / divisor,
                        nextReminder
                );
                result.addResult(line);
                reminder = nextReminder;
            }
            else if(reminder == 0 || i == dividendNums.size() - 1) {
                result.addResult(new ResultItem(reminder));
            }

        }

        return result;
    }

    private static List<Integer> getListOfDigits(int number) {
        int numberLength = Util.getNumberLength(number);
        List<Integer> result = new LinkedList<Integer>();
        AtomicInteger tempNum = new AtomicInteger(number);

        result = Stream.generate(() -> "")
                .limit(numberLength)
                .map((m) -> {
                    Integer tt = tempNum.get();
                    tempNum.set(tt / 10);
                    return tt % 10;
                }).collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }
}
