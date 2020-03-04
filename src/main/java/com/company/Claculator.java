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

        Stack<Integer> dividendNums = getListOfDigits(dividend);


        int reminder = 0;

        while (! dividendNums.empty()) {
            reminder = reminder * 10 + dividendNums.pop();
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
            else if(reminder == 0 || dividendNums.size() == 0) {
                result.addResult(new ResultItem(reminder));
            }

        }

        return result;
    }

    private static Stack<Integer> getListOfDigits(int number) {
          return Stream.iterate(number, i -> i/10)
                .limit(Util.getNumberLength(number))
                .map(i -> i % 10)
                .collect(Collectors.toCollection(Stack::new));
    }
}
