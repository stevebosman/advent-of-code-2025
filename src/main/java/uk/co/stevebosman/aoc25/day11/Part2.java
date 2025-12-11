package uk.co.stevebosman.aoc25.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Part2(Map<String, Node> nodes) {

  private static final String START = "svr";
  private static final String DAC = "dac";
  private static final String FFT = "fft";
  private static final String FINISH = "out";

  public static Part2 of(final Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path);
    final Map<String, Node> nodes = lines.parallelStream()
                                         .map(Node::of)
                                         .collect(Collectors.toMap(Node::id, n -> n));
    return new Part2(nodes);
  }

  public long countPathsToOut() {
    return countForRoute(DAC, FFT) + countForRoute(FFT, DAC);
  }

  private long countForRoute(final String primary, final String secondary) {
    long result = 0;
    final long startToDac = pathsToOutFrom(nodes.get(START), primary, List.of(secondary, FINISH), new HashMap<>());
    if (startToDac > 0) {
      final long dacToFft = pathsToOutFrom(nodes.get(primary), secondary, List.of(FINISH), new HashMap<>());
      if (dacToFft > 0) {
        final long fftToFinish = pathsToOutFrom(nodes.get(secondary), FINISH, List.of(primary), new HashMap<>());
        result += startToDac * dacToFft * fftToFinish;
      }
    }
    return result;
  }

  private long pathsToOutFrom(final Node node, final String finish, final List<String> ignore, final Map<Node, Long> counts) {
    long result = 0;
    for (final String id : node.connections()) {
      if (ignore.contains(id)) continue;
      if (finish.equals(id)) {
        counts.put(node, 1L);
        result++;
      } else {
        final Node nextNode = nodes.get(id);
        if (counts.containsKey(nextNode)) {
          result += counts.get(nextNode);
        } else {
          final long pathCount = pathsToOutFrom(nextNode, finish, ignore, counts);
          counts.put(nextNode, pathCount);
          result += pathCount;
        }
      }
    }
    return result;
  }

}
