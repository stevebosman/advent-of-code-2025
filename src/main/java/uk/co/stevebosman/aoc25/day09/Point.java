package uk.co.stevebosman.aoc25.day09;

import java.util.List;

public record Point(int x, int y) {
  public static Point of(final String x) {
    final String[] positions = x.split(",");
    return new Point(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
  }

  public static List<Point> of(final List<String> x) {
    return x.stream()
            .map(Point::of)
            .toList();
  }

  public static long areaOf(final Point p1, final Point p2) {
    return (1L + Math.abs(p1.x - p2.x)) * (1L + Math.abs(p1.y - p2.y));
  }
}
