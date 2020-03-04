package com.company;

import java.util.List;
import java.util.Scanner;

public class LongDivisionApp {

    public static void main(String[] args) {
	    int devident = getInput("divident");
	    int divisor = getInput("divisor");

        Result result = Claculator.divide(devident, divisor);

        FormatterFactory fFactory = new FormatterFactory();
        Formatter formmatter = fFactory.getFormatter("Normal");
        List<String> lines = formmatter.getPrintLines(result);

        lines.stream().forEach(s -> System.out.print(s));
    }
    private static int getInput(String inputName) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the "+inputName+": ");
        return in.nextInt();
    }
}
