package lime.codegen;

import java.util.LinkedHashSet;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import lime.antlr4.ActionSymbol;
import lime.antlr4.ArrayType;
import lime.antlr4.ClassSymbol;
import lime.antlr4.EnumSymbol;
import lime.antlr4.EnumType;
import lime.antlr4.FieldSymbol;
import lime.antlr4.LimeGrammarBaseListener;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.ArrayDeclContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.CompilationUnitContext;
import lime.antlr4.LimeGrammarParser.EnumDeclContext;
import lime.antlr4.LimeGrammarParser.FieldDeclContext;
import lime.antlr4.LimeGrammarParser.Id_eleContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.LocalDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.LimeGrammarParser.ParsdefContext;
import lime.antlr4.LimeGrammarParser.TypeContext;
import lime.antlr4.MethodSymbol;
import lime.antlr4.ParameterSymbol;
import lime.antlr4.Scope;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;
import lime.antlr4.Type;
import lime.antlr4.VariableSymbol;

public class LimeParserTreeListener3  extends LimeGrammarBaseListener{
	Scope currentScope;
	SymbolTable symtab;
	LimeParserTreeListener3(SymbolTable symtab) {
		this.symtab = symtab;
		this.currentScope = symtab.GLOBALS;
	}
	/* 
	 * compilationUnit
     *   : importStmts classDecls EOF ;
	 */
	@Override
	public void enterCompilationUnit(CompilationUnitContext ctx) {
		for(int i = 0; i < ctx.classDecls().getChildCount(); ++i) {
			ClassDeclContext c = (ClassDeclContext)ctx.classDecls().getChild(i); 
			ClassSymbol cs = new ClassSymbol(c.ID().getText());
			currentScope.define(cs);		
			System.out.printf("Class %s is defined\n", c.ID().getText());
			currentScope = cs;
			for(int j = 0; j < c.classMember().size(); ++j) {
				if (c.classMember(j).methodDecl()!=null) {
					MethodSymbol ms = new MethodSymbol(c.classMember(j).methodDecl().ID().getText());
					currentScope.define(ms);
					System.out.printf("Method %s is defined\n", c.classMember(j).methodDecl().ID().getText());
				}
			}
			currentScope = currentScope.getEnclosingScope();
		}
	}
	
