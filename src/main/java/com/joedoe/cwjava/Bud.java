package com.joedoe.cwjava;

import java.util.HashSet;
import java.util.Set;

public class Bud {

    /**
     * Buddy Pairs
     * 5 kyu
     * https://www.codewars.com/kata/59ccf051dcc4050f7800008f/train/java
     */
    public static String buddy(long start, long limit) {
        for (long i = start; i <= limit; i++) {
            Set<Long> divisors = properDivisors(i);
            long buddy = sum(divisors)-1;
            if ((buddy > i) && isBuddyOf(i, buddy))
                return String.format("(%d %d)", i, buddy);
        }
        return "Nothing";
    }

    private static boolean isBuddyOf(long m, long n) {
        return  sum(properDivisors(n))-1 == m;
    }

    private static long sum(Set<Long> divisors) {
        long result = 0;
        for (Long x : divisors) 
            result += x;
        return result;
    }

    private static Set<Long> properDivisors(long n) {
        Set<Long> result = new HashSet<>();
        if (n != 1)
            result.add(1L);
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if ((n % i) == 0)
                result.add(i);
            if ((n % (n/i)) == 0)
                result.add(n / i);
        }
        return result;
    }

}