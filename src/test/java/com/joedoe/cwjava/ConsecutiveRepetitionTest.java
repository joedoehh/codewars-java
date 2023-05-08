package com.joedoe.cwjava;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ConsecutiveRepetitionTest {

  @Test
  public void exampleTests() {
      assertArrayEquals(new Object[]{"a", 4}, ConsecutiveRepetition.longestRepetition("aaaabb"));
      assertArrayEquals(new Object[]{"a", 4}, ConsecutiveRepetition.longestRepetition("bbbaaabaaaa"));
      assertArrayEquals(new Object[]{"u", 3}, ConsecutiveRepetition.longestRepetition("cbdeuuu900"));
      assertArrayEquals(new Object[]{"b", 5}, ConsecutiveRepetition.longestRepetition("abbbbb"));
      assertArrayEquals(new Object[]{"a", 2}, ConsecutiveRepetition.longestRepetition("aabb"));
      assertArrayEquals(new Object[]{"", 0}, ConsecutiveRepetition.longestRepetition(""));
  }
  
}