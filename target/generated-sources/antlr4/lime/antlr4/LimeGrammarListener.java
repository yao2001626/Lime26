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
	 * Enter a parse tree produced by the {@code notguardtom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void enterNotguardtom(@NotNull LimeGrammarParser.NotguardtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notguardtom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void exitNotguardtom(@NotNull LimeGrammarParser.NotguardtomContext ctx);
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
	 * Enter a parse tree produced by the {@code rand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterRand(@NotNull LimeGrammarParser.RandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rand}
	 * labeled alternative in {@link LimeGrammarParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitRand(@NotNull LimeGrammarParser.RandContext ctx);
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
	 * Enter a parse tree produced by the {@code intguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void enterIntguardatom(@NotNull LimeGrammarParser.IntguardatomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void exitIntguardatom(@NotNull LimeGrammarParser.IntguardatomContext ctx);
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
	 * Enter a parse tree produced by {@link LimeGrammarParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(@NotNull LimeGrammarParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LimeGrammarParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(@NotNull LimeGrammarParser.Import_stmtContext ctx);
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
	 * Enter a parse tree produced by the {@code guardatomexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardatomexpr(@NotNull LimeGrammarParser.GuardatomexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardatomexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardatomexpr(@NotNull LimeGrammarParser.GuardatomexprContext ctx);
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
	 * Enter a parse tree produced by the {@code idguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void enterIdguardatom(@NotNull LimeGrammarParser.IdguardatomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idguardatom}
	 * labeled alternative in {@link LimeGrammarParser#guardAtom}.
	 * @param ctx the parse tree
	 */
	void exitIdguardatom(@NotNull LimeGrammarParser.IdguardatomContext ctx);
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
	/**
	 * Enter a parse tree produced by the {@code guardeqexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuardeqexpr(@NotNull LimeGrammarParser.GuardeqexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code guardeqexpr}
	 * labeled alternative in {@link LimeGrammarParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuardeqexpr(@NotNull LimeGrammarParser.GuardeqexprContext ctx);
}