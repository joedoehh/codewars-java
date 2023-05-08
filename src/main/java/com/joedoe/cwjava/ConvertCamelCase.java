package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class ConvertCamelCase {

    /**
     * Convert string to camel case
     * 6 kyu
     * https://www.codewars.com/kata/517abf86da9663f1d2000003/train/java
     */
    static String toCamelCase(String s) {
        List<String> wordsUpper = new ArrayList<>();
        String[] words = s.split("[_]|[-]");
        for (int i=0; i < words.length; i++) {
            String word = words[i];
            if (i == 0)
                wordsUpper.add(word);
            else
                wordsUpper.add(capitalizeFirstLetter(word));
        }
        return String.join("", wordsUpper);
    }

    static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}