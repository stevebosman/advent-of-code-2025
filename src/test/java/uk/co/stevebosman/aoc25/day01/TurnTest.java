package uk.co.stevebosman.aoc25.day01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TurnTest {

  @ParameterizedTest
  @CsvSource(value = {
          "R20,RIGHT,20",
          "L15,LEFT,15",
  })
  void of(final String code, final Direction expectedDirection, final int expectedSteps) {
    final Turn actual = Turn.of(code);
    assertNotNull(actual);
    assertAll(
            () -> assertEquals(expectedDirection, actual.direction),
            () -> assertEquals(expectedSteps, actual.steps)
    );
  }
}