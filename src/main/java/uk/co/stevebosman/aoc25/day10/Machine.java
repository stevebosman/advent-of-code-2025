package uk.co.stevebosman.aoc25.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Machine(List<Boolean> desiredState, List<Transition> transitions, List<Integer> joltages) {
  public static Machine of(final String line) {
    final String[] parts = line.split(" ");
    final List<Boolean> states = parts[0].substring(1, parts[0].length() - 1)
                                         .chars()
                                         .mapToObj(c -> c == '#')
                                         .toList();
    final List<Transition> transitions = Arrays.stream(Arrays.copyOfRange(parts, 1, parts.length - 1))
                                               .map(Transition::of)
                                               .toList();
    final String joltageText = parts[parts.length - 1];
    final List<Integer> joltages = Arrays.stream(joltageText.substring(1, joltageText.length() - 1)
                                                            .split(","))
                                         .map(Integer::valueOf)
                                         .toList();
    return new Machine(states, transitions, joltages);
  }

  public int initialise() {
    final Map<List<Boolean>, Integer> statesEncountered = new HashMap<>();
    final List<Boolean> initialState = desiredState.stream()
                                                   .map(s -> false)
                                                   .toList();
    statesEncountered.put(initialState, 0);
    for (final Transition transition : transitions) {
      tryTransition(statesEncountered, transition, initialState, 1);
    }
    return statesEncountered.get(desiredState);
  }

  private void tryTransition(final Map<List<Boolean>, Integer> statesEncountered, final Transition transition, final List<Boolean> initialState, final int depth) {
    final List<Boolean> nextState = new ArrayList<>();
    for (int i = 0; i < initialState.size(); i++) {
      if (transition.buttons()
                    .contains(i)) {
        nextState.add(!initialState.get(i));
      } else {
        nextState.add(initialState.get(i));
      }
    }
    if (statesEncountered.containsKey(nextState) && statesEncountered.get(nextState) <= depth) return;
    statesEncountered.put(nextState, depth);
    if (nextState.equals(desiredState)) return;
    for (final Transition nextTransition : transitions) {
      tryTransition(statesEncountered, nextTransition, nextState, depth + 1);
    }
  }
}
