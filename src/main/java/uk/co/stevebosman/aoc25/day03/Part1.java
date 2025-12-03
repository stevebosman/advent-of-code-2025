package uk.co.stevebosman.aoc25.day03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Part1 {
  public static int totalJoltage(final Stream<String> instructions) {
    return instructions.map(Part1::maxJoltage)
                       .reduce(0, Integer::sum);
  }

  public static int maxJoltage(final String text) {
    final List<Integer> digits = Arrays.stream(text.split(""))
                                       .map(Integer::parseInt)
                                       .toList();
    int maxDigitIndex = 0;
    int maxDigit = digits.get(0);
    for (int i = 1; i < digits.size() - 1; i++) {
      final Integer digit = digits.get(i);
      if (digit > maxDigit) {
        maxDigitIndex = i;
        maxDigit = digit;
      }
    }
    int secondaryDigitIndex = maxDigitIndex + 1;
    int secondaryDigit = digits.get(secondaryDigitIndex);
    for (int i = secondaryDigitIndex + 1; i < digits.size(); i++) {
      final Integer digit = digits.get(i);
      if (digit > secondaryDigit) {
        secondaryDigitIndex = i;
        secondaryDigit = digit;
      }
    }
    return maxDigit * 10 + secondaryDigit;
  }
}
