package uk.co.stevebosman.aoc25.day04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {
  @Test
  void part1ExampleSum() throws IOException {
    final Day04 day04 = new Day04(Files.readAllLines(Path.of("src", "test", "resources", "Day04Part1Example1.txt")));
    assertEquals(13, day04.part1());
  }

  @Test
  void part2ExampleSum() throws IOException {
    final Day04 day04 = new Day04(Files.readAllLines(Path.of("src", "test", "resources", "Day04Part1Example1.txt")));
    assertEquals(43, day04.part2());
  }

  @Test
  void part1input() throws IOException {
    final Day04 day04 = new Day04(Files.readAllLines(Path.of("src", "test", "resources", "Day04Part1Input.txt")));
    System.out.println("day 4, part 1: " + day04.part1());
  }

  @Test
  void part2input() throws IOException {
    final Day04 day04 = new Day04(Files.readAllLines(Path.of("src", "test", "resources", "Day04Part1Input.txt")));
    System.out.println("day 4, part 2: " + day04.part2());
  }
}