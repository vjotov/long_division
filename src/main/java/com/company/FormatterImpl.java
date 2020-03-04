package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatterImpl implements Formatter {
    private int leadingZeros = 0;
    @Override
    public String format(Result result) {
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
                if (dividend == 0) {
                    this.leadingZeros++;
                    offset++;
                    continue;
                }
                printResult.add(String.format("%s_%s%d",
                        getSpacer(" ", offset - this.leadingZeros),
                        getSpacer("0", leadingZeros),
                        dividend
                ));
                printResult.add(String.format("%s%d",
                        getSpacer(" ", offset + 1 + getCarrySpace(dividend, lineResult)),
                        lineResult
                ));
                printResult.add(String.format("%s%s",
                        getSpacer(" ", offset + 1 - this.leadingZeros),
                        getSpacer("-", dividentLen + this.leadingZeros)
                ));
                resetLeadingZeros();
            }

            int reminderLength = Util.getNumberLength(line.getReminder());
            if (isLast(lines, i)) {

                printResult.add(String.format("%s%d",
                        getSpacer(" ", offset +
                                getDividentSpace(dividentLen, reminderLength) +
                                getCarrySpace(dividend, reminderLength)),
                        line.getReminder()
                ));
            } else {
                if (line.getReminder() == 0) {
                    offset += dividentLen;
                } else if (reminderLength != dividentLen) {
                    offset += dividentLen - 1;
                }
            }
        }
//        printResult.stream().forEach(s )
        return "";
    }

    private void resetLeadingZeros() {
        leadingZeros = 0;
    }

    private int getDividentSpace(int dividentLength, int reminderLength) {
        if (dividentLength - reminderLength == 0)
            return 1;
        else
            return dividentLength - reminderLength;
    }

    private boolean isLast(ArrayList<ResultItem> lines, int i) {
        return i == lines.size() - 1;
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
