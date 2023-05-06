package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 */
public class DHondt {

    public record TieBreak(int index, int divisor, int leftMost) {}
 
    /**
     * D'Hondt method
     * 6 kyu
     * https://www.codewars.com/kata/63ee1d8892cff420d2c869af/train/java
     */
    public static int[] distributeSeats(int numSeats, int[] votes) {
        int[] distribution = new int[votes.length];
        int[] nextIndex = new int[votes.length];
        for (int i = 0; i < votes.length; i++) {
            distribution[i] = 0;
            nextIndex[i] = 0;
        }
        int[][] template = distributionTemplate(numSeats, votes);
        for (int i=0; i < numSeats; i++) {
            int max = Integer.MIN_VALUE;
            int foundIndex = 0;
            List<TieBreak> tieBreaks = new ArrayList<>();
            for (int j=0; j < votes.length; j++) {
                TieBreak tb = new TieBreak(j, nextIndex[j], template[j][0]);
                if (template[j][nextIndex[j]] > max) {
                    max = template[j][nextIndex[j]];
                    foundIndex = j;
                    tieBreaks = new ArrayList<>();
                    tieBreaks.add(tb);
                } else if (template[j][nextIndex[j]] == max) {
                    tieBreaks.add(tb);
                }
            }    
            if (tieBreaks.size() > 1) {
                List<TieBreak> tieBreaksSecond = new ArrayList<>();
                int minorDivisor = Integer.MAX_VALUE;
                for (TieBreak tb : tieBreaks) {
                    if (tb.divisor < minorDivisor) {
                        minorDivisor = tb.divisor;
                        foundIndex = tb.index;
                        tieBreaksSecond = new ArrayList<>();
                        tieBreaksSecond.add(tb);
                    } else if (tb.divisor == minorDivisor) {
                        tieBreaksSecond.add(tb);
                    }       
                }
                if (tieBreaksSecond.size() > 1) {
                    int maxLeftmost = Integer.MIN_VALUE;
                    for (TieBreak tb : tieBreaksSecond) {
                        if (tb.leftMost > maxLeftmost) {
                            maxLeftmost = tb.leftMost;
                            foundIndex = tb.index;
                        }       
                    }
                }    
            }
            distribution[foundIndex]++;
            nextIndex[foundIndex]++;    
        }
        return distribution;
    }

    public static int[][] distributionTemplate(int numSeats, int[] votes)  {
        int[][] template = new int[votes.length][numSeats];
        for (int i = 0; i < votes.length; i++) 
            for (int j = 1; j < numSeats+1; j++) 
                template[i][j-1] = votes[i] / j;
        return template;
    }

}
