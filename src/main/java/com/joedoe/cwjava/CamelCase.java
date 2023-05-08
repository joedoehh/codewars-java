package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class CamelCase {

    /**
     * CamelCase Method
     * 6 kyu
     * https://www.codewars.com/kata/587731fda577b3d1b0001196/train/java 
     */
    public static String camelCase(String str) {
        if (null == str || str.length() == 0)
            return str;
        String[] splitBySpace = str.split(" ");    
        List<String> wordsCamelCased = new ArrayList<>();
        for (int i=0; i < splitBySpace.length; i++) {
            String nextWord = splitBySpace[i];
            if (null == nextWord || nextWord.length() == 0)
                continue;
            wordsCamelCased.add(capitalizeFirstLetter(nextWord));
        }
        return String.join("", wordsCamelCased);
    }

    static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}