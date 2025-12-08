package uk.co.stevebosman.aoc25.day08;

public record Distance(Point p1, Point p2, long distance) {
  public static Distance of(final Point point1, final Point point2) {
    return new Distance(point1, point2, point1.distance2(point2));
  }
}
