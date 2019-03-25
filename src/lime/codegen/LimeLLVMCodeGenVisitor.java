package lime.codegen;

import java.util.List;
import java.util.Map;

import lime.antlr4.ClassSymbol;
import lime.antlr4.FieldSymbol;
import lime.antlr4.LimeGrammarBaseVisitor;
import lime.antlr4.LimeGrammarLexer;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.AddexprContext;
import lime.antlr4.LimeGrammarParser.AndexprContext;
import lime.antlr4.LimeGrammarParser.ArgsContext;
import lime.antlr4.LimeGrammarParser.AtomContext;
import lime.antlr4.LimeGrammarParser.AtomexprContext;
import lime.antlr4.LimeGrammarParser.BlockContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.ClassMemberContext;
import lime.antlr4.LimeGrammarParser.CompexprContext;
import lime.antlr4.LimeGrammarParser.CompilationUnitContext;
import lime.antlr4.LimeGrammarParser.Compound_stmtContext;
import lime.antlr4.LimeGrammarParser.Elif_statContext;
import lime.antlr4.LimeGrammarParser.Else_statContext;
import lime.antlr4.LimeGrammarParser.EqexprContext;
import lime.antlr4.LimeGrammarParser.Expr_listContext;
import lime.antlr4.LimeGrammarParser.Expr_stmtContext;
import lime.antlr4.LimeGrammarParser.GetArgContext;
import lime.antlr4.LimeGrammarParser.GetRandContext;
import lime.antlr4.LimeGrammarParser.Id_listContext;
import lime.antlr4.LimeGrammarParser.If_statContext;
import lime.antlr4.LimeGrammarParser.If_stmtContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.LocalDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.LimeGrammarParser.Method_callContext;
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
import lime.antlr4.LimeGrammarParser.SetRandContext;
import lime.antlr4.LimeGrammarParser.Simple_stmtContext;
import lime.antlr4.LimeGrammarParser.Small_stmtContext;
import lime.antlr4.LimeGrammarParser.StmtContext;
import lime.antlr4.LimeGrammarParser.TypeparslistContext;
import lime.antlr4.LimeGrammarParser.UnaryMinusexprContext;
import lime.antlr4.LimeGrammarParser.While_stmtContext;
import lime.antlr4.MethodSymbol;
import lime.antlr4.ParameterSymbol;
import lime.antlr4.Scope;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;
import lime.antlr4.Type;
import lime.antlr4.VariableSymbol;


