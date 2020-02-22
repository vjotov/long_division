package com.company;

import java.util.Scanner;

public class LongDivisionApp {

    public static void main(String[] args) {
//	    int devident = getInput("divident");
//	    int divisor = getInput("divisor");
        //System.out.println(((int) Math.log10(123111) + 1));
//        Result result = Claculator.divide(devident, divisor);
        Result result = Claculator.divide(4, 2);
    }
    private static int getInput(String inputName) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the "+inputName+": ");
        return in.nextInt();
    }
}
