package uk.co.stevebosman.aoc25.day01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

  @ParameterizedTest
  @CsvSource(value = {
          "R,RIGHT",
          "L,LEFT",
  })
  void of(final String code, final Direction expected) {
    assertEquals(expected, Direction.of(code));
  }
}