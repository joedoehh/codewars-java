package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class DigPow {

    /**
     * Playing with digits
     * 6 kyu
     * https://www.codewars.com/kata/5552101f47fc5178b1000050/train/java
     */
    public static long digPow(int n, int p) {
        System.out.println("n=" + n + ", p="+p);
        long pow = computePow(n, p);
        long div = pow / n;
        long remainder = pow % n;
        return remainder != 0 ? -1 : div;
    }

    static long computePow(int n, int p) {
        long returnValue = 0;
        Integer[] digits = digits(n);
        int power = p;
        for (int i = 0; i < digits.length; i++) {
            returnValue += Math.pow(digits[i], power);
            power++;
        }
        return returnValue;
    }

    static Integer[] digits(int n) {
        List<Integer> result = new ArrayList<>();
        String nAsString = "" + n;
        for (int i = 0; i < nAsString.length(); i++)
            result.add(Integer.valueOf(nAsString.substring(i, i + 1)));
        return result.toArray(new Integer[result.size()]);
    }

}
