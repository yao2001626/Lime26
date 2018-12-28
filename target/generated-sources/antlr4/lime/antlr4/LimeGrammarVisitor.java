// Generated from LimeGrammar.g4 by ANTLR 4.7.2

    package lime.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LimeGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LimeGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(LimeGrammarParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(LimeGrammarParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(LimeGrammarParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#attrDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrDecl(LimeGrammarParser.AttrDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#initDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDecl(LimeGrammarParser.InitDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(LimeGrammarParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#actionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionDecl(LimeGrammarParser.ActionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(LimeGrammarParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#typedargslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedargslist(LimeGrammarParser.TypedargslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#argsdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsdef(LimeGrammarParser.ArgsdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LimeGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LimeGrammarParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(LimeGrammarParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_stmt(LimeGrammarParser.Small_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(LimeGrammarParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(LimeGrammarParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(LimeGrammarParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(LimeGrammarParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(LimeGrammarParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LimeGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(LimeGrammarParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#or_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_test(LimeGrammarParser.Or_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_test(LimeGrammarParser.And_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_test(LimeGrammarParser.Not_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(LimeGrammarParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_op(LimeGrammarParser.Comp_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(LimeGrammarParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(LimeGrammarParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LimeGrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#xor_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor_expr(LimeGrammarParser.Xor_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(LimeGrammarParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expr(LimeGrammarParser.Shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(LimeGrammarParser.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LimeGrammarParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LimeGrammarParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LimeGrammarParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#exprlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlist(LimeGrammarParser.ExprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#testlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist(LimeGrammarParser.TestlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(LimeGrammarParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(LimeGrammarParser.ArgumentContext ctx);
}