public class LimeLLVMCodeGenVisitor extends LimeGrammarBaseVisitor<String>{
	String ou="";
	String className;
	List<String> multiassignment;
	Map<String, String> init_map;
	String initcode;
	int action_counter = 0;
	SymbolTable symtab;
	boolean initfunction = false;
	public LimeLLVMCodeGenVisitor(SymbolTable symtab){
		this.symtab = symtab;
	}
	//compilationUnit
    // : classDecl EOF ;
	@Override
	public String visitCompilationUnit(CompilationUnitContext ctx) {
		for(ClassDeclContext c :ctx.classDecl()) {
			String t = this.visit(c);
			if(t!=null)ou +=t; 
			ou += "\n";
		}
		return ou;
	}
	/*
	 * classDecl
	 *		: 'class' ID NEWLINE INDENT classMember* DEDENT ;
	 */
	@Override
	public String visitClassDecl(ClassDeclContext ctx) {
		this.action_counter=0;
		this.className = ctx.ID().getText();
		String l = "";
		
		Symbol cs = this.symtab.GLOBALS.resolve(ctx.ID().getText());
		l+="#include <stddef.h>\n";
		l+="#include <stdlib.h>\n";
		l+="struct "+this.className+"_struct{\n";
		l+="int pre_ebp;\n";
		l+="int pre_esp;\n";
		l+="int lock;\n";
		l+="int system_next;\n";
		if(cs instanceof ClassSymbol){
			for (FieldSymbol f: ((ClassSymbol) cs).getFields()) {
				String typ = f.getType().getName();
				if(typ.equals("int")|| typ.equals("bool")) {
					l+="int " +f.getName()+";\n";
					
				}else {
					l+="struct "+typ+"_struct *" +f.getName()+";\n";
				}
			}
		}
		l+="};\n";
		
		//declare Classname_init()
		MethodSymbol ms = (MethodSymbol)((ClassSymbol)cs).resolveMethod("init");
		if(ms!=null) {
			l+= "struct "+cs.getName()+"_struct * " + cs.getName() +"_init(";
			//args
			int n = ms.getNumArgs();
			if(n==0) l+= ");\n";
			else if(n==1) l+="int);\n";
			else {
				l+="int";
				int nn=n-1;
				while(nn>0){
					l+=", int";
					nn--;
				}
				l+=");\n";
			}		
		}
		//declare externFunctions
		String tmp="";
		System.out.println(((ClassSymbol)cs).externMethods);
		for (String s: ((ClassSymbol)cs).externMethods) {
    		//System.out.println(s.split("_")[1]);
    		
			
			if(symtab.PREDEFINED.resolve(s)!=null) {
        		continue;
        	}else {
        		System.out.println(s.split("_")[1]);
        		//MethodSymbol calledmethod = (MethodSymbol)((ClassSymbol)(symtab.GLOBALS.findSyresolveSymbol(s.split("_")[0])).resolveMethod(s.split("_")[1]);
        		MethodSymbol calledmethod = ((ClassSymbol)symtab.GLOBALS.resolve(s.split("_")[0])).resolveMethod(s.split("_")[1]);
        		if(calledmethod.getType()==null || calledmethod.getType().getName().equals("void")) {
        			tmp += "void ";
        		}else {
        			tmp += "int ";
        		}
        		int n = calledmethod.getNumArgs();
        		
        		tmp += s;
        		tmp+="(";
        		if(n==0) {
        			tmp+="void*, void*";
        		}else {//n>0
        			tmp +="int ";
        			int nn=n-1;
        			while(nn>0) {
        				tmp+=",int ";
        				nn--;
        			}
        			tmp+=", void*, void*";
        		}
        		tmp+=");\n";
        	}
		}
		l+=tmp;

		for(ClassMemberContext m :ctx.classMember()) {
			String t = this.visit(m);
			if (t!=null) l += t+"\n";
		}
		return l;
	}

	@Override
	public String visitClassMember(ClassMemberContext ctx) {
		if(ctx.methodDecl()!=null) {
			return this.visit(ctx.methodDecl());
		} 
		if(ctx.actionDecl()!=null) {
			return this.visit(ctx.actionDecl());
		}
		return super.visitClassMember(ctx);
	}
	
	//initDecl returns [Scope scope]
	//		: 'init' parameters NEWLINE INDENT block DEDENT ;
	
	/*
	@Override
	public String visitInitDecl(InitDeclContext ctx) {
		initfunction = true;
		//method name
		String s = "void *"+this.className+"_init_code";
		//method args
		s+="(";
		s+= this.visit(ctx.parameters());
		s+=")";
		s +="{\n";
		s +=String.format("struct %s_struct *this =(struct %s_struct *)malloc(sizeof(struct %s_struct));\n", this.className, this.className, this.className);
		s += this.visit(ctx.block());
		s += String.format("return this;\n");
		s +="}";
		initfunction = false;
		return s+"\n";
	}
	*/
	@Override
	public String visitInitDecl(InitDeclContext ctx) {
		
		
		return null;
	}
	
	
	
