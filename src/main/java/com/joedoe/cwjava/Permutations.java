package com.joedoe.cwjava;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Permutations {

    public static List<String> singlePermutations(String s) {
        return new Permutations(s).solution();
    }

    private final String input;

    public Permutations(String input) {
        this.input = input;
    }

    public List<String> solution() {
        List<String> permutations = new LinkedList<>();
        permutation("", input, permutations);
        return permutations
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private void permutation(
            String prefix,
            String string,
            List<String> all
    ) {
        int length = string.length();
        if (length == 0) {
            all.add(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                permutation(
                        prefix + string.charAt(i),
                        string.substring(0, i) + string.substring(i + 1, length),
                        all
                );
            }
        }
    }


}
