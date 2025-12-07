package uk.co.stevebosman.aoc25.day05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
  @Test
  void part1Example() throws IOException {
    final int actual = Day05.part1(Path.of("src", "test", "resources", "Day05Example.txt"));
    assertEquals(3, actual);
  }

  @Test
  void part1input() throws IOException {
    final int actual = Day05.part1(Path.of("src", "test", "resources", "Day05Input.txt"));
    System.out.println("day 5, part 1: " + actual);
  }

  @Test
  void part2Example() throws IOException {
    final long actual = Day05.part2(Path.of("src", "test", "resources", "Day05Example.txt"));
    assertEquals(14, actual);
  }

  @Test
  void part2input() throws IOException {
    final long actual = Day05.part2(Path.of("src", "test", "resources", "Day05Input.txt"));
    System.out.println("day 5, part 2: " + actual);
  }
}