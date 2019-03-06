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
	 * Enter a parse tree produced by {@link LimeGrammarParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(LimeGrammarParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(LimeGrammarParser.FieldDeclContext ctx);
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
	 * Enter a parse tree produced by {@link LimeGrammarParser#typeparslist}.
	 * @param ctx the parse tree
	 */
	void enterTypeparslist(LimeGrammarParser.TypeparslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#typeparslist}.
	 * @param ctx the parse tree
	 */
	void exitTypeparslist(LimeGrammarParser.TypeparslistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#parsdef}.
	 * @param ctx the parse tree
	 */
	void enterParsdef(LimeGrammarParser.ParsdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#parsdef}.
	 * @param ctx the parse tree
	 */
	void exitParsdef(LimeGrammarParser.ParsdefContext ctx);
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
	 * Enter a parse tree produced by {@link LimeGrammarParser#multi_assign}.
	 * @param ctx the parse tree
	 */
	void enterMulti_assign(LimeGrammarParser.Multi_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#multi_assign}.
	 * @param ctx the parse tree
	 */
	void exitMulti_assign(LimeGrammarParser.Multi_assignContext ctx);
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
	 * Enter a parse tree produced by {@link LimeGrammarParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalDecl(LimeGrammarParser.LocalDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalDecl(LimeGrammarParser.LocalDeclContext ctx);
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
	 * Enter a parse tree produced by {@link LimeGrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(LimeGrammarParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(LimeGrammarParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#elif_stat}.
	 * @param ctx the parse tree
	 */
	void enterElif_stat(LimeGrammarParser.Elif_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#elif_stat}.
	 * @param ctx the parse tree
	 */
	void exitElif_stat(LimeGrammarParser.Elif_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#else_stat}.
	 * @param ctx the parse tree
	 */
	void enterElse_stat(LimeGrammarParser.Else_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#else_stat}.
	 * @param ctx the parse tree
	 */
	void exitElse_stat(LimeGrammarParser.Else_statContext ctx);
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
	 * Enter a parse tree produced by the {@code guardcompexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardcompexpr(LimeGrammarParser.GuardcompexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardcompexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardcompexpr(LimeGrammarParser.GuardcompexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardeqexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardeqexpr(LimeGrammarParser.GuardeqexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardeqexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardeqexpr(LimeGrammarParser.GuardeqexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardandexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardandexpr(LimeGrammarParser.GuardandexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardandexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardandexpr(LimeGrammarParser.GuardandexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardorexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardorexpr(LimeGrammarParser.GuardorexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardorexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardorexpr(LimeGrammarParser.GuardorexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardatomexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardatomexpr(LimeGrammarParser.GuardatomexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardatomexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardatomexpr(LimeGrammarParser.GuardatomexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void enterIdguardatom(LimeGrammarParser.IdguardatomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void exitIdguardatom(LimeGrammarParser.IdguardatomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void enterIntguardatom(LimeGrammarParser.IntguardatomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void exitIntguardatom(LimeGrammarParser.IntguardatomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notguardtom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void enterNotguardtom(LimeGrammarParser.NotguardtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notguardtom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void exitNotguardtom(LimeGrammarParser.NotguardtomContext ctx);
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
	 * Enter a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqexpr(LimeGrammarParser.EqexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqexpr(LimeGrammarParser.EqexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotexpr(LimeGrammarParser.NotexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotexpr(LimeGrammarParser.NotexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultexpr(LimeGrammarParser.MultexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultexpr(LimeGrammarParser.MultexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompexpr(LimeGrammarParser.CompexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompexpr(LimeGrammarParser.CompexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusexpr(LimeGrammarParser.UnaryMinusexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusexpr(LimeGrammarParser.UnaryMinusexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddexpr(LimeGrammarParser.AddexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddexpr(LimeGrammarParser.AddexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomexpr(LimeGrammarParser.AtomexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomexpr(LimeGrammarParser.AtomexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrexpr(LimeGrammarParser.OrexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrexpr(LimeGrammarParser.OrexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(LimeGrammarParser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(LimeGrammarParser.AndexprContext ctx);
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
	 * Enter a parse tree produced by the {@code newcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterNewcall(LimeGrammarParser.NewcallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitNewcall(LimeGrammarParser.NewcallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethodcall(LimeGrammarParser.MethodcallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethodcall(LimeGrammarParser.MethodcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(LimeGrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(LimeGrammarParser.ArgsContext ctx);
}