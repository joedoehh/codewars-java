package com.joedoe.cwjava;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

public class BitCountTest {
    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("7"), BitCount.countOnes(5,7));
        assertEquals(new BigInteger("51"), BitCount.countOnes(12,29));
    }
}
