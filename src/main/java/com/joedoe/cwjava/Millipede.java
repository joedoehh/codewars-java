package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class Millipede {

    /**
     * Millipede of words
     * 6 kyu
     * https://www.codewars.com/kata/6344701cd748a12b99c0dbc4/train/java
     */
    public static boolean check(String[] words) {
        return millipede("", words, 0, words.length);
    }

    private static boolean millipede(String sentence, String[] words, int wordsUsed, int totalNrOfWords) {
        boolean result;
        if (words.length == 0 && wordsUsed == totalNrOfWords) {
            return true;
        }
        for (String word : words) {
            if (fits(sentence, word)) {
                result = millipede(sentence+" "+word, dropFirstOccurence(word, words), wordsUsed+1, totalNrOfWords);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String[] dropFirstOccurence(String word, String[] words) {
        List<String> result = new ArrayList<>();
        boolean droppingMode = true;
        for (String nextWord : words) {
            if (word.equals(nextWord)) 
                if (droppingMode) 
                    droppingMode = false;
                else 
                    result.add(nextWord);
            else 
                result.add(nextWord);
        }
        return result.toArray(new String[result.size()]);
    }

    private static boolean fits(String sentence, String word) {
        if (sentence.equals(""))
            return true;
        return sentence.charAt(sentence.length() - 1) == word.charAt(0);
    }

}