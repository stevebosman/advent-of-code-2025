package uk.co.stevebosman.aoc25.day01;

public class SafeDial {
  private int size;
  private int position;
  private int zeroes = 0;
  private int clicks = 0;
  public SafeDial(final int size, final int position) {
    this.size = size;
    this.position = position;
  }

  public void twist(final Turn turn) {
    final int intermediate;
    if (turn.direction==Direction.RIGHT) {
      intermediate= (position + turn.steps);
    } else {
      intermediate= (position - turn.steps);
    }
    if (intermediate>0) {
      clicks += intermediate/size;
      position = intermediate % size;
    } else {
      if (position!=0) clicks+=1;
      clicks += -intermediate/size;
      position = intermediate;
      while (position<0) position+=size;
    }
    if (position==0) {
      zeroes+=1;
    }
  }

  public int getPosition() {
    return position;
  }

  public long getZeroes() {
    return zeroes;
  }
  public long getClicks() {
    return clicks;
  }
}
