package lime.codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import lime.antlr4.ClassSymbol;
import lime.antlr4.EnumSymbol;
import lime.antlr4.FieldSymbol;
import lime.antlr4.LimeGrammarBaseVisitor;
import lime.antlr4.LimeGrammarLexer;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.AddexprContext;
import lime.antlr4.LimeGrammarParser.AndexprContext;
import lime.antlr4.LimeGrammarParser.ArgsContext;
import lime.antlr4.LimeGrammarParser.ArrayDeclContext;
import lime.antlr4.LimeGrammarParser.AtomContext;
import lime.antlr4.LimeGrammarParser.AtomexprContext;
import lime.antlr4.LimeGrammarParser.BlockContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.ClassMemberContext;
import lime.antlr4.LimeGrammarParser.CompexprContext;
import lime.antlr4.LimeGrammarParser.Compound_stmtContext;
import lime.antlr4.LimeGrammarParser.Elif_statContext;
import lime.antlr4.LimeGrammarParser.Else_statContext;
import lime.antlr4.LimeGrammarParser.EqexprContext;
import lime.antlr4.LimeGrammarParser.ExitContext;
import lime.antlr4.LimeGrammarParser.Expr_listContext;
import lime.antlr4.LimeGrammarParser.Expr_stmtContext;
import lime.antlr4.LimeGrammarParser.GetArgContext;
import lime.antlr4.LimeGrammarParser.GetRandContext;
import lime.antlr4.LimeGrammarParser.Id_eleContext;
import lime.antlr4.LimeGrammarParser.Id_listContext;
import lime.antlr4.LimeGrammarParser.If_statContext;
import lime.antlr4.LimeGrammarParser.If_stmtContext;
import lime.antlr4.LimeGrammarParser.LocalDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.LimeGrammarParser.MethodcallContext;
import lime.antlr4.LimeGrammarParser.MultexprContext;
import lime.antlr4.LimeGrammarParser.Multi_assignContext;
import lime.antlr4.LimeGrammarParser.NewcallContext;
import lime.antlr4.LimeGrammarParser.NotexprContext;
import lime.antlr4.LimeGrammarParser.OrexprContext;
import lime.antlr4.LimeGrammarParser.ParametersContext;
import lime.antlr4.LimeGrammarParser.ParsdefContext;
import lime.antlr4.LimeGrammarParser.PrintContext;
import lime.antlr4.LimeGrammarParser.Return_stmtContext;
import lime.antlr4.LimeGrammarParser.SelectorContext;
import lime.antlr4.LimeGrammarParser.SetRandContext;
import lime.antlr4.LimeGrammarParser.Simple_stmtContext;
import lime.antlr4.LimeGrammarParser.Small_stmtContext;
import lime.antlr4.LimeGrammarParser.StmtContext;
import lime.antlr4.LimeGrammarParser.TypeContext;
import lime.antlr4.LimeGrammarParser.TypeparslistContext;
import lime.antlr4.LimeGrammarParser.UnaryMinusexprContext;
import lime.antlr4.LimeGrammarParser.While_stmtContext;
import lime.antlr4.MethodSymbol;
import lime.antlr4.ParameterSymbol;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;
import lime.antlr4.VariableSymbol;

public class LimeLLVMCodeGenVisitor extends LimeGrammarBaseVisitor<String> {
	String ou = "";
	String className;
	List<String> multiassignment;
	Map<String, String> init_map;
	String initcode;
	int action_counter = 0;
	SymbolTable symtab;
	boolean initfunction = false;
	String dir;

	public LimeLLVMCodeGenVisitor(SymbolTable symtab, String dir) {
		this.symtab = symtab;
		this.dir = dir;
	}

