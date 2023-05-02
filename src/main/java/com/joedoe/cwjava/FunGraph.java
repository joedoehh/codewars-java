package com.joedoe.cwjava;

public class FunGraph {

    /**
     * ASCII fun graph
     * 6 kyu
     * https://www.codewars.com/kata/6444f6b558ed4813e8b70d43/train/java
     */
    public static String graph(int[] arr) {
        // hard coded special cases
        if (arr.length == 0)
            return "";
        if (arr.length == 1 && arr[0] == 0)
            return " ____  ^ 0";
        // draw line by line
        int maxValue = findMaxValue(arr);
        StringBuffer graph = new StringBuffer();
        for (int i = maxValue; i >= 0; i--) {
            StringBuffer nextLine = drawLine(i, i == maxValue, arr);
            if (i > 0)
                nextLine.append("\n");
            graph.append(nextLine);
        }
        System.out.println(graph);
        return graph.toString();
    }

    private static int findMaxValue(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static StringBuffer drawLine(int legendValue, boolean isFirstLine, int[] arr) {
        StringBuffer line = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            int nextValue = arr[i];
            if (legendValue > nextValue)
                line.append(drawEmpty());
            else if (legendValue == nextValue)
                line.append(drawBarTop());
            else
                line.append(drawBarBetween());
        }
        if (isFirstLine)
            line.append(drawTopLegend(legendValue));
        else
            line.append(drawLegend(legendValue));
        return line;
    }

    private static StringBuffer drawBarTop() {
        return new StringBuffer(" ____ ");
    }

    private static StringBuffer drawBarBetween() {
        return new StringBuffer("|    |");
    }

    private static StringBuffer drawEmpty() {
        return new StringBuffer("......");
    }

    private static StringBuffer drawTopLegend(int i) {
        return drawLegend(i, "^");
    }

    private static StringBuffer drawLegend(int i) {
        return drawLegend(i, "|");
    }

    private static StringBuffer drawLegend(int i, String ruler) {
        return new StringBuffer(" " + ruler + " " + i);
    }

}