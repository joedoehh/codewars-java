package com.joedoe.cwjava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BudTest {

    private static void testing(long start, long limit, String expected) {
        System.out.println("start: " + start);
        System.out.println("limit: " + limit);
        String actual = Bud.buddy(start, limit);
        System.out.println("Expect: " + expected);
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        testing(48, 100, "(48 75)");
        testing(381, 4318, "(1050 1925)");
        testing(2382, 3679, "Nothing");
        testing(1071625, 1103735, "(1081184 1331967)");
    }
}