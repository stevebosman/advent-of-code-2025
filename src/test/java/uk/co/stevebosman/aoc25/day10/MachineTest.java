package uk.co.stevebosman.aoc25.day10;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MachineTest {
  private static final Machine EXAMPLE1 = new Machine(List.of(false, true, true, false),
                                                      List.of(
                                                              new Transition(List.of(3)),
                                                              new Transition(List.of(1, 3)),
                                                              new Transition(List.of(2)),
                                                              new Transition(List.of(2, 3)),
                                                              new Transition(List.of(0, 2)),
                                                              new Transition(List.of(0, 1))
                                                      ),
                                                      List.of(3, 5, 4, 7));

  @Test
  void of() {
    final Machine actual = Machine.of("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}");
    assertEquals(EXAMPLE1, actual);
  }

  @Test
  void initialiseIndicatorLights() {
    assertEquals(2, EXAMPLE1.initialiseIndicatorLights());
  }

  @Test
  void initialiseJoltage() {
    final Optional<Integer> actual = EXAMPLE1.initialiseJoltage();
    assertTrue(actual.isPresent());
    assertEquals(10, actual.get());
  }
}