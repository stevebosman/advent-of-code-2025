package uk.co.stevebosman.aoc25.day03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Part2 {
  public static long totalJoltage(final Stream<String> instructions) {
    return instructions.map(Part2::maxJoltage)
                       .reduce(0L, Long::sum);
  }

  public static long maxJoltage(final String text) {
    final List<Integer> digits = Arrays.stream(text.split(""))
                                       .map(Integer::parseInt)
                                       .toList();
    long total = 0;
    int lastIndex = -1;
    for (int offset = 11; offset >= 0; offset--) {
      int maxDigitIndex = lastIndex + 1;
      int maxDigit = digits.get(maxDigitIndex);
      for (int i = maxDigitIndex + 1; i < digits.size() - offset; i++) {
        final Integer digit = digits.get(i);
        if (digit > maxDigit) {
          maxDigitIndex = i;
          maxDigit = digit;
        }
      }
      total = total * 10 + maxDigit;
      lastIndex = maxDigitIndex;
    }
    return total;
  }
}
