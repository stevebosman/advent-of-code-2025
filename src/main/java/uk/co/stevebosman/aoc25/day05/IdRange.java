package uk.co.stevebosman.aoc25.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record IdRange(long start, long end) {
  public static IdRange of(final String range) {
    final String[] elements = range.split("-");
    return new IdRange(Long.parseLong(elements[0]), Long.parseLong(elements[1]));
  }

  public static List<IdRange> mergeAll(final List<IdRange> ranges) {
    final List<IdRange> sorted = ranges.stream()
                                       .sorted(Comparator.comparingLong(o -> o.start))
                                       .toList();
    final List<IdRange> result = new ArrayList<>();
    IdRange current = sorted.getFirst();
    for (int i = 1; i < sorted.size(); i++) {
      final IdRange next = sorted.get(i);
      if (current.overlaps(next)) {
        current = current.merge(next);
      } else {
        result.add(current);
        current = next;
      }
    }
    result.add(current);
    return result;
  }

  public boolean contains(final long id) {
    return id >= start && id <= end;
  }

  public IdRange merge(final IdRange range) {
    if (!overlaps(range)) throw new IllegalArgumentException("ranges don't overlap");
    return new IdRange(Math.min(start, range.start), Math.max(end, range.end));
  }

  public boolean overlaps(final IdRange range) {
    return range.contains(start) || range.contains(end) || this.contains(range.start) || this.contains(range.end);
  }

  public long size() {
    return end - start + 1;
  }
}
