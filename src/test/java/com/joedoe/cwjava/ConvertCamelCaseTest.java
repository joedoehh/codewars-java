package com.joedoe.cwjava;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class ConvertCamelCaseTest {

  @Test
  public void testSomeUnderscoreLowerStart() {
    String input = "the_Stealth_Warrior";
    System.out.println("input: " + input);
    assertEquals("theStealthWarrior", ConvertCamelCase.toCamelCase(input));
  }

  @Test
  public void testSomeDashLowerStart() {
    String input = "the-Stealth-Warrior";
    System.out.println("input: " + input);
    assertEquals("theStealthWarrior", ConvertCamelCase.toCamelCase(input));
  }
 
  @Test
  public void testSomeRandom() {
    String input = "bridge-Yellow-down-Street-bridge-north-Samurai";
    System.out.println("input: " + input);
    assertEquals("bridgeYellowDownStreetBridgeNorthSamurai", ConvertCamelCase.toCamelCase(input));
  }
  
}