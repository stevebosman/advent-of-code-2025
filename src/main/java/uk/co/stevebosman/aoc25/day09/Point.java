package uk.co.stevebosman.aoc25.day09;

import java.util.List;

public record Point(long x, long y) {
  public static Point of(final String x) {
    final String[] positions = x.split(",");
    return new Point(Long.parseLong(positions[0]), Long.parseLong(positions[1]));
  }

  public static List<Point> of(final List<String> x) {
    return x.stream()
            .map(Point::of)
            .toList();
  }

  public static long areaOf(final Point p1, final Point p2) {
    return (1 + Math.abs(p1.x - p2.x)) * (1 + Math.abs(p1.y - p2.y));
  }
}
