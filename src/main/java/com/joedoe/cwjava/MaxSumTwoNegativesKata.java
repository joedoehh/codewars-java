package com.joedoe.cwjava;

/**
 * Max sum between two negatives
 * 7 kyu
 * https://www.codewars.com/kata/6066ae080168ff0032c4107a/train/java
 */
class MaxSumTwoNegativesKata {

    public static int maxSum(int[] arr) {
        int maxSum = -1;
        int currentSum = 0;
        boolean sumUp = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                sumUp = !sumUp;
                if (!sumUp) {
                    if (currentSum > maxSum)
                        maxSum = currentSum;
                    currentSum = 0;
                    sumUp = true;
                }
            } else if (sumUp)
                currentSum += arr[i];

        }
        return maxSum;
    }

}
