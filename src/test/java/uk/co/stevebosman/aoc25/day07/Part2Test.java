package uk.co.stevebosman.aoc25.day07;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part2Test {
  @Test
  void example() throws IOException {
    final long actual = Part2.run(Path.of("src", "test", "resources", "Day07Example.txt"));
    assertEquals(40L, actual);
  }

  @Test
  void input() throws IOException {
    final long actual = Part2.run(Path.of("src", "test", "resources", "Day07Input.txt"));
    System.out.println("day 7, part 2: " + actual);
  }
}