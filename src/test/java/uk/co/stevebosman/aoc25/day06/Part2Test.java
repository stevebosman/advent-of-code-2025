package uk.co.stevebosman.aoc25.day06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part2Test {
  @Test
  void part2Example() throws IOException {
    final long actual = Part2.run(Path.of("src", "test", "resources", "Day06Example.txt"));
    assertEquals(3263827L, actual);
  }

  @Test
  void part2input() throws IOException {
    final long actual = Part2.run(Path.of("src", "test", "resources", "Day06Input.txt"));
    System.out.println("day 6, part 2: " + actual);
  }
}