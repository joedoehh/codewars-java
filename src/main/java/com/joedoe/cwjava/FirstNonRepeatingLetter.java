package com.joedoe.cwjava;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingLetter {

    public static String firstNonRepeatingLetter(String s){
        return new CountMap(s).firstNonRepeating();
    }

    static class CountIndex {
        int count, index;
        String letter;

        public CountIndex(int index, String letter)
        {
            this.count = 1;
            this.index = index;
            this.letter = letter;
        }

        public void incCount() { this.count++; }
    }

    static class CountMap {
        HashMap<Character, CountIndex> countMap = new HashMap<>();

        public CountMap(String str) {
            for (int i = 0; i < str.length(); i++) {
                String value = str.substring(i, i + 1);
                Character key = value.charAt(0);
                if (value.compareTo("a") >= 0 && value.compareTo("z") <= 0)
                    key = value.toUpperCase().charAt(0);
                if (countMap.containsKey(key)) {
                    countMap.get(key).incCount();
                } else {
                    countMap.put(key, new CountIndex(i, value));
                }
            }
        }

        public String firstNonRepeating() {
            String result = "";
            int smallestIndex = Integer.MAX_VALUE;
            for (Map.Entry<Character, CountIndex> entry : countMap.entrySet()) {
                if (entry.getValue().count == 1 && entry.getValue().index < smallestIndex) {
                    result = entry.getValue().letter;
                    smallestIndex = entry.getValue().index;
                }
            }
            return result;
        }
    }

}