package lime.codegen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import lime.antlr4.ActionSymbol;
import lime.antlr4.ClassSymbol;
import lime.antlr4.LimeGrammarBaseListener;
import lime.antlr4.LimeGrammarParser.ActionDeclContext;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.LimeGrammarParser.InitDeclContext;
import lime.antlr4.LimeGrammarParser.MethodDeclContext;
import lime.antlr4.MethodSymbol;
import lime.antlr4.Scope;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;

public class LimeSkeletonCodeGenListenerNew extends LimeGrammarBaseListener{
	
	SymbolTable symtab;
	Scope currentScope;
	File outputDir;
	FileOutputStream fos;
	OutputStreamWriter fileWriter;
	String content="";
	String sourcefileName = "";
	List<String> records;
	
	public LimeSkeletonCodeGenListenerNew(SymbolTable st){
		this.symtab = st;
		this.currentScope = st.GLOBALS;
		
		//this.outputDir = source;
	}
	
	public LimeSkeletonCodeGenListenerNew(SymbolTable st, String fileName){
		this.symtab = st;
		this.currentScope = st.GLOBALS;
		this.sourcefileName = fileName;
		
		//this.outputDir = source;
	}

	@Override
	public void enterClassDecl(ClassDeclContext ctx) {
		String cName= ctx.ID().toString();
		currentScope = (Scope)this.currentScope.resolve(ctx.ID().toString());
		System.out.println("enter class: "+ ((ClassSymbol)currentScope).getFields());
		File outputFile = new File(this.outputDir, ctx.ID().toString()+".s");
		try {
			fos= new FileOutputStream(outputFile);
			fileWriter = new OutputStreamWriter(fos, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String templatesFilename = "input_data/class.stg";
		STGroup templates = new STGroupFile(templatesFilename);
		ST t = templates.getInstanceOf("class");
		
		//class(class_name, fields, methods, actions, enabled, paramsize)
		t.add("class_name", cName);
		t.add("fields", ((ClassSymbol)currentScope).getDefinedFields());
		t.add("methods", ((ClassSymbol)currentScope).getDefinedMethods());
		t.add("actions", ((ClassSymbol)currentScope).getDefinedActions());
		boolean enabled = ((ClassSymbol)currentScope).getActions().size()>0;
		t.add("active", enabled);
		int size = ((ClassSymbol)currentScope).getDefinedFields().size();
		if(enabled) {
			size = 32768;
		}else {
			size += (size+4)*4; 
		}
		t.add("size", size);
		int xyz = (((ClassSymbol)currentScope).getDefinedFields().size()+ 4)*4 ;
		t.add("XYZ", xyz);
		content="";
		//System.out.println(t.render());
		content += t.render();
		//int parasize = ((ClassSymbol)currentScope).getinitparasize();
	}
	
	void findMethodbody(String file, String method) throws IOException {
		boolean startFunction =false;
		boolean endFunction =false;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		records = new ArrayList<String>();
		String line;
	    try {
			while ((line = reader.readLine()) != null)
			{
			  if(line.startsWith(method)) {
				  startFunction = true;
			  }else if(startFunction && line.contains(".cfi_endproc")) {
				  endFunction = true;
			  }else if(startFunction && !endFunction) {  
				  if(!line.startsWith("##") && !line.contains("retl"))records.add(line);
			  }else if(startFunction && endFunction) {
				  break;
			  }else if(!startFunction && !endFunction) {
				  continue;
			  }
			  //records.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.close();
		}
	}
	void writeFile(String cName, ClassSymbol cls) {
		//write file
		String outfileName = "input_data/lime_merge/"+cName+".s";
		String llvmName = "input_data/lime_LLVM/"+sourcefileName+".s";
		FileWriter writer;
		Set<String> llvmMethods = new HashSet<String>();
		for(MethodSymbol c: cls.getDefinedMethods()) {
			llvmMethods.add("_"+cName +"_"+ c.getName()+":");
		}
		for(ActionSymbol a : cls.getDefinedActions()) {
			llvmMethods.add("_"+cName +"_"+ a.getName()+":");
		}
		for(String llname: llvmMethods) {
			try {
				//System.out.println("find: "+ llname);
				findMethodbody(llvmName, llname);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("body: "+llname.substring(0, llname.length()-1)+"_body");
			String replace ="";
			for(String cc: records) {
				replace += cc;
				replace +="\n";
			}
			content = content.replace(llname.substring(0, llname.length()-1)+"_body", replace);
			content = content.replaceAll("##", ";");
		}
		try {
			writer = new FileWriter(outfileName);
			writer.write(content); 
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void exitClassDecl(ClassDeclContext ctx) {
		String cName= currentScope.getName();
		ClassSymbol cls = (ClassSymbol)currentScope; 
		currentScope = currentScope.getEnclosingScope();
		System.out.println("exit class: "+ currentScope);
		writeFile(cName, cls);
	}

	@Override
	public void enterInitDecl(InitDeclContext ctx) {
		System.out.println("enter init: "+ currentScope);
		//currentScope = (Scope)this.currentScope.resolve(ctx.ID().toString());
	}

	@Override
	public void exitInitDecl(InitDeclContext ctx) {
		//currentScope = currentScope.getEnclosingScope();
		System.out.println("exit init: "+ currentScope);
	}

	@Override
	public void enterMethodDecl(MethodDeclContext ctx) {
		String cName= currentScope.getName();
		currentScope = (Scope)this.currentScope.resolve(ctx.ID().toString());
		System.out.println("enter method: "+ currentScope);
		
		
		String templatesFilename = "input_data/method.stg";
		STGroup templates = new STGroupFile(templatesFilename);
		ST t = templates.getInstanceOf("method");
		
		//method(class_name, method_name, paranum, guard, block)
		t.add("class_name", cName);
		t.add("method_name", ctx.ID().toString());
		t.add("paranum", ((MethodSymbol)currentScope).getNumberOfParameters());
		t.add("guard",((MethodSymbol)currentScope).guard);
		//System.out.println(t.render());
		content += t.render();
	}

	@Override
	public void exitMethodDecl(MethodDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		System.out.println("exit method: "+ currentScope);
		
	}
	@Override
	public void enterActionDecl(ActionDeclContext ctx) {
		String cName= currentScope.getName();
		currentScope = (Scope)this.currentScope.resolve(ctx.ID().toString());
		System.out.println("enter action: "+ currentScope);
		String templatesFilename = "input_data/action.stg";
		STGroup templates = new STGroupFile(templatesFilename);
		ST t = templates.getInstanceOf("action");
		//action(class_name, action_name, guard, block)
		t.add("class_name", cName);
		t.add("action_name", ctx.ID().toString());
		t.add("guard",((ActionSymbol)currentScope).guard);
		//System.out.println(t.render());
		content += t.render();
	}
	@Override
	public void exitActionDecl(ActionDeclContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		System.out.println("exit action: "+ currentScope);
	}
}
