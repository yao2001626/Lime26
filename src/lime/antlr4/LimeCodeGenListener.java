package lime.antlr4;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import lime.antlr4.LimeGrammarParser.MethodDeclContext;

public class LimeCodeGenListener extends LimeGrammarBaseListener{
	SymbolTable symtab;
	Scope currentScope;
	ST t;
	STGroup templates;
	LimeCodeGenListener(SymbolTable st){
		this.symtab = st;
		String templatesFilename = "input_data/llvm.stg";
		templates = new STGroupFile(templatesFilename);
		templates.load();
		
	}
	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("define method\n");
		t = templates.getInstanceOf("def_method");
		//Symbol s = symtab.resolveID(ctx.ID().getText());
		//t.add("sym", s);
		if(t!=null) {
			 System.out.println(t.render());
		}	
		//def_method();
	}
}
