import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;

public class SimpleLangBuilder extends SimpleLangParserBaseListener {
    private final Stack<ASTNode> stack = new Stack<>();

    private Map<String, String> symbolTable = new HashMap<>();

    private void semanticErr(Token token, String message) {
        System.err.printf("Line %d:%d - %s%n", token.getLine(), token.getCharPositionInLine(), message);
    }

    public ASTNode build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }

    @Override
    public void exitDeclaration(SimpleLangParser.DeclarationContext ctx) {
        String id = ctx.ID().getText();

        // Check if the identifier is already declared
        if (this.symbolTable.containsKey(id)) {
            this.semanticErr(ctx.ID().getSymbol(), String.format("Identifier '%s' is already declared.", id));
        } else if (ctx.expression().NUMBER() != null) {
            this.symbolTable.put(id, "number");
        } else if (ctx.expression().STRING() != null) {
            this.symbolTable.put(id, "string");
        }

        ExpressionNode expr = (ExpressionNode) this.stack.pop();
        this.stack.push(new DeclarationNode(id, expr));
    }

    @Override
    public void exitAssignment(SimpleLangParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();

        // Check if the identifier is declared
        if (!this.symbolTable.containsKey(id)) {
            this.semanticErr(ctx.ID().getSymbol(), String.format("Identifier '%s' is not declared.", id));
        }

        if (this.symbolTable.get(id).equals("number") && ctx.expression().STRING() != null) {
            symbolTable.put(id, "string");
        } else if (this.symbolTable.get(id).equals("string") && ctx.expression().NUMBER() != null) {
            symbolTable.put(id, "number");
        }

        ExpressionNode expr = (ExpressionNode) this.stack.pop();
        this.stack.push(new AssignmentNode(id, expr));
    }

    @Override
    public void exitPrintStatement(SimpleLangParser.PrintStatementContext ctx) {
        ExpressionNode expr = (ExpressionNode) this.stack.pop();
        this.stack.push(new PrintNode(expr));
    }

    @Override
    public void exitIfStatement(SimpleLangParser.IfStatementContext ctx) {
        List<StatementNode> elseBranch = new ArrayList<>();
        if (ctx.ELSE() != null) {
            for (SimpleLangParser.StatementContext stmtCtx : ctx.statement().subList(1, ctx.statement().size())) {
                elseBranch.addFirst((StatementNode) this.stack.pop());
            }
        }

        List<StatementNode> thenBranch = new ArrayList<>();
        for (SimpleLangParser.StatementContext stmtCtx : ctx.statement().subList(0, 1)) {
            thenBranch.addFirst((StatementNode) this.stack.pop());
        }

        ComparisonNode condition = (ComparisonNode) this.stack.pop();

        this.stack.push(new IfNode(condition, thenBranch, elseBranch));
    }

    @Override
    public void exitExpression(SimpleLangParser.ExpressionContext ctx) {
        if (ctx.children.size() == 1) {
            if (ctx.ID() != null) {
                // Check if the identifier is declared
                String id = ctx.ID().getText();
                if (!this.symbolTable.containsKey(id)) {
                    this.semanticErr(ctx.ID().getSymbol(), String.format("Identifier '%s' is not declared.", id));
                }

                this.stack.push(new IdentifierNode(ctx.ID().getText()));
            } else if (ctx.NUMBER() != null) {
                this.stack.push(new NumberNode(Integer.parseInt(ctx.NUMBER().getText())));
            } else if (ctx.STRING() != null) {
                this.stack.push(new StringNode(ctx.STRING().getText()));
            }
        } else if (ctx.children.size() == 3) {
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

        // Check if both expression nodes are of the same type
        String leftType = getExpressionNodeType(left);
        String rightType = getExpressionNodeType(right);

        if (!leftType.equals(rightType)) {
            this.semanticErr(ctx.start, "Type mismatch: cannot compare " + leftType + " with " + rightType);
        }

        this.stack.push(new ComparisonNode(left, operator, right));
    }

    private String getExpressionNodeType(ExpressionNode node) {
        String leftType = switch (node.getClass().getName()) {
            case "NumberNode" -> "number";
            case "StringNode" -> "string";
            case "IdentifierNode" -> {
                String id = ((IdentifierNode) node).name;
                yield this.symbolTable.get(id);
            }
            default -> "unknown";
        };
        return leftType;
    }

    @Override
    public void exitProgram(SimpleLangParser.ProgramContext ctx) {
        List<StatementNode> statements = new ArrayList<>();
        int statementCount = ctx.statement().size();
        for (int i = 0; i < statementCount; i++) {
            statements.addFirst((StatementNode) this.stack.pop());
        }
        this.stack.push(new ProgramNode(statements));
    }
}

abstract class ASTNode {}

class ProgramNode extends ASTNode {
    List<StatementNode> statements;

    ProgramNode(List<StatementNode> statements) {
        this.statements = statements;
    }

    public String toString() {
        return "Program(" + statements.toString() + ")";
    }
}

abstract class StatementNode extends ASTNode {}

class DeclarationNode extends StatementNode {
    String id;
    ExpressionNode expression;

    DeclarationNode(String id, ExpressionNode expression) {
        this.id = id;
        this.expression = expression;
    }

    public String toString() {
        return String.format("\nDeclaration('%s', %s", id, expression);
    }
}

class AssignmentNode extends StatementNode {
    String id;
    ExpressionNode expression;

    AssignmentNode(String id, ExpressionNode expression) {
        this.id = id;
        this.expression = expression;
    }

    public String toString() {
        return String.format("Assignment('%s', %s)", id, expression);
    }
}

class PrintNode extends StatementNode {
    ExpressionNode expression;

    PrintNode(ExpressionNode expression) {
        this.expression = expression;
    }

    public String toString() {
        return String.format("Print(%s)", this.expression);
    }
}

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
        sb.append("\nIf(\n\t").append(this.condition).append(",\n\tThen(");
        for (StatementNode stmt : this.thenBranch) {
            sb.append("\n\t\t").append(stmt).append(",");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        sb.append("\n\t)");
        if (!this.elseBranch.isEmpty()) {
            sb.append(",\n\tElse(");
            for (StatementNode stmt : this.elseBranch) {
                sb.append("\n\t\t").append(stmt).append(",");
            }
            sb.replace(sb.length() - 1, sb.length(), "");
            sb.append("\n\t)");
        }
        sb.append("\n)");
        return sb.toString();
    }
}

abstract class ExpressionNode extends ASTNode {}

class IdentifierNode extends ExpressionNode {
    String name;

    IdentifierNode(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("Identifier(%s)", this.name);
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
        return String.format("Comparison('%s', '%s', '%s')", this.left, this.operator, this.right);
    }
}

class NumberNode extends ExpressionNode {
    int value;

    NumberNode(int value) {
        this.value = value;
    }

    public String toString() {
        return String.format("Number(%s)", this.value);
    }
}

class StringNode extends ExpressionNode {
    String value;

    StringNode(String value) {
        this.value = value;
    }

    public String toString() {
        return String.format("String(%s)", this.value);
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
        return String.format("BinaryOperation('%s', '%s', '%s')", this.left, this.operator, this.right);
    }
}
