package com.company;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.*;

public class LongDivisionTest {
    @Test
    void numberLength() {
        assertEquals(2, Util.getNumberLength(10));
        assertEquals(1, Util.getNumberLength(1));
        assertEquals(1, Util.getNumberLength(0));
        assertEquals(1, Util.getNumberLength(-5));
        assertEquals(5, Util.getNumberLength(12345));
    }

    @Test
    void divisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Claculator.divide(1,0);});
    }

//    @Test
//    void hundertByOne() {
//        Result result = Claculator.divide(132,2);
//    }
////    @Test
//    void divisionOnGreater() {
//        Result result = Claculator.divide(1,2);
//        assertTrue(result.isPositiveResult());
//        ResultItem line = result.getLastResult();
//        assertEquals(new ResultItem(0,1,2,0,0),line);
//    }
//
////    @Test
//    void fourOnTwo() {
//        Result result = Claculator.divide(4,2);
//        assertTrue(result.isPositiveResult());
//        ResultItem line = result.getLastResult();
//        assertEquals(new ResultItem(0,4,2,2,0),line);
//    }
////    @Test
//    void twoOnTwo() {
//        Result result = Claculator.divide(-2,-2);
//        assertTrue(result.isPositiveResult());
//        ResultItem line = result.getLastResult();
//        assertEquals(new ResultItem(0,2,2,1,0),line);
//    }
////    @Test
//    void fiveOnTwo() {
//        Result result = Claculator.divide(-5,2);
//        assertTrue(!result.isPositiveResult());
//        ResultItem line = result.getLastResult();
//        assertEquals(new ResultItem(0,5,2,2,1),line);
//    }
//
//    //@Test
//    void n210On3() {
//        Result result = Claculator.divide(210,3);
//        assertTrue(result.isPositiveResult());
//        ArrayList<ResultItem> results = result.getResultLines();
//        assertEquals(2, results.size());
//        ResultItem line = results.get(0);
//        assertEquals(0,line.getOffset());
//        assertEquals(210,line.getDividend());
//        assertEquals(3,line.getDivisor());
//        assertEquals(70,line.getQuotient());
//        assertEquals(0,line.getReminder());
//        line = results.get(1);
//        assertEquals(2,line.getOffset());
//        assertEquals(0,line.getDividend());
//        assertEquals(3,line.getDivisor());
//        assertEquals(0,line.getQuotient());
//        assertEquals(0,line.getReminder());
//    }
//

}
