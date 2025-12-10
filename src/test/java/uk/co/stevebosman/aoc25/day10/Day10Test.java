package uk.co.stevebosman.aoc25.day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
  @Test
  void example() throws IOException {
    final int actual = Day10.part1(Path.of("src", "test", "resources", "Day10Example.txt"));
    assertEquals(7, actual);
  }

  @Test
  void input() throws IOException {
    final int actual = Day10.part1(Path.of("src", "test", "resources", "Day10Input.txt"));
    System.out.println("day 10, part 1: " + actual);
  }
}