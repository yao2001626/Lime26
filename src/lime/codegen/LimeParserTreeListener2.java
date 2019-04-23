package lime.codegen;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import lime.antlr4.ActionSymbol;
import lime.antlr4.ArrayType;
import lime.antlr4.ClassSymbol;
import lime.antlr4.EnumSymbol;
import lime.antlr4.EnumType;
import lime.antlr4.FieldSymbol;
import lime.antlr4.LimeGrammarBaseListener;
import lime.antlr4.MethodSymbol;
import lime.antlr4.ParameterSymbol;
import lime.antlr4.Scope;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;
import lime.antlr4.Type;
import lime.antlr4.VariableSymbol;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.ArrayCreateContext;
import lime.antlr4.LimeGrammarParser.ArrayDeclContext;
import lime.antlr4.LimeGrammarParser.ArrayElementContext;
import lime.antlr4.LimeGrammarParser.ArrayElementmethodcallContext;
import lime.antlr4.LimeGrammarParser.AtomContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.EnumDeclContext;
import lime.antlr4.LimeGrammarParser.FieldDeclContext;
import lime.antlr4.LimeGrammarParser.GetArgContext;
import lime.antlr4.LimeGrammarParser.GetRandContext;
import lime.antlr4.LimeGrammarParser.GuardatomidContext;
import lime.antlr4.LimeGrammarParser.Id_eleContext;
import lime.antlr4.LimeGrammarParser.Id_listContext;
import lime.antlr4.LimeGrammarParser.ImportstmtContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.LocalDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.LimeGrammarParser.MethodcallContext;
import lime.antlr4.LimeGrammarParser.Multi_assignContext;
import lime.antlr4.LimeGrammarParser.NewcallContext;
import lime.antlr4.LimeGrammarParser.ParsdefContext;
import lime.antlr4.LimeGrammarParser.PrintContext;
import lime.antlr4.LimeGrammarParser.SetRandContext;
import lime.antlr4.LimeGrammarParser.TypeContext;
import lime.antlr4.LimeGrammarParser.UserDefinedContext;

public class LimeParserTreeListener2 extends LimeGrammarBaseListener {
	Scope currentScope;
	SymbolTable symtab;
	String className = "";
	boolean startClass = false;
	boolean inMethod =false;
	boolean multiAssign= false;
	LimeParserTreeListener2(SymbolTable symtab) {
		this.symtab = symtab;
		this.currentScope = symtab.GLOBALS;
	}

	public boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	// importstmt
	// : 'import' ID'(' type_list ')' (':' type)? NEWLINE;
	@Override
	public void enterImportstmt(ImportstmtContext ctx) {
		String importFun = " ";
		if (ctx.type() != null) {
			importFun += ctx.type().getText() + importFun;
		} else {
			importFun += "void" + importFun;
		}
		importFun += ctx.ID().getText();
		importFun += '(';
		importFun += ctx.type_list().getText();
		importFun += ");\n";
		this.symtab.importedMethod.put(ctx.ID().getText(), importFun);
	}

