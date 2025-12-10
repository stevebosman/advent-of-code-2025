package uk.co.stevebosman.aoc25.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransitionTest {

  @Test
  void of() {
    final Transition actual = Transition.of("(1,3)");
    final Transition expected = new Transition(List.of(1, 3));
    assertEquals(expected, actual);
  }
}