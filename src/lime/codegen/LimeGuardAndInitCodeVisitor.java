package lime.codegen;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import lime.antlr4.ActionSymbol;
import lime.antlr4.ClassSymbol;
import lime.antlr4.EnumSymbol;
import lime.antlr4.FieldSymbol;
import lime.antlr4.LimeGrammarBaseVisitor;
import lime.antlr4.MethodSymbol;
import lime.antlr4.ParameterSymbol;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.BlockContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.ClassMemberContext;
import lime.antlr4.LimeGrammarParser.GuardandexprContext;
import lime.antlr4.LimeGrammarParser.GuardatomidContext;
import lime.antlr4.LimeGrammarParser.GuardatomintContext;
import lime.antlr4.LimeGrammarParser.GuardatomnotContext;
import lime.antlr4.LimeGrammarParser.GuardcompexprContext;
import lime.antlr4.LimeGrammarParser.GuardorexprContext;
import lime.antlr4.LimeGrammarParser.GuardparenContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.LimeGrammarParser.Multi_assignContext;
import lime.antlr4.LimeGrammarParser.Simple_stmtContext;
import lime.antlr4.LimeGrammarParser.Small_stmtContext;
import lime.antlr4.LimeGrammarParser.StmtContext;
import lime.antlr4.Scope;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;
import lime.antlr4.VariableSymbol;

public class LimeGuardAndInitCodeVisitor extends LimeGrammarBaseVisitor<String> {
	SymbolTable symtab;
	Scope currentScope;
	String guards;
	Map<String, String> initcode;
	String className;
	String methodName;
	Map<String, String> negatedOpPair;
	boolean inGuardcompexpr = false;
	static int labelnum = 100;
	Stack<String> availRegs;
	Stack<String> operands;

	LimeGuardAndInitCodeVisitor(SymbolTable st) {
		this.symtab = st;
		this.currentScope = st.GLOBALS;

		negatedOpPair = new HashMap<String, String>();
		initNegatedOpPair();
		availRegs = new Stack<String>();
		availRegs.push("EAX");
		availRegs.push("EBX");
		availRegs.push("EDX");
		operands = new Stack<String>();
	}

	void initNegatedOpPair() {
		negatedOpPair.put("JGE", "JL");
		negatedOpPair.put("JG", "JLE");
		negatedOpPair.put("JLE", "JG");
		negatedOpPair.put("JL", "JGE");
		negatedOpPair.put("JE", "JNE");
		negatedOpPair.put("JNE", "JE");
	}

	// classDecl returns [Scope scope]
	// : 'class' ID NEWLINE INDENT classMember* DEDENT ;
	@Override
	public String visitClassDecl(ClassDeclContext ctx) {
		String s = "";
		className = ctx.ID().getText();
		//System.out.printf("Class: %s\n", className);
		if(className.equals("Start")) return s;
		this.initcode = new HashMap<String, String>();
		for (ClassMemberContext m : ctx.classMember()) {
			String t = this.visit(m);
			if (t != null)
				s += t + "\n";
		}
		return s;
	}
	
	/*
	 * init code generator: Map<String, String> initcode; E.g.: initcode =
	 * {"a":"true", "key": "3", "index":"arg0"} the value of the map can be: 1.
	 * constant value: true, nil, true, 1, 2 2. arguments: arg${index}
	 */

	boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	String genInitCode() {
		String code = "";
		ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
		if (!cs.getName().equals("Start")) {
			if (initcode.size() > 0) {

				for (String i : initcode.keySet()) {
					int fieldIndex = ((ClassSymbol) cs).getFieldIndex(i);
					if (fieldIndex == -1) {
						// System.err.println((ClassSymbol) (currentScope.getEnclosingScope()));
						// System.err.printf("Didn't find field %s in init code\n", i);
					}
					if (initcode.get(i).startsWith("arg")) {
						int argIndex = ((MethodSymbol) (cs.resolve("init"))).getParIndex(initcode.get(i).substring(3));
						// System.out.println(((MethodSymbol)
						// (cs.resolve("init"))).getSymbolNames()+methodName+ initcode.get(i));
						// System.out.println(((MethodSymbol)
						// (cs.resolve("init"))).getSymbolNames()+methodName+ initcode.get(i));
						if (argIndex == -1) {
							System.err.printf("Didn't find arg %s in init code \n", initcode.get(i).substring(3));
						}
						code += String.format("MOV DWORD ECX, [ESP + %d]\n", (argIndex + 1) * 4);
						code += String.format("MOV DWORD [EAX + %d], ECX\n", (fieldIndex + 4) * 4);
					} else {//
						code += String.format("MOV DWORD [EAX + %d], %s\n", (fieldIndex + 4) * 4, initcode.get(i));
					}
				}
			}
		}
		//System.out.println(className + " : " + code);
		return code;
	}

	// initDecl returns [Scope scope]
	// : 'init' parameters block;
	@Override
	public String visitInitDecl(InitDeclContext ctx) {
		String s = "";
		this.visit(ctx.block());
		return s;
	}
	//block
	// : simple_stmt | NEWLINE INDENT stmt+ DEDENT ;
	@Override
	public String visitBlock(BlockContext ctx) {
		for (StmtContext m : ctx.stmt()) {
			this.visit(m);
		}
		return "";
	}

	@Override
	public String visitStmt(StmtContext ctx) {
		if (ctx.simple_stmt() != null)
			this.visit(ctx.simple_stmt());
		return "";
	}

	// multi_assign
	// : id_list ':=' expr_list;
	@Override
	public String visitMulti_assign(Multi_assignContext ctx) {
		String[] ids = ctx.id_list().getText().split(",");
		String[] vals = ctx.expr_list().getText().split(",");
		if (ids.length != vals.length) {
			System.err.printf("multi assign mismatch ids :%d vals: %d \n", ids.length, vals.length);
		} else {
			/*
			for (int i = 0; i < ids.length; ++i) {
				if (vals[i].startsWith("0") || vals[i].startsWith("false") || vals[i].startsWith("nil"))
					continue;
				if (vals[i] == "true") {
					initcode.put(ids[i], "1");
				} else if (isNumeric(vals[i])) {
					initcode.put(ids[i], vals[i]);
				} else {// should be parameter/field/local var
					ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
					MethodSymbol ms = cs.resolveMethod("init");
					Symbol s = ms.resolve(vals[i]);
					System.err.println(vals[i]);
					if (s instanceof ParameterSymbol) {
						initcode.put(ids[i], "arg" + vals[i]);
					} else if (s instanceof EnumSymbol) {
						initcode.put(ids[i], Integer.toString(((EnumSymbol) s).getConstantValue()));
						// System.err.println(s);
					} else if(s instanceof VariableSymbol){
						
					} else if(s instanceof FieldSymbol) {
						
					} else {
						if (!cs.getName().equals("Start"))
							System.err.printf(
									"Error: init code only supports constant number, parameters %s:=%s class: %s s: %s)\n",
									ids[i], vals[i], className, s);
					}
				}
			}*/
			for(int i = 0; i < ids.length; ++i) {
				Symbol s = symtab.GLOBALS.resolve(className);
				if(s instanceof ClassSymbol) {
					ClassSymbol cs = (ClassSymbol) s;
					Symbol lsymbol = ((Scope)cs).resolve(ids[i]);
					if(((FieldSymbol)lsymbol).getType().getName() == "enum") {
						int enumval = cs.resolveEnumValue(vals[i]); 
						initcode.put(ids[i], Integer.toString(enumval));
						//System.err.printf("Find Enum %s: %d: %s\n", lsymbol.getName(), enumval, vals[i]);
						continue;
					} else {
						if (vals[i].startsWith("0") || vals[i].startsWith("false") || vals[i].startsWith("nil"))
							continue;
						if (vals[i].startsWith("true")) {
							initcode.put(ids[i], "1");
						} else if (isNumeric(vals[i])) {
							initcode.put(ids[i], vals[i]);
						} else {
							MethodSymbol ms = cs.resolveMethod("init");
							Symbol valsym = ms.resolve(vals[i]);
							if (valsym  instanceof ParameterSymbol) {
								initcode.put(ids[i], "arg" + vals[i]);
							} else if (valsym instanceof VariableSymbol) {
								initcode.put(ids[i], "var" + vals[i]);
							} else if(valsym instanceof FieldSymbol) {
								initcode.put(ids[i], "field" + vals[i]);
							} else {
								System.err.printf("Can't find assign: %s: %s\n", lsymbol.getName(), vals[i]);
							}
						}		
					}
				}else {
					System.err.printf("Can't resolve the vlaue %s of calss", ids[i]);
				}	
			}	
		}
		// gen init code
		ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
		cs.setObjInitCode(genInitCode());
		return "";
	}
	