	// classDecl returns [Scope scope]
	// : 'class' ID NEWLINE INDENT classMember* DEDENT ;
	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		ClassSymbol cs = new ClassSymbol(ctx.ID().getText());
		cs.setDefNode((ParserRuleContext) ctx);
		ctx.scope = cs;
		currentScope.define(cs);
		currentScope = cs;
		className = ctx.ID().getText();
		if (cs.getName().equals("Start"))
			startClass = true;
	}

	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		//System.out.println(currentScope);
		currentScope = currentScope.getEnclosingScope();
	}

	// : 'method' ID parameters (':' type)? (NEWLINE INDENT 'when' guard 'do')?
	// block (DEDENT)?;
	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		MethodSymbol ms = new MethodSymbol(ctx.ID().getText());
		ctx.scope = ms;
		ms.setDefNode((ParserRuleContext) ctx);
		if (ctx.type() == null)
			ms.setType((Type) symtab.GLOBALS.resolve("void"));
		else
			ms.setType((Type) symtab.GLOBALS.resolve(ctx.type().getText()));
		currentScope.define(ms);
		currentScope = ms;
		inMethod = true;
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
	}

	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		ActionSymbol as = new ActionSymbol(ctx.ID().getText());
		ctx.scope = as;
		as.setDefNode((ParserRuleContext) ctx);
		currentScope.define(as);
		currentScope = as;
	}

	// actionDecl returns [Scope scope]
	// : 'action' ID (NEWLINE INDENT 'when' guard 'do')? block (DEDENT)? ;
	@Override
	public void exitActionDecl(ActionDeclContext ctx) {
		// TODO Auto-generated method stub
		if(ctx.guard()==null) ((ActionSymbol)currentScope).setUnguarded();
		currentScope = currentScope.getEnclosingScope();
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
	public void enterGuardatomid(GuardatomidContext ctx) {
		if(inMethod) {
			MethodSymbol ms = (MethodSymbol)currentScope;
			ms.guardIds.add(ctx.ID().getText());
		}
	}

	// type returns [Type typ]
	// : 'int' | 'bool' | 'void' | ID | arrayDecl;
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
			ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(ctx.ID().getText());
			if (cs == null)
				System.err.printf("Can't resolve the type: %s\n", ctx.ID().getText());
			else
				typ = (Type) cs;
		} else if (ctx.arrayDecl() != null) {
			typ = (Type) ctx.arrayDecl().typ;
		} else if(ctx.enumDecl()!=null){
			typ = ctx.enumDecl().typ;
		}
		else{
			System.err.printf("Can't resolve the type %s\n", ctx.getText());
		}
		ctx.typ = typ;
	}

	// fieldDecl
	// : 'var' id_list ':' type NEWLINE ;
	@Override
	public void exitFieldDecl(FieldDeclContext ctx) {
		
		List<Id_eleContext> idele = ctx.id_list().id_ele();
		for (Id_eleContext x : idele) {
			FieldSymbol vs = new FieldSymbol(x.ID().getText());
			vs.setType((Type) ctx.type().typ);
			currentScope.define(vs);
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
		if(inMethod && multiAssign) {
			MethodSymbol ms = (MethodSymbol)currentScope;
			ms.methodAssignLvalue.add(ctx.ID().getText());
		}
	}

	// arrayDecl returns [ArrayType typ]
	// :'array' 'of' ty=('int' | 'bool' | ID);
	@Override
	public void enterArrayDecl(ArrayDeclContext ctx) {
		ArrayType arrtyp = null;
		if (ctx.ty != null) {
			if (ctx.ty.getText().equals("int")) {
				arrtyp = new ArrayType((Type) symtab.GLOBALS.resolve("int"));
			} else if (ctx.ty.getText().equals("bool")) {
				arrtyp = new ArrayType((Type) symtab.GLOBALS.resolve("bool"));
			} else {// array of Objects
				ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(ctx.ID().getText());
				if (cs == null) {
					System.err.printf("arrayDecl: type %s can't resolve\n", ctx.ID().getText());
				}
				arrtyp = new ArrayType((Type) cs);
			}
		} else {
			System.err.println("arrayDecl: type is null");
		}
		ctx.typ = arrtyp;
	}
	
	//enumDecl returns [Type typ]
	//: '{' ID (',' ID)* '}';
	@Override
	public void enterEnumDecl(EnumDeclContext ctx) {
		ClassSymbol cs = (ClassSymbol) currentScope;
		EnumType et = new EnumType(); 
		LinkedHashSet<String> vals = new LinkedHashSet<String>();
		for(TerminalNode id: ctx.ID()) {
			cs.define(new EnumSymbol(id.getText()));
		}
		et.addAllValues(vals);
		ctx.typ= et;
	}

	// parsdef
	// : id_list ':' type ;
	@Override
	public void exitParsdef(ParsdefContext ctx) {
		Type typ = ctx.type().typ;
		if (typ == null) {
			System.err.printf("Parameter define: the type %s can't find\n", ctx.type().typ);
		}
		
		List<Id_eleContext> idele = ctx.id_list().id_ele();
		for (Id_eleContext x : idele) {
			ParameterSymbol ps = new ParameterSymbol(x.ID().getText(), typ);
			ps.setType((Type) ctx.type().typ);
			currentScope.define(ps);
			//System.out.println("args: " + x.ID().getText());
		}
		
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
	}

	@Override
	public void exitInitDecl(InitDeclContext ctx) {
		String dec = "";
		MethodSymbol ms = (MethodSymbol)currentScope;
		String t = ((MethodSymbol)currentScope).getType().getName();
		if(t.equals("void")) {
			dec += "void ";
		}else if(t.equals("int")|| t.equals("bool")) {
			dec += "int "; 
		}else {
			dec += "struct "+t+"_struct *";
		}
		dec += " ";
		dec += currentScope.getEnclosingScope().getName()+ "_"+((MethodSymbol)currentScope).getName();
		dec += "(";
		dec += ms.getParTypeList();
		dec += ")";
		ms.methodDecl = dec;
		//for lime_main code
		dec = "void *";
		dec += currentScope.getEnclosingScope().getName()+ "_"+((MethodSymbol)currentScope).getName();
		dec += "(";
		String tplist2 = ms.getParTypeList();
		//System.out.println(tplist2);
		if(!tplist2.equals("")){
			String tmp2[] = tplist2.split(","); 
			for(int i=0; i<tmp2.length; ++i) {
				if(tmp2[i].equals("int")||tmp2[i].equals("bool")) continue;
				else tmp2[i] ="void *";
			}
			dec+=String.join(",", tmp2);
		}
		dec +=")";
		//System.out.println(dec);
		ms.methodDeclforMain = dec;
		currentScope = currentScope.getEnclosingScope();
	}

	// localDecl
	// : 'var' id_list ':' type ;
	@Override
	public void exitLocalDecl(LocalDeclContext ctx) {
		Type typ = ctx.type().typ;
		if (typ == null) {
			System.err.printf("Parameter define: the type %s can't find\n", ctx.type().typ);
		}
		List<Id_eleContext> idele = ctx.id_list().id_ele();
		for(Id_eleContext id : idele) {
			VariableSymbol vs = new VariableSymbol(id.ID().getText());
			vs.setType(typ);
			currentScope.define(vs);
		}
	}
	//id_ele
	//: ID selector? ;
	@Override
	public void enterId_ele(Id_eleContext ctx) {
		// TODO Auto-generated method stub
		super.enterId_ele(ctx);
	}
	//id_list
	//: id_ele (',' id_ele)* ;
	@Override
	public void enterId_list(Id_listContext ctx) {
		// TODO Auto-generated method stub
		super.enterId_list(ctx);
	}

	// atom
	// : INTEGER | True | False | Null | ID | method_call | arrayCreate |
	// arrayElement;
	@Override
	public void enterAtom(AtomContext ctx) {
		if (ctx.ID() != null) {
			Symbol s = currentScope.resolve(ctx.ID().getText());
			if (s == null) {
				System.err.printf("Error: can't resolve %s!\n", ctx.ID().getText());
			}
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
	
	// ID args
	@Override
	public void enterUserDefined(UserDefinedContext ctx) {
		if (!this.symtab.importedMethod.containsKey(ctx.ID().getText())) {
			System.err.printf("Error: %s method is undefined!\n", ctx.ID().getText());
		}
	}

	// arrayElement
	// : ID '[' expr ']'
	@Override
	public void enterArrayElement(ArrayElementContext ctx) {
		Symbol s = currentScope.resolve(ctx.ID().getText());
		if (s == null) {
			System.err.printf("Error: %s can't be resolved!\n", ctx.ID().getText());
		}

		if (s instanceof FieldSymbol) {
			if (!(((FieldSymbol) s).getType() instanceof ArrayType)) {
				System.err.printf("Error: FieldSymbol %s is not an Array type\n", s.getName());
			}
		} else if (s instanceof VariableSymbol) {
			if (!(((VariableSymbol) s).getType() instanceof ArrayType)) {
				System.err.printf("Error: VariableSymbol %s is not an Array type\n", s.getName());
			}
		} else if (s instanceof ParameterSymbol) {
			if (!(((ParameterSymbol) s).getType() instanceof ArrayType)) {
				System.err.printf("Error: ParameterSymbol %s is not an Array type\n", s.getName());
			}
		} else {
			System.err.printf("Error: Symbol %s unsupported for Array\n", s.getName());
		}
	}

	// arrayCreate
	// : 'new' ty=('int' | 'bool' | ID) '[' expr ']'
	@Override
	public void enterArrayCreate(ArrayCreateContext ctx) {
		if (ctx.ID() != null) {
			Symbol s = this.symtab.GLOBALS.resolve(ctx.ID().getText());
			if (s == null) {
				System.err.printf("Error: undefined %s!\n", ctx.ID().getText());
			}
		}
	}
	
	//| ID 
	@Override
	public void exitGuardatomid(GuardatomidContext ctx) {
		if(ctx.ID() != null) {
			Symbol s = currentScope.resolve(ctx.ID().getText());
			if (s == null) {
				System.err.printf("Error: guard ID: %s can't be resolved!\n", ctx.ID().getText());
			}
			if (!(s instanceof FieldSymbol) && !(s instanceof EnumSymbol)) {
				System.err.printf("Error: %s is not a field symbol. Only fields can be used as guard in Lime!\n", ctx.ID().getText());
			}
			
		}
	}
	

}
