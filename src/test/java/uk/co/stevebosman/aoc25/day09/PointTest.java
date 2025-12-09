package uk.co.stevebosman.aoc25.day09;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

  @Test
  void of() {
    assertEquals(new Point(2, 5), Point.of("2,5"));
  }

  @ParameterizedTest
  @CsvSource(value = {
          "2,5,11,1,50",
          "11,1,2,5,50",
  })
  void areaOf(final int p1x, final int p1y, final int p2x, final int p2y, final long expected) {
    assertEquals(expected, Point.areaOf(new Point(p1x, p1y), new Point(p2x, p2y)));
  }
}