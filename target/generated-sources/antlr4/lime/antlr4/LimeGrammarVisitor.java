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
	 * Visit a parse tree produced by {@link LimeGrammarParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(LimeGrammarParser.FieldDeclContext ctx);
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
	 * Visit a parse tree produced by {@link LimeGrammarParser#typeparslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeparslist(LimeGrammarParser.TypeparslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#parsdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsdef(LimeGrammarParser.ParsdefContext ctx);
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
	 * Visit a parse tree produced by {@link LimeGrammarParser#localDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDecl(LimeGrammarParser.LocalDeclContext ctx);
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
	 * Visit a parse tree produced by {@link LimeGrammarParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(LimeGrammarParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#elif_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif_stat(LimeGrammarParser.Elif_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#else_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_stat(LimeGrammarParser.Else_statContext ctx);
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
	 * Visit a parse tree produced by the {@code guardcompexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardcompexpr(LimeGrammarParser.GuardcompexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardeqexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardeqexpr(LimeGrammarParser.GuardeqexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardandexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardandexpr(LimeGrammarParser.GuardandexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardorexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardorexpr(LimeGrammarParser.GuardorexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardatomexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardatomexpr(LimeGrammarParser.GuardatomexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdguardatom(LimeGrammarParser.IdguardatomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntguardatom(LimeGrammarParser.IntguardatomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notguardtom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotguardtom(LimeGrammarParser.NotguardtomContext ctx);
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
	 * Visit a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqexpr(LimeGrammarParser.EqexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotexpr(LimeGrammarParser.NotexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpr(LimeGrammarParser.MultexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompexpr(LimeGrammarParser.CompexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusexpr(LimeGrammarParser.UnaryMinusexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexpr(LimeGrammarParser.AddexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomexpr(LimeGrammarParser.AtomexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexpr(LimeGrammarParser.OrexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpr(LimeGrammarParser.AndexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LimeGrammarParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewcall(LimeGrammarParser.NewcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodcall(LimeGrammarParser.MethodcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(LimeGrammarParser.ArgsContext ctx);
}