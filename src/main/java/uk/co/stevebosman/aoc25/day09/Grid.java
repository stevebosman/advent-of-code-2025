package uk.co.stevebosman.aoc25.day09;

import java.util.List;

public class Grid {
  private static final char UNKNOWN = '-';
  private static final int GREEN = 'O';
  private static final int RED = 'X';
  private static final int NOT_GREEN = '.';
  final char[][] grid;

  private Grid(final char[][] grid) {
    this.grid = grid;
  }

  public static Grid buildGrid(final List<Point> points) {
    final int maxX = points.stream()
                           .map(Point::x)
                           .max(Integer::compareTo)
                           .orElse(0);
    final int maxY = points.stream()
                           .map(Point::y)
                           .max(Integer::compareTo)
                           .orElse(0);
    final char[][] grid = new char[maxY + 1][maxX + 1];
    for (int y = 0; y < maxY + 1; y++) {
      for (int x = 0; x < maxX + 1; x++) {
        grid[y][x] = UNKNOWN;
      }
    }
    Point p1 = points.getLast();
    for (final Point p2 : points) {
      grid[p1.y()][p1.x()] = RED;
      grid[p2.y()][p2.x()] = RED;

      if (p1.x() == p2.x() && p1.y() < p2.y()) {
        for (int y = p1.y() + 1; y < p2.y(); y++) {
          grid[y][p1.x()] = GREEN;
        }
      } else if (p1.x() == p2.x()) {
        for (int y = p2.y() + 1; y < p1.y(); y++) {
          grid[y][p1.x()] = GREEN;
        }
      } else if (p1.x() < p2.x()) {
        for (int x = p1.x() + 1; x < p2.x(); x++) {
          grid[p1.y()][x] = GREEN;
        }
      } else {
        for (int x = p2.x() + 1; x < p1.x(); x++) {
          grid[p1.y()][x] = GREEN;
        }
      }
      p1 = p2;
    }
    // flood
    floodGrid(grid, maxY, maxX);

    return new Grid(grid);
  }

  private static void floodGrid(final char[][] grid, final int maxY, final int maxX) {
    for (int y = 0; y < maxY + 1; y++) {
      if (grid[y][0] == UNKNOWN) {
        floodCell(grid, maxY, maxX, y, 0);
      }
      if (grid[y][maxX] == UNKNOWN) {
        floodCell(grid, maxY, maxX, y, maxX);
      }
    }
    for (int x = 0; x < maxX + 1; x++) {
      if (grid[0][x] == UNKNOWN) {
        floodCell(grid, maxY, maxX, 0, x);
      }
      if (grid[maxY][x] == UNKNOWN) {
        floodCell(grid, maxY, maxX, maxY, x);
      }
    }
  }

  private static void floodCell(final char[][] grid, final int maxY, final int maxX, final int y, final int x) {
    if (y >= 0 && y <= maxY && x >= 0 && x <= maxX && grid[y][x] == UNKNOWN) {
      grid[y][x] = NOT_GREEN;
      floodCell(grid, maxY, maxX, y + 1, x);
      floodCell(grid, maxY, maxX, y - 1, x);
      floodCell(grid, maxY, maxX, y, x - 1);
      floodCell(grid, maxY, maxX, y, x + 1);
    }
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    for (final char[] line : grid) {
      sb.append(line);
      sb.append('\n');
    }
    return sb.toString();
  }

  public boolean containsArea(final Point point1, final Point point2) {
    final int minX = Math.min(point1.x(), point2.x());
    final int minY = Math.min(point1.y(), point2.y());
    final int maxX = Math.max(point1.x(), point2.x());
    final int maxY = Math.max(point1.y(), point2.y());
    boolean result = true;
    outer:
    for (int y = minY; y <= maxY; y++) {
      for (int x = minX; x <= maxX; x++) {
        if (grid[y][x] == NOT_GREEN) {
          result = false;
          break outer;
        }
      }
    }
    return result;
  }
}
