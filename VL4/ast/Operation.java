// Operation.java
public final class Operation extends Expr {
    public final Expr left;
    public final String op;
    public final Expr right;

    // Aufruf des Konstruktors nur in ExprBuilder
    Operation(Expr left, String op, Expr right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public String getOperation() {
        return this.op;
    }

    @Override
    public String toString() {
        return "(" + this.left + this.op + this.right + ")";
    }
}

