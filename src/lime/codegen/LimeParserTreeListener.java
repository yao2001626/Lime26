package lime.codegen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import lime.antlr4.ActionSymbol;
import lime.antlr4.BaseSymbol;
import lime.antlr4.ClassSymbol;
import lime.antlr4.FieldSymbol;
import lime.antlr4.GlobalScope;
import lime.antlr4.LimeGrammarBaseListener;
import lime.antlr4.MethodSymbol;
import lime.antlr4.ParameterSymbol;
import lime.antlr4.PrimitiveType;
import lime.antlr4.Scope;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;
import lime.antlr4.Type;
import lime.antlr4.VariableSymbol;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.AddexprContext;
import lime.antlr4.LimeGrammarParser.AndexprContext;
import lime.antlr4.LimeGrammarParser.AtomContext;
import lime.antlr4.LimeGrammarParser.AtomexprContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.CompilationUnitContext;
import lime.antlr4.LimeGrammarParser.EqexprContext;
import lime.antlr4.LimeGrammarParser.ExprContext;
import lime.antlr4.LimeGrammarParser.Expr_listContext;
import lime.antlr4.LimeGrammarParser.Expr_stmtContext;
import lime.antlr4.LimeGrammarParser.FieldDeclContext;
import lime.antlr4.LimeGrammarParser.GuardAtomContext;
import lime.antlr4.LimeGrammarParser.GuardContext;
import lime.antlr4.LimeGrammarParser.GuardandexprContext;
import lime.antlr4.LimeGrammarParser.GuardatomexprContext;
import lime.antlr4.LimeGrammarParser.GuardcompexprContext;
import lime.antlr4.LimeGrammarParser.GuardeqexprContext;
import lime.antlr4.LimeGrammarParser.GuardorexprContext;
import lime.antlr4.LimeGrammarParser.Id_listContext;
import lime.antlr4.LimeGrammarParser.IdguardatomContext;
import lime.antlr4.LimeGrammarParser.Import_stmtContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.IntguardatomContext;
import lime.antlr4.LimeGrammarParser.LocalDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.LimeGrammarParser.Method_callContext;
import lime.antlr4.LimeGrammarParser.MethodcallContext;
import lime.antlr4.LimeGrammarParser.MultexprContext;
import lime.antlr4.LimeGrammarParser.Multi_assignContext;
import lime.antlr4.LimeGrammarParser.NewcallContext;
import lime.antlr4.LimeGrammarParser.NotexprContext;
import lime.antlr4.LimeGrammarParser.NotguardtomContext;
import lime.antlr4.LimeGrammarParser.OrexprContext;
import lime.antlr4.LimeGrammarParser.ParsdefContext;
import lime.antlr4.LimeGrammarParser.TypeContext;
import lime.antlr4.LimeGrammarParser.UnaryMinusexprContext;
import lime.antlr4.MemberSymbol;

public class LimeParserTreeListener extends LimeGrammarBaseListener {
	Scope currentScope;
	SymbolTable symtab;
	String guardASMcode = "";
	Stack<String> regs;
	Stack<String> regAvail;
	Stack<Integer> notOps;
	String className = "";
	String methodName = "";
	String objInitCode = "";
	boolean initcode = false;
	boolean inMethod =false;
	boolean startClass = false;
	public Map<String, String> guardmap;
	public Map<String, String> initcodemap;

