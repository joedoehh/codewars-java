package com.joedoe.cwjava;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StringIncrementerTest {

    private static void doTest(String str, String expected) {
        String actual = assertDoesNotThrow(() -> StringIncrementer.incrementString(str), "Solution thrown an unexpected exception for str=\"" + str + "\"\n\n");
        assertEquals(expected, actual, "Incorrect answer for str=\"" + str + "\"\n\n");
    }

    @Test
    public void exampleTests() {
        doTest("foobar000", "foobar001");
        doTest("foo", "foo1");
        doTest("foobar001", "foobar002");
        doTest("foobar99", "foobar100");
        doTest("foobar099", "foobar100");
        doTest("", "1");
    }

    @Test
    public void exampleTestsPlus1() {
        doTest("foo", "foo1");
        doTest("", "1");
    }

    @Test
    public void randomTest() {
        doTest("6325656661175895", "6325656661175896");
        doTest("0000000000000000000006325656661175895", "0000000000000000000006325656661175896");
    }


}