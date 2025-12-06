package uk.co.stevebosman.aoc25.day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Part2 {
  public static long run(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);

    final int width = lines.getFirst()
                           .length();
    final String lastLine = lines.getLast();

    long result = 0L;
    final List<Long> values = new ArrayList<>();
    for (int i = width - 1; i >= 0; i--) {
      extractValue(lines, i).ifPresentOrElse(values::add, values::clear);
      if (lastLine.length() > i) {
        final char op = lastLine.charAt(i);
        if ('*' == op) {
          result += values.stream()
                          .reduce(1L, (a, b) -> a * b);
        } else if ('+' == op) {
          result += values.stream()
                          .reduce(0L, Long::sum);
        }
      }
    }
    return result;
  }

  private static Optional<Long> extractValue(final List<String> lines, final int index) {
    boolean blank = true;
    long result = 0L;
    for (int i = 0; i < lines.size() - 1; i++) {
      final String line = lines.get(i);
      final char c = line.charAt(index);
      if (c >= '0' && c <= '9') {
        blank = false;
        result = result * 10 + (c - '0');
      }
    }
    return blank
           ? Optional.empty()
           : Optional.of(result);
  }
}
