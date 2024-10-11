// ExprTokenizer.java
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.util.List;

public final class ExprTokenizer {
    private ExprTokenizer() { }

    public static void main(String[] args) throws Exception {
        ExprLexer lexer = new ExprLexer(CharStreams.fromStream(System.in));
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

