package uk.co.stevebosman.aoc25.day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
  @Test
  void part1example() throws IOException {
    final int actual = Day10.part1(Path.of("src", "test", "resources", "Day10Example.txt"));
    assertEquals(7, actual);
  }

  @Test
  void part1input() throws IOException {
    final int actual = Day10.part1(Path.of("src", "test", "resources", "Day10Input.txt"));
    System.out.println("day 10, part 1: " + actual);
  }

  @Test
  void part2example() throws IOException {
    final int actual = Day10.part2(Path.of("src", "test", "resources", "Day10Example.txt"));
    assertEquals(33, actual);
  }

  @Test
  void part2input() throws IOException {
    final int actual = Day10.part2(Path.of("src", "test", "resources", "Day10Input.txt"));
    System.out.println("day 10, part 2: " + actual);
  }
}