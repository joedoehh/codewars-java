package com.joedoe.cwjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringIncrementer {

    public static String incrementString(String str) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);
        String stringWithoutNumber = "";
        String number = "";
        while (matcher.find()) {
            stringWithoutNumber = str.substring(0, matcher.start());
            number = str.substring(matcher.start(), matcher.end());
        }
        if (number.isEmpty())
            str += "1";
        else {
            int new_number = Integer.parseInt(number) + 1;
            str = stringWithoutNumber + paddingZeroes(new_number, number.length());
        }
        return str;
    }

    private static String paddingZeroes(int newNumber, int length) {
        StringBuilder newNumberString = new StringBuilder("" + newNumber);
        int paddingSize = length - newNumberString.length();
        newNumberString.insert(0, "0".repeat(Math.max(0, paddingSize)));
        return newNumberString.toString();
    }
}