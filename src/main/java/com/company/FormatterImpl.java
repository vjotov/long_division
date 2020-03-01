package com.company;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatterImpl implements Formatter {
    @Override
    public void print(Result result) {
        System.out.format("_%d| %d%n",result.getDividend(),result.getDivisor());
        ArrayList<ResultItem> lines = result.getResultLines();
        int dividendColWidth = (int) Math.log10(result.getDividend()) + 1;
        int resultLengts = (int) Math.log10(result.getResult()) + 1;

        int offset = 0;
        for ( int i = 0; i < lines.size(); i++) {
            ResultItem line = lines.get(i);

            int dividend = line.getDividend();
            int lineResult = line.getResult()*line.getDivisor();
            int dividentLen = (int) Math.log10(dividend) +1;
            if(i==0) {
                int lineResultLen = (int) Math.log10(lineResult) + 1;
                System.out.format(" %d%s|%s%n %s%s|%s%n",
                        lineResult,
                        getSpacer(" ", dividendColWidth - lineResultLen),
                        getSpacer("-", resultLengts),
                        // new line
                        getSpacer("-", lineResultLen),
                        getSpacer(" ", dividendColWidth - offset - lineResultLen),
                        result.getResult()
                );
            } else {
                System.out.format("%s_%d%n%s%d%n%s%s%n",
                        getSpacer(" ", offset),
                        dividend,
                        // new line
                        getSpacer(" ", offset + 1),
                        lineResult,
                        // new line
                        getSpacer(" ", offset + 1),
                        getSpacer("-", dividentLen)
                );

            }

            if(i == lines.size()-1) {
                System.out.format("%s%d%n",
                        getSpacer(" ", offset + 1),
                        line.getReminder()
                );
            }

            if (line.getReminder() == 0) {
                offset += dividentLen;
            } else {
                offset += dividentLen - 1;
            }
        }
    }
    private String getSpacer(String spaceChar, int quantity) {
        return Stream.generate(() -> spaceChar)
                .limit(quantity)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
