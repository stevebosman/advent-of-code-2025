package uk.co.stevebosman.aoc25.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PuzzleTest {
  @Test
  void of() {
    final Puzzle actual = Puzzle.of("2x5: 5 4 3 2 1");
    final Puzzle expected = new Puzzle(2, 5, List.of(5, 4, 3, 2, 1));
    assertEquals(expected, actual);
  }
}