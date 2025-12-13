package uk.co.stevebosman.aoc25.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public record Part1(List<ParcelShape> parcels, List<Puzzle> puzzles) {

  public static Part1 of(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final List<ParcelShape> shapes = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      shapes.add(ParcelShape.of(lines.subList(1 + i * 5, (i + 1) * 5 - 1)));
    }
    final List<Puzzle> puzzles = new ArrayList<>();
    for (int i = 30; i < lines.size(); i++) {
      puzzles.add(Puzzle.of(lines.get(i)));
    }
    return new Part1(shapes, puzzles);
  }

  public long solvableCount() {
    return puzzles.parallelStream()
                  .filter(p -> p.isSolvable(parcels))
                  .count();
  }
}
