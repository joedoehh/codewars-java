package com.joedoe.cwjava;

import java.util.HashMap;
import java.util.Map;

public class PairOfGloves {

    /**
     * PairOfGloves
     * 6 kyu
     * https://www.codewars.com/kata/58235a167a8cb37e1a0000db/train/java
     */
    public static int numberOfPairs(String[] gloves) {
        Map<String, Integer> colorToNumber = new HashMap<>();
        for (int i = 0; i < gloves.length; i++) {
            Integer number = colorToNumber.get(gloves[i]);
            if (null == number)
                number = 0;
            number++;
            colorToNumber.put(gloves[i], number);
        }
        int pairsFound = 0;
        for (int number : colorToNumber.values())
            if (number % 2 == 0)
                pairsFound += number / 2;
            else if ((number-1) % 2 == 0)
                pairsFound += (number-1) / 2;
        return pairsFound;
    }

}