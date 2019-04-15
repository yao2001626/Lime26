package lime.codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
	String dir;
	
	public LimeSkeCodeGenListener(SymbolTable st, STGroup stg, String dir){
		this.symtab = st;
		this.currentScope = st.GLOBALS;
		this.content="";
		this.templates = stg;
		this.dir = dir;
	}
	void createFile(String className, String dir, String content) {
		if(className.equals("Start")) return;
		String limeSkeletonName = className+".skeleton.s";
		FileWriter outputSkefile;
		try {
			outputSkefile = new FileWriter(new File(dir, limeSkeletonName));
			outputSkefile.write(content);
	    	outputSkefile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//class(class_name, fields, methods, actions, active, size, XYZ, init)
	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		ST t = templates.getInstanceOf("class");
		currentScope = (Scope)this.currentScope.resolve(ctx.ID().toString());
		curClassName = ctx.ID().toString();
		t.add("class_name", curClassName);
		if(curClassName.equals("Start")) return;
		Set<String> externs = new HashSet<String>();
		for(String e: ((ClassSymbol)currentScope).methodsCalled.keySet()) {
			externs.add(e);
		}
		for(MethodSymbol ms:((ClassSymbol)currentScope).getDefinedMethods()){
			String name= curClassName+"_"+ms.getName();
			if(externs.contains(name)) {
				externs.remove(name);
			}
		}
		t.add("externs", externs);
		t.add("fields", ((ClassSymbol)currentScope).getDefinedFields());
		t.add("methods", ((ClassSymbol)currentScope).getDefinedMethods());
		t.add("actions", ((ClassSymbol)currentScope).getDefinedActions());
		boolean activated = ((ClassSymbol)currentScope).getActions().size()>0;
		t.add("active", activated);
		t.add("init", ((ClassSymbol)currentScope).getObjInitCode());
		t.add("imported", symtab.importedMethod.keySet());
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
		t.add("guardAsmCode", ((ActionSymbol)currentScope).guardAsmCode);
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
		t.add("guardAsmCode", ((MethodSymbol)currentScope).guardAsmCode);
		content += t.render();
	}
	
	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		//write to file
		createFile(ctx.ID().getText(), this.dir, content);
		
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
