package com.company;

import java.text.Format;
import java.util.Scanner;

public class LongDivisionApp {

    public static void main(String[] args) {
//	    int devident = getInput("divident");
//	    int divisor = getInput("divisor");
        //System.out.println(((int) Math.log10(123111) + 1));
//        Result result = Claculator.divide(devident, divisor);
        Result result = Claculator.divide(78945, 4);
        Formatter.print(result);
    }
    private static int getInput(String inputName) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the "+inputName+": ");
        return in.nextInt();
    }
}
