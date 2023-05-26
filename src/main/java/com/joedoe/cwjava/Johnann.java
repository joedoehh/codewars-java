package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

/**
 * John and Ann
 * 5 kyu
 * https://www.codewars.com/kata/57591ef494aba64d14000526/train/java
 */
public class Johnann {

    private record BothSeries(List<Long> j, List<Long> a) {}

    private static BothSeries createInitialSeries() {
        List<Long> j = new ArrayList<>();
        j.add(0l);
        List<Long> a = new ArrayList<>();
        a.add(1l);
        return new BothSeries(j, a);
    }

    public static List<Long> john(long n) {
        return createKataSeries(n, createInitialSeries()).j;
    }

    public static List<Long> ann(long n) {
        return createKataSeries(n, createInitialSeries()).a;
    }

    public static long sumJohn(long n) {
        long returnValue = 0;
        for (Long next : john(n)) 
            returnValue += next;
        return returnValue;
    }

    public static long sumAnn(long n) {
        long returnValue = 0;
        for (Long next : ann(n)) 
            returnValue += next;
        return returnValue;
    }

    private static BothSeries createKataSeries(long nLimit, BothSeries bothSeries) {
        for (long n = 1; n < nLimit; n++) {
            long newJ = n - bothSeries.a.get((bothSeries.j.get((int )n - 1)).intValue());
            bothSeries.j.add(newJ);
            long newA = n - bothSeries.j.get((bothSeries.a.get((int)n - 1)).intValue());
            bothSeries.a.add(newA);
        }
        return bothSeries;
    }

}