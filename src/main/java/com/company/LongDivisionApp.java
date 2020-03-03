package com.company;

import java.util.Scanner;

public class LongDivisionApp {

    public static void main(String[] args) {
	    int devident = getInput("divident");
	    int divisor = getInput("divisor");

        Result result = Claculator.divide(devident, divisor);
//        Result resultNew = Claculator.divideNew(devident, divisor);

        FormatterFactory fFactory = new FormatterFactory();
        Formatter formmatter = fFactory.getFormatter("Normal");
        formmatter.print(result);
//        formmatter.print(resultNew);
    }
    private static int getInput(String inputName) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the "+inputName+": ");
        return in.nextInt();
    }
}
