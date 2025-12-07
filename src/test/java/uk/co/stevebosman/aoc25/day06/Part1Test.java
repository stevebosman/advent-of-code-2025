package uk.co.stevebosman.aoc25.day06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {
  @Test
  void part1Example() throws IOException {
    final long actual = Part1.run(Path.of("src", "test", "resources", "Day06Example.txt"));
    assertEquals(4277556L, actual);
  }

  @Test
  void part1input() throws IOException {
    final long actual = Part1.run(Path.of("src", "test", "resources", "Day06Input.txt"));
    System.out.println("day 6, part 1: " + actual);
  }
}