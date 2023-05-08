package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class MexicanWave {

    /**
     * Mexican Wave
     * 6 kyu
     * https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/java
     */
    public static String[] wave(String str) {
        List<String> waveList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                continue;
            waveList.add(standUp(str, i));    
        }
        return waveList.toArray(new String[waveList.size()]);
    }
    
    static String standUp(String word, int index) {
        return word.substring(0, index) + word.substring(index, index+1).toUpperCase() + word.substring(index+1);
    }
    
}