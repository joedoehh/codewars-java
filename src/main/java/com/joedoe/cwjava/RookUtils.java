package com.joedoe.cwjava;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Rook Count Attack
 * 6 kyu
 * https://www.codewars.com/kata/64416600772f2775f1de03f9/train/java
 */
public class RookUtils {

    private record Position(int i, int j) {

        public String toString() {
            return "(" + i + " , " + j + ")";
        }

    }

    private record Pair(Position a, Position b) {

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Pair))
                return false;
            Pair other = (Pair) o;
            return (a.equals(other.a) && b.equals(other.b)) || (a.equals(other.b) && b.equals(other.a));
        }

        @Override
        public int hashCode() {
            return a.hashCode() + b.hashCode();
        }

        public String toString() {
            return "<" + a + " - " + b + ">";
        }

    }

    public static int countAttackingRooks(int[][] rooks) {
        Set<Pair> attackPairs = new HashSet<>();
        boolean[][] board = computeBoard(rooks);
        for (int i = 0; i < rooks.length; i++) {
            Position pos = new Position(rooks[i][0], rooks[i][1]);
            attackPairs.addAll(computeAttacked(pos, board));
        }
        return attackPairs.size();
    }

    private static boolean[][] computeBoard(int[][] rooks) {
        // create empty board
        boolean[][] board = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = false;
            }
        }
        // populate with rooks
        for (int i = 0; i < rooks.length; i++) {
            board[rooks[i][0]][rooks[i][1]] = true;
        }
        return board;
    }

    private static Collection<Pair> computeAttacked(Position pos, boolean[][] board) {
        Set<Pair> result = new HashSet<>();
        // look up
        if (pos.i > 0) {
            for (int i = pos.i - 1; i >= 0; i--) {
                boolean discoveredAttack = checkAndAdd(pos, new Position(i, pos.j), board, result);
                if (discoveredAttack)
                    break;
            }
        }
        // look down
        if (pos.i < 7) {
            for (int i = pos.i + 1; i < 8; i++) {
                boolean discoveredAttack = checkAndAdd(pos, new Position(i, pos.j), board, result);
                if (discoveredAttack)
                    break;
            }
        }
        // look left
        if (pos.j > 0) {
            for (int j = pos.j - 1; j >= 0; j--) {
                boolean discoveredAttack = checkAndAdd(pos, new Position(pos.i, j), board, result);
                if (discoveredAttack)
                    break;
            }
        }
        // look right
        if (pos.j < 7) {
            for (int j = pos.j + 1; j < 8; j++) {
                boolean discoveredAttack = checkAndAdd(pos, new Position(pos.i, j), board, result);
                if (discoveredAttack)
                    break;
            }
        }
        return result;
    }

    private static boolean checkAndAdd(Position pos, Position posToCheck, boolean[][] board, Set<Pair> result) {
        if (board[posToCheck.i][posToCheck.j]) {
            result.add(new Pair(pos, posToCheck));
            return true;
        }
        return false;
    }

}