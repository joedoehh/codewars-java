package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class ToSmallest {

    /**
     * Find the smallest.
     * 5 kyu
     * https://www.codewars.com/kata/573992c724fc289553000e95/train/java
     */
    public static long[] smallest(long n) {
        long smallest = n;
        long fromIndexSmallest = 0;
        long toIndexSmallest = 0;
        Long[] digits = digits(n);
        for (int fromIndex = 0; fromIndex < digits.length; fromIndex++)
            for (int toIndex = 0; toIndex < digits.length; toIndex++) {
                if (fromIndex == toIndex)
                    continue;
                long permutated = shuffle(digits, fromIndex, toIndex);
                if (permutated < smallest) {
                    smallest = permutated;
                    fromIndexSmallest = fromIndex;
                    toIndexSmallest = toIndex;
                }
            }
        return new long[] { smallest, fromIndexSmallest, toIndexSmallest };
    }

    private static long shuffle(Long[] digits, int from, int to) {
        String string = "";
        Long tmp = digits[from];
        int toIndex=0;
        int fromIndex = 0;
        while (toIndex < digits.length) {
            if (fromIndex == from)
                fromIndex++;
            if (toIndex == to) {
                string += "" + tmp;
                fromIndex--;
            }
            else        
                string += "" + digits[fromIndex];
            toIndex++;
            fromIndex++;
        }
        return Long.valueOf(string);
    }

    private static Long[] digits(long n) {
        List<Long> result = new ArrayList<>();
        String nAsString = "" + n;
        for (int i = 0; i < nAsString.length(); i++)
            result.add(Long.valueOf(nAsString.substring(i, i + 1)));
        return result.toArray(new Long[result.size()]);
    }

}