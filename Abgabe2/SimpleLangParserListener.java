// Generated from SimpleLangParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLangParser}.
 */
public interface SimpleLangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SimpleLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SimpleLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimpleLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimpleLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(SimpleLangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(SimpleLangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(SimpleLangParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(SimpleLangParser.ComparisonContext ctx);
}