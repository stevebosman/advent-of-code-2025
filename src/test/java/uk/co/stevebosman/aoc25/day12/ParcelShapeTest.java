package uk.co.stevebosman.aoc25.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParcelShapeTest {
  @Test
  void of1() {
    final boolean[][][] actual = ParcelShape.of(List.of("#"))
                                            .orientations();
    final boolean[][][] expected = new boolean[][][]{{{true}}};
    assertArrayEquals(expected, actual);
  }

  @Test
  void of2() {
    final boolean[][][] actual = ParcelShape.of(List.of("##"))
                                            .orientations();
    final boolean[][][] expected = new boolean[][][]{{{true, true}}, {{true}, {true}}};
    assertArrayEquals(expected, actual);
  }

  @Test
  void of3() {
    final ParcelShape parcelShape = ParcelShape.of(List.of("##", "#."));
    assertEquals(3, parcelShape.size());
    final boolean[][][] actual = parcelShape
                                            .orientations();
    final boolean[][][] expected = new boolean[][][]{
            {{true, true}, {true, false}},
            {{true, false}, {true, true}},
            {{true, true}, {false, true}},
            {{false, true}, {true, true}},
    };
    assertArrayEquals(expected, actual);
  }
}