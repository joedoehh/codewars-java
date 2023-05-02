package com.joedoe.cwjava;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
 
public class FunGraphTest {

  static Stream<Arguments> sampleTests() {
    return Stream.of(
        arguments(new int[] { 1, 3, 5, 4, 1 }, """
            ............ ____ ............ ^ 5
            ............|    | ____ ...... | 4
            ...... ____ |    ||    |...... | 3
            ......|    ||    ||    |...... | 2
             ____ |    ||    ||    | ____  | 1
            |    ||    ||    ||    ||    | | 0"""),

        arguments(new int[] { 1, 4, 2 }, """
            ...... ____ ...... ^ 4
            ......|    |...... | 3
            ......|    | ____  | 2
             ____ |    ||    | | 1
            |    ||    ||    | | 0"""),

        arguments(new int[] { 10, 5, 3, 1, 4 }, """
             ____ ........................ ^ 10
            |    |........................ | 9
            |    |........................ | 8
            |    |........................ | 7
            |    |........................ | 6
            |    | ____ .................. | 5
            |    ||    |............ ____  | 4
            |    ||    | ____ ......|    | | 3
            |    ||    ||    |......|    | | 2
            |    ||    ||    | ____ |    | | 1
            |    ||    ||    ||    ||    | | 0"""),

        arguments(new int[0], ""),

        arguments(new int[] { 0 }, " ____  ^ 0"));
  }

  @ParameterizedTest(name = "Input: {0}")
  @MethodSource
  @DisplayName("Sample tests")
  void sampleTests(int[] array, String expected) {
    String actual = FunGraph.graph(array);
    // the line feeds are added for better assertion messages, your solution should
    // not include them!
    expected = expected.isBlank() ? expected : "\n" + expected + "\n";
    actual = actual == null || actual.isBlank() ? actual : "\n" + actual + "\n";
    assertEquals(expected, actual);
  }
}
