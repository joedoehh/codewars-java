package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FibKind
 * 5 kyu
 * https://www.codewars.com/kata/5772382d509c65de7e000982/train/java
 */
public class Fibkind {

    public static long lengthSupUK(int n, int k) {
        u(n);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (u(i) >= k) {
                count += 1;
            }
        }
        return count;
    }

    public static long comp(int n) {
        u(n);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (u(i) < u(i-1)) {
                count += 1;
            }
        }
        return count;
    }

    static Map<Integer, Integer> uCache = new HashMap<>();
    static {
        uCache.put(1, 1);
        uCache.put(2, 1);
    }

    private static int u(int n) {
        int returnValue;
        if (!uCache.containsKey(n)) {
            int u = computeU(n);
            uCache.put(n, u);
            returnValue = u;
        } else {
            returnValue = uCache.get(n);
        }
        return returnValue;
    }

    private static int computeU(int n) {
        List<Integer> series = new ArrayList<>();
        series.add(1);
        series.add(1);
        for (int i = 2; i < n; i++) {
            int index1 = i - series.get(i - 1);
            int index2 = i - series.get(i - 2);
            int newValue = series.get(index1) + series.get(index2);
            series.add(newValue);
            uCache.put(i + 1, newValue);
        }
        return series.get(n - 1);
    }
}