	// classDecl returns [Scope scope]
	// : 'class' ID NEWLINE INDENT classMember* DEDENT ;
	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		Symbol cs = (Symbol)symtab.GLOBALS.resolve(ctx.ID().getText());
		if(!(cs instanceof ClassSymbol)) {
			System.err.printf("Can't resolve class %s in the global scope!\n", ctx.ID().getText());
		} else {
			ClassSymbol classsymbol = (ClassSymbol) cs;
			classsymbol.setDefNode((ParserRuleContext) ctx);
			ctx.scope = classsymbol;
			currentScope = classsymbol;
			System.out.printf("Enter class  %s\n", classsymbol.getName());
		}
	}
	
	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		System.out.printf("Exit class  %s\n", ctx.ID().getText());
	}
	
	// : 'method' ID parameters (':' type)? (NEWLINE INDENT 'when' guard 'do')?
	// block (DEDENT)?;
	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		Symbol s = currentScope.resolve(ctx.ID().getText());
		if (s instanceof MethodSymbol) {
			MethodSymbol ms = (MethodSymbol) s;
			ctx.scope = ms;
			ms.setDefNode((ParserRuleContext) ctx);
			if (ctx.type() == null) {
				ms.setType((Type) symtab.GLOBALS.resolve("void"));
			}else {
				ms.setType((Type) symtab.GLOBALS.resolve(ctx.type().getText()));
			}
			currentScope = ms;
			System.out.printf("Method %s is defined\n", ms.getName());
		} else {
			System.err.printf("Method %s is undefined\n", ctx.ID().getText());
		}
	}

	@Override
	public void exitMethodDecl(MethodDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		System.out.printf("Exit Method %s scope\n", ctx.ID().getText());
	}
	
	/* actionDecl returns [Scope scope]
	 * : 'action' ID  (NEWLINE INDENT 'when' guard 'do')? block (DEDENT)? ;
	 */
	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		ActionSymbol as = new ActionSymbol(ctx.ID().getText());
		ctx.scope = as;
		as.setDefNode((ParserRuleContext) ctx);
		currentScope.define(as);
		currentScope = as;
		System.out.printf("Action %s is defined\n", as.getName());
	}
	
	@Override
	public void exitActionDecl(ActionDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		System.out.printf("Exit action %s scope\n", ctx.ID().getText());
	}
	
	// initDecl returns [Scope scope]
	// : 'init' parameters block;
	@Override
	public void enterInitDecl(InitDeclContext ctx) {
		MethodSymbol ms = new MethodSymbol("init");
		ms.setDefNode((ParserRuleContext) ctx);
		ctx.scope = ms;
		ms.setType((Type)currentScope);
		currentScope.define(ms);
		currentScope = ms;
		System.out.printf("Class init is defined\n");
	}
	
	@Override
	public void exitInitDecl(InitDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		System.out.printf("Exit init\n");
	}
	
	/*
	 * fieldDecl 
	 * : 'var' id_list ':' type NEWLINE ;
	 */
	@Override
	public void enterFieldDecl(FieldDeclContext ctx) {
		// TODO Auto-generated method stub
		super.enterFieldDecl(ctx);
	}
	
	@Override
	public void exitFieldDecl(FieldDeclContext ctx) {
		List<Id_eleContext> idele = ctx.id_list().id_ele();
		for (Id_eleContext x : idele) {
			FieldSymbol vs = new FieldSymbol(x.ID().getText());
			vs.setType((Type) ctx.type().typ);
			System.out.printf("Feild variable is defined: %s\t %s\n", vs.getName(), vs.getType().getName());
			currentScope.define(vs);
		}
	}
	
	/* parsdef
	 *  : id_list ':' type ;
	 */
	@Override
	public void enterParsdef(ParsdefContext ctx) {
		// TODO Auto-generated method stub
		super.enterParsdef(ctx);
	}
	
	@Override
	public void exitParsdef(ParsdefContext ctx) {
		Type typ = ctx.type().typ;
		if (typ == null) {
			System.err.printf("Can't find Parameter's type: %s\n", ctx.type().typ);
		}
		List<Id_eleContext> idele = ctx.id_list().id_ele();
		for (Id_eleContext x : idele) {
			ParameterSymbol ps = new ParameterSymbol(x.ID().getText(), typ);
			currentScope.define(ps);
			System.out.printf("Method arg: %s: %s is defined\n", ps.getName(), typ.getName());
		}
	}
	
	/* 
	 * localDecl 
	 *  : 'var' id_list ':' type ;
	 */
	@Override
	public void enterLocalDecl(LocalDeclContext ctx) {
		// TODO Auto-generated method stub
		super.enterLocalDecl(ctx);
	}

	@Override
	public void exitLocalDecl(LocalDeclContext ctx) {
		Type typ = ctx.type().typ;
		if (typ == null) {
			System.err.printf("Can't find local variable's type: %s\n", ctx.type().typ);
		}
		List<Id_eleContext> idele = ctx.id_list().id_ele();
		for(Id_eleContext id : idele) {
			VariableSymbol vs = new VariableSymbol(id.ID().getText());
			vs.setType(typ);
			currentScope.define(vs);
			System.out.printf("Local variable var: %s is defined\n", vs.getName());
		}
	}
	
	/* type returns [Type typ]
	 *: 'int' | 'bool' | 'void' | ID | arrayDecl | enumDecl;
	 */
	
	@Override
	public void exitType(TypeContext ctx) {
		Type typ = null;
		if (ctx.getText().equals("int")) {
			typ = (Type) symtab.GLOBALS.resolve("int");
		} else if (ctx.getText().equals("bool")) {
			typ = (Type) symtab.GLOBALS.resolve("bool");
		} else if (ctx.getText().equals("void")) {
			typ = (Type) symtab.GLOBALS.resolve("void");
		} else if (ctx.ID() != null) {
			Symbol cs = symtab.GLOBALS.resolve(ctx.ID().getText());
			if (cs == null) {
				System.err.printf("Can't resolve the type: %s\n", ctx.ID().getText());
			} else if (cs instanceof ClassSymbol) {
				ClassSymbol classsym = (ClassSymbol) cs;
				typ = (Type) classsym;
				System.out.printf("Resolve the type: %s\n", typ.getName());
			} else {
				System.err.printf("Type ID shoud be a class: %s\n", cs.getName());
			}
		} else if (ctx.arrayDecl() != null) {
			typ = (Type) ctx.arrayDecl().typ;
			System.out.printf("Array is defined: %s\n", typ.getName());
		} else if(ctx.enumDecl()!=null){
			typ = ctx.enumDecl().typ;
			System.out.printf("EnumDecl is defined: %s\n", typ.getName());
		}
		else{
			System.err.printf("Can't resolve the type %s\n", ctx.getText());
		}
		ctx.typ = typ;
	}
	/* arrayDecl returns [ArrayType typ]
	 * :'array' 'of' ty=('int' | 'bool' | ID);
	*/
	@Override
	public void enterArrayDecl(ArrayDeclContext ctx) {
		ArrayType arrtyp = null;
		if (ctx.ty != null) {
			if (ctx.ty.getText().equals("int")) {
				arrtyp = new ArrayType((Type) symtab.GLOBALS.resolve("int"));
			} else if (ctx.ty.getText().equals("bool")) {
				arrtyp = new ArrayType((Type) symtab.GLOBALS.resolve("bool"));
			} else {// array of Objects
				Symbol s = symtab.GLOBALS.resolve(ctx.ID().getText());
				if (s == null) {
					System.err.printf("arrayDecl: type %s can't resolve\n", ctx.ID().getText());
				} else if(s instanceof ClassSymbol) {
					ClassSymbol cs = (ClassSymbol) s;
					System.out.println("arrayDecl: type: \t"+ cs.getName());
					arrtyp = new ArrayType((Type) cs);
				}
			}
		} else {
			System.err.println("arrayDecl: type is undefined\n");
		}
		ctx.typ = arrtyp;
	}
	
	@Override
	public void exitArrayDecl(ArrayDeclContext ctx) {
		// TODO Auto-generated method stub
		super.exitArrayDecl(ctx);
	}
	/* 
	 * enumDecl returns [Type typ]
	 *  : '{' ID (',' ID)* '}'; 
	 */
	@Override
	public void enterEnumDecl(EnumDeclContext ctx) {
		LinkedHashSet<String> vals = new LinkedHashSet<String>();
		for(TerminalNode id: ctx.ID()) {
			vals.add(id.getText());
			System.out.printf("enumValue: %s  is defined\n", id.getText());
		}
		EnumType et = new EnumType(vals);
		ctx.typ = et;
		((ClassSymbol)currentScope).EnumAddAll(vals);
	}
	@Override
	public void exitEnumDecl(EnumDeclContext ctx) {
		// TODO Auto-generated method stub
		super.exitEnumDecl(ctx);
	}
	
	
	
}
