package com.joedoe.cwjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotPathTest {

  @Test
  void testSomething() {
    assertEquals("Take 1 step up", RobotPath.walk("^"));
    assertEquals("Take 1 step down", RobotPath.walk("v"));
    assertEquals("Take 2 steps right", RobotPath.walk(">>"));
    assertEquals("Take 2 steps left\nTake 1 step right", RobotPath.walk("<<>"));
    assertEquals("Paused", RobotPath.walk(""));
  }

}