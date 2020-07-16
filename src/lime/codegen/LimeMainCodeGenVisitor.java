package lime.codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import lime.antlr4.ClassSymbol;
import lime.antlr4.EnumSymbol;
import lime.antlr4.FieldSymbol;
import lime.antlr4.LimeGrammarBaseVisitor;
import lime.antlr4.LimeGrammarLexer;
import lime.antlr4.MethodSymbol;
import lime.antlr4.ParameterSymbol;
import lime.antlr4.Scope;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;
import lime.antlr4.VariableSymbol;
import lime.antlr4.LimeGrammarParser.AddexprContext;
import lime.antlr4.LimeGrammarParser.AndexprContext;
import lime.antlr4.LimeGrammarParser.ArgsContext;
import lime.antlr4.LimeGrammarParser.ArrayCreateContext;
import lime.antlr4.LimeGrammarParser.ArrayDeclContext;
import lime.antlr4.LimeGrammarParser.ArrayElementContext;
import lime.antlr4.LimeGrammarParser.ArrayElementmethodcallContext;
import lime.antlr4.LimeGrammarParser.AtomContext;
import lime.antlr4.LimeGrammarParser.AtomexprContext;
import lime.antlr4.LimeGrammarParser.BlockContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.ClassDeclsContext;
import lime.antlr4.LimeGrammarParser.ClassMemberContext;
import lime.antlr4.LimeGrammarParser.CompexprContext;
import lime.antlr4.LimeGrammarParser.CompilationUnitContext;
import lime.antlr4.LimeGrammarParser.Compound_stmtContext;
import lime.antlr4.LimeGrammarParser.Elif_statContext;
import lime.antlr4.LimeGrammarParser.Else_statContext;
import lime.antlr4.LimeGrammarParser.EqexprContext;
import lime.antlr4.LimeGrammarParser.Expr_listContext;
import lime.antlr4.LimeGrammarParser.Expr_stmtContext;
import lime.antlr4.LimeGrammarParser.FieldDeclContext;
import lime.antlr4.LimeGrammarParser.For_stmtContext;
import lime.antlr4.LimeGrammarParser.GetArgContext;
import lime.antlr4.LimeGrammarParser.GetRandContext;
import lime.antlr4.LimeGrammarParser.Id_eleContext;
import lime.antlr4.LimeGrammarParser.Id_listContext;
import lime.antlr4.LimeGrammarParser.If_statContext;
import lime.antlr4.LimeGrammarParser.If_stmtContext;
import lime.antlr4.LimeGrammarParser.ImportStmtsContext;
import lime.antlr4.LimeGrammarParser.ImportstmtContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.MethodcallContext;
import lime.antlr4.LimeGrammarParser.MultexprContext;
import lime.antlr4.LimeGrammarParser.Multi_assignContext;
import lime.antlr4.LimeGrammarParser.NewcallContext;
import lime.antlr4.LimeGrammarParser.NotexprContext;
import lime.antlr4.LimeGrammarParser.OrexprContext;
import lime.antlr4.LimeGrammarParser.ParenexprContext;
import lime.antlr4.LimeGrammarParser.PrintContext;
import lime.antlr4.LimeGrammarParser.SelectorContext;
import lime.antlr4.LimeGrammarParser.SetRandContext;
import lime.antlr4.LimeGrammarParser.Simple_stmtContext;
import lime.antlr4.LimeGrammarParser.Single_assignContext;
import lime.antlr4.LimeGrammarParser.Small_stmtContext;
import lime.antlr4.LimeGrammarParser.StmtContext;
import lime.antlr4.LimeGrammarParser.TypeContext;
import lime.antlr4.LimeGrammarParser.UnaryMinusexprContext;
import lime.antlr4.LimeGrammarParser.UserDefinedContext;
import lime.antlr4.LimeGrammarParser.While_stmtContext;

public class LimeMainCodeGenVisitor extends LimeGrammarBaseVisitor<String> {
	SymbolTable symtab;
	Scope currentScope;
	String source;

