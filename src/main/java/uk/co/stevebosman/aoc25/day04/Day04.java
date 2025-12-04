package uk.co.stevebosman.aoc25.day04;

import java.util.List;

public class Day04 {
  private final int[][] grid;

  public Day04(final List<String> input) {
    final int yMax = input.size();
    final int xMax = input.getFirst()
                          .length();
    grid = new int[yMax + 2][xMax + 2];
    for (int y = 0; y < yMax; y++) {
      final String line = input.get(y);
      for (int x = 0; x < xMax; x++) {
        grid[y + 1][x + 1] = line.charAt(x) == '@'
                             ? 1
                             : 0;
      }
    }
  }

  public int part1() {
    return countExtractable();
  }

  public int part2() {
    int count = 0;
    while (true) {
      final int extracted = countExtractable();
      count += extracted;
      if (extracted == 0) break;
      doRemove();
    }
    return count;
  }

  private int countExtractable() {
    int count = 0;
    for (int y = 1; y < grid.length - 1; y++) {
      for (int x = 1; x < grid[y].length - 1; x++) {
        if (grid[y][x] == 1 && countPaper(y, x) < 4) {
          // mark for removal
          grid[y][x] = -1;
          count++;
        }
      }
    }
    return count;
  }

  private void doRemove() {
    for (int y = 1; y < grid.length - 1; y++) {
      for (int x = 1; x < grid[y].length - 1; x++) {
        if (grid[y][x] == -1) {
          grid[y][x] = 0;
        }
      }
    }
  }

  private int countPaper(final int y, final int x) {
    int count = 0;
    for (int dy = -1; dy <= 1; dy++) {
      for (int dx = -1; dx <= 1; dx++) {
        if (grid[y + dy][x + dx] != 0) {
          count++;
        }
      }
    }
    return count - 1;
  }
}
