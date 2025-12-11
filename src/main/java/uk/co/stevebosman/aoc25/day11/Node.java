package uk.co.stevebosman.aoc25.day11;

import java.util.Arrays;
import java.util.List;

public record Node(String id, List<String> connections) {
  public static Node of(final String text) {
    final int colonIndex = text.indexOf(':');
    return new Node(text.substring(0, colonIndex), Arrays.stream(text.substring(colonIndex + 2)
                                                                     .split(" "))
                                                         .toList());
  }
}
