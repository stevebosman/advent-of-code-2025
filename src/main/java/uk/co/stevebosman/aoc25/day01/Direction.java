package uk.co.stevebosman.aoc25.day01;

public enum Direction {
  RIGHT, LEFT;
  public static Direction of(final String code) {
    return "R".equals(code) ? RIGHT: LEFT;
  }
}
