package uk.co.stevebosman.aoc25.day07;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {
  @Test
  void part1Example() throws IOException {
    final long actual = Part1.run(Path.of("src", "test", "resources", "Day07Example.txt"));
    assertEquals(21L, actual);
  }

  @Test
  void part1input() throws IOException {
    final long actual = Part1.run(Path.of("src", "test", "resources", "Day07Input.txt"));
    System.out.println("day 7, part 1: " + actual);
  }
}