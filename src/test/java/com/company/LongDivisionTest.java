package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Method;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.*;

public class LongDivisionTest {

    @Test
    void divisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {Claculator.divide(1,0);});
    }

    @Test
    void divisionOnGreater() {
        // TODO 1/2=0 |0
    }

    @Test
    void fourOnTwo() {
        // TODO 4/2=2 |0
    }
    @Test
    void fiveOnTwo() {
        // TODO 5/2=2 | 1
    }
}