	void createFile(String className, String content) {
		String limeLLVMName = className + ".c";
		FileWriter outputFile;
		if (className.equals("Start"))
			return;
		ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
		if (cs == null) {
			System.err.print("Error: can't find class symbol: " + className);
		}
		try {
			outputFile = new FileWriter(new File(dir, limeLLVMName));
			outputFile.write("#include <stddef.h>\n");
			outputFile.write("#include <stdlib.h>\n");
			outputFile.write("#include <stdio.h>\n");
			for (String s : symtab.importedMethod.values()) {
				outputFile.write(s);
			}
			outputFile.write("struct " + this.className + "_struct{\n");
			outputFile.write("int pre_ebp;\n");
			outputFile.write("int pre_esp;\n");
			outputFile.write("int lock;\n");
			outputFile.write("int system_next;\n");
			for (FieldSymbol f : ((ClassSymbol) cs).getFields()) {
				String typ = f.getType().getName();
				if (typ.equals("int") || typ.equals("bool") || typ.equals("enum")) {
					outputFile.write("int " + f.getName() + ";\n");

				} else {
					outputFile.write("struct " + typ + "_struct *" + f.getName() + ";\n");
				}
			}
			outputFile.write("};\n");

			// init function decl

			// preDefined function decls

			// external functions decls
			for (String s : cs.methodsCalled.keySet()) {
				if (symtab.preDefinedMethod.containsKey(s)) {
					outputFile.write(((MethodSymbol) symtab.PREDEFINED.resolve(s)).methodDecl + ";\n");
					continue;
				}
				String tmp[] = s.split("_");
				System.err.printf("method: %s\n", s);
				ClassSymbol cst = (ClassSymbol) symtab.GLOBALS.resolve(tmp[0]);
				MethodSymbol ms = (MethodSymbol) cst.resolve(tmp[1]);
				// System.out.println(ms.methodDecl+";\n");
				outputFile.write(ms.methodDecl + ";\n");
			}

			outputFile.write(content);
			outputFile.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * classDecl : 'class' ID NEWLINE INDENT classMember* DEDENT ;
	 */
	@Override
	public String visitClassDecl(ClassDeclContext ctx) {
		this.action_counter = 0;
		this.className = ctx.ID().getText();
		String l = "";
		for (ClassMemberContext m : ctx.classMember()) {
			String t = this.visit(m);
			if (t != null)
				l += t;
		}
		createFile(className, l);
		return l;
	}

	@Override
	public String visitClassMember(ClassMemberContext ctx) {
		String s = "";
		if (ctx.methodDecl() != null) {
			s += this.visit(ctx.methodDecl());
		}
		if (ctx.actionDecl() != null) {
			s += this.visit(ctx.actionDecl());
		}
		return s;
	}

	// methodDecl
	// : 'method' ID parameters (':' type)? NEWLINE INDENT ('when' guard 'do')?
	// block DEDENT ;
	@Override
	public String visitMethodDecl(MethodDeclContext ctx) {
		String s = ctx.ID().getText();
		if (ctx.ID() != null) {
			// method name
			if (ctx.type() != null && ctx.type().getText() != "void") {
				s = "int " + this.className + "_" + s;
			} else {
				s = "void " + this.className + "_" + s;
			}
			// method args
			s += "(";
			s += this.visit(ctx.parameters());
			s += "){\n";
			s += this.visit(ctx.block());
			s += "}";
		}
		return s + "\n";
	}

	// parameters
	// : '(' typeparslist? ')' ;
	@Override
	public String visitParameters(ParametersContext ctx) {
		String s = "";
		if (ctx.typeparslist() != null) {
			String t = this.visit(ctx.typeparslist());
			if (t != null)
				s += t;
		}
		s += "struct " + this.className + "_struct *this, void* self";
		return s;

	}

	// typedparslist
	// : argsdef (',' argsdef)* ;
	@Override
	public String visitTypeparslist(TypeparslistContext ctx) {
		String s = "";
		if (ctx.parsdef() != null) {
			for (ParsdefContext a : ctx.parsdef()) {
				s += this.visit(a);
			}
			// if(initfunction) s+="$"; s=s.replace(",$", "");
		}
		return s;
	}

	// parsdef
	// : id_list ':' type ;
	@Override
	public String visitParsdef(ParsdefContext ctx) {
		String s = "";
		s += this.visit(ctx.type());
		s += this.visit(ctx.id_list());
		s += ",";
		return s;
	}

	// : 'int' | 'bool' | 'void' | ID | arrayDecl;
	@Override
	public String visitType(TypeContext ctx) {
		String s = "";
		if (ctx.getText().equals("int") || ctx.getText().equals("bool")) {
			s += "int ";
		} else if(ctx.getText().equals("this")){
			s += "this ";
		} else if (ctx.ID() != null) {
			s += "struct "+ ctx.ID().getText() + "_struct *";
		} else if (ctx.arrayDecl() != null) {
			s += this.visit(ctx.arrayDecl());
		}

		return s;
	}

	// array of ID
	@Override
	public String visitArrayDecl(ArrayDeclContext ctx) {
		String s = "";
		if (ctx.getText().equals("int") || ctx.getText().equals("bool")) {
			s += "int *";
		} else if (ctx.ID() != null) {
			s += ctx.ID().getText() + "_struct **";
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
		if (ctx.return_stmt() != null) {
			String t = this.visit(ctx.return_stmt());
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

	// localDecl
	// : 'var' id_list ':' type NEWLINE ;
	@Override
	public String visitLocalDecl(LocalDeclContext ctx) {
		// TODO Auto-generated method stub
		// return super.visitLocalDecl(ctx);
		String s = "\nint ";
		if (ctx.id_list() != null) {
			String t = this.visit(ctx.id_list());
			if (t != null)
				s += t;
		}
		s += ";\n";
		return s;
	}

	// multi_assign
	// : id_list ':=' expr_list;

	@Override
	public String visitMulti_assign(Multi_assignContext ctx) {
		String s = "";
		String src = this.visit(ctx.id_list());
		String[] ss = src.split(",");
		String[] dd = new String[ctx.expr_list().getChildCount()];
		// id list = id , id , id .... id in the position(i*2) number of ids = (size +
		// 1)/2
		for (int i = 0; i < (ctx.id_list().getChildCount() + 1) / 2; ++i) {
			dd[i] = this.visit(ctx.expr_list().getChild(i * 2));
			s += ss[i] + " = " + dd[i] + ";\n";
			// System.out.println(i);
		}
		// System.out.println(ss[0]);
		return s;
	}

	// expr_stmt
	// : src=expr_list;
	// expr_list
	// : expr (',' expr)* ;
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
		return s;
	}

	// return_stmt
	// : 'return' (test)? ;
	@Override
	public String visitReturn_stmt(Return_stmtContext ctx) {
		String s = "\nreturn ";
		if (ctx.expr() != null) {
			s += this.visit(ctx.expr());
		}
		return s + ";\n";
	}

	// actionDecl
	// : 'action' ID NEWLINE INDENT ('when' guard 'do')? block DEDENT ;
	@Override
	public String visitActionDecl(ActionDeclContext ctx) {
		String s = "";
		this.action_counter++;
		s = "\nvoid " + this.className + "_" + ctx.ID().getText() + "(struct " + this.className
				+ "_struct *this, void* self)";
		s += "\n{\n";
		s += this.visit(ctx.block());
		s += "}\n";
		return s;
	}

	String getThisPrefix(String in) {
		Symbol s = this.symtab.GLOBALS.findSymbol(in);
		if (s instanceof FieldSymbol) {
			return "this->" + in;
		} else if (s instanceof VariableSymbol) {
			// System.out.println("variable symbol: "+ ctx.ID().getText());
			return in;
		} else if (s instanceof ParameterSymbol) {
			// System.out.println("Parameter symbol: "+ ctx.ID().getText());
			return in;
		} else {
			// System.out.println("symbol: "+ ctx.ID().getText());
			return in;
		}
	}

	// id_list
	// : id_ele (',' id_ele)* ;
	@Override
	public String visitId_list(Id_listContext ctx) {
		String s = "";
		String t = "";
		t = this.visit(ctx.id_ele(0));
		s += getThisPrefix(t);
		for (int i = 1; i < ctx.id_ele().size(); ++i) {
			s += ",";
			t = this.visit(ctx.id_ele(i));
			s += getThisPrefix(t);
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
			s += this.visit(ctx.selector());
		}
		return s;
	}

	// selector
	// : '[' expr ']'
	@Override
	public String visitSelector(SelectorContext ctx) {
		String s = "";
		s += "[";
		s += this.visit(ctx.expr());
		s += "]";
		return s;
	}

	// expr op=( '=' | '!=' ) expr #eqexpr
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
		return s;
	}

	// : 'new' n=ID args #newcall
	@Override
	public String visitNewcall(NewcallContext ctx) {
		String s = "";
		s += "(struct " + ctx.n.getText() + "_struct *) " + ctx.n.getText() + "_init";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	// | c=ID '.' m=ID args #methodcall
	@Override
	public String visitMethodcall(MethodcallContext ctx) {
		String s = "";
		String t = "";
		// String t = ((ClassSymbol)
		// this.symtab.GLOBALS.resolve(ctx.c.getText())).getType().getName();
		// System.out.printf("methodcall %s\n", ctx.m.getText());
		Symbol symbol = this.symtab.GLOBALS.findSymbol(ctx.c.getText());
		if (symbol instanceof FieldSymbol) {
			//System.err.printf("methodcall field:%s\n", ctx.m.getText());
			FieldSymbol symbolF = (FieldSymbol) this.symtab.GLOBALS.findSymbol(ctx.c.getText());
			t = symbolF.getType().getName();
			//System.err.printf("methodcall field:%s:%s\n", ctx.m.getText(),t);
		} else if (symbol instanceof ParameterSymbol) {
			//System.err.printf("methodcall parameter:%s.%s\n",ctx.c.getText(), ctx.m.getText());
			ParameterSymbol symbolP = (ParameterSymbol) symbol;
			//System.err.printf("methodcall parameter:%s\n",symbolP.getName());
			t = symbolP.getType().getName();
			//System.err.printf("methodcall Parameter:%s:%s\n",  ctx.m.getText(),t);
		}
		//FieldSymbol fs = (FieldSymbol) this.symtab.GLOBALS.findSymbol(ctx.c.getText());
		s = t + "_" + ctx.m.getText();
		s += "(";
		String tt = this.visit(ctx.args());
		if (tt != "") {
			s += tt + ",";
		}
		s += "this->" + ctx.c.getText();
		s += ", self)";
		return s;
	}

	@Override
	public String visitGetRand(GetRandContext ctx) {
		String s = "";
		s += "getRand";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	@Override
	public String visitGetArg(GetArgContext ctx) {
		String s = "";
		s += "getArg";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	@Override
	public String visitSetRand(SetRandContext ctx) {
		String s = "";
		s += "setRand";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}

	@Override
	public String visitPrint(PrintContext ctx) {
		String s = "";
		s += "print";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}
	
	@Override
	public String visitExit(ExitContext ctx) {
		String s = "";
		s += "exit(1)";
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
	// : if_stmt | while_stmt | methodDecl | actionDecl | initDecl | localDecl ;
	@Override
	public String visitCompound_stmt(Compound_stmtContext ctx) {
		String s = "";
		if (ctx.if_stmt() != null) {
			s += this.visit(ctx.if_stmt());
		}
		return s;
	}

	// atom
	// : INTEGER | True | False | Null | ID | method_call;
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
		} else if (ctx.This() != null) {
			return "this";
		}else if (ctx.ID() != null) {
			// System.out.println("find a ID: this->"+ ctx.ID().getText());
			Symbol s = this.symtab.GLOBALS.findSymbol(ctx.ID().getText());

			if (s instanceof FieldSymbol) {
				return "this->" + ctx.ID().getText();
			} else if (s instanceof VariableSymbol) {
				// System.out.println("variable symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			} else if (s instanceof ParameterSymbol) {
				// System.out.println("Parameter symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			} else {
				ClassSymbol cs = (ClassSymbol) this.symtab.GLOBALS.resolve(className);
				int enumval = cs.resolveEnumValue(ctx.ID().getText());
				return Integer.toString(enumval);
				/*
				Symbol ss = cs.resolve(ctx.ID().getText());
				if (ss instanceof EnumSymbol) {
					return Integer.toString(((EnumSymbol) ss).getConstantValue());
					//System.err.println("symbol: "+ ctx.ID().getText() + s.getScope());
					//return Integer.toString(((EnumSymbol) ss).getConstantValue());
				}
				// System.out.println("symbol: "+ ctx.ID().getText() + s.getScope());
				*/
				//return ctx.ID().getText();
			}
		} else if (ctx.method_call() != null) {
			return this.visit(ctx.method_call());
		} else
			return "";
	}

	public String toString() {
		return ou;
	}
}