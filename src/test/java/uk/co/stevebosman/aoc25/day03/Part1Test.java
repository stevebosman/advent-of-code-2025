package uk.co.stevebosman.aoc25.day03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {

  @ParameterizedTest
  @CsvSource(value = {
          "987654321111111,98",
          "811111111111119,89",
          "234234234234278,78",
          "818181911112111,92"
  })
  void maxJoltage(final String text, final int expected) {
    assertEquals(expected, Part1.maxJoltage(text));
  }

  @Test
  void example() throws IOException {
    final int actual = Part1.totalJoltage(
            Files.lines(Path.of("src", "test", "resources", "Day03Part1Example1.txt")));
    assertEquals(357, actual);
  }

  @Test
  void input() throws IOException {
    final int actual = Part1.totalJoltage(
            Files.lines(Path.of("src", "test", "resources", "Day03Part1Input.txt")));
    System.out.println("day 3, part 1: " + actual);
  }
}