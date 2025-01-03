// ExprLexer.java
public final class ExprLexer {
    public enum TokenType { NUMBER, PLUS, MINUS, MUL, DIV, LPAREN, RPAREN, WS }

    public static final class Token {
        public final TokenType type;
        public final String text;

        private Token(TokenType type, String text) {
            this.type = type; 
            this.text = text;
        }

        @Override
        public String toString() {
            return this.type + "(\"" + this.text + "\")";
        }
    }

    private char[] input;
    private int current;
    private char c;

    public ExprLexer(String input) {
        this.input = input.toCharArray();
        this.current = 0;
        this.c = this.input[0];
    }

    public Token nextToken() {
        while (this.c != '\000') {
            switch (this.c) {
            case ' ':
            case '\t':
            case '\r':
            case '\n':
                ws();
                continue;
            case '+' :
                consume();
                return new Token(TokenType.PLUS, "+");
            case '-' :
                consume();
                return new Token(TokenType.MINUS, "-");
            case '*' :
                consume();
                return new Token(TokenType.MUL, "*");
            case '/' :
                consume();
                return new Token(TokenType.DIV, "/");
            case '(' :
                consume();
                return new Token(TokenType.LPAREN, "(");
            case ')' :
                consume();
                return new Token(TokenType.RPAREN, ")");
            default:
                return number();
            }
        }

        return null;
    }

    private Token number() {
        String text = "";
        while (Character.isDigit(this.c)) {
            text += this.c;
            consume();
        }
        
        if (text.length() == 0) {
            invalid();
        }

        if (this.c == '.') {
            text += this.c;
            consume();

            if (!Character.isDigit(this.c)) {
                invalid();
            }

            do {
                text += this.c;
                consume();
            } while (Character.isDigit(this.c));
        }

        return new Token(TokenType.NUMBER, text);
    }

    private void ws() {
        char c;
        while ((c = this.input[this.current]) == ' '
               || c == '\t' || c == '\r' || c == '\n') {
            consume();
        }
    }

    private void consume() {
        ++this.current;
        if (this.current < this.input.length) {
            this.c = this.input[this.current];
        } else {
            this.c = '\000';
        }
    }
    
    private void invalid() {
        throw new RuntimeException(
              String.format("invalid character at index %d: '\\u%04x'",
                            this.current, (int) this.c));

    }
}

