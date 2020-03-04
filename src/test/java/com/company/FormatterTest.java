package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    private Formatter formatter;
    @BeforeEach
    void prepareFormatter() {
        FormatterFactory fFactory = new FormatterFactory();
        this.formatter = fFactory.getFormatter("Normal");
    }
    @Test
    void threeBythree(){
        Result result = Claculator.divide(3,3);
        List<String> lines = formatter.getPrintLines(result);

        assertEquals(4, lines.size());
        assertEquals("_3|3",lines.get(0));
        assertEquals(" 3|-",lines.get(1));
        assertEquals(" -|1",lines.get(2));
        assertEquals(" 0",lines.get(3));

    }
}
