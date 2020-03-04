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
    void T3By3(){
        Result result = Claculator.divide(3,3);
        List<String> lines = formatter.getPrintLines(result);

        assertEquals(4, lines.size());
        assertEquals("_3|3",lines.get(0));
        assertEquals(" 3|-",lines.get(1));
        assertEquals(" -|1",lines.get(2));
        assertEquals(" 0",lines.get(3));
    }
    @Test
    void T34By12(){
        Result result = Claculator.divide(12345,12);
        List<String> lines = formatter.getPrintLines(result);

        assertEquals(10, lines.size());
        assertEquals("_12345|12",lines.get(0));
        assertEquals(" 12   |----",lines.get(1));
        assertEquals(" --   |1028",lines.get(2));
        assertEquals("  _34",lines.get(3));
        assertEquals("   24",lines.get(4));
        assertEquals("   --",lines.get(5));
        assertEquals("  _105",lines.get(6));
        assertEquals("    96",lines.get(7));
        assertEquals("   ---",lines.get(8));
        assertEquals("     9",lines.get(9));
    }
}
