// ExprBuilder.java
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Stack;

/*
 * Transformiert einen ParseTree in einen abstrakten Syntaxbaum (AST).
 * Abstraktion:
 * - Weglassen der primary-Knoten und damit auch der Klammer-Tokens
 * - Weglassen von expr- und multExpr-Knoten mit nur einem Kind-Knoten
 * - einheitliche Transformation von expr- und multExpr-Knoten
 *   mit drei oder mehr Kind-Knoten
 */
public final class ExprBuilder extends ExprParserBaseListener {
    private Stack<Expr> stack = new Stack<Expr>();

    public Expr build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }

    @Override
    public void exitExpr(ExprParser.ExprContext ctx) {
        int n = ctx.getChildCount();
        if (n > 1) {
            // Operatoren von links nach rechsts berechnen
            var s = new Stack<Expr>();
            for (int i = 0; i < n; i += 2) {
                s.push(this.stack.pop());
            }
            var left = s.pop();
            for (int i = 1; i < n; i += 2) {
                String op = ctx.getChild(i).getText();
                left = new Operation(left, op, s.pop());
            }
            this.stack.push(left);
        }
    }

    @Override
    public void exitMultExpr(ExprParser.MultExprContext ctx) {
        int n = ctx.getChildCount();
        if (n > 1) {
            // Operatoren von links nach rechsts berechnen
            var s = new Stack<Expr>();
            for (int i = 0; i < n; i += 2) {
                s.push(this.stack.pop());
            }
            var left = s.pop();
            for (int i = 1; i < n; i += 2) {
                String op = ctx.getChild(i).getText();
                left = new Operation(left, op, s.pop());
            }
            this.stack.push(left);
        }
    }

    @Override
    public void exitValue(ExprParser.ValueContext ctx) {
        String s = ctx.Number().getText();
        switch (ctx.getStart().getType()) {
        case ExprLexer.PLUS:
            s = ctx.PLUS().getText() + s;
            break;
        case ExprLexer.MINUS:
            s = ctx.MINUS().getText() + s;
            break;
        }

        this.stack.push(new Value(s));
    }
}

