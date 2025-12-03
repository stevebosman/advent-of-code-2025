package uk.co.stevebosman.aoc25.day02;

import java.util.Set;
import java.util.TreeSet;

public final class Range {
  private final String startText;
  private final String endText;
  private final long start;
  private final long end;

  private Range(final String startText, final String endText, final long start, final long end) {
    this.startText = startText;
    this.endText = endText;
    this.start = start;
    this.end = end;
  }

  public static Range of(final String rangeText) {
    final String[] rangeValues = rangeText.split("-");
    return new Range(rangeValues[0], rangeValues[1], Long.parseLong(rangeValues[0]), Long.parseLong(rangeValues[1]));
  }

  public Set<Long> getInvalids() {
    return getInvalids(2);
  }

  public Set<Long> getInvalids(final int repeats) {
    final Set<Long> invalids = new TreeSet<>();
    final long s = startText.length() < repeats
                   ? 0
                   : Long.parseLong(startText.substring(0, startText.length() / repeats));
    for (long i = s; ; i++) {
      final long test = Long.parseLong(("" + i).repeat(repeats));
      if (test > end) break;
      if (start <= test) {
        invalids.add(test);
      }
    }
    return invalids;
  }

  public Set<Long> getInvalids2() {
    final Set<Long> invalids = new TreeSet<>();
    for (int i = 2; i <= 9; i++) {
      invalids.addAll(getInvalids(i));
    }
    return invalids;
  }
}
