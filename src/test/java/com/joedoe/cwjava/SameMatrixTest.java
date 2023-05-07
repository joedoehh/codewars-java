package com.joedoe.cwjava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SameMatrixTest {

  @Test
  public void SamplesTests() {
    int[][] ms;
    
    ms = new int[][] {{1, 2, 3, 4},
                      {3, 1, 4, 2},
                      {4, 3, 2, 1},
                      {2, 4, 1, 3}};
    assertEquals(SameMatrix.count_different_matrices(ms), 1);
    
    ms = new int[][] {{3, 1, 2, 3},
                      {3, 1, 2, 3},
                      {1, 3, 3, 2},
                      {3, 2, 1, 3}};
    assertEquals(SameMatrix.count_different_matrices(ms), 1);
    
    ms = new int[][] {{5, 1, 2, 6},
                      {5, 4, 3, 5},
                      {2, 5, 6, 1}};
    assertEquals(SameMatrix.count_different_matrices(ms), 2);
    
    ms = new int[][] {{1, 2, 2, 1},
                      {1, 1, 2, 2},
                      {2, 1, 1, 2},
                      {2, 1, 2, 1},
                      {1, 2, 1, 2}};
    assertEquals(SameMatrix.count_different_matrices(ms), 2);
  }

}