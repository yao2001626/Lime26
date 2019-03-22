package lime.codegen;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import lime.antlr4.ActionSymbol;
import lime.antlr4.ClassSymbol;
import lime.antlr4.LimeGrammarBaseListener;
import lime.antlr4.MethodSymbol;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.Scope;
import lime.antlr4.SymbolTable;

public class LimeSkeCodeGenListener extends LimeGrammarBaseListener{
	SymbolTable symtab;
	Scope currentScope;
	String content;
	STGroup templates;
	String curClassName;
	
	public LimeSkeCodeGenListener(SymbolTable st, STGroup stg){
		this.symtab = st;
		this.currentScope = st.GLOBALS;
		this.content="";
		this.templates = stg;
	}
	//class(class_name, fields, methods, actions, active, size, XYZ, init)
	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		ST t = templates.getInstanceOf("class");
		currentScope = (Scope)this.currentScope.resolve(ctx.ID().toString());
		curClassName = ctx.ID().toString();
		t.add("class_name", curClassName);
		t.add("externs", ((ClassSymbol)currentScope).externMethods);
		t.add("fields", ((ClassSymbol)currentScope).getDefinedFields());
		t.add("methods", ((ClassSymbol)currentScope).getDefinedMethods());
		t.add("actions", ((ClassSymbol)currentScope).getDefinedActions());
		boolean activated = ((ClassSymbol)currentScope).getActions().size()>0;
		t.add("active", activated);
		
		t.add("init", ((ClassSymbol)currentScope).getObjInitCode());
		/*
		int size = ((ClassSymbol)currentScope).getDefinedFields().size();
		
		if(activated) {
			size = 32768;
		}else {
			size += (size+4)*4; 
		}*/
		// coroutine size = 32768
		//int size =32768;
		//coroutine size = 4096
		int size = 4096;
		t.add("size", size);
		int xyz = (((ClassSymbol)currentScope).getDefinedFields().size()+ 4)*4 ;
		t.add("XYZ", xyz);
		content="";
		content += t.render();
	}
	
	//action(class_name, action_name, unguarded)
	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		currentScope = ctx.scope;
		ST t = templates.getInstanceOf("action");
		t.add("class_name", curClassName);
		t.add("action_name", ctx.ID().toString());
		t.add("unguarded", ((ActionSymbol)currentScope).unguarded());
		content += t.render();
	}
	
	//method(class_name, method_name, paranum, enabled, unguarded)
	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		currentScope = ctx.scope;
		ST t = templates.getInstanceOf("method");
		t.add("class_name", this.curClassName);
		t.add("method_name", ctx.ID().toString());
		t.add("paranum", ((MethodSymbol)currentScope).getNumberOfParameters());
		t.add("enabled", ((MethodSymbol)currentScope).isEnabled()&& ((ClassSymbol)currentScope.getEnclosingScope()).getActions().size()>0);
		t.add("unguarded", ((MethodSymbol)currentScope).unguarded());
		content += t.render();
	}
	
	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
	}
	@Override
	public void exitMethodDecl(MethodDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
	}
	@Override
	public void exitActionDecl(ActionDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
	}
}
