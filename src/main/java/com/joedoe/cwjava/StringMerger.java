package com.joedoe.cwjava;

public class StringMerger {

    private final String string;
    private final String firstPart;
    private final String secondPart;

    public StringMerger(
            String string,
            String firstPart,
            String secondPart
    ) {
        this.string = string;
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    public boolean solution() {
        return isMerger(string, firstPart, secondPart);
    }

    private boolean isMerger(
            String string,
            String firstPart,
            String secondPart
    ) {
        if (string.isEmpty()) {
            return firstPart.isEmpty() && secondPart.isEmpty();
        }

        boolean isMergeFromPart1 = false;
        boolean isMergeFromPart2 = false;

        if (!firstPart.isEmpty() && string.charAt(0) == firstPart.charAt(0)) {
            isMergeFromPart1 = isMerge(
                    string.substring(1),
                    firstPart.substring(1),
                    secondPart
            );
        }
        if (!secondPart.isEmpty() && string.charAt(0) == secondPart.charAt(0)) {
            isMergeFromPart2 = isMerge(
                    string.substring(1),
                    firstPart,
                    secondPart.substring(1)
            );
        }
        return isMergeFromPart1 || isMergeFromPart2;
    }


    public static boolean isMerge(String s, String part1, String part2) {
        return new StringMerger(s, part1, part2).solution();
    }
}
