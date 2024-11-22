import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import java.io.BufferedReader;
import java.util.LinkedList;

public final class Procedural {
    private Procedural() { }

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

    private static void readLines(BufferedReader reader, LinkedList<String> lines) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    }

    private static void removeEmptyLines(LinkedList<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) {
                lines.remove(i);
                i--;
            }
        }
    }

    private static void removeShortLines(LinkedList<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).length() < MIN_LENGTH) {
                lines.remove(i);
                i--;
            }
        }
    }

    private static int totalLineLengths(LinkedList<String> lines) {
        int totalLength = 0;
        for (String line : lines) {
            totalLength += line.length();
        }
        return totalLength;
    }
}