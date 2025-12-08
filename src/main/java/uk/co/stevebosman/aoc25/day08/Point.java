package uk.co.stevebosman.aoc25.day08;

import java.util.List;

public record Point(long x, long y, long z) {
  public static Point of(final String x) {
    final String[] positions = x.split(",");
    return new Point(Long.parseLong(positions[0]), Long.parseLong(positions[1]), Long.parseLong(positions[2]));
  }

  public static List<Point> of(final List<String> x) {
    return x.stream()
            .map(Point::of)
            .toList();
  }

  public long distance2(final Point p) {
    return square(this.x - p.x) + square(this.y - p.y) + square(this.z - p.z);
  }

  private long square(final long i) {
    return i * i;
  }
}
