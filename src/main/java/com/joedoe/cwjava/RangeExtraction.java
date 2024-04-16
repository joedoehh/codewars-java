package com.joedoe.cwjava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        if (null == arr || arr.length == 0) return "";
        if (arr.length == 1) return ""+arr[0];
        Arrays.sort(arr);
        Set<Integer> targetSet = new HashSet<Integer>();
        for (int i : arr) targetSet.add(i);
        return convertToRangeExpression(targetSet, arr[0], arr[arr.length-1]);
    }

    private static String convertToRangeExpression(Set<Integer> values, int min, int max) {
        StringBuffer result = new StringBuffer();
        StringBuffer nextRange = new StringBuffer();
        boolean spansTwo = false;
        boolean spansThree = false;
        for (int i=min; i <= max; i++) {
            // next range ends
            if (!values.contains(i) && nextRange.length() != 0) {
                if (spansThree) {
                    nextRange.append("-");
                    nextRange.append(i-1);
                } else if (spansTwo) {
                    nextRange.append(",");
                    nextRange.append(i-1);
                }
                result.append(nextRange);
                if (i != max)
                    result.append(",");
                nextRange = new StringBuffer();
                spansTwo = false;
                spansThree = false;
            } else if (values.contains(i)) {
                // range is open
                if (nextRange.length() == 0)
                    nextRange.append(i);
                else if (nextRange.length() > 0 && !spansTwo)
                    spansTwo = true;
                else if (nextRange.length() > 0 && !spansThree)
                    spansThree = true;
            }
        }
        // close last range
        if (nextRange.length() != 0) {
            if (spansThree) {
                nextRange.append("-");
                nextRange.append(max);
            } else if (spansTwo) {
                nextRange.append(",");
                nextRange.append(max);
            }
            result.append(nextRange);
        }
        return result.toString();
    }
}
