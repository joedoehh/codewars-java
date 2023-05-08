package com.joedoe.cwjava;

public class ConsecutiveRepetition {

    /**
     * Character with longest consecutive repetition
     * 6 kyu
     * https://www.codewars.com/kata/586d6cefbcc21eed7a001155/train/java
     */    
    public static Object[] longestRepetition(String s) {
        if (s == null || s.length() == 0)
            return new Object[]{"", 0};
        int currentLength = 1;
        char currentChar = s.charAt(0);
        int maxLength = 0;
        char maxChar = currentChar;
        for (int i=1; i < s.length(); i++) 
            if (currentChar == s.charAt(i))
                currentLength++;
            else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxChar = currentChar;
                }
                currentChar = s.charAt(i);
                currentLength = 1;
            } 
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxChar = currentChar;
        }               
        return new Object[]{""+maxChar, maxLength}; 
    }

}
