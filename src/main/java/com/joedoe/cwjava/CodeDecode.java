package com.joedoe.cwjava;

/**
 * CodeDecode
 * 5 kyu
 * https://www.codewars.com/kata/56fcc393c5957c666900024d/train/java
 */
public class CodeDecode {

    public static String code(String s) {
        if (s.equals("")) {
            return "";
        }
        // determine square size and padding missing chars
        int n = squareSize(s, true);
        s += "\013".repeat(n * n - s.length());

        // square string
        char[][] square = new char[n][n];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square[i][j] = s.charAt(i * n + j);
            }
        }

        // rotate square 90 degree clockwise
        char[][] squareRotated = new char[n][n];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                squareRotated[i][j] = square[n - j - 1][i];
            }
        }

        // convert square to code string
        String coded = "";
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                coded += squareRotated[i][j];
            }
            if (i != n - 1) {
                coded += "\n";
            }
        }
        return coded;
    }

    public static String decode(String s) {
        if (s.equals("")) {
            return "";
        }

        // determine square size (remove \n)
        s = s.replaceAll("\n", "");
        int n = squareSize(s, false);

        // square string
        char[][] square = new char[n][n];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square[i][j] = s.charAt(i*n+j);
            }
        }

        // rotate square 90 degree counter-clockwise
        char[][] squareRotated = new char[n][n];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                squareRotated[i][j] = square[j][n-i-1];
            }
        }

        // convert square to decode string
        String decoded = "";
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                decoded += squareRotated[i][j];
            }
        }
        decoded = decoded.replaceAll("\013", "");
        return decoded;
    }

    private static int squareSize(String s, boolean ceil) {
        double sqrt = Math.sqrt(s.length());
        if (ceil) {
            return (int) Math.ceil(sqrt);
        } else {
            return (int) Math.floor(sqrt);
        }
    }
    
}