package uk.co.stevebosman.aoc25.day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Part1 {
  public static long run(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final int count = splitLine(lines, 0).length;
    final long[][] elements = new long[count][lines.size() - 1];
    for (int rowIndex = 0; rowIndex < lines.size() - 1; rowIndex++) {
      final String[] values = splitLine(lines, rowIndex);
      for (int colIndex = 0; colIndex < values.length; colIndex++) {
        elements[colIndex][rowIndex] = Long.parseLong(values[colIndex]);
      }
    }
    final String[] operations = splitLine(lines, lines.size() - 1);
    long result = 0;
    for (int opIndex = 0; opIndex < operations.length; opIndex++) {
      final String operation = operations[opIndex];
      if (operation.equals("+")) {
        result += Arrays.stream(elements[opIndex])
                        .reduce(0L, Long::sum);
      } else if (operation.equals("*")) {
        result += Arrays.stream(elements[opIndex])
                        .reduce(1L, (a, b) -> a * b);
      }
    }
    return result;
  }

  private static String[] splitLine(final List<String> lines, final int index) {
    return lines.get(index)
                .trim()
                .split(" +");
  }
}
