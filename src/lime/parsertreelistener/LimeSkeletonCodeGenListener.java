package lime.parsertreelistener;

import java.io.FileWriter;
import java.io.IOException;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import lime.antlr4.ActionSymbol;
import lime.antlr4.LimeGrammarBaseListener;
import lime.antlr4.MethodSymbol;
import lime.antlr4.Scope;
import lime.antlr4.SymbolTable;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.GuardContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;

public class LimeSkeletonCodeGenListener extends LimeGrammarBaseListener{
	SymbolTable symtab;
	Scope currentScope;
	ST t;
	STGroup templates;
	String currentClassName;
	public String ot="";
	public LimeSkeletonCodeGenListener(SymbolTable st){
		this.symtab = st;
		String templatesFilename = "input_data/def_class.stg";
		templates = new STGroupFile(templatesFilename);
		templates.load();
	}
	
	//def_class(class_name, fields, methods, actions, enabled, size, XYZ, init)
	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		t = templates.getInstanceOf("def_class");
		this.currentClassName = ctx.scope.getName();
		t.add("class_name", this.currentClassName);
		this.ot += t.render();	
	}
	//def_method(class_name, method_name, num, rettype, args, guard, block)
	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		t = templates.getInstanceOf("def_method");
		t.add("class_name", this.currentClassName);
		t.add("method_name", ctx.scope.getName());
		t.add("num", ((MethodSymbol)ctx.scope).getNumberOfParameters());
		if(t!=null) {
			this.ot += t.render();
			//System.out.println(t.render());
		}	
	}
	//def_action(class_name, action_name, index, guard, block)
	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		t = templates.getInstanceOf("def_action");
		t.add("class_name", this.currentClassName);
		t.add("action_name", ctx.scope.getName());
		//t.add("actions", ((ClassSymbol)ctx.scope.getEnclosingScope()).actions);
		t.add("index", ((ActionSymbol)ctx.scope).getSlotNumber());
		if(t!=null) {
			this.ot += t.render();
			//System.out.println(t.render());
		}
	}
}
