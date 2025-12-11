package uk.co.stevebosman.aoc25.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part2Test {
  @Test
  void example() throws IOException {
    final long actual = Part2.of(Path.of("src", "test", "resources", "Day11Part2Example.txt"))
                             .countPathsToOut();
    assertEquals(2, actual);
  }

  @Test
  void input() throws IOException {
    final long actual = Part2.of(Path.of("src", "test", "resources", "Day11Part2Input.txt"))
                             .countPathsToOut();
    System.out.println("day 11, part 2: " + actual);
  }
}