	//methodDecl
	//: 'method' ID  parameters (':' type)? NEWLINE INDENT ('when' guard 'do')? block DEDENT ;
	@Override
	public String visitMethodDecl(MethodDeclContext ctx) {
		String s = ctx.ID().getText();
		if(ctx.ID()!=null) {
			//method name
			if(ctx.type()!= null && ctx.type().getText()!="void") {
				s = "int " + this.className+"_"+s;
			}else {
				s = "void " + this.className+"_"+s;
			}
			//method args
			s+="(";
			s+= this.visit(ctx.parameters());
			/*if(t=="") s+="struct "+this.className.toUpperCase()+"_struct *this";
			else {
				s+= t+", struct "+this.className.toUpperCase()+"_struct *this";
			}*/
			s+=")";
			s +="{\n";
			s += this.visit(ctx.block());
			s +="}";
		}
		return s+"\n";
	}
	//parameters
	//: '(' typeparslist? ')' ;
	@Override
	public String visitParameters(ParametersContext ctx) {
		String s ="";
		if(ctx.typeparslist()!=null) {
			String t=this.visit(ctx.typeparslist());
			if(t!=null)s+=t;
		}
		s+= "struct "+ this.className+"_struct *this, void* self";
		return s;
		
	}
	//typedparslist
	//: argsdef (',' argsdef)* ;
	@Override
	public String visitTypeparslist(TypeparslistContext ctx) {
		String s="";
		if(ctx.parsdef()!=null) {
			for(ParsdefContext a:ctx.parsdef()) {
				s += this.visit(a);
			}
			//if(initfunction) s+="$"; s=s.replace(",$", "");
		}
		return s;
	}
	//parsdef
	//: ID ':' type ;
	@Override
	public String visitParsdef(ParsdefContext ctx) {
		String s="";
		if(ctx.ID()!=null) {
			 s+="int "+ctx.ID().getText();
			 s+= ",";
		}	
		return s;
	}
	//block
	//: simple_stmt | NEWLINE INDENT stmt+ DEDENT ;
	@Override
	public String visitBlock(BlockContext ctx) {
		String s="";
		if(ctx.simple_stmt()!=null) {
			//System.out.print("missing something\n"+ctx.getText());
			String t = this.visit(ctx.simple_stmt());
			if(t!=null) s+=t;
		}
		if(ctx.stmt()!=null) {
			for(StmtContext x : ctx.stmt()) {
				String t = this.visit(x);
				if(t!=null)
					s += t;
			}
		}
		return s;
	}
	//stmt
	//: simple_stmt | compound_stmt ;
	@Override
	public String visitStmt(StmtContext ctx) {
		String s="";
		if(ctx.simple_stmt()!=null) {
			s+=this.visit(ctx.simple_stmt());
		}
		if(ctx.compound_stmt()!=null) {
			s+=this.visit(ctx.compound_stmt());
		}
		return s;
	}
	//simple_stmt
	//: small_stmt (';' small_stmt)* (';')? NEWLINE ;
	@Override
	public String visitSimple_stmt(Simple_stmtContext ctx) {
		String s="";
		if(ctx.small_stmt()!=null) {
			for(Small_stmtContext ss:ctx.small_stmt()) {
				String t =this.visit(ss);
				if(t!=null) s+=t;
			}
		}
		return s;
	}
	
	//small_stmt
	//: multi_assign | expr_stmt | localDecl | return_stmt | method_call;
	@Override
	public String visitSmall_stmt(Small_stmtContext ctx) {
		String s="";
		if(ctx.multi_assign()!=null) {
			String t =this.visit(ctx.multi_assign());
			if(t!=null) s+=t;
		}
		if(ctx.expr_stmt()!=null) {
			String t =this.visit(ctx.expr_stmt());
			if(t!=null) s+=t;
		}
		if(ctx.return_stmt()!=null) {
			String t =this.visit(ctx.return_stmt());
			if(t!=null) s+=t;
		}
		if(ctx.method_call()!=null) {
			String t =this.visit(ctx.method_call());
			if(t!=null) s+=t;
		}
		
		return s;
	}
	//localDecl 
	//: 'var' id_list ':' type NEWLINE ;
	@Override
	public String visitLocalDecl(LocalDeclContext ctx) {
		// TODO Auto-generated method stub
		//return super.visitLocalDecl(ctx);
		String s ="\nint ";
		if(ctx.id_list()!=null) {
			String t =this.visit(ctx.id_list());
			if(t!=null) s+=t;
		}
		s += ";\n";
		return s;
	}
	
	
	//multi_assign
	//: id_list ':=' expr_list;
	/*
	@Override
	public String visitMulti_assign(Multi_assignContext ctx) {
		//String s = "";
		String src = this.visit(ctx.id_list());
		//System.out.println(ctx.getText());
		if(ctx.expr_list()!=null) {
			String des = this.visit(ctx.expr_list());
			String[] ss = src.split(",");
			// bug: a, method_call(x,y), c
			String[] dd = des.split(" ,");
			
			String res="";
			for(int i=0;i<ss.length;++i) {
				res+= ss[i]+" = " +dd[i]+";\n";
			}
			return res;
		}
		return src+";";
	}*/
	
