package com.joedoe.cwjava;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ProdFibTest {

    @Test
    public void test0() {
        long[] r = new long[] { 1, 1, 1 };
        assertArrayEquals(r, ProdFib.productFib(1));
    }

    @Test
    public void test1() {
        long[] r = new long[] { 55, 89, 1 };
        assertArrayEquals(r, ProdFib.productFib(4895));
    }

    @Test
    public void test2() {
        long[] r = new long[] { 89, 144, 0 };
        assertArrayEquals(r, ProdFib.productFib(5895));
    }
}