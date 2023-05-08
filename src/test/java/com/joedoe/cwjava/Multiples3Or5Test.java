package com.joedoe.cwjava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Multiples3Or5Test {

  @Test
  public void test() {
    assertEquals(23, new Multiples3Or5().solution(10));
  }

}