package com.joedoe.cwjava;

public class HumanReadableTime {

    /**
     * Human readable times
     * 5 kyu
     * https://www.codewars.com/kata/52685f7382004e774f0001f7/train/java
     */
    public static String makeReadable(int seconds) {
        int s = seconds % 60;
        int h = seconds / 60;
        int m = h % 60;
        h = h / 60;
        return String.format("%s:%s:%s", toPaddedRepresentation(h), toPaddedRepresentation(m), toPaddedRepresentation(s));
    }

    private static String toPaddedRepresentation(int nr) {
        return (nr < 10) ? "0" + nr : "" + nr;
    }

}