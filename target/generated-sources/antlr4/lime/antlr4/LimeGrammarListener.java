// Generated from LimeGrammar.g4 by ANTLR 4.4

    package lime.antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LimeGrammarParser}.
 */
public interface LimeGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#single_assign}.
	 * @param ctx the parse tree
	 */
	void enterSingle_assign(@NotNull LimeGrammarParser.Single_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#single_assign}.
	 * @param ctx the parse tree
	 */
	void exitSingle_assign(@NotNull LimeGrammarParser.Single_assignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardatomint}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardatomint(@NotNull LimeGrammarParser.GuardatomintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardatomint}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardatomint(@NotNull LimeGrammarParser.GuardatomintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddexpr(@NotNull LimeGrammarParser.AddexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddexpr(@NotNull LimeGrammarParser.AddexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull LimeGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull LimeGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(@NotNull LimeGrammarParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(@NotNull LimeGrammarParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(@NotNull LimeGrammarParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(@NotNull LimeGrammarParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalDecl(@NotNull LimeGrammarParser.LocalDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalDecl(@NotNull LimeGrammarParser.LocalDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull LimeGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull LimeGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(@NotNull LimeGrammarParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(@NotNull LimeGrammarParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenexpr(@NotNull LimeGrammarParser.ParenexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenexpr(@NotNull LimeGrammarParser.ParenexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getRand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterGetRand(@NotNull LimeGrammarParser.GetRandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getRand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitGetRand(@NotNull LimeGrammarParser.GetRandContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#id_ele}.
	 * @param ctx the parse tree
	 */
	void enterId_ele(@NotNull LimeGrammarParser.Id_eleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#id_ele}.
	 * @param ctx the parse tree
	 */
	void exitId_ele(@NotNull LimeGrammarParser.Id_eleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(@NotNull LimeGrammarParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(@NotNull LimeGrammarParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotexpr(@NotNull LimeGrammarParser.NotexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotexpr(@NotNull LimeGrammarParser.NotexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void enterInitDecl(@NotNull LimeGrammarParser.InitDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void exitInitDecl(@NotNull LimeGrammarParser.InitDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(@NotNull LimeGrammarParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(@NotNull LimeGrammarParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayElementmethodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterArrayElementmethodcall(@NotNull LimeGrammarParser.ArrayElementmethodcallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayElementmethodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitArrayElementmethodcall(@NotNull LimeGrammarParser.ArrayElementmethodcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(@NotNull LimeGrammarParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(@NotNull LimeGrammarParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(@NotNull LimeGrammarParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(@NotNull LimeGrammarParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code userDefined}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterUserDefined(@NotNull LimeGrammarParser.UserDefinedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code userDefined}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitUserDefined(@NotNull LimeGrammarParser.UserDefinedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getArg}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterGetArg(@NotNull LimeGrammarParser.GetArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getArg}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitGetArg(@NotNull LimeGrammarParser.GetArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(@NotNull LimeGrammarParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(@NotNull LimeGrammarParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardorexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardorexpr(@NotNull LimeGrammarParser.GuardorexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardorexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardorexpr(@NotNull LimeGrammarParser.GuardorexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardparen}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardparen(@NotNull LimeGrammarParser.GuardparenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardparen}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardparen(@NotNull LimeGrammarParser.GuardparenContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#else_stat}.
	 * @param ctx the parse tree
	 */
	void enterElse_stat(@NotNull LimeGrammarParser.Else_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#else_stat}.
	 * @param ctx the parse tree
	 */
	void exitElse_stat(@NotNull LimeGrammarParser.Else_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayElement(@NotNull LimeGrammarParser.ArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayElement(@NotNull LimeGrammarParser.ArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(@NotNull LimeGrammarParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(@NotNull LimeGrammarParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#multi_assign}.
	 * @param ctx the parse tree
	 */
	void enterMulti_assign(@NotNull LimeGrammarParser.Multi_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#multi_assign}.
	 * @param ctx the parse tree
	 */
	void exitMulti_assign(@NotNull LimeGrammarParser.Multi_assignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrexpr(@NotNull LimeGrammarParser.OrexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrexpr(@NotNull LimeGrammarParser.OrexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull LimeGrammarParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull LimeGrammarParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(@NotNull LimeGrammarParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(@NotNull LimeGrammarParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#typeparslist}.
	 * @param ctx the parse tree
	 */
	void enterTypeparslist(@NotNull LimeGrammarParser.TypeparslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#typeparslist}.
	 * @param ctx the parse tree
	 */
	void exitTypeparslist(@NotNull LimeGrammarParser.TypeparslistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(@NotNull LimeGrammarParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(@NotNull LimeGrammarParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#elif_stat}.
	 * @param ctx the parse tree
	 */
	void enterElif_stat(@NotNull LimeGrammarParser.Elif_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#elif_stat}.
	 * @param ctx the parse tree
	 */
	void exitElif_stat(@NotNull LimeGrammarParser.Elif_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardatomid}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardatomid(@NotNull LimeGrammarParser.GuardatomidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardatomid}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardatomid(@NotNull LimeGrammarParser.GuardatomidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompexpr(@NotNull LimeGrammarParser.CompexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompexpr(@NotNull LimeGrammarParser.CompexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(@NotNull LimeGrammarParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(@NotNull LimeGrammarParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(@NotNull LimeGrammarParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(@NotNull LimeGrammarParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSmall_stmt(@NotNull LimeGrammarParser.Small_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSmall_stmt(@NotNull LimeGrammarParser.Small_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethodcall(@NotNull LimeGrammarParser.MethodcallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethodcall(@NotNull LimeGrammarParser.MethodcallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultexpr(@NotNull LimeGrammarParser.MultexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultexpr(@NotNull LimeGrammarParser.MultexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#importstmt}.
	 * @param ctx the parse tree
	 */
	void enterImportstmt(@NotNull LimeGrammarParser.ImportstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#importstmt}.
	 * @param ctx the parse tree
	 */
	void exitImportstmt(@NotNull LimeGrammarParser.ImportstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(@NotNull LimeGrammarParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(@NotNull LimeGrammarParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#actionDecl}.
	 * @param ctx the parse tree
	 */
	void enterActionDecl(@NotNull LimeGrammarParser.ActionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#actionDecl}.
	 * @param ctx the parse tree
	 */
	void exitActionDecl(@NotNull LimeGrammarParser.ActionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(@NotNull LimeGrammarParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(@NotNull LimeGrammarParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(@NotNull LimeGrammarParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(@NotNull LimeGrammarParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardatomnot}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardatomnot(@NotNull LimeGrammarParser.GuardatomnotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardatomnot}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardatomnot(@NotNull LimeGrammarParser.GuardatomnotContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#classDecls}.
	 * @param ctx the parse tree
	 */
	void enterClassDecls(@NotNull LimeGrammarParser.ClassDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#classDecls}.
	 * @param ctx the parse tree
	 */
	void exitClassDecls(@NotNull LimeGrammarParser.ClassDeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#importStmts}.
	 * @param ctx the parse tree
	 */
	void enterImportStmts(@NotNull LimeGrammarParser.ImportStmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#importStmts}.
	 * @param ctx the parse tree
	 */
	void exitImportStmts(@NotNull LimeGrammarParser.ImportStmtsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqexpr(@NotNull LimeGrammarParser.EqexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqexpr(@NotNull LimeGrammarParser.EqexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardandexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardandexpr(@NotNull LimeGrammarParser.GuardandexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardandexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardandexpr(@NotNull LimeGrammarParser.GuardandexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusexpr(@NotNull LimeGrammarParser.UnaryMinusexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusexpr(@NotNull LimeGrammarParser.UnaryMinusexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code guardcompexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardcompexpr(@NotNull LimeGrammarParser.GuardcompexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardcompexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardcompexpr(@NotNull LimeGrammarParser.GuardcompexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setRand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterSetRand(@NotNull LimeGrammarParser.SetRandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setRand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitSetRand(@NotNull LimeGrammarParser.SetRandContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(@NotNull LimeGrammarParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(@NotNull LimeGrammarParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(@NotNull LimeGrammarParser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(@NotNull LimeGrammarParser.AndexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#parsdef}.
	 * @param ctx the parse tree
	 */
	void enterParsdef(@NotNull LimeGrammarParser.ParsdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#parsdef}.
	 * @param ctx the parse tree
	 */
	void exitParsdef(@NotNull LimeGrammarParser.ParsdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(@NotNull LimeGrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(@NotNull LimeGrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#arrayCreate}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreate(@NotNull LimeGrammarParser.ArrayCreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#arrayCreate}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreate(@NotNull LimeGrammarParser.ArrayCreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#type_list}.
	 * @param ctx the parse tree
	 */
	void enterType_list(@NotNull LimeGrammarParser.Type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#type_list}.
	 * @param ctx the parse tree
	 */
	void exitType_list(@NotNull LimeGrammarParser.Type_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull LimeGrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull LimeGrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomexpr(@NotNull LimeGrammarParser.AtomexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link LimeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomexpr(@NotNull LimeGrammarParser.AtomexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(@NotNull LimeGrammarParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(@NotNull LimeGrammarParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull LimeGrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull LimeGrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterNewcall(@NotNull LimeGrammarParser.NewcallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newcall}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitNewcall(@NotNull LimeGrammarParser.NewcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LimeGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull LimeGrammarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull LimeGrammarParser.StmtContext ctx);
}