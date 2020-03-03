package com.company;

public class Util {
    public static int getNumberLength(int number) {
        if(number == 0)
            return 1;
        else
            return (int) Math.log10(number) + 1;
    }
}
