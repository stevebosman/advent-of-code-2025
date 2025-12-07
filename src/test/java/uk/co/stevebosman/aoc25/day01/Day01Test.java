package uk.co.stevebosman.aoc25.day01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
  @Test
  void example() throws IOException {
    final Day01 day01 = new Day01();
    final SafeDial actual = day01.process(
            Files.readAllLines(Path.of("src", "test", "resources", "Day01Example.txt")));
    assertEquals(3, actual.getZeroes());
    assertEquals(6, actual.getClicks());
  }

  @Test
  void input() throws IOException {
    final Day01 day01 = new Day01();
    final SafeDial actual = day01.process(
            Files.readAllLines(Path.of("src", "test", "resources", "Day01Input.txt")));
    System.out.println("day 1, part 1: " + actual.getZeroes());
    System.out.println("day 1, part 2: " + actual.getClicks());
  }
}