	// small_stmt
	// : multi_assign | expr_stmt | localDecl | return_stmt | method_call;
	// There are no return_stmt | method_call | expr_stmt | localDecl
	@Override
	public String visitSmall_stmt(Small_stmtContext ctx) {
		if(ctx.localDecl()!=null || ctx.return_stmt()!=null || ctx.method_call()!=null || ctx.expr_stmt()!=null) {
			System.err.printf("Method_call/return/localDecl should not be in init code\n");
		}
		if (ctx.multi_assign() != null) {
			this.visit(ctx.multi_assign());
		}
		return "";
	}
	
	// simple_stmt
	// : fst=small_stmt (';' small_stmt)* (';')? NEWLINE ;
	@Override
	public String visitSimple_stmt(Simple_stmtContext ctx) {
		//this.visit(ctx.fst);
		for (Small_stmtContext ss : ctx.small_stmt()) {
			this.visit(ss);
		}
		return "";
	}

	// guard code generator
	String negated(String s) {
		String tmp[] = s.split(" ");
		// neg op label
		String res = "";
		res += negatedOpPair.get(tmp[0]);
		if (tmp[1].equals("success")) {
			res += " fail\n";
		} else {
			res += " success\n";
		}
		return res;
	}

	// 1. if the last instruction is 'fail', negated it;
	// 2. replace all the 'fail' to 'label'
	String negatedForOr(String s, String label) {
		String tmp[] = s.split("\n");
		String last = tmp[tmp.length - 1];
		String tmp2[] = last.split(" ");
		String res = "";
		if (tmp2[1].equals("fail")) {
			tmp[tmp.length - 1] = negated(last);
		}
		res = String.join("\n", tmp);
		res = res.replaceAll("fail", label);
		return res;
	}

	// 1. if the last instruction is 'success', negated it;
	// 2. replace all the 'success' to 'label'
	String negatedForAnd(String s, String label) {
		String tmp[] = s.split("\n");
		String last = tmp[tmp.length - 1];
		String tmp2[] = last.split(" ");
		String res = "";
		if (tmp2[1].equals("success")) {
			tmp[tmp.length - 1] = negated(last);
		}
		res = String.join("\n", tmp);
		res = res.replaceAll("success", label);
		return res;
	}

