package uk.co.stevebosman.aoc25.day02;

import java.util.ArrayList;
import java.util.List;

public class Day02 {
  private final String[] ranges;

  public Day02(final String s) {
    this.ranges = s.split(",");
  }

  public long invalidSum() {
    final List<Long> invalids = new ArrayList<>();
    for (final String range : ranges) {
      invalids.addAll(Range.of(range)
                           .getInvalids());
    }
    return invalids.stream()
                   .reduce(0L, Long::sum);
  }

  public long invalidSum2() {
    final List<Long> invalids = new ArrayList<>();
    for (final String range : ranges) {
      invalids.addAll(Range.of(range)
                           .getInvalids2());
    }
    return invalids.stream()
                   .reduce(0L, Long::sum);
  }
}
