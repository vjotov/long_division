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

            String pattern1, pattern2;
            if(i==0) {
                pattern1 = " %s%d%s|%s%n";
                pattern2 = "  %s%s|%s%n";
                //right = Stream.generate(() -> "-")
                //        .limit(resultLengts)
                //        .map(Object::toString)
                //        .collect(Collectors.joining());

                

            } else if (i ==1 ) {
                //right = Integer.toString(result.getResult());
            }
            else {
                pattern1 = " %s%d%s%n";
                pattern2 = "  %s%s%n";
                //right = "";
            }
            int dividend = line.getDividend();
            int dividentLen = (int) Math.log10(dividend) +1;
            System.out.format(" %s%d%s|%s%n",
                    Stream.generate(() -> " ")
                            .limit(offset)
                            .map(Object::toString)
                            .collect(Collectors.joining()),
                    dividend,
                    Stream.generate(() -> " ")
                            .limit(dividendColWidth - offset - dividentLen)
                            .map(Object::toString)
                            .collect(Collectors.joining()),
                    );
            System.out.format(" %s%n",
                    Stream.generate(() -> "-")
                            .limit(dividentLen)
                            .map(Object::toString)
                            .collect(Collectors.joining())
                    );
        }
    }
}
