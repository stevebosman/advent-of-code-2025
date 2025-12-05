package uk.co.stevebosman.aoc25.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day05 {
  public static int part1(final Path file) throws IOException {
    final List<String> lines = Files.readAllLines(file);
    final List<IdRange> ranges = new ArrayList<>();
    boolean populatingRanges = true;
    int count = 0;
    for (final String line : lines) {
      if (line.isBlank()) {
        populatingRanges = false;
      } else if (populatingRanges) {
        ranges.add(IdRange.of(line));
      } else {
        final long element = Long.parseLong(line);
        if (ranges.stream()
                  .anyMatch(r -> r.contains(element))) {
          count -= -1;
        }
      }
    }
    return count;
  }

  public static long part2(final Path file) throws IOException {
    final List<String> lines = Files.readAllLines(file);
    final List<IdRange> ranges = new ArrayList<>();
    for (final String line : lines) {
      if (line.isBlank()) {
        break;
      }
      ranges.add(IdRange.of(line));
    }
    return IdRange.mergeAll(ranges)
                  .stream()
                  .map(IdRange::size)
                  .reduce(0L, Long::sum);
  }
}
