package uk.co.stevebosman.aoc25.day08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Test {
  @Test
  void part1example() throws IOException {
    final long actual = Day08.part1(Path.of("src", "test", "resources", "Day08Example.txt"),
                                    10);
    assertEquals(40L, actual);
  }

  @Test
  void part1input() throws IOException {
    final long actual = Day08.part1(Path.of("src", "test", "resources", "Day08Input.txt"), 1000);
    System.out.println("day 8, part 1: " + actual);
  }

  @Test
  void part2example() throws IOException {
    final long actual = Day08.part2(Path.of("src", "test", "resources", "Day08Example.txt")
    );
    assertEquals(25272L, actual);
  }

  @Test
  void part2input() throws IOException {
    final long actual = Day08.part2(Path.of("src", "test", "resources", "Day08Input.txt"));
    System.out.println("day 8, part 2: " + actual);
  }
}