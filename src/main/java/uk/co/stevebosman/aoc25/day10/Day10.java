package uk.co.stevebosman.aoc25.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class Day10 {

  public static int part1(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    return lines.parallelStream()
                .map(Machine::of)
                .map(Machine::initialiseIndicatorLights)
                .reduce(0, Integer::sum);
  }

  public static int part2(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    return lines.parallelStream()
                .map(Machine::of)
                .map(Machine::initialiseJoltage)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .reduce(0, Integer::sum);
  }

}
