package uk.co.stevebosman.aoc25.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTest {

  @Test
  void of() {
    assertEquals(new Node("a", List.of("b", "c")), Node.of("a: b c"));
  }
}