package com.joedoe.cwjava;

/**
 * Vowel Count
 * 7 kyu
 * https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/java
 */
public class Vowels {

  public static int getCount(String str) {
    int result = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      switch (c) {
        case 'a', 'e', 'i', 'o', 'u':
          result++;
          break;
      }
    }
    return result;
  }

}
