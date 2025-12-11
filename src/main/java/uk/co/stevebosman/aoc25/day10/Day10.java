package uk.co.stevebosman.aoc25.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day10 {

  public static int part1(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    return lines.parallelStream()
                .map(Machine::of)
                .map(Machine::initialise)
                .reduce(0, Integer::sum);
  }

}