	@Override
	public String visitMulti_assign(Multi_assignContext ctx) {
		String s = "";
		String src = this.visit(ctx.id_list());
		String[] ss = src.split(",");
		String[] dd = new String[ctx.expr_list().getChildCount()];
		//id list = id , id , id ....  id in the position(i*2) number of ids = (size + 1)/2 
		for (int i=0; i<(ctx.id_list().getChildCount()+1)/2; ++i) {
			dd[i] = this.visit(ctx.expr_list().getChild(i*2));
			s += ss[i] + " = " + dd[i]+ ";\n";
			//System.out.println(i);
		}
		//System.out.println(ss[0]);
		return s;
	}
	
	//expr_stmt
	//: src=expr_list;
	//expr_list
	//: expr (',' expr)* ;
	@Override
	public String visitExpr_stmt(Expr_stmtContext ctx) {
		String src = this.visit(ctx.src);
		//init code
 		return src+";";
	}
	//if_stmt
	//: if_stat elif_stat* else_stat?;
	@Override
	public String visitIf_stmt(If_stmtContext ctx) {
		String s="";
		s += this.visit(ctx.if_stat());
		for(Elif_statContext elif: ctx.elif_stat()) {
			s+=this.visit(elif);
		}
		if(ctx.else_stat()!=null)
			s += this.visit(ctx.else_stat());
		return s;
	}
	//if_stat
	//: 'if' expr 'then' block;
	@Override
	public String visitIf_stat(If_statContext ctx) {
		String s="";
		s+= "\nif (";
		s+= this.visit(ctx.expr());
		s+= "){\n";
		s+= this.visit(ctx.block());
		s+= "\n}\n";
		return s;
	}
	//elif_stat
	//	 : 'elif' expr 'then' block;
	@Override
	public String visitElif_stat(Elif_statContext ctx) {
		String s="";
		s+= "else if(";
		s+= this.visit(ctx.expr());
		s+= "){\n";
		s+= this.visit(ctx.block());
		s+= "\n}";
		return s;
	}
	//else_stat
	// : 'else' block;
	@Override
	public String visitElse_stat(Else_statContext ctx) {
		String s="";
		s+= "else {\n";
		s+=this.visit(ctx.block());
		s+= "\n}\n";
		return s;
	}
	//	while_stmt
	//	: 'while' test 'do' block ; 
	@Override
	public String visitWhile_stmt(While_stmtContext ctx) {
		String s="";
		return s;
	}
	//	return_stmt
	//	: 'return' (test)? ;
	@Override
	public String visitReturn_stmt(Return_stmtContext ctx) {
		String s = "\nreturn ";
		if(ctx.expr()!=null) {
			s+=this.visit(ctx.expr());
		}
		return s + ";\n";
	}
	//actionDecl
	//: 'action' ID NEWLINE INDENT ('when' guard 'do')? block DEDENT ;
	@Override
	public String visitActionDecl(ActionDeclContext ctx) {
		String s ="";
		this.action_counter++;
		s = "\nvoid " + this.className+"_"+ctx.ID().getText()+"(struct "+this.className+"_struct *this, void* self)";
		s +="\n{\n";
		s += this.visit(ctx.block());
		s +="}\n";
		return s;
	}
	
