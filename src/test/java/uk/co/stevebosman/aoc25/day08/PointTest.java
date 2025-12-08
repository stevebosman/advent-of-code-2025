package uk.co.stevebosman.aoc25.day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

  @Test
  void of() {
    assertEquals(new Point(1, 2, 3), Point.of("1,2,3"));
  }

  @Test
  void distance2() {
    assertEquals(14L, new Point(1, 2, 3).distance2(new Point(0, 0, 0)));
  }
}