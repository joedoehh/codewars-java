package com.joedoe.cwjava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Alphabet War
 * 7 kyu
 * https://www.codewars.com/kata/59377c53e66267c8f6000027/train/java
 */
class AlphabetWarKata {

    private static Map<String, Integer> LETTER_POWER_MAP;
    private static Set<String> LETTER_TEAM_LEFT_SET;
    private static Set<String> LETTER_TEAM_RIGHT_SET;

    static {
        LETTER_POWER_MAP = new HashMap<>();
        LETTER_POWER_MAP.put("w", 4);
        LETTER_POWER_MAP.put("m", 4);
        LETTER_POWER_MAP.put("p", 3);
        LETTER_POWER_MAP.put("q", 3);
        LETTER_POWER_MAP.put("b", 2);
        LETTER_POWER_MAP.put("d", 2);
        LETTER_POWER_MAP.put("s", 1);
        LETTER_POWER_MAP.put("z", 1);

        LETTER_TEAM_LEFT_SET = new HashSet<>();
        LETTER_TEAM_LEFT_SET.add("w");
        LETTER_TEAM_LEFT_SET.add("p");
        LETTER_TEAM_LEFT_SET.add("b");
        LETTER_TEAM_LEFT_SET.add("s");

        LETTER_TEAM_RIGHT_SET = new HashSet<>();
        LETTER_TEAM_RIGHT_SET.add("m");
        LETTER_TEAM_RIGHT_SET.add("q");
        LETTER_TEAM_RIGHT_SET.add("d");
        LETTER_TEAM_RIGHT_SET.add("z");
    }

    public static String alphabetWar(String fight) {
        int scoreLeft = 0, scoreRight = 0;
        for (int i = 0; i < fight.length(); i++) {
            String c = ""+fight.charAt(i);
            Integer score = LETTER_POWER_MAP.get(c);
            if (null != score) {
                if (LETTER_TEAM_LEFT_SET.contains(c))
                    scoreLeft += score;
                else if (LETTER_TEAM_RIGHT_SET.contains(c))    
                    scoreRight += score;
            }
        }
        if (scoreLeft > scoreRight)
            return "Left side wins!";
        else if (scoreRight > scoreLeft)
            return "Right side wins!";
        else
            return "Let's fight again!";
    }

}
