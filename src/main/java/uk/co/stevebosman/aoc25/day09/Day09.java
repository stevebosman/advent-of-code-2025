package uk.co.stevebosman.aoc25.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day09 {
  public static long part1(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final List<Point> points = Point.of(lines);
    final List<Long> areas = computeAllAreas(points);
    return areas.stream()
                .max(Long::compareTo)
                .orElse(0L);
  }

  private static List<Long> computeAllAreas(final List<Point> points) {
    final int numberOfPoints = points.size();
    final List<Long> areas = new ArrayList<>();
    for (int i = 0; i < numberOfPoints; i++) {
      for (int j = i + 1; j < numberOfPoints; j++) {
        areas.add(Point.areaOf(points.get(i), points.get(j)));
      }
    }
    areas.sort(Long::compareTo);
    return areas;
  }
}
