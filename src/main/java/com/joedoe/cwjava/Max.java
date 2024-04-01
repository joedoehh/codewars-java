package com.joedoe.cwjava;

public class Max {
    // Kadane’s Algorithm: dynamic programming approach
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        if (maxSoFar == -1)
            return 0;
        else
            return maxSoFar;
    }
}
