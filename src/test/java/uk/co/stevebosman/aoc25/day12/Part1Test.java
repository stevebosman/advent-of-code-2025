package uk.co.stevebosman.aoc25.day12;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Part1Test {
  @Test
  void ofExample() throws IOException {
    final Part1 actual = Part1.of(Path.of("src", "test", "resources", "Day12Example.txt"));
    assertNotNull(actual);
  }

  @Test
  void example() throws IOException {
    final Part1 actual = Part1.of(Path.of("src", "test", "resources", "Day12Example.txt"));
    assertEquals(2, actual.solvableCount());
  }

  @Test
  void ofInput() throws IOException {
    final Part1 actual = Part1.of(Path.of("src", "test", "resources", "Day12Input.txt"));
    assertNotNull(actual);
  }

  @Test
  void input() throws IOException {
    final Part1 actual = Part1.of(Path.of("src", "test", "resources", "Day12Input.txt"));
    System.out.println("day 12, part 1: " + actual.solvableCount());
  }

}