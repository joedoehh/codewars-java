package com.joedoe.cwjava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuildTowerTest {

  @Test
  public void basicTests() {
    assertEquals(String.join(",", "*"), String.join(",", BuildTower.towerBuilder(1)));
    assertEquals(String.join(",", " * ", "***"), String.join(",", BuildTower.towerBuilder(2)));
    assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", BuildTower.towerBuilder(3)));
  }

}