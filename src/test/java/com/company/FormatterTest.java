package com.company;

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
    void T3By3() {
        Result result = Claculator.divide(3, 3);

        assertEquals("_3|3\n" +
                " 3|-\n" +
                " -|1\n" +
                " 0", formatter.format(result));
    }

    @Test
    void T34By12() {
        Result result = Claculator.divide(12345, 12);

        assertEquals("_12345|12\n" +
                " 12   |----\n" +
                " --   |1028\n" +
                "  _34\n" +
                "   24\n" +
                "   --\n" +
                "  _105\n" +
                "    96\n" +
                "   ---\n" +
                "     9", formatter.format(result));
    }

    @Test
    void T505By5() {
        Result result = Claculator.divide(505, 5);

        assertEquals("_505|5\n" +
                " 5  |---\n" +
                " -  |101\n" +
                " _05\n" +
                "   5\n" +
                "  --\n" +
                "   0", formatter.format(result));
    }

    @Test
    void T11332By3() {
        Result result = Claculator.divide(11332, 3);

        assertEquals("_11332|3\n" +
                "  9   |----\n" +
                " --   |3777\n" +
                " _23\n" +
                "  21\n" +
                "  --\n" +
                "  _23\n" +
                "   21\n" +
                "   --\n" +
                "   _22\n" +
                "    21\n" +
                "    --\n" +
                "     1", formatter.format(result));

    }
}
