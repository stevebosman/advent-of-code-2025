package uk.co.stevebosman.aoc25.day03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part2Test {

  @ParameterizedTest
  @CsvSource(value = {
          "987654321111111,987654321111",
          "811111111111119,811111111119",
          "234234234234278,434234234278",
          "818181911112111,888911112111"
  })
  void maxJoltage(final String text, final long expected) {
    assertEquals(expected, Part2.maxJoltage(text));
  }

  @Test
  void example() throws IOException {
    final long actual = Part2.totalJoltage(
            Files.lines(Path.of("src", "test", "resources", "Day03Part1Example1.txt")));
    assertEquals(3121910778619L, actual);
  }

  @Test
  void input() throws IOException {
    final long actual = Part2.totalJoltage(
            Files.lines(Path.of("src", "test", "resources", "Day03Part1Input.txt")));
    System.out.println("day 3, part 2: " + actual);
  }
}