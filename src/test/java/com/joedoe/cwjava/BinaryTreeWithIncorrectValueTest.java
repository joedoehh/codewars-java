package com.joedoe.cwjava;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BinaryTreeWithIncorrectValueTest {

  @Test
  public void testTreeWith3Levels() {
    
      final int[][] expected = {{0,27}, {1,13}, {2,14}, {6,7}, {2,3}};
    
      final int[][] input = new int[5][];
      input[0] = new int[] {28, 13, 14, 6, 7, 5, 9};
      input[1] = new int[] {27, 14, 14, 6, 7, 5, 9};
      input[2] = new int[] {27, 13, 15, 6, 7, 5, 9};
      input[3] = new int[] {29, 13, 16, 5, 8, 9, 1};
      input[4] = new int[] {5, 2, 2, 1, 1, 2, 1};
    
      final int[][] actual = new int[5][];
      for (int test = 0; test < input.length; test++) {
        actual[test] = BinaryTreeWithIncorrectValue.findIncorrectNumber(input[test]);
        assertArrayEquals("not as expected for 3 level test " + test, expected[test], actual[test]);
      } 
  }

  @Test
  public void testTreeWith4Levels() {
    
      final int[][] expected = {{0,19}, {2,10}, {3,4}, {8,1}};
    
      final int[][] input = new int[4][];
      input[0] = new int[] {21, 9, 10, 4, 5, 4, 6, 2, 2, 1, 4, 1, 3, 2, 4};
      input[1] = new int[] {19, 9, 12, 4, 5, 4, 6, 2, 2, 1, 4, 1, 3, 2, 4};
      input[2] = new int[] {19, 9, 10, 5, 5, 4, 6, 2, 2, 1, 4, 1, 3, 2, 4};
      input[3] = new int[] {19, 9, 10, 4, 5, 4, 6, 3, 2, 1, 4, 1, 3, 2, 4};
    
      final int[][] actual = new int[4][];
      for (int test = 0; test < input.length; test++) {
        actual[test] = BinaryTreeWithIncorrectValue.findIncorrectNumber(input[test]);
        assertArrayEquals("not as expected for 4 level test " + test, expected[test], actual[test]);
      }  
  }

}