	public LimeMainCodeGenVisitor(SymbolTable st, String sourceName) {
		this.symtab = st;
		this.source = sourceName;
	}

	void createFile(String source, String content) {
		String limeMainName = source.substring(0, source.length() - 5) + "_main.c";
		FileWriter outputFile;
		try {
			outputFile = new FileWriter(new File(limeMainName));
			// add includes and preDefined functions
			outputFile.write("#include <stdio.h>\n");
			outputFile.write("#include <stdlib.h>\n");

			// add external declarations
			ClassSymbol cs = (ClassSymbol) this.symtab.GLOBALS.resolve("Start");

			for (String s : cs.methodsCalled.keySet()) {
				if (symtab.preDefinedMethod.containsKey(s))
					continue;
				String tmp[] = s.split("_");
				ClassSymbol cst = (ClassSymbol) symtab.GLOBALS.resolve(tmp[0]);
				MethodSymbol ms = (MethodSymbol) cst.resolve(tmp[1]);

				// System.out.println(ms.methodDecl+";\n");
				outputFile.write(ms.methodDeclforMain + ";\n");
			}

			// add predefined functions
			outputFile.write(symtab.preDeclaredMethod + "\n");
			outputFile.write(symtab.preDefinedMethod.get("print") + "\n");
			outputFile.write(symtab.preDefinedMethod.get("getArg") + "\n");
			outputFile.write(symtab.preDefinedMethod.get("setRand") + "\n");
			outputFile.write(symtab.preDefinedMethod.get("getRand") + "\n");

			// write lime_main function
			outputFile.write(content);
			outputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.print("writing file: "+limeMainName+"\n");
	}

	// compilationUnit
	// : importStmts classDecls EOF ;
	// everything goes here
	@Override
	public String visitCompilationUnit(CompilationUnitContext ctx) {
		String s = "";
		s += this.visit(ctx.importStmts());
		s += this.visit(ctx.classDecls());
		createFile(source, s);
		return s;
	}

	// importStmts
	// : importstmt*;
	@Override
	public String visitImportStmts(ImportStmtsContext ctx) {
		String s = "";
		for (ImportstmtContext imp : ctx.importstmt()) {
			s += this.visit(imp);
		}
		return s;
	}

	// classDecls
	// : classDecl+;
	@Override
	public String visitClassDecls(ClassDeclsContext ctx) {
		String s = "";
		for (ClassDeclContext c : ctx.classDecl()) {
			s += this.visit(c);
		}
		return s;
	}

	// importstmt
	// : 'import' ID'(' type_list ')' (':' type)? NEWLINE;
	@Override
	public String visitImportstmt(ImportstmtContext ctx) {
		String s = "";
		if (ctx.type() != null) {
			s += ctx.type().getText() + " ";
		} else {
			s += "void ";
		}
		s += ctx.ID().getText();
		s += "(";
		s += ctx.type_list().getText();
		s += ");\n";
		return s;
	}

	// classDecl returns [Scope scope]
	// : 'class' ID NEWLINE INDENT classMember* DEDENT ;
	@Override
	public String visitClassDecl(ClassDeclContext ctx) {
		String s = "";
		if (ctx.ID().getText().equals("Start")) {
			s += "void lime_main(void * self){\n";
			for (ClassMemberContext m : ctx.classMember()) {
				String t = this.visit(m);
				if (t != null)
					s += t + "\n";
			}
			s += "}";
		}
		return s;
	}

	// fieldDecl
	// : 'var' id_list ':' type NEWLINE ;
	@Override
	public String visitFieldDecl(FieldDeclContext ctx) {
		String s = "";
		String type = this.visit(ctx.type());
		s += type;
		s += this.visit(ctx.id_list());
		s += ";";
		return s;
	}

	// type returns [Type typ]
	// : 'int' | 'bool' | 'void' | ID | arrayDecl;
	@Override
	public String visitType(TypeContext ctx) {
		String s = "";
		if (ctx.ID() != null) {
			// return ctx.ID().getText() + " *";
			s += "void *";
		} else if (ctx.arrayDecl() != null) {
			s += this.visit(ctx.arrayDecl());
		} else {
			s += ctx.getText();
		}
		return s + " ";
	}

	// arrayDecl returns [ArrayType typ]
	// :'array' 'of' ty=('int' | 'bool' | ID);
	@Override
	public String visitArrayDecl(ArrayDeclContext ctx) {
		String s = "";
		if (ctx.ty.equals("int") || ctx.ty.equals("bool")) {
			s += "int *";
		} else {// ID
			s += "void **";
		}
		return s;
	}

	// block
	// : simple_stmt | NEWLINE INDENT stmt+ DEDENT ;
	@Override
	public String visitBlock(BlockContext ctx) {
		String s = "";
		if (ctx.simple_stmt() != null) {
			// System.out.print("missing something\n"+ctx.getText());
			String t = this.visit(ctx.simple_stmt());
			if (t != null)
				s += t;
		}
		if (ctx.stmt() != null) {
			for (StmtContext x : ctx.stmt()) {
				String t = this.visit(x);
				if (t != null)
					s += t;
			}
		}
		return s;
	}

	// stmt
	// : simple_stmt | compound_stmt ;
	@Override
	public String visitStmt(StmtContext ctx) {
		String s = "";
		if (ctx.simple_stmt() != null) {
			s += this.visit(ctx.simple_stmt());
		}
		if (ctx.compound_stmt() != null) {
			s += this.visit(ctx.compound_stmt());
		}
		return s;
	}

	// simple_stmt
	// : small_stmt (';' small_stmt)* (';')? NEWLINE ;
	@Override
	public String visitSimple_stmt(Simple_stmtContext ctx) {
		String s = "";
		if (ctx.small_stmt() != null) {
			for (Small_stmtContext ss : ctx.small_stmt()) {
				String t = this.visit(ss);
				if (t != null)
					s += t;
			}
		}
		return s;
	}

	// small_stmt
	// : multi_assign | expr_stmt | localDecl | return_stmt | method_call;
	@Override
	public String visitSmall_stmt(Small_stmtContext ctx) {
		String s = "";
		if (ctx.multi_assign() != null) {
			String t = this.visit(ctx.multi_assign());
			if (t != null)
				s += t;
		}
		if (ctx.expr_stmt() != null) {
			String t = this.visit(ctx.expr_stmt());
			if (t != null)
				s += t;
		}
		if (ctx.method_call() != null) {
			String t = this.visit(ctx.method_call());
			if (t != null)
				s += t;
		}

		return s;
	}

	// multi_assign
	// : id_list ':=' expr_list;
	@Override
	public String visitMulti_assign(Multi_assignContext ctx) {
		String src = "";
		int ctnid = ctx.id_list().id_ele().size();
		int ctnexpr = ctx.expr_list().expr().size();
		if (ctnid != ctnexpr) {
			System.out.println("Error: multi_assign unmatch: " + ctx.getText());
		}
		for (int i = 0; i < ctnid; ++i) {
			String ss = this.visit(ctx.id_list().id_ele(i));
			String dd = this.visit(ctx.expr_list().expr(i));
			src += ss + " = " + dd + ";\n";
		}
		return src;
	}

	// expr_stmt
	// : src=expr_list;
	@Override
	public String visitExpr_stmt(Expr_stmtContext ctx) {
		String src = this.visit(ctx.src);
		// init code
		return src + ";";
	}

	// if_stmt
	// : if_stat elif_stat* else_stat?;
	@Override
	public String visitIf_stmt(If_stmtContext ctx) {
		String s = "";
		s += this.visit(ctx.if_stat());
		for (Elif_statContext elif : ctx.elif_stat()) {
			s += this.visit(elif);
		}
		if (ctx.else_stat() != null)
			s += this.visit(ctx.else_stat());
		return s;
	}

	// if_stat
	// : 'if' expr 'then' block;
	@Override
	public String visitIf_stat(If_statContext ctx) {
		String s = "";
		s += "\nif (";
		s += this.visit(ctx.expr());
		s += "){\n";
		s += this.visit(ctx.block());
		s += "\n}\n";
		return s;
	}

	// elif_stat
	// : 'elif' expr 'then' block;
	@Override
	public String visitElif_stat(Elif_statContext ctx) {
		String s = "";
		s += "else if(";
		s += this.visit(ctx.expr());
		s += "){\n";
		s += this.visit(ctx.block());
		s += "\n}";
		return s;
	}

	// else_stat
	// : 'else' block;
	@Override
	public String visitElse_stat(Else_statContext ctx) {
		String s = "";
		s += "else {\n";
		s += this.visit(ctx.block());
		s += "\n}\n";
		return s;
	}

	// while_stmt
	// : 'while' test 'do' block ;
	@Override
	public String visitWhile_stmt(While_stmtContext ctx) {
		String s = "";
		s += "while(";
		s += this.visit(ctx.expr());
		s += "){\n\t";
		s += this.visit(ctx.block());
		s += "\n}";
		return s;
	}

	@Override
	public String visitSingle_assign(Single_assignContext ctx) {
		String s = "";
		s += ctx.id_ele().getText();
		s += " = ";
		s += this.visit(ctx.expr());
		s += ";";
		return s;
	}

	// for_stmt
	// : 'for' single_assign 'to' expr 'do' block;
	@Override
	public String visitFor_stmt(For_stmtContext ctx) {
		String s = "";
		s += "for(";
		s += this.visit(ctx.single_assign());
		s += ctx.single_assign().getChild(0).getText() + "<= ";
		s += this.visit(ctx.expr());
		s += "; ++" + ctx.single_assign().getChild(0).getText();
		s += "){\n\t";
		s += this.visit(ctx.block());
		s += "\n}\n";
		return s;
	}

	// '(' expr ')' #parenexpr
	@Override
	public String visitParenexpr(ParenexprContext ctx) {
		return "(" + this.visit(ctx.expr()) + ")";
	}

	// id_list
	// : id_ele ?(',' id_ele?)*;
	@Override
	public String visitId_list(Id_listContext ctx) {
		String s = "";
		s += this.visit(ctx.id_ele(0));// ctx.ID(0).getText();
		for (int i = 1; i < ctx.id_ele().size(); ++i) {
			s += ",";
			s += this.visit(ctx.id_ele(i));
		}
		return s;
	}

	// id_ele
	// : ID selector? ;
	@Override
	public String visitId_ele(Id_eleContext ctx) {
		String s = "";
		s += ctx.ID().getText();
		if (ctx.selector() != null) {
			s += '[' + this.visit(ctx.selector()) + ']';
		}
		return s;
	}

	@Override
	public String visitEqexpr(EqexprContext ctx) {
		String s = "";
		if (ctx.expr(0) != null)
			s += this.visit(ctx.expr(0));
		// System.out.printf("%s\n", ctx.op.getText());
		if (ctx.op.getType() == LimeGrammarLexer.NEquals) {
			// System.out.printf("done\n");
			s += " != ";
		} else {
			s += " == ";
		}
		if (ctx.expr(1) != null)
			s += this.visit(ctx.expr(1));
		return s;
	}

	// | 'not' expr #notexpr
	@Override
	public String visitNotexpr(NotexprContext ctx) {
		String s = "";
		s += "!";
		if (ctx.expr() != null) {
			s += this.visit(ctx.expr());
		}
		return s;
	}

	// | expr op=( '*' | '/' | '%' ) expr #multexpr
	@Override
	public String visitMultexpr(MultexprContext ctx) {
		String s = "";
		if (ctx.expr(0) != null)
			s += this.visit(ctx.expr(0));
		s += ctx.op.getText();
		if (ctx.expr(1) != null)
			s += this.visit(ctx.expr(1));
		return s;
	}

	// | expr op=( '>=' | '<=' | '>' | '<' ) expr #compexpr
	@Override
	public String visitCompexpr(CompexprContext ctx) {
		String s = "";
		if (ctx.expr(0) != null)
			s += this.visit(ctx.expr(0));
		s += ctx.op.getText();
		if (ctx.expr(1) != null)
			s += this.visit(ctx.expr(1));
		return s;
	}

	// : '-' expr #unaryMinusexpr
	@Override
	public String visitUnaryMinusexpr(UnaryMinusexprContext ctx) {
		String s = "";
		s += "-";
		if (ctx.expr() != null)
			s += this.visit(ctx.expr());
		return s;
	}

	// | expr op=( '+' | '-' ) expr #addexpr
	@Override
	public String visitAddexpr(AddexprContext ctx) {
		String s = "";
		if (ctx.expr(0) != null)
			s += this.visit(ctx.expr(0));
		s += " " + ctx.op.getText() + " ";
		if (ctx.expr(1) != null)
			s += this.visit(ctx.expr(1));
		return s;
	}

	// | atom #atomexpr
	@Override
	public String visitAtomexpr(AtomexprContext ctx) {
		return this.visit(ctx.atom());
	}

	// | expr 'or' expr #orexpr
	@Override
	public String visitOrexpr(OrexprContext ctx) {
		String s = "";
		if (ctx.expr(0) != null)
			s += this.visit(ctx.expr(0));
		s += "||";
		if (ctx.expr(1) != null)
			s += this.visit(ctx.expr(1));
		return s;
	}

	// | expr 'and' expr #andexpr
	@Override
	public String visitAndexpr(AndexprContext ctx) {
		String s = "";
		if (ctx.expr(0) != null)
			s += this.visit(ctx.expr(0));
		s += "&&";
		if (ctx.expr(1) != null)
			s += this.visit(ctx.expr(1));
		return s;
	}

	// expr_list
	// : expr (',' expr)*;
	@Override
	public String visitExpr_list(Expr_listContext ctx) {
		String s = "";
		s += this.visit(ctx.expr(0));
		for (int i = 1; i < ctx.expr().size(); ++i) {
			s += ", ";
			s += this.visit(ctx.expr(i));
		}
		// System.out.println(s);
		return s;
	}

	// : 'new' n=ID args #newcall
	@Override
	public String visitNewcall(NewcallContext ctx) {
		String s = "";
		s += "(void *)";
		s += ctx.n.getText() + "_init";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		// System.out.println("new method call");
		// System.out.println(s);
		return s;
	}

	// | c=ID '.' m=ID args #methodcall
	@Override
	public String visitMethodcall(MethodcallContext ctx) {
		String s = "";
		// String t =
		// ((Symbol)this.symtab.GLOBALS.findSymbol(ctx.c.getText())).getScope().getName();
		String t = ((FieldSymbol) this.symtab.GLOBALS.findSymbol(ctx.c.getText())).getType().getName();
		s = t + "_" + ctx.m.getText();
		s += "(";
		String tt = this.visit(ctx.args());
		if (tt != "") {
			s += tt + ", ";
		}
		s += ctx.c.getText();
		s += ", self)";
		return s;
	}

	// arrayElement '.' m=ID args #arrayElementmethodcall
	@Override
	public String visitArrayElementmethodcall(ArrayElementmethodcallContext ctx) {
		String s = "";
		// System.out.print(ctx.arrayElement().ID().getText());

		String t = ((FieldSymbol) symtab.GLOBALS.findSymbol(ctx.arrayElement().ID().getText())).getType().getName();
		s = t + "_" + ctx.m.getText();
		s += "(";
		String tt = this.visit(ctx.args());
		if (tt != "") {
			s += tt + ", ";
		}
		s += this.visit(ctx.arrayElement());
		s += ", self)";
		return s;
	}

	// arrayElement
	// : ID selector
	@Override
	public String visitArrayElement(ArrayElementContext ctx) {
		String s = "";
		// System.out.print("selector");
		s += ctx.ID().getText();
		s += '[';
		s += this.visit(ctx.selector());
		s += ']';
		// System.out.println(s);
		return s;
	}

	// arrayCreate
	// : 'new' ty=('int' | 'bool' | ID) selector
	@Override
	public String visitArrayCreate(ArrayCreateContext ctx) {
		String s = "";
		String t = this.visit(ctx.selector());
		if (ctx.ty.equals("int") || ctx.ty.equals("bool")) {
			s += "(int *)malloc(sizeof(int) *";
			String.format(s, t);
		} else {// ID
			s += "(void **)malloc(sizeof(void *) * ";
		}
		s += t;
		s += ")";
		return s;
	}

	// selector
	// : '[' expr ']'
	@Override
	public String visitSelector(SelectorContext ctx) {
		return this.visit(ctx.expr());
	}

	@Override
	public String visitGetRand(GetRandContext ctx) {
		String s = "";
		s += "getRand";
		s += "(";
		// s += ctx.atom().getText();
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	@Override
	public String visitGetArg(GetArgContext ctx) {
		String s = "";
		s += "getArg";
		s += "(";
		// s += ctx.atom().getText();
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	@Override
	public String visitSetRand(SetRandContext ctx) {
		String s = "";
		s += "setRand";
		s += "(";
		// s += ctx.atom().getText();
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	@Override
	public String visitPrint(PrintContext ctx) {
		String s = "";
		s += "print";
		s += "(";
		// s += ctx.atom().getText();
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	// ID args
	@Override
	public String visitUserDefined(UserDefinedContext ctx) {
		String s = "";
		s += ctx.ID().getText();
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	// args
	// : '(' expr_list? ')';
	@Override
	public String visitArgs(ArgsContext ctx) {
		String s = "";
		if (ctx.expr_list() != null) {
			s += this.visit(ctx.expr_list());
		}
		return s;
	}

	// compound_stmt
	// : if_stmt | while_stmt | for_stmt ;
	@Override
	public String visitCompound_stmt(Compound_stmtContext ctx) {
		String s = "";
		if (ctx.if_stmt() != null) {
			s += this.visit(ctx.if_stmt());
		}
		if (ctx.while_stmt() != null) {
			s += this.visit(ctx.while_stmt());
		}
		if (ctx.for_stmt() != null) {
			s += this.visit(ctx.for_stmt());
		}
		return s;
	}

	@Override
	public String visitInitDecl(InitDeclContext ctx) {
		String res = "";
		// res += this.visit(ctx.parameters());
		res += this.visit(ctx.block());
		// System.out.print(res);
		return res;
	}

	// atom
	// : INTEGER | True | False | Null | ID | method_call | arrayCreate |
	// arrayElement;
	@Override
	public String visitAtom(AtomContext ctx) {
		if (ctx.INTEGER() != null) {
			// System.out.println("find a integer: "+ ctx.INTEGER().getText());
			return ctx.INTEGER().getText();
		} else if (ctx.Null() != null) {
			// System.out.println("find a null: "+ ctx.Null().getText());
			return "NULL";
		} else if (ctx.True() != null) {
			// System.out.println("find a true: "+ ctx.True().getText());
			return "1";
		} else if (ctx.False() != null) {
			return "0";
		} else if (ctx.ID() != null) {
			// System.out.println("find a ID: this->"+ ctx.ID().getText());
			Symbol s = this.symtab.GLOBALS.findSymbol(ctx.ID().getText());
			if (s instanceof FieldSymbol) {
				// return "this->"+ctx.ID().getText();
				return ctx.ID().getText();
			} else if (s instanceof VariableSymbol) {
				// System.out.println("variable symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			} else if (s instanceof ParameterSymbol) {
				// System.out.println("Parameter symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			} else {
				ClassSymbol cs = (ClassSymbol) this.symtab.GLOBALS.resolve("Start");
				Symbol ss = cs.resolve(ctx.ID().getText());
				if (ss instanceof EnumSymbol) {
					//System.out.println("symbol: " + ctx.ID().getText());
					return Integer.toString(((EnumSymbol) ss).getConstantValue());
				}
				// System.out.println("symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			}
		} else if (ctx.method_call() != null) {
			return this.visit(ctx.method_call());
		} else if (ctx.arrayCreate() != null) {
			return this.visit(ctx.arrayCreate());
		} else if (ctx.arrayElement() != null) {
			// System.out.print("array");
			return this.visit(ctx.arrayElement());
		} else
			return "";
	}

}