	public LimeParserTreeListener(SymbolTable symtab) {
		this.symtab = symtab;
		this.currentScope = symtab.GLOBALS;
		regAvail = new Stack<String>();
		regs = new Stack<String>();
		notOps = new Stack<Integer>();
		this.regAvail.push("EAX");
		this.regAvail.push("EDX");
		this.guardmap = new HashMap<String, String>();
		this.initcodemap = new HashMap<String, String>();
		this.objInitCode = "";

	}
	// compilationUnit
	// : (classDecl+) EOF ;

	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		// System.out.println("enter class"+ currentScope);
		ClassSymbol cs = new ClassSymbol(ctx.ID().getText());
		cs.setDefNode((ParserRuleContext) ctx);
		ctx.scope = cs;
		currentScope.define(cs);
		currentScope = cs;
		className = ctx.ID().getText();
		if(cs.getName().equals("Start")) startClass = true;
	}

	@Override
	public void enterCompilationUnit(CompilationUnitContext ctx) {
		// TODO Auto-generated method stub
		super.enterCompilationUnit(ctx);
	}

	@Override
	public void exitCompilationUnit(CompilationUnitContext ctx) {
		// TODO Auto-generated method stub
		super.exitCompilationUnit(ctx);
	}

	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		// System.out.println("exit class: definde methods: "+
		// ((ClassSymbol)currentScope).getNumberOfDefinedMethods()+
		// ((ClassSymbol)currentScope).getNumberOfFields()+((ClassSymbol)currentScope).getNumberOfDefinedActions());
		
		//System.out.println(((ClassSymbol)currentScope).methodCalled);
		
		((ClassSymbol)currentScope).addExternalFunction();
		//System.out.println(((ClassSymbol)currentScope).externMethods);
		currentScope = currentScope.getEnclosingScope();
		// System.out.println("global: " +this.symtab.GLOBALS);
		// System.out.println("methods: "+
		// ((ClassSymbol)this.symtab.GLOBALS.resolve("PQ")).getDefinedMethods());
		// System.out.println("actions: "+
		// ((ClassSymbol)this.symtab.GLOBALS.resolve("PQ")).getDefinedMethods());
		// System.out.println("symbols: "+ this.symtab.GLOBALS.getSymbols() +
		// this.symtab.GLOBALS.getNumberOfSymbols());
		className = "";
		startClass = false;
	}
	//import_stmt
	//  : 'import' ID'(' type_list ')' (':' type)?;
	@Override
	public void enterImport_stmt(Import_stmtContext ctx) {
		MethodSymbol ms = new MethodSymbol(ctx.ID().getText());
		if(ctx.type()==null) {
			ms.setType((Type)symtab.GLOBALS.getSymbol("void"));
		}else {
			ms.setType((Type)symtab.GLOBALS.getSymbol("int"));
		}
		int n = ctx.type_list().getChildCount();
		ms.setNumArgs(n);
		symtab.PREDEFINED.define(ms);
	}

	
	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		//System.out.println("enter method: "+ currentScope);
		MethodSymbol ms = new MethodSymbol(ctx.ID().getText());
		ctx.scope = ms;
		ms.setDefNode((ParserRuleContext) ctx);
		currentScope.define(ms);
		currentScope = ms;
		methodName = ctx.ID().getText();
		inMethod = true;
	}

	@Override
	public void exitMethodDecl(MethodDeclContext ctx) {
		// System.out.println("exit method guard: "+ctx.guard().getText()+"\n"+
		// guardASMcode);
		guardmap.put(className + methodName, guardASMcode);
		
		MethodSymbol ms = (MethodSymbol) currentScope;
		ms.guard = this.guardASMcode;
		ms.setEnabled(((ClassSymbol) currentScope.getEnclosingScope()).classGuardIds);
		if(ctx.guard()==null) ms.setUnguarded();
		inMethod = false;
		this.guardASMcode = "";
		currentScope = currentScope.getEnclosingScope();
		methodName = "";
		
	}

	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		// System.out.println("enter action: "+ currentScope);
		ActionSymbol as = new ActionSymbol(ctx.ID().getText());
		ctx.scope = as;
		as.setDefNode((ParserRuleContext) ctx);
		currentScope.define(as);
		currentScope = as;
		methodName = ctx.ID().getText();
	}

	@Override
	public void exitActionDecl(ActionDeclContext ctx) {
		// System.out.println("exit action guard: "+ctx.guard().getText()+"\n" +
		// guardASMcode);
		guardmap.put(className + methodName, guardASMcode);
		ActionSymbol as = (ActionSymbol) currentScope;
		as.guard = this.guardASMcode;
		if(ctx.guard()==null) as.setUnguarded();
		this.guardASMcode = "";
		currentScope = currentScope.getEnclosingScope();
		methodName = "";
	}

	@Override
	public void enterFieldDecl(FieldDeclContext ctx) {
		List<TerminalNode> ids = ctx.id_list().ID();
		for (TerminalNode x : ids) {
			FieldSymbol vs = new FieldSymbol(x.getText());
			vs.setType((Type) currentScope.resolve(ctx.type().getText()));
			currentScope.define(vs);
		}
	}

	public boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	@Override
	public void enterInitDecl(InitDeclContext ctx) {
		// System.out.println("init enter: " + currentScope);
		MethodSymbol ms = new MethodSymbol("init");
		ms.setDefNode((ParserRuleContext) ctx);
		ctx.scope = ms;
		currentScope.define(ms);
		currentScope = ms;
		// init code generator: only allow multiple assignment
		initcode = true;
	}

	@Override
	public void exitInitDecl(InitDeclContext ctx) {
		// System.out.println("init exit: " + currentScope);
		initcode = false;
		currentScope = currentScope.getEnclosingScope();
	}

	/*
	 * init code generator: Map<String, String> init_args; E.g.: init_args =
	 * {"a":"true", "key": "3", "index":"arg0"} the value of the map can be: 1.
	 * constant value: true, nil, true, 1, 2 2. arguments: arg${index}
	 */
	String genInitCode() {
		String code = "";
		ClassSymbol cs = (ClassSymbol) currentScope.getEnclosingScope();
		if(!cs.getName().equals("Start")) {
			if (initcodemap.size() > 0) {
				for (String i : initcodemap.keySet()) {
					int fieldIndex = ((ClassSymbol) currentScope.getEnclosingScope()).getFieldIndex(i);
					if (fieldIndex == -1) {
						//System.err.println((ClassSymbol) (currentScope.getEnclosingScope()));
						//System.err.printf("Didn't find field %s in init code\n", i);
					}
					if (initcodemap.get(i).startsWith("arg")) {
						int argIndex = ((MethodSymbol) currentScope).getParIndex(initcodemap.get(i).substring(3));
						if (argIndex == -1) {
							System.err.println((MethodSymbol) currentScope);
							System.err.printf("Didn't find arg %s in init code\n", initcodemap.get(i).substring(3));
						}
						code += String.format("MOV DWORD ECX, [ESP + %d]\n\t", (argIndex + 1) * 4);
						code += String.format("MOV DWORD [EAX + %d], ECX\n\t", (fieldIndex+4) * 4);
					} else {//
						code += String.format("MOV DWORD [EAX + %d], %s\n\t", (fieldIndex+4) * 4, initcodemap.get(i));
					}
				}
			}
		}
		return code;
	}

	// for init code of the object
	// multi_assign
	// : id_list ':=' expr_list;
	@Override
	public void enterMulti_assign(Multi_assignContext ctx) {
		if (initcode && !startClass) {
			String[] ids = ctx.id_list().getText().split(",");
			String[] vals = ctx.expr_list().getText().split(",");
			if (ids.length != vals.length) {
				System.err.printf("multi assign mismatch ids :%d vals: %d \n", ids.length, vals.length);
			} else {
				for (int i = 0; i < ids.length; ++i) {
					if (vals[i].startsWith("0") || vals[i].startsWith("false") || vals[i].startsWith("nil"))
						continue;
					if (vals[i] == "true") {
						initcodemap.put(ids[i], "1");
					} else if (isNumeric(vals[i])) {
						initcodemap.put(ids[i], vals[i]);
					} else {// should be parameter
						Symbol s = currentScope.resolve(vals[i]);
						if (s instanceof ParameterSymbol) {
							initcodemap.put(ids[i], "arg" + vals[i]);
						} else {
							System.err.printf(
									"init code multi assign only support simple value, such as constant number, parameters %s:=%s class: %s bool %b)\n", ids[i],vals[i], className, startClass);
						}
					}
				}
			}
			// gen init code
			ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
			cs.setObjInitCode(genInitCode());
		}
		if(inMethod) {
			String[] ids = ctx.id_list().getText().split(",");
			MethodSymbol ms = (MethodSymbol)currentScope;
			for(String id:ids) {
				ms.methodAssignLvalue.add(id);
			}
		}
	}

	// parsdef
	// : ID ':' type ;
	@Override
	public void enterParsdef(ParsdefContext ctx) {
		// System.out.println("parameter def: " + currentScope);
		ParameterSymbol ps = new ParameterSymbol(ctx.ID().getText());
		ps.setDefNode(ctx);
		Type t = (Type) currentScope.resolve(ctx.type().getText());
		ps.setType(t);
		currentScope.define(ps);
	}

	@Override
	public void enterLocalDecl(LocalDeclContext ctx) {
		// System.out.println("local var def: " + currentScope);
		Type t = (Type) currentScope.resolve(ctx.type().getText());
		List<TerminalNode> ids = ctx.id_list().ID();
		for (TerminalNode x : ids) {
			VariableSymbol vs = new VariableSymbol(x.getText());
			vs.setType((Type) currentScope.resolve(t.getName()));
			currentScope.define(vs);
		}
	}

	// guardAtom op=( '>=' | '<=' | '>' | '<' ) guardAtom
	@Override
	public void exitGuardcompexpr(GuardcompexprContext ctx) {
		// System.out.println("guard comare defines: " + ctx.getText());
		String op = ctx.op.getText();
		String strFormat = "CMP DWORD %s, %s\n";
		String rightreg = regs.pop();
		String leftreg = regs.pop();
		String succeed = className + "_" + methodName + "_succeed";
		String output = "";
		if (ctx.guardAtom(0) != null && ctx.guardAtom(1) != null) {
			// id_0 should be in reg0 and id_1 should be in reg1
			output = String.format(strFormat, leftreg, rightreg);
		}
		switch (op) {
		case ">=":
			output += "JGE " + succeed + "\n";
			break;
		case "<=":
			output += "JLE " + succeed + "\n";
			break;
		case ">":
			output += "JG " + succeed + "\n";
			break;
		case "<":
			output += "JL " + succeed + "\n";
			break;
		default:
			output += "failed\n";
		}
		regAvail.push(leftreg);
		regAvail.push(rightreg);
		this.guardASMcode += output;
	}

	// guard op=( '=' | '!=' ) guard
	@Override
	public void exitGuardeqexpr(GuardeqexprContext ctx) {
		// System.out.println("guard equal defines: " + ctx.getText());
		String op = ctx.op.getText();
		String strFormat = "CMP DWORD %s, %s\n";
		String succeed = className + "_" + methodName + "_succeed";
		String rightreg = regs.pop();
		String leftreg = regs.pop();
		String output = "";
		if (ctx.guardAtom(0) != null && ctx.guardAtom(1) != null) {
			// id_0 should be in reg0 and id_1 should be in reg1
			output = String.format(strFormat, leftreg, rightreg);
		}
		switch (op) {
		case "=":
			output += "JEQ " + succeed + "\n";
			break;
		case "!=":
			output += "JNE " + succeed + "\n";
			break;
		default:
			output += "failed\n";
		}
		regAvail.push(leftreg);
		regAvail.push(rightreg);
		this.guardASMcode += output;
	}

	// guardAtom 'and' guardAtom
	@Override
	public void exitGuardandexpr(GuardandexprContext ctx) {
		// System.out.println("guard and defines: " + ctx.getText());
		String strFormat = "CMP DWORD %s, 1\n";
		String succeed = className + "_" + methodName + "_succeed";
		String failed = className + "_" + methodName + "_checkguard_fail";
		int rightnot = notOps.pop();
		int leftnot = notOps.pop();
		String rightreg = regs.pop();
		String leftreg = regs.pop();
		String output = "";
		if (ctx.guardAtom(0) != null && ctx.guardAtom(1) != null) {
			// if guardAtom failed goto failed
			String right = String.format(strFormat, rightreg);
			String left = String.format(strFormat, leftreg);
			output += left;
			if (leftnot == 1)
				output += "JE " + failed + "\n";
			else
				output += "JNE " + failed + "\n";
			output += right;
			if (rightnot == 1)
				output += "JNE " + succeed + "\n";
			else
				output += "JE " + succeed + "\n";
		}
		regAvail.push(leftreg);
		regAvail.push(rightreg);
		this.guardASMcode += output;

	}

	// guardAtom 'or' guardAtom
	@Override
	public void exitGuardorexpr(GuardorexprContext ctx) {
		// System.out.println("guard or defines: " + ctx.getText());
		String strFormat = "CMP DWORD %s, 1\n";
		String succeed = className + "_" + methodName + "_succeed";
		//String failed = className + "_" + methodName + "_checkguard_fail";
		String output = "";
		int rightnot = notOps.pop();
		int leftnot = notOps.pop();
		String rightreg = regs.pop();
		String leftreg = regs.pop();
		if (ctx.guardAtom(0) != null && ctx.guardAtom(1) != null) {
			String right = String.format(strFormat, rightreg);
			String left = String.format(strFormat, leftreg);
			output += left;
			if (leftnot == 1)
				output += "JNE " + succeed + "\n";
			else
				output += "JE " + succeed + "\n";
			output += right;
			if (rightnot == 1)
				output += "JNE " + succeed + "\n";
			else
				output += "JE " + succeed + "\n";
		}
		regAvail.push(leftreg);
		regAvail.push(rightreg);
		this.guardASMcode += output;
	}

	@Override
	public void exitGuardatomexpr(GuardatomexprContext ctx) {
		// System.out.println("guard atom defines: " + ctx.getText());
		// regAvail.push();
		String arg = regs.pop();
		int guardnot = notOps.pop();
		String succeed = className + "_" + methodName + "_succeed";
		String output = String.format("CMP DWORD %s, 1\n", arg);
		if (guardnot == 1)
			output += "JNE " + succeed + "\n";
		else
			output += "JE " + succeed + "\n";
		this.guardASMcode += output;
		regAvail.push(arg);
	}

	@Override
	public void exitIdguardatom(IdguardatomContext ctx) {
		String a = regAvail.pop();
		ClassSymbol cls = (ClassSymbol) currentScope.resolve(className);
		FieldSymbol fs = (FieldSymbol) currentScope.resolve(ctx.ID().getText());
		int index = cls.getDefinedFields().indexOf(fs);
		String s = "MOV DWORD " + a + ", " + "[ECX + %d]\n";
		String o = String.format(s, (index + 4) * 4);
		this.guardASMcode += o;
		regs.push(a);
		notOps.push(0);
		
		cls.classGuardIds.add(ctx.ID().getText());
		
	}

	@Override
	public void exitIntguardatom(IntguardatomContext ctx) {
		regs.push(ctx.INTEGER().getText());
		notOps.push(0);
	}

	@Override
	public void exitNotguardtom(NotguardtomContext ctx) {
		String r = regAvail.pop();
		ClassSymbol cls = (ClassSymbol) currentScope.resolve(className);
		FieldSymbol fs = (FieldSymbol) currentScope.resolve(ctx.ID().getText());
		int index = cls.getDefinedFields().indexOf(fs);
		String s = "MOV DWORD " + r + ", " + "[ECX + %d]\n";
		String o = String.format(s, (index + 4) * 4);
		this.guardASMcode += o;
		regs.push(r);
		notOps.push(1);
		cls.classGuardIds.add(ctx.ID().getText());
	}

	// atom
	// : INTEGER | True | False | Null | ID | method_call;
	@Override
	public void enterAtom(AtomContext ctx) {
		if (ctx.ID() != null) {
			Symbol s = currentScope.resolve(ctx.ID().getText());
			if (s == null) {
				System.err.printf("Error: can't resolve %s!\n", ctx.ID().getText());
			}
		}
	}

	// : 'new' n=ID args
	@Override
	public void enterNewcall(NewcallContext ctx) {
		if (ctx.n != null) {
			Symbol s = currentScope.resolve(ctx.n.getText());
			if (!(s instanceof ClassSymbol)) {
				System.err.printf("Error: new ID args: ID  (%s) should be class symbol!\n", ctx.n.getText());
			}
		}
	}

	// | c=ID '.' m=ID args
	@Override
	public void enterMethodcall(MethodcallContext ctx) {
		if (ctx.ID(1) != null) {
			// Symbol s = this.symtab.GLOBALS.resolve(ctx.c.getText());
			Symbol s = currentScope.resolve(ctx.c.getText());
			Symbol c = this.symtab.GLOBALS.resolve(((FieldSymbol) s).getType().getName());
			if (!(c instanceof ClassSymbol)) {
				System.err.printf("Error: c=ID . m=ID args: c=ID (%s) should be class symbol!\n", ctx.c.getText());
			}
			MethodSymbol m = ((ClassSymbol) c).resolveMethod(ctx.m.getText());
			if (m == null) {
				System.err.printf("Error: c=ID . m=ID args: c=ID (%s: %s) should be method symbol!\n", ctx.m.getText(),
						c.getScope());
			}
			//methodcalled
			((ClassSymbol)(currentScope.getEnclosingScope())).methodCalled.add(((FieldSymbol) s).getType().getName()+"_"+m.getName());
		}
	}
}
