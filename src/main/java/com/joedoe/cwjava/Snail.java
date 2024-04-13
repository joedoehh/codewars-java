package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class Snail {

    public static int[] snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        while (array.length != 0) {
            for (int next : array[0]) result.add(next);
            array = transposeAndRotate(array);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[][] transposeAndRotate(int[][] matrix) {
        // termination: empty matrix does not get handled
        if (matrix.length == 1) return new int[0][0];
        // zip and transpose matrix
        int m = matrix.length-1;
        int n = matrix[0].length;
        int[][] zipped = new int[n][m];
        for (int i=0; i < n; i++)
            for (int j=1; j <= m; j++)
               zipped[i][j-1] = matrix[j][i];
        // return reverted matrix
        return revert(zipped);
    }

    private static int[][] revert(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] reverted = new int[m][n];
        for (int i=0; i < m; i++)
            for (int j=0; j < n; j++)
                reverted[i][j] = matrix[m-i-1][j];
        return reverted;
    }

}