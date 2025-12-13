package uk.co.stevebosman.aoc25.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Puzzle(int height, int width, List<Integer> counts) {
  public static Puzzle of(final String line) {
    final String[] split = line.split(":");
    final String[] dimensions = split[0].split("x");
    return new Puzzle(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), Arrays.stream(split[1].trim()
                                                                                                              .split(" "))
                                                                                              .map(Integer::parseInt)
                                                                                              .toList());
  }

  private static long getRequiredTotalArea(final List<ParcelShape> shapes, final List<Integer> counts) {
    long totalArea = 0;
    for (int i = 0; i < shapes.size(); i++) {
      totalArea += counts.get(i) * shapes.get(i)
                                         .size();
    }
    return totalArea;
  }

  public boolean isSolvable(final List<ParcelShape> shapes) {
//    System.out.println("=".repeat(30) + counts);
    final boolean fit = fit(shapes, new boolean[height][width], (long) width * height, counts);
    System.out.println("fit = " + fit);
    return fit;
  }

  private boolean fit(final List<ParcelShape> parcels, final boolean[][] grid, final long free, final List<Integer> counts) {
    final Integer remainder = counts.stream()
                                    .reduce(0, Integer::sum);
    if (remainder == 0) return true;
    final long totalAreaRequired = getRequiredTotalArea(parcels, counts);
    if (totalAreaRequired > free) return false;
    for (int parcelIndex = 0; parcelIndex < parcels.size(); parcelIndex++) {
      if (counts.get(parcelIndex) > 0) {
        final ParcelShape parcel = parcels.get(parcelIndex);
        for (int orientationIndex = 0; orientationIndex < parcel.orientations().length; orientationIndex++) {
          final boolean[][] orientation = parcel.orientations()[orientationIndex];
          for (int row = 0; row <= height - orientation.length; row++) {
            for (int column = 0; column <= width - orientation[0].length; column++) {
              if (canFit(grid, orientation, row, column)) {
//                System.out.println(remainder + " " + parcelIndex + "." + orientationIndex  + " (" + row + "," + column + ")");
                final boolean[][] nextGrid = apply(grid, orientation, row, column);
                final List<Integer> nextCounts = new ArrayList<>(counts);
                nextCounts.set(parcelIndex, nextCounts.get(parcelIndex) - 1);
                if (fit(parcels, nextGrid, free - parcel.size(), nextCounts)) return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean canFit(final boolean[][] grid, final boolean[][] rotation, final int row, final int column) {
    for (int dy = 0; dy < rotation.length; dy++) {
      for (int dx = 0; dx < rotation[dy].length; dx++) {
        if (grid[row + dy][column + dx] && rotation[dy][dx]) return false;
      }
    }
    return true;
  }

  private boolean[][] apply(final boolean[][] grid, final boolean[][] rotation, final int row, final int column) {
    final boolean[][] result = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      System.arraycopy(grid[i], 0, result[i], 0, grid[i].length);
    }
    for (int dy = 0; dy < rotation.length; dy++) {
      for (int dx = 0; dx < rotation[dy].length; dx++) {
        result[row + dy][column + dx] = result[row + dy][column + dx] || rotation[dy][dx];
      }
    }
    return result;
  }


}
