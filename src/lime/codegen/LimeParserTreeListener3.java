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
import lime.antlr4.LimeGrammarParser.ArrayElementmethodcallContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.CompilationUnitContext;
import lime.antlr4.LimeGrammarParser.EnumDeclContext;
import lime.antlr4.LimeGrammarParser.ExitContext;
import lime.antlr4.LimeGrammarParser.FieldDeclContext;
import lime.antlr4.LimeGrammarParser.GetArgContext;
import lime.antlr4.LimeGrammarParser.GetRandContext;
import lime.antlr4.LimeGrammarParser.GuardatomidContext;
import lime.antlr4.LimeGrammarParser.Id_eleContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.LocalDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.LimeGrammarParser.MethodcallContext;
import lime.antlr4.LimeGrammarParser.Multi_assignContext;
import lime.antlr4.LimeGrammarParser.NewcallContext;
import lime.antlr4.LimeGrammarParser.ParsdefContext;
import lime.antlr4.LimeGrammarParser.PrintContext;
import lime.antlr4.LimeGrammarParser.SetRandContext;
import lime.antlr4.LimeGrammarParser.Single_assignContext;
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
	boolean inMethod = false;
	boolean multiAssign = false;
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
			//System.out.printf("Class %s is defined\n", c.ID().getText());
			currentScope = cs;
			for(int j = 0; j < c.classMember().size(); ++j) {
				if (c.classMember(j).methodDecl()!=null) {
					MethodSymbol ms = new MethodSymbol(c.classMember(j).methodDecl().ID().getText());
					currentScope.define(ms);
					//System.out.printf("Method %s is defined\n", c.classMember(j).methodDecl().ID().getText());
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
			//System.out.printf("Enter class  %s\n", classsymbol.getName());
		}
	}
	
	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		//System.out.printf("Exit class  %s\n", ctx.ID().getText());
	}
	
	// : (private)? 'method' ID parameters (':' type)? (NEWLINE INDENT 'when' guard 'do')?
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
			
			if (ctx.Private()!=null) {
				ms.setPrivate();
			}
			
			currentScope = ms;
			inMethod = true;
			//System.out.printf("Method %s is defined\n", ms.getName());
		} else {
			System.err.printf("Method %s is undefined\n", ctx.ID().getText());
		}
	}

	@Override
	public void exitMethodDecl(MethodDeclContext ctx) {
		String dec = "";
		//for llvm code
		MethodSymbol ms = (MethodSymbol)currentScope;
		String tmp = ((MethodSymbol)currentScope).getType().getName();
		if(tmp.equals("int")||tmp.equals("bool")) {
			dec += "int ";
		}else if(tmp.equals("void")) {
			dec += "void ";
		}else {
			dec += "void* ";
		}
		dec += " ";
		dec+= currentScope.getEnclosingScope().getName()+ "_"+((MethodSymbol)currentScope).getName();
		dec += "(";
		String tplist = ms.getParTypeList();
		if(!tplist.equals("")){
			dec+=tplist+", ";
		}
		dec +=String.format("struct %s_struct *, void*", currentScope.getEnclosingScope().getName());
		dec += ")";
		ms.methodDecl = dec;
		//for lime_main code
		dec = "";
		String rettype= ((MethodSymbol)currentScope).getType().getName();
		if(rettype.equals("int")|| rettype.equals("int")) {
			dec += "int ";
		}else  if(rettype.equals("void")){
			dec += "void ";
		}else{
			dec += "void *";
		}
		dec += currentScope.getEnclosingScope().getName()+ "_"+((MethodSymbol)currentScope).getName();
		dec += "(";
		String tplist2 = ms.getParTypeList();
		if(!tplist2.equals("")){
			String tmp2[] = tplist2.split(","); 
			for(int i=0; i<tmp2.length; ++i) {
				if(tmp2[i].equals("int")||tmp2[i].equals("bool")) continue;
				else tmp2[i] ="void *";
			}
			dec+=String.join(",", tmp2)+", ";
		}
		dec +="void*, void*)";
		//System.out.println(dec);
		ms.methodDeclforMain = dec;
		if(ctx.guard()==null) ms.setUnguarded();
		inMethod = false;
		ms.setEnabled(ms.guardIds);
		
		currentScope = currentScope.getEnclosingScope();
		//System.out.printf("Exit Method %s scope\n", ctx.ID().getText());
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
		//System.out.printf("Action %s is defined\n", as.getName());
	}
	
	@Override
	public void exitActionDecl(ActionDeclContext ctx) {
		if(ctx.guard()==null) ((ActionSymbol)currentScope).setUnguarded();
		currentScope = currentScope.getEnclosingScope();
		//System.out.printf("Exit action %s scope\n", ctx.ID().getText());
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
		//System.out.printf("Class init is defined\n");
	}
	
	@Override
	public void exitInitDecl(InitDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		//System.out.printf("Exit init\n");
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
			//System.out.printf("Feild variable is defined: %s\t %s\n", vs.getName(), vs.getType().getName());
			currentScope.define(vs);
		}
	}
	
	
	@Override
	public void exitGetRand(GetRandContext ctx) {
		((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put("getRand", "int getRand(int)");
	}

	@Override
	public void exitGetArg(GetArgContext ctx) {
		((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put("getArg", "int getArg(int)");
	}

	@Override
	public void exitSetRand(SetRandContext ctx) {
		((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put("setRand", "void setRand(int)");
	}

	@Override
	public void enterPrint(PrintContext ctx) {
		((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put("print", "void print(int)");
	}
	
	@Override
	public void enterExit(ExitContext ctx) {
		((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put("exit", "void exit()");
	}

	@Override
	public void enterGuardatomid(GuardatomidContext ctx) {
		if(inMethod) {
			MethodSymbol ms = (MethodSymbol)currentScope;
			ms.guardIds.add(ctx.ID().getText());
		}
	}
	//multi_assign
	//: id_list ':=' expr_list;
	@Override
	public void enterMulti_assign(Multi_assignContext ctx) {
		multiAssign = true;
	}

	@Override
	public void exitMulti_assign(Multi_assignContext ctx) {
		multiAssign = false;
	}
	
	//id_ele
	//: ID selector? ;	

	@Override
	public void exitId_ele(Id_eleContext ctx) {
		if(inMethod) {
			MethodSymbol ms = (MethodSymbol)currentScope;
			ms.methodAssignLvalue.add(ctx.ID().getText());
		}
	}
	
	
	
	@Override
	public void enterSingle_assign(Single_assignContext ctx) {
		Symbol s = (Symbol) currentScope;
		//System.err.printf("******************************add enabled guard %s\n", ctx.id_ele().ID().getText());
		if (s instanceof MethodSymbol) {
			MethodSymbol ms = (MethodSymbol)s;
			//System.err.printf("******************************add enabled guard %s\n", ctx.id_ele().ID().getText());
			ms.methodAssignLvalue.add(ctx.id_ele().ID().getText());
		}
	}
	
	// 'new' n=ID args
	@Override
	public void enterNewcall(NewcallContext ctx) {
		if (ctx.n != null) {
			Symbol s = currentScope.resolve(ctx.n.getText());
			if (!(s instanceof ClassSymbol)) {
				System.err.printf("Error: new ID args: ID  (%s) should be class symbol!\n", ctx.n.getText());
			}
			// add init method
			
			String value = ctx.n.getText() + "_init"+ctx.args().getText();
			//System.out.print(value);
			((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put(ctx.n.getText() + "_init", value);//(ctx.n.getText() + "_init");
		}
	}

	// c=ID '.' m=ID args
	@Override
	public void enterMethodcall(MethodcallContext ctx) {
		Symbol s = currentScope.resolve(ctx.c.getText());
		if (s == null)
			System.err.printf("Error: object %s can't be resloved\n", ctx.c.getText());
		//System.out.printf("Info: object %s can't be resloved\n", ctx.c.getText());
		Symbol c = null;
		if (s instanceof FieldSymbol) {
			c = currentScope.resolve(((FieldSymbol) s).getType().getName());
		} else if (s instanceof VariableSymbol) {
			c = this.symtab.GLOBALS.resolve(((VariableSymbol) s).getType().getName());
		} else if (s instanceof ParameterSymbol) {
			c = this.symtab.GLOBALS.resolve(((ParameterSymbol) s).getType().getName());
		}
		if (!(c instanceof ClassSymbol)) {
			System.err.printf("Error: %s should be an object!\n", ctx.c.getText());
		}

		MethodSymbol m = ((ClassSymbol) c).resolveMethod(ctx.m.getText());

		if (m == null) {
			System.err.printf("Error: %s should be method!\n", ctx.m.getText());
		}
		String value =c.getName()+"_"+ ctx.m.getText()+ctx.args().getText();
		((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put(c.getName()+"_"+ ctx.m.getText(), value);//add(ctx.m.getText());
	}
	
	//arrayElement '.' m=ID args			   #arrayElementmethodcall
	@Override
	public void exitArrayElementmethodcall(ArrayElementmethodcallContext ctx) {
		Symbol s = currentScope.resolve(ctx.arrayElement().ID().getText());
		ClassSymbol cs = (ClassSymbol)currentScope.resolve(((FieldSymbol)s).getType().getName());
		String value =cs.getName()+"_"+ ctx.m.getText()+ctx.args().getText();
		((ClassSymbol) (currentScope.getEnclosingScope())).methodsCalled.put(cs.getName()+"_"+ ctx.m.getText(), value);//add(ctx.m.getText());
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
			//System.out.printf("Method arg: %s: %s is defined\n", ps.getName(), typ.getName());
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
			//System.out.printf("Local variable var: %s is defined\n", vs.getName());
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
				//System.out.printf("Resolve the type: %s\n", typ.getName());
			} else {
				System.err.printf("Type ID shoud be a class: %s\n", cs.getName());
			}
		} else if (ctx.arrayDecl() != null) {
			typ = (Type) ctx.arrayDecl().typ;
			//System.out.printf("Array is defined: %s\n", typ.getName());
		} else if(ctx.enumDecl()!=null){
			typ = ctx.enumDecl().typ;
			//System.out.printf("EnumDecl is defined: %s\n", typ.getName());
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
					//System.out.println("arrayDecl: type: \t"+ cs.getName());
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
			//System.out.printf("enumValue: %s  is defined\n", id.getText());
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
