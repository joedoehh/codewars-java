package com.joedoe.cwjava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSumTwoNegativesKataTest {  
    @Test
    public void testBasic() {
      assertEquals(8, MaxSumTwoNegativesKata.maxSum(new int[] { -1, 6, -2, 3, 5, -7 }));
      assertEquals(0, MaxSumTwoNegativesKata.maxSum(new int[] { 5, -1, -2 }));
      assertEquals(-1, MaxSumTwoNegativesKata.maxSum(new int[] { 1, -2 }));
    }
}