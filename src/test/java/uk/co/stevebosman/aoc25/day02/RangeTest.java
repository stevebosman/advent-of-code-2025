package uk.co.stevebosman.aoc25.day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeTest {
  @ParameterizedTest
  @CsvSource(value = {
          "11-22,2",
          "95-115,1",
          "998-1012,1",
          "1188511880-1188511890,1",
          "222220-222224,1",
          "1698522-1698528,0",
          "446443-446449,1",
          "38593856-38593862,1",
          "565653-565659,0",
          "824824821-824824827,0",
          "2121212118-2121212124,0"
  })
  public void ofInvalids(final String rangeText, final int expectedInvalidCount) {
    assertEquals(expectedInvalidCount, Range.of(rangeText).getInvalids().size());
  }

  @ParameterizedTest
  @CsvSource(value = {
          "11-22,2",
          "95-115,2",
          "998-1012,2",
          "1188511880-1188511890,1",
          "222220-222224,1",
          "1698522-1698528,0",
          "446443-446449,1",
          "38593856-38593862,1",
          "565653-565659,1",
          "824824821-824824827,1",
          "2121212118-2121212124,1"
  })
  public void ofInvalids2(final String rangeText, final long expectedInvalidCount) {
    assertEquals(expectedInvalidCount, Range.of(rangeText).getInvalids2().size());
  }
}