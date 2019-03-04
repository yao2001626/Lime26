package lime.antlr4;

import java.io.IOException;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.ClassMemberContext;
import lime.antlr4.LimeGrammarParser.CompilationUnitContext;
import lime.antlr4.LimeGrammarParser.GuardContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;

public class LimeSymbolListener {
	String className;
	SymbolTable symtab;
    Scope currentScope;
	public void parse(String code, Scope curScope, SymbolTable symbolTable) throws IOException {
        // step 1 LEXER & PARSER
        LimeGrammarLexer lexer = new Builder.Lexer(code).build(); 
        LimeGrammarParser parser = new Builder.Parser(lexer).build();
		ClassListener classListener = new ClassListener();
		this.symtab = symbolTable;
		this.currentScope = curScope;
		CompilationUnitContext tree= parser.compilationUnit();
		//ParseTreeListener ptl = new ParseTreeListener();
		
		ParseTreeWalker.DEFAULT.walk(classListener, tree );
		return;
	}
	class ClassListener extends  LimeGrammarBaseListener {	
		@Override 
		public void enterClassDecl(LimeGrammarParser.ClassDeclContext ctx) {
//			ClassSymbol cs = new ClassSymbol(ctx.ID().getText(), currentScope);
//			className = ctx.ID().getText();
//			//cs.def =  ctx.ID(;
//			currentScope.define(cs);
//			currentScope  = cs;
//			//currentScope = new LocalScope(currentScope);
//	        ClassMemberListener classMemberListener = new ClassMemberListener();
//			//ctx.classMember().forEach(classMember -> classMember.enterRule(classMemberListener));
//	        ParseTreeWalker.DEFAULT.walk(classMemberListener);
		
			System.out.println("enter class: " + symtab );
		}
		@Override 
		public void exitClassDecl(LimeGrammarParser.ClassDeclContext ctx) { 
			System.out.println("exit class: " + symtab );
			currentScope = currentScope.getEnclosingScope(); 
		}
		
	}
	class ClassMemberListener extends LimeGrammarBaseListener{
		@Override
		public void enterClassMember(ClassMemberContext ctx) {
			// TODO Auto-generated method stub
			//System.out.println("Enter CalssMember");
//			if (ctx.methodDecl() != null ) {
//				MethodListener methodListener = new MethodListener();
//				ctx.methodDecl().enterRule(methodListener);
//			}
//			if(ctx.actionDecl() != null) {
//				ActionListener actionListener = new ActionListener();
//				ctx.actionDecl().enterRule(actionListener);
//			}
//			if(ctx.initDecl() != null) {
//				InitListener initListener=new InitListener();
//				ctx.initDecl().enterRule(initListener);
//			}
//			if (ctx.attrDecl() != null) {
//				VarDeclListener varDeclListener = new VarDeclListener();
//				ctx.attrDecl().enterRule(varDeclListener);
//			}			
			System.out.println("enter classmember: " + symtab );
		}

		@Override
		public void exitClassMember(ClassMemberContext ctx) {
			// TODO Auto-generated method stub
			//super.exitClassMember(ctx);
//			if (ctx.methodDecl() != null ) {
//				MethodListener methodListener = new MethodListener();
//				ctx.methodDecl().exitRule(methodListener);
//			}
//			if(ctx.actionDecl() != null) {
//				ActionListener actionListener = new ActionListener();
//				ctx.actionDecl().exitRule(actionListener);
//			}
//			if(ctx.initDecl() != null) {
//				InitListener initListener=new InitListener();
//				ctx.initDecl().exitRule(initListener);
//			}
//			if (ctx.attrDecl() != null) {
//				VarDeclListener varDeclListener = new VarDeclListener();
//				ctx.attrDecl().exitRule(varDeclListener);
//			}			
			System.out.println("exit classmember: " + symtab );
			
			
		}
		
		
	} 
	
	class MethodListener extends LimeGrammarBaseListener{
		@Override
		public void enterMethodDecl(MethodDeclContext ctx) {
			// TODO Auto-generated method stub
//			MethodSymbol ms;
//			if(ctx.type()==null) {
//				ms = new MethodSymbol(ctx.ID().getText(), "viod", currentScope);
//			}else {
//				ms = new MethodSymbol(ctx.ID().getText(), ctx.type().getText(), currentScope);	
//			}
//
//			//ms.def = (LimeAST) ctx.ID();
//			currentScope.define(ms);
//			currentScope = ms;
			System.out.println("Enter Method: " + ctx.ID().getText());
		}

		@Override
		public void exitMethodDecl(MethodDeclContext ctx) {
			// TODO Auto-generated method stub
			System.out.println("exit method: current scope :" +currentScope );
			currentScope = currentScope.getEnclosingScope(); 
		}
	}
	
	class ActionListener extends LimeGrammarBaseListener{
		
		@Override
		public void enterActionDecl(ActionDeclContext ctx) {
			// TODO Auto-generated method stub
//			ActionSymbol as = new ActionSymbol(ctx.ID().getText(), currentScope);
//			//as.def = (LimeAST) ctx.ID();
//			currentScope.define(as);
//			currentScope = as;
			System.out.println("Enter Action: " + ctx.ID().getText());
		}
		@Override
		public void exitActionDecl(ActionDeclContext ctx) {
			// TODO Auto-generated method stub
			System.out.println("exit action: current scope :" +currentScope );
			currentScope = currentScope.getEnclosingScope(); 
		}
	}
	
	class InitListener extends LimeGrammarBaseListener{

		@Override
		public void enterInitDecl(InitDeclContext ctx) {
			
		}

		@Override
		public void exitInitDecl(InitDeclContext ctx) {
			
		}
	}
	
}
