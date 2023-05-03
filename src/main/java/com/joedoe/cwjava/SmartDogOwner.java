package com.joedoe.cwjava;

public class SmartDogOwner {

    /**
     * Decode the woofs!
     * 6 kyu
     * https://www.codewars.com/kata/63fb421be6be1f57ad81809e/train/java
     */
    public static String woofDecoder(String str) {
        StringBuffer decoded = new StringBuffer();
        int nrOfWoofs = 0;
        for (String substring : str.split("!")) {
            nrOfWoofs = decode(substring.trim(), decoded);
        }
        if (decoded.length() == 0)
            decoded.append("nothing to decode!");
        else if (nrOfWoofs > 26)
            decoded = new StringBuffer("just barking!");
        return decoded.toString().toLowerCase();
    }

    private static int decode(String sequence, StringBuffer decoded) {
        String seqNormalized = sequence.toLowerCase().replaceAll("[^woof-]", "").toString();
        int nrWoofs = 0;
        for (String substring : seqNormalized.split("-")) {
            if (substring.matches(".*[w].*[o].*[o].*[f].*")) 
                nrWoofs++;
        }
        if (nrWoofs == 0)
            decoded.append("");
        else if (nrWoofs >= 1 && nrWoofs <=26)
            decoded.append(decode(nrWoofs));
        else {
            decoded.append("?"+nrWoofs);
        }    
        return nrWoofs;    
    }

    private static char decode(int countTokens) {
        return (char) (64 + countTokens);
    }

}