	String getThisPrefix(String in) {
		Symbol s = this.symtab.GLOBALS.findSymbol(in);
		if(s instanceof FieldSymbol) {
			return "this->"+in;
		}else if(s instanceof VariableSymbol) {
			//System.out.println("variable symbol: "+ ctx.ID().getText());
			return in;
		}else if(s instanceof ParameterSymbol) {
			//System.out.println("Parameter symbol: "+ ctx.ID().getText());
			return in;
		}else {
			//System.out.println("symbol: "+ ctx.ID().getText());
			return in;
		}
	}
	
	
	
	@Override
	public String visitId_list(Id_listContext ctx) {
		String s="";
		s+=getThisPrefix(ctx.ID(0).getText());
		for(int i=1;i<ctx.ID().size();++i) {
			s += ",";
			s +=getThisPrefix(ctx.ID(i).getText());
		}

		return s;
	}
	
	
	//expr op=( '=' | '!=' ) expr             #eqexpr
	@Override
	public String visitEqexpr(EqexprContext ctx) {
		String s="";
		if(ctx.expr(0)!=null)s+=this.visit(ctx.expr(0));
		//System.out.printf("%s\n", ctx.op.getText());
		if(ctx.op.getType()==LimeGrammarLexer.NEquals){
			//System.out.printf("done\n");
			s += " != ";
		}else {
			s += " == ";
		}
		if(ctx.expr(1)!=null)s+=this.visit(ctx.expr(1));
		return s;
	}
	//| 'not' expr                               #notexpr
	@Override
	public String visitNotexpr(NotexprContext ctx) {
		String s = "";
		s += "!";
		if(ctx.expr()!=null) {
			s+=this.visit(ctx.expr());
		}
		return s;
	}
	//| expr op=( '*' | '/' | '%' ) expr         #multexpr
	@Override
	public String visitMultexpr(MultexprContext ctx) {
		String s ="";
		if(ctx.expr(0)!=null) s+=this.visit(ctx.expr(0));
		s+=ctx.op.getText();
		if(ctx.expr(1)!=null) s+=this.visit(ctx.expr(1));
		return s;
	}
	// | expr op=( '>=' | '<=' | '>' | '<' ) expr #compexpr
	@Override
	public String visitCompexpr(CompexprContext ctx) {
		String s="";
		if(ctx.expr(0)!=null) s+=this.visit(ctx.expr(0));
		s+=ctx.op.getText();
		if(ctx.expr(1)!=null) s+=this.visit(ctx.expr(1));
		return s;
	}
	//: '-' expr                                 #unaryMinusexpr
	@Override
	public String visitUnaryMinusexpr(UnaryMinusexprContext ctx) {
		String s ="";
		s += "-";
		if(ctx.expr()!=null) s+=this.visit(ctx.expr());
		return s;
	}
	 //| expr op=( '+' | '-' ) expr               #addexpr
	@Override
	public String visitAddexpr(AddexprContext ctx) {
		String s ="";
		if(ctx.expr(0)!=null) s+=this.visit(ctx.expr(0));
		s+=" "+ ctx.op.getText()+" ";
		if(ctx.expr(1)!=null) s+=this.visit(ctx.expr(1));
		return s;
	}
	//| atom										#atomexpr
	@Override
	public String visitAtomexpr(AtomexprContext ctx) {
		return this.visit(ctx.atom());
	}
	//| expr 'or' expr                           #orexpr
	@Override
	public String visitOrexpr(OrexprContext ctx) {
		String s ="";
		if(ctx.expr(0)!=null) s+=this.visit(ctx.expr(0));
		s+="||";
		if(ctx.expr(1)!=null) s+=this.visit(ctx.expr(1));
		return s;
	}
	//| expr 'and' expr                          #andexpr
	@Override
	public String visitAndexpr(AndexprContext ctx) {
		String s ="";
		if(ctx.expr(0)!=null) s+=this.visit(ctx.expr(0));
		s+="&&";
		if(ctx.expr(1)!=null) s+=this.visit(ctx.expr(1));
		return s;
	}
	//expr_list
	//: expr (',' expr)*;
	@Override
	public String visitExpr_list(Expr_listContext ctx) {
		String s ="";
		s += this.visit(ctx.expr(0));
		for(int i = 1;i<ctx.expr().size();++i) {
			s += ", ";
			s += this.visit(ctx.expr(i));
		}
		return s;
	}
	//: 'new' n=ID args 					   #newcall
	@Override
	public String visitNewcall(NewcallContext ctx) {
		String s ="";
		s+= "(struct "+ctx.n.getText()+"_struct *) " + ctx.n.getText()+"_init";
		s+="(";
		s+=this.visit(ctx.args());
		s+=")";
		return s;
	}
	//| c=ID '.' m=ID args 					   #methodcall
	@Override
	public String visitMethodcall(MethodcallContext ctx) {
		String s="";
		String t = ((Symbol)this.symtab.GLOBALS.findSymbol(ctx.c.getText())).getScope().getName();
		s=t+"_"+ctx.m.getText();
		s+="(";
		String tt = this.visit(ctx.args());
		if(tt!="") {
			s+=tt+",";
		}
		s+="this->"+ctx.c.getText();
		s+=", self)";
		return s;
	}
	
