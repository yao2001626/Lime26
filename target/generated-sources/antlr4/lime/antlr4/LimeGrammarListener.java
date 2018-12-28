// Generated from LimeGrammar.g4 by ANTLR 4.7.2

    package lime.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LimeGrammarParser}.
 */
public interface LimeGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(LimeGrammarParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(LimeGrammarParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(LimeGrammarParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(LimeGrammarParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(LimeGrammarParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(LimeGrammarParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#attrDecl}.
	 * @param ctx the parse tree
	 */
	void enterAttrDecl(LimeGrammarParser.AttrDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#attrDecl}.
	 * @param ctx the parse tree
	 */
	void exitAttrDecl(LimeGrammarParser.AttrDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void enterInitDecl(LimeGrammarParser.InitDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void exitInitDecl(LimeGrammarParser.InitDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(LimeGrammarParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(LimeGrammarParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#actionDecl}.
	 * @param ctx the parse tree
	 */
	void enterActionDecl(LimeGrammarParser.ActionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#actionDecl}.
	 * @param ctx the parse tree
	 */
	void exitActionDecl(LimeGrammarParser.ActionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(LimeGrammarParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(LimeGrammarParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#typedargslist}.
	 * @param ctx the parse tree
	 */
	void enterTypedargslist(LimeGrammarParser.TypedargslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#typedargslist}.
	 * @param ctx the parse tree
	 */
	void exitTypedargslist(LimeGrammarParser.TypedargslistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#argsdef}.
	 * @param ctx the parse tree
	 */
	void enterArgsdef(LimeGrammarParser.ArgsdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#argsdef}.
	 * @param ctx the parse tree
	 */
	void exitArgsdef(LimeGrammarParser.ArgsdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LimeGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LimeGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LimeGrammarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LimeGrammarParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(LimeGrammarParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(LimeGrammarParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSmall_stmt(LimeGrammarParser.Small_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSmall_stmt(LimeGrammarParser.Small_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(LimeGrammarParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(LimeGrammarParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(LimeGrammarParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(LimeGrammarParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(LimeGrammarParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(LimeGrammarParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(LimeGrammarParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(LimeGrammarParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(LimeGrammarParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(LimeGrammarParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LimeGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LimeGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(LimeGrammarParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(LimeGrammarParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#or_test}.
	 * @param ctx the parse tree
	 */
	void enterOr_test(LimeGrammarParser.Or_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#or_test}.
	 * @param ctx the parse tree
	 */
	void exitOr_test(LimeGrammarParser.Or_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAnd_test(LimeGrammarParser.And_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAnd_test(LimeGrammarParser.And_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNot_test(LimeGrammarParser.Not_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNot_test(LimeGrammarParser.Not_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(LimeGrammarParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(LimeGrammarParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(LimeGrammarParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(LimeGrammarParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(LimeGrammarParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(LimeGrammarParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(LimeGrammarParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(LimeGrammarParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LimeGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LimeGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#xor_expr}.
	 * @param ctx the parse tree
	 */
	void enterXor_expr(LimeGrammarParser.Xor_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#xor_expr}.
	 * @param ctx the parse tree
	 */
	void exitXor_expr(LimeGrammarParser.Xor_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(LimeGrammarParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(LimeGrammarParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#shift_expr}.
	 * @param ctx the parse tree
	 */
	void enterShift_expr(LimeGrammarParser.Shift_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#shift_expr}.
	 * @param ctx the parse tree
	 */
	void exitShift_expr(LimeGrammarParser.Shift_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArith_expr(LimeGrammarParser.Arith_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArith_expr(LimeGrammarParser.Arith_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LimeGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LimeGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LimeGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LimeGrammarParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(LimeGrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(LimeGrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void enterExprlist(LimeGrammarParser.ExprlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void exitExprlist(LimeGrammarParser.ExprlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#testlist}.
	 * @param ctx the parse tree
	 */
	void enterTestlist(LimeGrammarParser.TestlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#testlist}.
	 * @param ctx the parse tree
	 */
	void exitTestlist(LimeGrammarParser.TestlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(LimeGrammarParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(LimeGrammarParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(LimeGrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(LimeGrammarParser.ArgumentContext ctx);
}