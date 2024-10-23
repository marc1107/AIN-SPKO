// LLParser.java
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

public final class LLParser {
    private LLParser() { }

    private static final Reader INPUT = new InputStreamReader(System.in);

    public static void main(String[] args) throws IOException {
        e();
        System.out.printf("%ninput accepted%n");
    }

    private static void e() throws IOException {
        b();
        ee();
    }

    private static void b() throws IOException {
        int c = INPUT.read();
        switch (c) {
        case '0':
        case '1':
            match(c);
            break;
        case -1:
            error("unexpected end of input");
            break;
        default:
            error("unexpected input \'" + (char) c + '\'');
        }
    }

    private static void ee() throws IOException {
        int c = INPUT.read();
        switch (c) {
        case '*':
        case '+':
            match(c);
            b();
            ee();
            break;
        case '$':
            match(c);
            break;
        case -1:
            error("unexpected end of input");
            break;
        default:
            error("unexpected input \'" + (char) c + '\'');
        }
    }

    private static void match(int c) {
        System.out.print((char)c);
    }

    private static void error(String s) {
        System.err.printf("%nerror: %s%n", s);
        System.exit(1);
    }
}

