package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Formatter {
    public static void print(Result result) {
        System.out.format("_%d| %d%n",result.getDividend(),result.getDivisor());
        ArrayList<ResultItem> lines = result.getResultLines();
        int dividendColWidth = (int) Math.log10(result.getDividend()) + 1;
        int resultLengts = (int) Math.log10(result.getResult()) + 1;

        int offset = 0;
        for ( int i = 0; i < lines.size(); i++) {
            ResultItem line = lines.get(i);

            int dividend = line.getDividend();
            int reminder = line.getReminder();
            int lineResult = line.getResult()*line.getDivisor();
            int lineResultLen = (int) Math.log10(line.getReminder()) + 1;
            int dividentLen = (int) Math.log10(dividend) +1;
            if(i==0) {
                System.out.format(" %s%d%s|%s%n",
                        Stream.generate(() -> " ")
                                .limit(offset)
                                .map(Object::toString)
                                .collect(Collectors.joining()),
                        lineResult,
                        Stream.generate(() -> " ")
                                .limit(dividendColWidth - offset - dividentLen + lineResultLen)
                                .map(Object::toString)
                                .collect(Collectors.joining()),
                        Stream.generate(() -> "-")
                                .limit(resultLengts)
                                .map(Object::toString)
                                .collect(Collectors.joining())
                );
                System.out.format(" %s%s|%s%n",
                        Stream.generate(() -> "-")
                                .limit(dividentLen)
                                .map(Object::toString)
                                .collect(Collectors.joining()),
                        Stream.generate(() -> " ")
                                .limit(dividendColWidth - offset - dividentLen)
                                .map(Object::toString)
                                .collect(Collectors.joining()),
                        result.getResult()
                );
                offset += dividentLen -1;

            } else {
                System.out.format(" %s_%d%n",
                        Stream.generate(() -> " ")
                                .limit(dividendColWidth - offset - dividentLen)
                                .map(Object::toString)
                                .collect(Collectors.joining()),
                        dividend
                        );
                System.out.format(" %s %s%n",
                        Stream.generate(() -> " ")
                                .limit(dividendColWidth - offset - dividentLen)
                                .map(Object::toString)
                                .collect(Collectors.joining()),
                        Stream.generate(() -> "-")
                                .limit(dividentLen)
                                .map(Object::toString)
                                .collect(Collectors.joining())

                );
                if(i == lines.size()-1) {

                    System.out.format(" %s %d%n",
                            Stream.generate(() -> " ")
                                    .limit(dividendColWidth - offset - dividentLen + lineResultLen)
                                    .map(Object::toString)
                                    .collect(Collectors.joining()),
                            reminder
                    );
                }
            }
        }
    }
}
