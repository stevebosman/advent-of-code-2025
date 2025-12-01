package uk.co.stevebosman.aoc25.day01;

import java.util.List;

public class Day01 {
  private final SafeDial dial = new SafeDial(100, 50);
  public SafeDial process(final List<String> instructions) {
    instructions.forEach(l -> dial.twist(Turn.of(l)));
    return dial;
  }
}
