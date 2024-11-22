import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.stream.Collectors;

public final class Functional {
    private Functional() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Paths.get(args[0]);
        var lines = new LinkedList<String>();

        long start = System.nanoTime();

        readLines(Files.newBufferedReader(input), lines);
        removeEmptyLines(lines);
        removeShortLines(lines);
        int n = totalLineLengths(lines);

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

    private static void readLines(BufferedReader reader, LinkedList<String> lines) {
        lines.addAll(reader.lines().toList());
    }

    private static void removeEmptyLines(LinkedList<String> lines) {
        var filtered = lines.stream()
                .filter(line -> !line.trim().isEmpty())
                .collect(Collectors.toCollection(LinkedList::new));

        lines.clear();
        lines.addAll(filtered);
    }

    private static void removeShortLines(LinkedList<String> lines) {
        var filtered = lines.stream()
                .filter(line -> line.length() >= MIN_LENGTH)
                .collect(Collectors.toCollection(LinkedList::new));

        lines.clear();
        lines.addAll(filtered);
    }

    private static int totalLineLengths(LinkedList<String> lines) {
        return lines.stream()
                .mapToInt(String::length)
                .sum();
    }
}