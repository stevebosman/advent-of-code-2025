package uk.co.stevebosman.aoc25.day09;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {
  @Test
  void part1example() throws IOException {
    final long actual = Day09.part1(Path.of("src", "test", "resources", "Day09Example.txt"));
    assertEquals(50L, actual);
  }

  @Test
  void part1input() throws IOException {
    final long actual = Day09.part1(Path.of("src", "test", "resources", "Day09Input.txt"));
    System.out.println("day 9, part 1: " + actual);
  }

  @Test
  void part2example() throws IOException {
    final long actual = Day09.part2(Path.of("src", "test", "resources", "Day09Example.txt"));
    assertEquals(24L, actual);
  }

  @Test
  void part2input() throws IOException {
    final long actual = Day09.part2(Path.of("src", "test", "resources", "Day09Input.txt"));
    System.out.println("day 9, part 2: " + actual);
  }
}