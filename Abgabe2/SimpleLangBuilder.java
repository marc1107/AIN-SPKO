import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimpleLangBuilder extends SimpleLangParserBaseListener {
    private final Stack<ASTNode> stack = new Stack<>();

    public ASTNode build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }

    @Override
    public void exitDeclaration(SimpleLangParser.DeclarationContext ctx) {
        String id = ctx.ID().getText();
        ExpressionNode expr = (ExpressionNode) this.stack.pop();
        this.stack.push(new DeclarationNode(id, expr));
    }

    @Override
    public void exitPrintStatement(SimpleLangParser.PrintStatementContext ctx) {
        ExpressionNode expr = (ExpressionNode) this.stack.pop();
        this.stack.push(new PrintNode(expr));
    }

    @Override
    public void exitIfStatement(SimpleLangParser.IfStatementContext ctx) {
        // List to hold else branch statements, if present
        List<StatementNode> elseBranch = new ArrayList<>();
        if (ctx.ELSE() != null) {
            // Access statements in the else branch
            for (SimpleLangParser.StatementContext stmtCtx : ctx.statement().subList(1, ctx.statement().size())) {
                elseBranch.add(0, (StatementNode) this.stack.pop());
            }
        }

        // List to hold then branch statements
        List<StatementNode> thenBranch = new ArrayList<>();
        for (SimpleLangParser.StatementContext stmtCtx : ctx.statement().subList(0, 1)) {
            thenBranch.add(0, (StatementNode) this.stack.pop());
        }

        // Pop condition expression from stack
        ComparisonNode condition = (ComparisonNode) this.stack.pop();

        // Push new IfNode onto stack
        this.stack.push(new IfNode(condition, thenBranch, elseBranch));
    }

    @Override
    public void exitExpression(SimpleLangParser.ExpressionContext ctx) {
        if (ctx.children.size() == 1) { // ID or NUMBER
            if (ctx.ID() != null) {
                this.stack.push(new IdentifierNode(ctx.ID().getText()));
            } else if (ctx.NUMBER() != null) {
                this.stack.push(new NumberNode(Integer.parseInt(ctx.NUMBER().getText())));
            }
        } else if (ctx.children.size() == 3) { // Binary operation
            ExpressionNode right = (ExpressionNode) this.stack.pop();
            ExpressionNode left = (ExpressionNode) this.stack.pop();
            String operator = ctx.getChild(1).getText();
            this.stack.push(new BinaryOperationNode(left, operator, right));
        }
    }

    @Override
    public void exitComparison(SimpleLangParser.ComparisonContext ctx) {
        ExpressionNode right = (ExpressionNode) this.stack.pop();
        ExpressionNode left = (ExpressionNode) this.stack.pop();
        String operator = ctx.getChild(1).getText();
        this.stack.push(new ComparisonNode(left, operator, right));
    }

    @Override
    public void exitProgram(SimpleLangParser.ProgramContext ctx) {
        List<StatementNode> statements = new ArrayList<>();
        int statementCount = ctx.statement().size();
        for (int i = 0; i < statementCount; i++) {
            statements.add(0, (StatementNode) this.stack.pop());
        }
        this.stack.push(new ProgramNode(statements));
    }
}

// Abstrakte Basisklasse für alle AST-Knoten
abstract class ASTNode {}

// Klasse für Programm
class ProgramNode extends ASTNode {
    List<StatementNode> statements;

    ProgramNode(List<StatementNode> statements) {
        this.statements = statements;
    }

    public String toString() {
        return statements.toString();
    }
}

// Abstrakte Basisklasse für Anweisungen
abstract class StatementNode extends ASTNode {}

// Klasse für Variablendeklarationen
class DeclarationNode extends StatementNode {
    String id;
    ExpressionNode expression;

    DeclarationNode(String id, ExpressionNode expression) {
        this.id = id;
        this.expression = expression;
    }

    public String toString() {
        return id + " = " + expression;
    }
}

// Klasse für Druckanweisungen
class PrintNode extends StatementNode {
    ExpressionNode expression;

    PrintNode(ExpressionNode expression) {
        this.expression = expression;
    }

    public String toString() {
        return String.format("print(%s)", this.expression);
    }
}

// Klasse für If-Anweisungen
class IfNode extends StatementNode {
    ExpressionNode condition;
    List<StatementNode> thenBranch;
    List<StatementNode> elseBranch;

    IfNode(ExpressionNode condition, List<StatementNode> thenBranch, List<StatementNode> elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(this.condition).append(") {\n");
        for (StatementNode stmt : this.thenBranch) {
            sb.append("  ").append(stmt).append("\n");
        }
        sb.append("}");
        if (!this.elseBranch.isEmpty()) {
            sb.append(" else {\n");
            for (StatementNode stmt : this.elseBranch) {
                sb.append("  ").append(stmt).append("\n");
            }
            sb.append("}");
        }
        return sb.toString();
    }
}

// Abstrakte Basisklasse für Ausdrücke
abstract class ExpressionNode extends ASTNode {}

// Klassen für verschiedene Ausdruckstypen
class IdentifierNode extends ExpressionNode {
    String name;

    IdentifierNode(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

class ComparisonNode extends ExpressionNode {
    private final ExpressionNode left;
    private final String operator;
    private final ExpressionNode right;

    public ComparisonNode(ExpressionNode left, String operator, ExpressionNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public String toString() {
        return String.format("(%s %s %s)", this.left, this.operator, this.right);
    }
}

class NumberNode extends ExpressionNode {
    int value;

    NumberNode(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

class BinaryOperationNode extends ExpressionNode {
    ExpressionNode left;
    String operator;
    ExpressionNode right;

    BinaryOperationNode(ExpressionNode left, String operator, ExpressionNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public String toString() {
        return String.format("(%s %s %s)", this.left, this.operator, this.right);
    }
}
