package uk.co.stevebosman.aoc25.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Part1(Map<String, Node> nodes) {

  public static Part1 of(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final Map<String, Node> nodes = lines.parallelStream()
                                         .map(Node::of)
                                         .collect(Collectors.toMap(Node::id, n -> n));
    return new Part1(nodes);
  }

  public int countPathsToOut() {
    final Map<Node, Integer> counts = new HashMap<>();
    return pathsToOutFrom(counts, nodes.get("you"));
  }

  private int pathsToOutFrom(final Map<Node, Integer> counts, final Node node) {
    int result = 0;
    for (final String id : node.connections()) {
      if ("out".equals(id)) {
        counts.put(node, 1);
        result++;
      } else {
        final Node nextNode = nodes.get(id);
        if (counts.containsKey(nextNode)) {
          result += counts.get(nextNode);
        } else {
          final int pathCount = pathsToOutFrom(counts, nextNode);
          counts.put(nextNode, pathCount);
          result += pathCount;
        }
      }
    }
    return result;
  }

}