	@Override
	public String visitGetRand(GetRandContext ctx) {
		String s ="";
		s += "getRand";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}
	@Override
	public String visitGetArg(GetArgContext ctx) {
		String s ="";
		s += "getArg";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}
	@Override
	public String visitSetRand(SetRandContext ctx) {
		String s ="";
		s += "setRand";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}
	@Override
	public String visitPrint(PrintContext ctx) {
		String s ="";
		s += "print";
		s += "(";
		s += this.visit(ctx.args());
		s += ")";
		return s;
	}
	//args
	//: '(' expr_list? ')';
	@Override
	public String visitArgs(ArgsContext ctx) {
		String s = "";
		if(ctx.expr_list()!=null) {
			s+=this.visit(ctx.expr_list());
		}
		return s;
	}
	//compound_stmt
	//: if_stmt | while_stmt  | methodDecl | actionDecl | initDecl | localDecl ;
	@Override
	public String visitCompound_stmt(Compound_stmtContext ctx) {
		String s="";
		if(ctx.if_stmt()!=null) {
			s+=this.visit(ctx.if_stmt());
		}
		return s;
	}
	//atom
	//:  INTEGER | True | False | Null | ID | method_call;
	@Override
	public String visitAtom(AtomContext ctx) {
		if(ctx.INTEGER()!=null) {
			//System.out.println("find a integer: "+ ctx.INTEGER().getText());
			return ctx.INTEGER().getText();
		}else if(ctx.Null()!=null) {
			//System.out.println("find a null: "+ ctx.Null().getText());
			return "NULL";
		}else if(ctx.True()!=null){
			//System.out.println("find a true: "+ ctx.True().getText());
			return "1";
		}else if(ctx.False()!=null){
			return "0";
		}else if (ctx.ID()!=null) {
			//System.out.println("find a ID: this->"+ ctx.ID().getText());
			Symbol s = this.symtab.GLOBALS.findSymbol(ctx.ID().getText());
			if(s instanceof FieldSymbol) {
				return "this->"+ctx.ID().getText();
			}else if(s instanceof VariableSymbol) {
				//System.out.println("variable symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			}else if(s instanceof ParameterSymbol) {
				//System.out.println("Parameter symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			}else {
				//System.out.println("symbol: "+ ctx.ID().getText());
				return ctx.ID().getText();
			}
		}else if(ctx.method_call()!=null) {
			return this.visit(ctx.method_call());
		}else return "";
	}
	public String toString() {
		return ou;
	}
}