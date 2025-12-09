package uk.co.stevebosman.aoc25.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day09 {

  public static long part1(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final List<Point> points = Point.of(lines);
    final List<Long> areas = computeAllAreas(points);
    return areas.stream()
                .max(Long::compareTo)
                .orElse(0L);
  }

  public static long part2(final Path path) throws IOException {
    // This works and is pretty fast, but I hate it :^D
    final List<String> lines = Files.readAllLines(path);
    final List<Point> points = Point.of(lines);

    final List<Integer> uniqueX = points.stream()
                                        .map(Point::x)
                                        .distinct()
                                        .sorted()
                                        .toList();
    final List<Integer> uniqueY = points.stream()
                                        .map(Point::y)
                                        .distinct()
                                        .sorted()
                                        .toList();

    final List<Point> simplifiedPoints = new ArrayList<>();
    final Map<Point, Point> simplifiedPointsMap = new HashMap<>();
    for (final Point point : points) {
      final Point simplified = new Point(uniqueX.indexOf(point.x()), uniqueY.indexOf(point.y()));
      simplifiedPoints.add(simplified);
      simplifiedPointsMap.put(simplified, point);
    }

    final Grid simplifiedGrid = Grid.buildGrid(simplifiedPoints);
//    System.out.println("simplifiedGrid =\n" + simplifiedGrid);

    final int numberOfPoints = points.size();
    long largest = 0L;
    for (int p1 = 0; p1 < numberOfPoints; p1++) {
      final Point point1 = simplifiedPoints.get(p1);
      for (int p2 = p1 + 1; p2 < numberOfPoints; p2++) {
        final Point point2 = simplifiedPoints.get(p2);
        if (simplifiedGrid.containsArea(point1, point2)) {
          final long area = Point.areaOf(simplifiedPointsMap.get(point1), simplifiedPointsMap.get(point2));
          if (area > largest) {
            largest = area;
          }
        }
      }
    }

    return largest;
  }


  private static List<Long> computeAllAreas(final List<Point> points) {
    final int numberOfPoints = points.size();
    final List<Long> areas = new ArrayList<>();
    for (int p1 = 0; p1 < numberOfPoints; p1++) {
      for (int p2 = p1 + 1; p2 < numberOfPoints; p2++) {
        areas.add(Point.areaOf(points.get(p1), points.get(p2)));
      }
    }
    areas.sort(Long::compareTo);
    return areas;
  }
}
