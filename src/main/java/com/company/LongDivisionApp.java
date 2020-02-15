package com.company;

import java.util.Scanner;

public class LongDivisionApp {

    public static void main(String[] args) {
	    int devident = getInput("divident");
	    int divisor = getInput("divisor");

        Result result = Claculator.divide(devident, divisor);
    }
    private static int getInput(String inputName) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the "+inputName+": ");
        return in.nextInt();
    }
}
