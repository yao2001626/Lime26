package lime.antlr4;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.AtomContext;
import lime.antlr4.LimeGrammarParser.AttrDeclContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;

public class LimeParserTreeListener  extends LimeGrammarBaseListener {
	SymbolTable symtab;
    Scope currentScope;
    String className;
    
    LimeParserTreeListener(Scope scope, SymbolTable symtab){
    	this.symtab = symtab;
    	this.currentScope = scope;
    }
    
	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("enter class");
		ClassSymbol cs = new ClassSymbol(ctx.ID().getText());
		cs.setDefNode(ctx.getParent());
		currentScope.define(cs);
		currentScope  = cs;	
	}
	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("exit class: " + currentScope);
		currentScope = currentScope.getEnclosingScope(); 
	}

	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("enter method"+ currentScope);
		MethodSymbol ms = new MethodSymbol(ctx.ID().getText());
		ms.setDefNode(ctx.getParent());
		currentScope.define(ms);
		currentScope = ms;	
	}

	@Override
	public void exitMethodDecl(MethodDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("exit method"+ currentScope);
		currentScope = currentScope.getEnclosingScope(); 
	}

	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("enter action"+ currentScope);
		ActionSymbol as = new ActionSymbol(ctx.ID().getText());
		//as.def = (LimeAST) ctx.ID();
		currentScope.define(as);
		currentScope = as;
	}

	@Override
	public void exitActionDecl(ActionDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("exit action: " + currentScope);
		currentScope = currentScope.getEnclosingScope(); 
	}

	@Override
	public void enterAttrDecl(AttrDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("attr define: "+ctx.getText());
		List<TerminalNode> id_list = ctx.id_list().ID();
		String t = ctx.type().getText();
		for(TerminalNode x : id_list) {
			VariableSymbol vs = new VariableSymbol(x.getText());
			currentScope.define(vs);
		}
	}

	@Override
	public void exitAttrDecl(AttrDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("attr define exit: " + currentScope);
	}

	

	@Override
	public void enterInitDecl(InitDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("init enter: " + currentScope);
//		MethodSymbol ms = new MethodSymbol("init", "void", currentScope);
//		//ms.def = (LimeAST) ctx.Init();
//		currentScope.define(ms);
//		currentScope = ms;
	}
	@Override
	public void exitInitDecl(InitDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("init exit: " + currentScope);
		currentScope = currentScope.getEnclosingScope();
	}
	
	@Override
	public void enterAtom(AtomContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println("resolve id "+ctx.ID().getText());
		Symbol s = null;
		if(ctx.ID() !=null ) {
			 s = currentScope.resolve(ctx.ID().getText());	
		}
		
		if(s==null) {
			System.out.println("Didn't find INTEGER | 'false' | 'true' | 'nil' ");
		}else {
			System.out.println("Found :"+ ctx.getSourceInterval() );
		}	
	}

	@Override
	public void exitAtom(AtomContext ctx) {
		// TODO Auto-generated method stub
		super.exitAtom(ctx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		//System.out.println("this is parser tree enter: "+ arg0.getText());
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		//System.out.println("this is parser tree exit: " + arg0.getText());
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
