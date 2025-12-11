package uk.co.stevebosman.aoc25.day10;

import java.util.Arrays;
import java.util.List;

public record Transition(List<Integer> buttons) {
  public static Transition of(final String text) {
    return new Transition(Arrays.stream(text.substring(1, text.length() - 1)
                                            .split(","))
                                .map(Integer::valueOf)
                                .toList());
  }
}
