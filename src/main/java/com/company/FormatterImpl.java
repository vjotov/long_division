package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatterImpl implements Formatter {
    @Override
    public List<String> getPrintLines(Result result) {
        List<String> printResult = new ArrayList<String>();
        printResult.add(String.format("_%d|%d", result.getDividend(), result.getDivisor()));
        ArrayList<ResultItem> lines = result.getResultLines();
        int dividendColWidth = Util.getNumberLength(result.getDividend());
        int resultLengts = Util.getNumberLength(result.getResult());

        int offset = 0;
        for (int i = 0; i < lines.size(); i++) {
            ResultItem line = lines.get(i);

            int dividend = line.getDividend();
            int lineResult = line.getResult() * line.getDivisor();
            int dividentLen = (dividend == 0) ? 1 : Util.getNumberLength(dividend);

            if (i == 0) {
                int lineResultLen = Util.getNumberLength(lineResult);
                printResult.add(String.format("%s%d%s|%s",
                        getSpacer(" ", 1 + getCarrySpace(dividend, lineResult)),
                        lineResult,
                        getSpacer(" ", dividendColWidth - lineResultLen - getCarrySpace(dividend, lineResult)),
                        getSpacer("-", resultLengts)
                        // new line

                ));
                printResult.add(String.format(" %s%s|%s",
                        getSpacer("-", lineResultLen + getCarrySpace(dividend, lineResult)),
                        getSpacer(" ", dividendColWidth - offset - lineResultLen - getCarrySpace(dividend, lineResult)),
                        result.getResult()
                ));
            } else {
                printResult.add(String.format("%s_%d",
                        getSpacer(" ", offset),
                        dividend
                ));
                printResult.add(String.format("%s%d",
                        getSpacer(" ", offset + 1 + getCarrySpace(dividend, lineResult)),
                        lineResult
                ));
                printResult.add(String.format("%s%s",
                        getSpacer(" ", offset + 1),
                        getSpacer("-", dividentLen)
                ));
            }

            if (i == lines.size() - 1) {
                printResult.add(String.format("%s%d",
                        getSpacer(" ", offset + 1 + getCarrySpace(dividend, line.getReminder())),
                        line.getReminder()
                ));
            }

            if (line.getReminder() == 0) {
                offset += dividentLen;
            } else {
                offset += dividentLen - 1;
            }
        }
        return printResult;
    }

    private String getSpacer(String spaceChar, int quantity) {
        return Stream.generate(() -> spaceChar)
                .limit(quantity)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private int getCarrySpace(int dividend, int lineResult) {
        if (Util.getNumberLength(dividend) == Util.getNumberLength(lineResult))
            return 0;
        else
            return 1;
    }
}
