package com.joedoe.cwjava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuValidator {

    private record Field(int x, int y) {
    }

    private static Map<Integer, Set<Field>> blocks;

    static {
        blocks = new HashMap<>();
        // ------------- 0 1 2
        Set<Field> block = new HashSet<>();
        block.add(new Field(0, 0));
        block.add(new Field(0, 1));
        block.add(new Field(0, 2));
        block.add(new Field(1, 0));
        block.add(new Field(1, 1));
        block.add(new Field(1, 2));
        block.add(new Field(2, 0));
        block.add(new Field(2, 1));
        block.add(new Field(2, 2));
        blocks.put(0, block);
        block = new HashSet<>();
        block.add(new Field(0, 3));
        block.add(new Field(0, 4));
        block.add(new Field(0, 5));
        block.add(new Field(1, 3));
        block.add(new Field(1, 4));
        block.add(new Field(1, 5));
        block.add(new Field(2, 3));
        block.add(new Field(2, 4));
        block.add(new Field(2, 5));
        blocks.put(1, block);
        block = new HashSet<>();
        block.add(new Field(0, 6));
        block.add(new Field(0, 7));
        block.add(new Field(0, 8));
        block.add(new Field(1, 6));
        block.add(new Field(1, 7));
        block.add(new Field(1, 8));
        block.add(new Field(2, 6));
        block.add(new Field(2, 7));
        block.add(new Field(2, 8));
        blocks.put(2, block);

        // ------------- 3 4 5
        block = new HashSet<>();
        block.add(new Field(3, 0));
        block.add(new Field(3, 1));
        block.add(new Field(3, 2));
        block.add(new Field(4, 0));
        block.add(new Field(4, 1));
        block.add(new Field(4, 2));
        block.add(new Field(5, 0));
        block.add(new Field(5, 1));
        block.add(new Field(5, 2));
        blocks.put(3, block);
        block = new HashSet<>();
        block.add(new Field(3, 3));
        block.add(new Field(3, 4));
        block.add(new Field(3, 5));
        block.add(new Field(4, 3));
        block.add(new Field(4, 4));
        block.add(new Field(4, 5));
        block.add(new Field(5, 3));
        block.add(new Field(5, 4));
        block.add(new Field(5, 5));
        blocks.put(4, block);
        block = new HashSet<>();
        block.add(new Field(3, 6));
        block.add(new Field(3, 7));
        block.add(new Field(3, 8));
        block.add(new Field(4, 6));
        block.add(new Field(4, 7));
        block.add(new Field(4, 8));
        block.add(new Field(5, 6));
        block.add(new Field(5, 7));
        block.add(new Field(5, 8));
        blocks.put(5, block);

        // ------------- 6 7 8
        block = new HashSet<>();
        block.add(new Field(6, 0));
        block.add(new Field(6, 1));
        block.add(new Field(6, 2));
        block.add(new Field(7, 0));
        block.add(new Field(7, 1));
        block.add(new Field(7, 2));
        block.add(new Field(8, 0));
        block.add(new Field(8, 1));
        block.add(new Field(8, 2));
        blocks.put(6, block);
        block = new HashSet<>();
        block.add(new Field(6, 3));
        block.add(new Field(6, 4));
        block.add(new Field(6, 5));
        block.add(new Field(7, 3));
        block.add(new Field(7, 4));
        block.add(new Field(7, 5));
        block.add(new Field(8, 3));
        block.add(new Field(8, 4));
        block.add(new Field(8, 5));
        blocks.put(7, block);
        block = new HashSet<>();
        block.add(new Field(6, 6));
        block.add(new Field(6, 7));
        block.add(new Field(6, 8));
        block.add(new Field(7, 6));
        block.add(new Field(7, 7));
        block.add(new Field(7, 8));
        block.add(new Field(8, 6));
        block.add(new Field(8, 7));
        block.add(new Field(8, 8));
        blocks.put(8, block);
    }

    /**
     * Sudoku Validator
     * 6 kyu
     * https://www.codewars.com/kata/63d1bac72de941033dbf87ae/train/java
     */
    public static boolean validate(int[][] board) {
        if (!rowsValid(board))
            return false;
        if (!columnsValid(board))
            return false;
        if (!blocksValid(board))
            return false;
        return true;
    }

    private static boolean columnsValid(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Integer> columnElements = new HashSet<>();
            for (int j = 0; j < board.length; j++)
                columnElements.add(board[i][j]);
            if (!complete(columnElements))
                return false;
        }
        return true;
    }

    private static boolean rowsValid(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Integer> rowElements = new HashSet<>();
            for (int j = 0; j < board.length; j++)
                rowElements.add(board[j][i]);
            if (!complete(rowElements))
                return false;
        }
        return true;
    }

    private static boolean blocksValid(int[][] board) {
        for (Integer blockIndex : blocks.keySet()) {
            Set<Integer> blockElements = new HashSet<>();
            for (Field field : blocks.get(blockIndex))
                blockElements.add(board[field.x][field.y]);
            if (!complete(blockElements))
                return false;
        }
        return true;
    }

    private static boolean complete(Set<Integer> elements) {
        if (elements.size() != 9) 
            return false;
        for (int i = 1; i <= 9; i++)
            if (!elements.contains(i))
                return false;    
        return true;
    }

}