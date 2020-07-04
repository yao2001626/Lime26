// Generated from LimeGrammar.g4 by ANTLR 4.4

    package lime.antlr4;

import org.antlr.v4.runtime.misc.NotNull;
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
	 * Visit a parse tree produced by {@link LimeGrammarParser#single_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_assign(@NotNull LimeGrammarParser.Single_assignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardatomint}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardatomint(@NotNull LimeGrammarParser.GuardatomintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexpr(@NotNull LimeGrammarParser.AddexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull LimeGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(@NotNull LimeGrammarParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(@NotNull LimeGrammarParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#localDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDecl(@NotNull LimeGrammarParser.LocalDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull LimeGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(@NotNull LimeGrammarParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenexpr(@NotNull LimeGrammarParser.ParenexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getRand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetRand(@NotNull LimeGrammarParser.GetRandContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#id_ele}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_ele(@NotNull LimeGrammarParser.Id_eleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(@NotNull LimeGrammarParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotexpr(@NotNull LimeGrammarParser.NotexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#initDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDecl(@NotNull LimeGrammarParser.InitDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(@NotNull LimeGrammarParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayElementmethodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElementmethodcall(@NotNull LimeGrammarParser.ArrayElementmethodcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(@NotNull LimeGrammarParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(@NotNull LimeGrammarParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code userDefined}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefined(@NotNull LimeGrammarParser.UserDefinedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getArg}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetArg(@NotNull LimeGrammarParser.GetArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(@NotNull LimeGrammarParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardorexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardorexpr(@NotNull LimeGrammarParser.GuardorexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardparen}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardparen(@NotNull LimeGrammarParser.GuardparenContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#else_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_stat(@NotNull LimeGrammarParser.Else_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#arrayElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElement(@NotNull LimeGrammarParser.ArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(@NotNull LimeGrammarParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#multi_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti_assign(@NotNull LimeGrammarParser.Multi_assignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexpr(@NotNull LimeGrammarParser.OrexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull LimeGrammarParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(@NotNull LimeGrammarParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#typeparslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeparslist(@NotNull LimeGrammarParser.TypeparslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(@NotNull LimeGrammarParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#elif_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif_stat(@NotNull LimeGrammarParser.Elif_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardatomid}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardatomid(@NotNull LimeGrammarParser.GuardatomidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompexpr(@NotNull LimeGrammarParser.CompexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(@NotNull LimeGrammarParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(@NotNull LimeGrammarParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_stmt(@NotNull LimeGrammarParser.Small_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodcall(@NotNull LimeGrammarParser.MethodcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpr(@NotNull LimeGrammarParser.MultexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#importstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportstmt(@NotNull LimeGrammarParser.ImportstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(@NotNull LimeGrammarParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#actionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionDecl(@NotNull LimeGrammarParser.ActionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(@NotNull LimeGrammarParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(@NotNull LimeGrammarParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardatomnot}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardatomnot(@NotNull LimeGrammarParser.GuardatomnotContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#classDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecls(@NotNull LimeGrammarParser.ClassDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#importStmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmts(@NotNull LimeGrammarParser.ImportStmtsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqexpr(@NotNull LimeGrammarParser.EqexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardandexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardandexpr(@NotNull LimeGrammarParser.GuardandexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusexpr(@NotNull LimeGrammarParser.UnaryMinusexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#thisEle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisEle(@NotNull LimeGrammarParser.ThisEleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code guardcompexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardcompexpr(@NotNull LimeGrammarParser.GuardcompexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setRand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRand(@NotNull LimeGrammarParser.SetRandContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(@NotNull LimeGrammarParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpr(@NotNull LimeGrammarParser.AndexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#parsdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsdef(@NotNull LimeGrammarParser.ParsdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull LimeGrammarParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#arrayCreate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreate(@NotNull LimeGrammarParser.ArrayCreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#type_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_list(@NotNull LimeGrammarParser.Type_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull LimeGrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomexpr(@NotNull LimeGrammarParser.AtomexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(@NotNull LimeGrammarParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull LimeGrammarParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewcall(@NotNull LimeGrammarParser.NewcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LimeGrammarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull LimeGrammarParser.StmtContext ctx);
}