package uk.co.stevebosman.aoc25.day01;

public class Turn {
  final Direction direction;
  final int steps;

  public Turn(final Direction direction, final int steps) {
    this.direction = direction;
    this.steps = steps;
  }

  public static Turn of(final String line) {
    return new Turn(Direction.of(line.substring(0, 1)), Integer.parseInt(line.substring(1)));
  }

  @Override
  public String toString() {
    return "Turn{" +
            "direction=" + direction +
            ", steps=" + steps +
            '}';
  }
}
