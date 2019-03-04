package lime.antlr4;

import java.util.List;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.GuardContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;

public class LimeCodeGenListener extends LimeGrammarBaseListener{
	SymbolTable symtab;
	Scope currentScope;
	ST t;
	STGroup templates;
	String currentClassName;
	public LimeCodeGenListener(SymbolTable st){
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
		t.add("class_name", ctx.scope.getName());
		int s = ((ClassSymbol)ctx.scope).fields.size();
		
		t.add("fields", ((ClassSymbol)ctx.scope).fields);
		t.add("methods", ((ClassSymbol)ctx.scope).methods);
		t.add("actions", ((ClassSymbol)ctx.scope).actions);
		t.add("enabled", true);
		t.add("guard", true);
		t.add("XYZ", (s+4)*4);
		System.out.println(t.render());	
	}
	
	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		t = templates.getInstanceOf("def_method");
		t.add("class_name", this.currentClassName);
		t.add("method_name", ctx.scope.getName());
		t.add("num", ((MethodSymbol)ctx.scope).getNumberOfParameters());
//		if(ctx.type()!=null){
//			t.add("rettype", ctx.scope.resolve(ctx.type().getText()));
//		}else {
//			t.add("rettype", "void");
//		}
//		if(ctx.parameters().typedargslist() != null) {
//			List<ArgsdefContext> ll = ctx.parameters().typedargslist().argsdef();
//			t.add("args", ll);
//		}
//		if(ctx.test() != null) {
//			t.add("guard", ctx.test().getText());	
//		}
		if(t!=null) {
			 System.out.println(t.render());
		}	
	}

	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		// TODO Auto-generated method stub
		t = templates.getInstanceOf("def_action");
		t.add("class_name", this.currentClassName);
		t.add("action_name", ctx.scope.getName());
		//t.add("actions", ((ClassSymbol)ctx.scope.getEnclosingScope()).actions);
		t.add("index", ((ActionSymbol)ctx.scope).getSlotNumber());
		if(t!=null) {
			 System.out.println(t.render());
		}
	}

	@Override
	public void enterInitDecl(InitDeclContext ctx) {
		// TODO Auto-generated method stub
		super.enterInitDecl(ctx);
	}
}
