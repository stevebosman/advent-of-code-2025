package uk.co.stevebosman.aoc25.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record ParcelShape(long size, boolean[][][] orientations) {
  public static ParcelShape of(final List<String> lines) {

    final Set<String> uniqueTest = new HashSet<>();
    final List<boolean[][]> representations = new ArrayList<>();

    final boolean[][] chars = charsOf(lines);
    addRotation(chars, uniqueTest, representations);
    addRotation(flip(chars), uniqueTest, representations);

    final boolean[][] rotated1 = rotateClockwise(chars);
    addRotation(rotated1, uniqueTest, representations);
    addRotation(flip(rotated1), uniqueTest, representations);

    final boolean[][] rotated2 = rotateClockwise(rotated1);
    addRotation(rotated2, uniqueTest, representations);
    addRotation(flip(rotated2), uniqueTest, representations);

    final boolean[][] rotated3 = rotateClockwise(rotated2);
    addRotation(rotated3, uniqueTest, representations);
    addRotation(flip(rotated3), uniqueTest, representations);

    return new ParcelShape(lines.toString()
                                .chars()
                                .filter(c -> c == '#')
                                .count(), representations.toArray(boolean[][][]::new));
  }

  private static void addRotation(final boolean[][] flippedLines0, final Set<String> uniqueTest, final List<boolean[][]> representations) {
    final String e = Arrays.deepToString(flippedLines0);
    if (!uniqueTest.contains(e)) {
      uniqueTest.add(e);
      representations.add(flippedLines0);
    }
  }

  private static boolean[][] charsOf(final List<String> lines) {
    final int height = lines.size();
    final int width = lines.getFirst()
                           .length();
    final boolean[][] chars = new boolean[height][width];
    for (int i = 0; i < height; i++) {
      final char[] line = lines.get(i)
                               .toCharArray();
      for (int j = 0; j < line.length; j++) {
        chars[i][j] = line[j] == '#';
      }
    }
    return chars;
  }

  private static boolean[][] flip(final boolean[][] arr) {
    final int M = arr.length;
    final int N = arr[0].length;
    final boolean[][] ret = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      ret[i] = arr[M - 1 - i];
    }
    return ret;
  }

  static boolean[][] rotateClockwise(final boolean[][] mat) {
    final int M = mat.length;
    final int N = mat[0].length;
    final boolean[][] ret = new boolean[N][M];
    for (int r = 0; r < M; r++) {
      for (int c = 0; c < N; c++) {
        ret[c][M - 1 - r] = mat[r][c];
      }
    }
    return ret;
  }
}
