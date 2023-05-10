package com.joedoe.cwjava;

public class RgbToHex {

    /**
     * RGB To Hex Conversion
     * 5 kyu
     * https://www.codewars.com/kata/513e08acc600c94f01000001/train/java
     */
    public static String rgb(int r, int g, int b) {
        return rgb(r) + rgb(g) + rgb(b);
    }

    private static String rgb(int value) {
        if (value <= 0)
            return "00";
        else if (value >= 255)
            return "FF";
        else {
            String hex = Integer.toHexString(value).toUpperCase();
            return (hex.length() == 1) ? "0" + hex : hex;
        }
    }

}
