package uk.co.stevebosman.aoc25.day02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
  @Test
  void part1ExampleSum() throws IOException {
    final Day02 day02 = new Day02(Files.readString(Path.of("src", "test", "resources", "Day02Part1Example1.txt")));
    assertEquals(1227775554L, day02.invalidSum());
  }

  @Test
  void part1input() throws IOException {
    final Day02 day02 = new Day02(Files.readString(Path.of("src", "test", "resources", "Day02Part1Input.txt")));
    System.out.println("sum: " + day02.invalidSum());
  }

  @Test
  void part2ExampleSum() throws IOException {
    final Day02 day02 = new Day02(Files.readString(Path.of("src", "test", "resources", "Day02Part1Example1.txt")));
    assertEquals(4174379265L, day02.invalidSum2());
  }

  @Test
  void part2input() throws IOException {
    final Day02 day02 = new Day02(Files.readString(Path.of("src", "test", "resources", "Day02Part1Input.txt")));
    System.out.println("sum: " + day02.invalidSum2());
  }
}