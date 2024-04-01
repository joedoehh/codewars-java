package com.joedoe.cwjava;

import java.util.Arrays;

public class Dinglemouse {

    public static int[] sort(final int array[]) {
        return new Dinglemouse(array).solution();
    }

    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private final int[] input;

    public Dinglemouse(int[] input) {
        this.input = input;
    }

    public int[] solution() {
        return Arrays.stream(input).mapToObj(value -> new Value(value == 0 ? "zero" : convert(value), value)).sorted().toList().stream().mapToInt(v -> v.number).toArray();
    }

    private String convert(final int n) {
        if (n < 20) {
            return UNITS[n];
        }
        if (n < 100) {
            return TENS[n / 10] + UNITS[n % 10];
        }
        return UNITS[n / 100] + " hundred" + ((n % 100 != 0) ? " and " : "") + convert(n % 100);
    }

    private record Value(String string, int number) implements Comparable<Value> {

        @Override
        public int compareTo(Value o) {
            return this.string.compareTo(o.string);
        }

    }
}
