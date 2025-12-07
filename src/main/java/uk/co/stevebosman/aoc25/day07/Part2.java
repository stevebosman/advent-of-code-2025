package uk.co.stevebosman.aoc25.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {

  public static Map<String, Long> pathCounts = new HashMap<>();

  public static long run(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final int beam = lines.getFirst()
                          .indexOf('S');
    return countPaths(beam, 1, lines);
  }

  private static long countPaths(final int beam, final int lineIndex, final List<String> lines) {
    if (lineIndex == lines.size() - 1) return 1;
    final String key = beam + "_" + lineIndex;
    if (pathCounts.containsKey(key)) return pathCounts.get(key);
    long counts = 0;
    final String line = lines.get(lineIndex);
    final char c = line.charAt(beam);
    if (c == '^') {
      counts += countPaths(beam - 1, lineIndex + 1, lines);
      counts += countPaths(beam + 1, lineIndex + 1, lines);
    } else {
      counts = countPaths(beam, lineIndex + 1, lines);
    }
    pathCounts.put(key, counts);
    return counts;
  }
}
