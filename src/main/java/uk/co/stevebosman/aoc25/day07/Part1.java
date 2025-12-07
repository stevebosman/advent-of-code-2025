package uk.co.stevebosman.aoc25.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Part1 {
  public static long run(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    Set<Integer> beams = Set.of(lines.getFirst()
                                     .indexOf('S'));
    int splits = 0;
    for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++) {
      final Set<Integer> nextBeams = new TreeSet<>();
      final String line = lines.get(lineIndex);
      for (final Integer beam : beams) {
        final char c = line.charAt(beam);
        if (c == '^') {
          nextBeams.add(beam - 1);
          nextBeams.add(beam + 1);
          splits++;
        } else {
          nextBeams.add(beam);
        }
      }
      beams = nextBeams;
    }
    return splits;
  }
}
