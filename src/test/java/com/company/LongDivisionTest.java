package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Method;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.*;

public class LongDivisionTest {

    @Test
    void divisionByZero() {
        assertThrows(ArithmeticException.class, () -> {Claculator.divide(1,0);});
    }
}
