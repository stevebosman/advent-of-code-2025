package uk.co.stevebosman.aoc25.day08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {
  @Test
  void example() throws IOException {
    final long actual = Part1.run(Path.of("src", "test", "resources", "Day08Example.txt"),
                                                                10);
    assertEquals(40L, actual);
  }

  @Test
  void input() throws IOException {
    final long actual = Part1.run(Path.of("src", "test", "resources", "Day08Input.txt"), 1000);
    System.out.println("day 8, part 1: " + actual);
  }
}