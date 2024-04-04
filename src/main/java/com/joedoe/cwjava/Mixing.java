package com.joedoe.cwjava;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mixing {
    public static String mix(String s1, String s2) {
        if (s1.equals(s2)) {
            return "";
        }

        final Map<Character, Long> charactersFromS1 = calculateCharacterFrequency(s1);
        final Map<Character, Long> charactersFromS2 = calculateCharacterFrequency(s2);
        final List<Character> allCharacters = new ArrayList<>(charactersFromS1.keySet());

        for (char c : new ArrayList<>(charactersFromS2.keySet())) {
            if (!allCharacters.contains(c)) {
                allCharacters.add(c);
            }
        }

        List<String> result = new ArrayList<>();

        for (Character allCharacter : allCharacters) {
            final StringBuilder sb = new StringBuilder();
            final char current = allCharacter;
            final long frequency_1 = charactersFromS1.getOrDefault(current, 0L);
            final long frequency_2 = charactersFromS2.getOrDefault(current, 0L);
            final long frequency = Math.max(frequency_1, frequency_2);

            if (frequency_1 == frequency_2) {
                sb.append('=');
            } else {
                sb.append(frequency_1 > frequency_2 ? '1' : '2');
            }
            sb.append(':');

            for (int j = 0; j < frequency; j++) {
                sb.append(current);
            }

            result.add(sb.toString());
        }

        return result.stream()
                .sorted(Comparator.comparing(String::length)
                        .reversed()
                        .thenComparing(s -> s.isEmpty() ? -1 : s.charAt(0))
                        .thenComparing(Function.identity()))
                .collect(Collectors.joining("/"));
    }

    private static Map<Character, Long> calculateCharacterFrequency(String s) {
        return CharBuffer.wrap(s.toCharArray())
                .chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isAlphabetic)
                .filter(c -> Character.toUpperCase(c) != c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}