	// 1. if there is only one branch instruction: 'fail', change the condition,
	// 'success', change to 'fail'
	// 2 else: last instruction, change the condition, the previous instructions:
	// change the labels
	String negatedForNot(String s) {
		String tmp[] = s.split("\n");
		int count = 0;
		String res = "";
		for (String line : tmp) {
			String tmp2[] = line.split(" ");
			if (negatedOpPair.containsKey(tmp2[0]))
				count++;
		}
		String last = tmp[tmp.length - 1];
		if (count == 0) {
			System.err.printf("Error: guard code generation: no JXX instruction\n");
			return s;
		} else if (count == 1) {
			String tmp3[] = last.split(" ");
			if (tmp3[1].equals("fail")) {
				tmp3[0] = negatedOpPair.get(tmp3[0]);
			} else {
				tmp3[1] = "fail";
			}
			res = String.join(" ", tmp3);
			tmp[tmp.length - 1] = res;
			return String.join("\n", tmp) + "\n";
		} else {
			String tmp3[] = last.split(" ");
			tmp3[0] = negatedOpPair.get(tmp3[0]);
			res = String.join(" ", tmp3);
			tmp[tmp.length - 1] = res;

			for (int i = 0; i < tmp.length - 1; ++i) {
				String tmp4[] = tmp[i].split(" ");
				if (tmp4[1].equals("success")) {
					tmp4[1] = "fail";
					tmp[i] = String.join(" ", tmp4);
				} else if (tmp4[1].equals("fail")) {
					tmp4[1] = "success";
					tmp[i] = String.join(" ", tmp4);
				}
			}
			return String.join("\n", tmp) + "\n";
		}
	}

	String tmplocalLabel() {
		LimeGuardAndInitCodeVisitor.labelnum++;
		return "" + LimeGuardAndInitCodeVisitor.labelnum;
	}

	@Override
	public String visitMethodDecl(MethodDeclContext ctx) {
		String s = "";
		String succeed = className + "_" + ctx.ID().getText() + "_succeed\n";
		String failed = className + "_" + ctx.ID().getText() + "_checkguard_fail\n";
		methodName = ctx.ID().getText();
		if (ctx.guard() != null) {
			s += this.visit(ctx.guard());

			// System.out.println("method guard: "+ctx.ID().getText());
			// System.out.print(s);
			// negated the last instruction if it jumps to fails
			String tmp[] = s.split("\n");
			String last = tmp[tmp.length - 1];
			if (last.split(" ")[1].equals("fail")) {
				tmp[tmp.length - 1] = negated(last);
			}
			// System.out.print(String.join("\n", tmp).replaceAll("fail",
			// failed).replaceAll("success", succeed));

			// guardmap.put(className + ctx.ID().getText(), String.join("\n",
			// tmp).replaceAll("fail", failed).replaceAll("success", succeed));
			ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
			MethodSymbol ms = (MethodSymbol) cs.resolve(ctx.ID().getText());
			ms.guardAsmCode = String.join("\n", tmp).replaceAll("fail", failed).replaceAll("success", succeed);
		}
		return "";
	}

	//
	@Override
	public String visitActionDecl(ActionDeclContext ctx) {
		String s = "";
		String succeed = className + "_" + ctx.ID().getText() + "_succeed\n";
		String failed = className + "_" + ctx.ID().getText() + "_checkguard_fail\n";
		methodName = ctx.ID().getText();
		if (ctx.guard() != null) {
			s += this.visit(ctx.guard());

			String tmp[] = s.split("\n");
			String last = tmp[tmp.length - 1];
			if (last.split(" ")[1].equals("fail")) {
				tmp[tmp.length - 1] = negated(last);
			}
			// guardmap.put(className + ctx.ID().getText(), String.join("\n",
			// tmp).replaceAll("fail", failed).replaceAll("success", succeed));
			ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
			ActionSymbol ms = (ActionSymbol) cs.resolve(ctx.ID().getText());
			ms.guardAsmCode = String.join("\n", tmp).replaceAll("fail", failed).replaceAll("success", succeed);
		}

		return "";
	}

	// INTEGER #guardatomint
	@Override
	public String visitGuardatomint(GuardatomintContext ctx) {
		operands.push("num_" + ctx.getText());
		return "";
	}

