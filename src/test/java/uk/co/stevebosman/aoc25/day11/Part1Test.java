package uk.co.stevebosman.aoc25.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {
  @Test
  void example() throws IOException {
    final int actual = Part1.of(Path.of("src", "test", "resources", "Day11Part1Example.txt"))
                            .countPathsToOut();
    assertEquals(5, actual);
  }

  @Test
  void input() throws IOException {
    final int actual = Part1.of(Path.of("src", "test", "resources", "Day11Part1Input.txt"))
                            .countPathsToOut();
    System.out.println("day 11, part 1: " + actual);
  }
}