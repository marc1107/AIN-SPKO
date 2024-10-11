import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpressionTokenizer {
    public static void main(String[] args) throws IOException {
        String inputFile = "abfahrt-kn.txt";
        String input = new String(Files.readAllBytes(Paths.get(inputFile)));

        AbfahrtenLexer lexer = new AbfahrtenLexer(CharStreams.fromString(input));
        var tokens = lexer.getAllTokens();

        for (Token t : tokens) {
            if (t.getChannel() == Token.HIDDEN_CHANNEL) {
                continue;
            }
            System.out.printf(
                    "%s(\"%s\") ",
                    lexer.getVocabulary().getSymbolicName(t.getType()),
                    t.getText());
        }
        System.out.println();

        for (Token t : tokens) {
            System.out.printf(
                    "%s(\"%s\") ",
                    lexer.getVocabulary().getSymbolicName(t.getType()),
                    replaceWhitespace(t.getText()));
        }
        System.out.println();
    }

    private static String replaceWhitespace(String s) {
        return s.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }
}