	// guard 'or' guard #guardorexpr
	@Override
	public String visitGuardorexpr(GuardorexprContext ctx) {
		String s = "";
		String left = this.visit(ctx.guard(0));
		String label = className + "_guard_" + tmplocalLabel() + ":\n";
		s = negatedForOr(left, label);
		s += label;
		s += this.visit(ctx.guard(1));
		return s;
	}

	// '(' guard ')'
	@Override
	public String visitGuardparen(GuardparenContext ctx) {
		return this.visit(ctx.guard());
	}

	// ID #guardatomid
	@Override
	public String visitGuardatomid(GuardatomidContext ctx) {
		String t = "";
		ClassSymbol cs = (ClassSymbol) symtab.GLOBALS.resolve(className);
		Symbol s = cs.resolve(ctx.ID().getText());
		
		if(cs.enumValues.containsKey(ctx.ID().getText())){
			operands.push("num_" + Integer.toString(((cs.enumValues.get(ctx.ID().getText())))));
			return t;
		}
		/*
		if (s instanceof EnumSymbol) {
			operands.push("num_" + Integer.toString(((EnumSymbol) s).getConstantValue()));
			return t;
		}*/

		if (s instanceof FieldSymbol) {
			String tmp2 = "MOV DWORD %s, [ECX + %d]\n";
			ClassSymbol cls = (ClassSymbol) symtab.GLOBALS.resolve(className);
			int index = cls.getDefinedFields().indexOf((FieldSymbol) s);
			String reg = availRegs.pop();
			operands.push("reg_" + reg);
			t += String.format(tmp2, reg, (index + 4) * 4);
			if (!inGuardcompexpr) {
				t += String.format("CMP %s, 1\n", reg);
				t += "JE success\n";
				availRegs.push(reg);
			}
			return t;
		}

		//System.out.println("id : " + t);
		return t;
	}

	// 'not' guard #guardatomnot
	@Override
	public String visitGuardatomnot(GuardatomnotContext ctx) {
		String t = this.visit(ctx.guard());
		return negatedForNot(t);
	}

	// guard 'and' guard #guardandexpr
	@Override
	public String visitGuardandexpr(GuardandexprContext ctx) {
		String s = "";
		String left = this.visit(ctx.guard(0));
		String label = className + "_guard_" + tmplocalLabel() + ":\n";
		s = negatedForAnd(left, label);
		s += label;
		s += this.visit(ctx.guard(1));
		return s;
	}

	// guard op=( '>=' | '<=' | '>' | '<' | '=' | '!=') guard #guardcompexpr
	@Override
	public String visitGuardcompexpr(GuardcompexprContext ctx) {
		String s = "";
		//System.out.println(ctx.getText());
		inGuardcompexpr = true;
		s += this.visit(ctx.guard(0));
		s += this.visit(ctx.guard(1));
		inGuardcompexpr = false;
		String op = ctx.op.getText();

		String right = operands.pop();
		//System.out.println(right+s);
		if (right.split("_")[0].equals("reg")) {
			availRegs.push(right.split("_")[1]);
		}
		String rightOperand = right.split("_")[1];
		//System.err.printf("Error: %s %s for boolean expression\n", className, methodName);
		String left = operands.pop();
		// System.out.println(left);
		if (left.split("_")[0].equals("reg")) {
			availRegs.push(left.split("_")[1]);
		}
		String leftOperand = left.split("_")[1];

		s += String.format("CMP %s, %s\n", leftOperand, rightOperand);
		switch (op) {
		case ">=":
			s += "JGE " + "success\n";
			break;
		case "<=":
			s += "JLE " + "success\n";
			break;
		case ">":
			s += "JG " + "success\n";
			break;
		case "<":
			s += "JL " + "success\n";
			break;
		case "=":
			s += "JE " + "success\n";
			break;
		case "!=":
			s += "JNE " + "success\n";
			break;
		default:
			System.err.printf("Error: unsupported operator %s for boolean expression\n", op);
			break;
		}
		return s;
	}
}
