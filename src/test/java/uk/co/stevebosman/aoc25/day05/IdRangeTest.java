package uk.co.stevebosman.aoc25.day05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdRangeTest {

  @Test
  void of() {
    final IdRange actual = IdRange.of("32143243124-32432421342");
    assertEquals(32143243124L, actual.start());
    assertEquals(32432421342L, actual.end());
  }

  @ParameterizedTest
  @CsvSource(value = {
          "32143243124-32432421342, 32143243123, false",
          "32143243124-32432421342, 32143243124, true",
          "32143243124-32432421342, 32343243124, true",
          "32143243124-32432421342, 32432421342, true",
          "32143243124-32432421342, 32432421343, false",
  })
  void contains(final String range, final long test, final boolean expected) {
    assertEquals(expected, IdRange.of(range)
                                  .contains(test));
  }

  @ParameterizedTest
  @CsvSource(value = {
          "3-5,10-14, false",
          "10-14,12-18, true",
          "12-18,16-20,true",
          "16-20,3-5, false",
  })
  void overlaps(final String rangeText1, final String rangeText2, final boolean expected) {
    final IdRange range1 = IdRange.of(rangeText1);
    final IdRange range2 = IdRange.of(rangeText2);
    assertAll(
            () -> assertEquals(expected, range1.overlaps(range2)),
            () -> assertEquals(expected, range2.overlaps(range1))
    );
  }

  @ParameterizedTest
  @CsvSource(value = {
          "3-5, 3",
          "10-14, 5",
          "12-18, 7",
          "16-20, 5",
  })
  void size(final String rangeText, final long expected) {
    assertEquals(expected, IdRange.of(rangeText)
                                  .size());
  }

  @ParameterizedTest
  @CsvSource(value = {
          "10-14, 12-18, 10-18",
          "12-18, 16-20, 12-20",
  })
  void merge(final String rangeText1, final String rangeText2, final String expectedRangeText) {
    final IdRange range1 = IdRange.of(rangeText1);
    final IdRange range2 = IdRange.of(rangeText2);
    final IdRange expected = IdRange.of(expectedRangeText);
    final IdRange actual1 = range1.merge(range2);
    final IdRange actual2 = range2.merge(range1);
    assertAll(
            () -> assertEquals(actual1, actual2),
            () -> assertEquals(expected, actual1),
            () -> assertEquals(expected, actual2)
    );
  }

  @ParameterizedTest
  @CsvSource(value = {
          "3-5,10-14",
          "16-20,3-5",
  })
  void mergeFailure(final String rangeText1, final String rangeText2) {
    final IdRange range1 = IdRange.of(rangeText1);
    final IdRange range2 = IdRange.of(rangeText2);
    assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> range1.merge(range2)),
            () -> assertThrows(IllegalArgumentException.class, () -> range2.merge(range1))
    );
  }

  @ParameterizedTest
  @CsvSource(value = {
          "3-5|12-18|10-14,3-5|10-18",
          "12-18|3-5|10-14|16-20,3-5|10-20",
  })
  void mergeAll(final String rangesText, final String expectedText) {
    final List<IdRange> ranges = ranges(rangesText);
    final List<IdRange> expected = ranges(expectedText);
    final List<IdRange> actual = IdRange.mergeAll(ranges);
    assertAll(
            () -> assertEquals(expected.size(), actual.size()),
            () -> assertTrue(actual.containsAll(expected), () -> actual + " does not contain " + expected)
    );
  }

  private List<IdRange> ranges(final String rangesText) {
    return Arrays.stream(rangesText.split("\\|"))
                 .map(IdRange::of)
                 .toList();
  }

}