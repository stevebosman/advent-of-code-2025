package uk.co.stevebosman.aoc25.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Part1 {
  public static long run(final Path path, final int limit) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final List<Point> points = Point.of(lines);
    final int numberOfPoints = points.size();
    final List<Distance> distances = new ArrayList<>();
    for (int i = 0; i < numberOfPoints; i++) {
      for (int j = i + 1; j < numberOfPoints; j++) {
        distances.add(Distance.of(points.get(i), points.get(j)));
      }
    }
    distances.sort(Comparator.comparingLong(Distance::distance));
    final List<Distance> nearest = distances.subList(0, limit);
    final List<Set<Point>> circuits = new ArrayList<>();
    for (final Distance distance : nearest) {
      final List<Set<Point>> matchingCircuits = circuits.stream()
                                                        .filter(c -> c.contains(distance.p1()) || c.contains(
                                                                distance.p2()))
                                                        .toList();
      if (matchingCircuits.isEmpty()) {
        final Set<Point> newCircuit = new HashSet<>();
        newCircuit.add(distance.p1());
        newCircuit.add(distance.p2());
        circuits.add(newCircuit);
      } else if (matchingCircuits.size() == 1) {
        final Set<Point> circuit = matchingCircuits.getFirst();
        circuit.add(distance.p1());
        circuit.add(distance.p2());
      } else if (matchingCircuits.size() == 2) {
        matchingCircuits.getFirst()
                        .addAll(matchingCircuits.getLast());
        if (!circuits.remove(matchingCircuits.getLast())) {
          throw new IllegalStateException("failed to remove circuit");
        }
      } else {
        throw new IllegalStateException("surprising number of matches");
      }
    }
    final List<Integer> sortedSizes = circuits.stream()
                                       .map(Set::size)
                                       .sorted((a, b) -> b - a)
                                       .toList();
    return (long) sortedSizes.get(0) * sortedSizes.get(1) * sortedSizes.get(2);
  }
}
