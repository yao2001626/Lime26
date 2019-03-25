package lime.codegen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import lime.antlr4.ActionSymbol;
import lime.antlr4.Builder;
import lime.antlr4.ClassSymbol;
import lime.antlr4.FunctionSymbol;
import lime.antlr4.LimeGrammarLexer;
import lime.antlr4.LimeGrammarParser;
import lime.antlr4.LimeGrammarParser.ClassDeclContext;
import lime.antlr4.MethodSymbol;
import lime.antlr4.Symbol;
import lime.antlr4.SymbolTable;

import lime.codegen.LimeLLVMCodeGenVisitor;
import lime.codegen.LimeParserTreeListener;

public class Main {
		//private static boolean makeDot = false;
		private static String stringTemplateFile="./lime.stg";
    	public static void main(String[] args)
        {
            try
            {
                if  (args.length > 0)
                {
                    // Recursively parse each directory, and each file on the
                    // command line
                	
                	int s = 0;
                	if(args[0].startsWith("-stg")) {
                		stringTemplateFile = args[1]!=null? args[1]: "./lime.stg"; 
                		s = 2;
                	}
                	
                	
                    for (int i=s; i<args.length; i++)
                    {
                        parse(new File(args[i]));
                    }
                }
                else
                {
                    System.err.println("Usage: java -jar Lime-Compiler.jar [ -stg ./lime.stg ] <directory | filename.lime>");
                }
            }
            catch (Exception ex)
            {
                System.err.println("Lime parser threw exception:");
                ex.printStackTrace();
            }
        }

        public static void parse(File source) throws Exception
        {

            // Open the supplied file or directory
            try
            {
                // From here, any exceptions are just thrown back up the chain
                if (source.isDirectory())
                {
                    //System.out.println("Directory: " + source.getAbsolutePath());
                    String files[] = source.list();

                    for (int i=0; i<files.length; i++)
                    {
                        parse(new File(source, files[i]));
                    }
                }

                // Else find out if it is a lime file and parse it if it is
                //
                else
                {
                    // File without paths etc
                    String sourceFile = source.getName();

                    if  (sourceFile.length() > 4)
                    {
                        String suffix = sourceFile.substring(sourceFile.length()-5).toLowerCase();

                        // Ensure that this is a lime source file (or seemingly)
                        //
                        if  (suffix.compareTo(".lime") == 0)
                        {
                            parseSource(source.getAbsolutePath());
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                System.err.println("Lime parser caught error on file open:");
                ex.printStackTrace();
            }

        }
        @SuppressWarnings("unchecked")
		public static void buildJson(String source, SymbolTable symtab, Map<String, String> guards) throws Exception{
        	
        	try {
        		String fileName = source.substring(0, source.length()-4);
                fileName = fileName+"json";	
        		FileWriter jsonF = new FileWriter(fileName);
                Set<String> objs = symtab.GLOBALS.getSymbolNames();
                JSONArray limeClasses = new JSONArray();
                for(String o:objs) {
                	if(o.equals("int")||o.equals("bool")||o.equals("void")||o.equals("Start")) continue;
                	JSONObject className = new JSONObject();
                	className.put("class_name", o);
                	JSONObject limeguards = new JSONObject();
                	//methods
                	JSONArray mtds = new JSONArray();
                	ClassSymbol cs = (ClassSymbol)symtab.GLOBALS.resolve(o);
                	//init code
                	className.put(cs.getName()+"_init_code", cs.getObjInitCode());
                	for(MethodSymbol ms: cs.getDefinedMethods()) {
                		if(ms.getName()=="init") continue;
                		mtds.add(ms.getName());
                		//method guard
                		limeguards.put(o+ms.getName(), guards.get(o+ms.getName()));	
                	}
                	className.put("methods",mtds);
                	//actions
                	JSONArray acts = new JSONArray();
                	for(ActionSymbol as: cs.getDefinedActions()) {
                		acts.add(as.getName());
                		//action guard
                		limeguards.put(o+as.getName(), guards.get(o+as.getName()));
                	}
                	className.put("actions",acts);
                	className.put("guards",limeguards);
                	limeClasses.add(className);
                }
                jsonF.write(limeClasses.toJSONString());
                jsonF.close();
        		
        	} catch(Exception ex) {
        		System.err.println("Build Lime class json file threw an exception:\n\n");
                ex.printStackTrace();
        	}
        }
        public static void genMain(String source, SymbolTable symtab, String mainBody, HashSet<String> externFunctions) throws Exception{
        	try {
        		String fileName = source.substring(0, source.length()-5);
                String mainfileName = fileName+"_main.c";
                String mainheaderfileName = fileName+"_main.h";
                FileWriter mainF = new FileWriter(mainfileName);
                FileWriter mainH = new FileWriter(mainheaderfileName);
                String f = "#include <stdlib.h>\n" + 
                		"#include <stdio.h>\n" + 
                		"#include \"%s_main.h\"\n";
                String mainFinclude = String.format(f, fileName.split("/")[fileName.split("/").length-1]);
                mainF.write(mainFinclude);
                //predefined methods filename_main.c
                mainF.write(symtab.preDefinedMethod.get("print")+"\n");
                mainF.write(symtab.preDefinedMethod.get("getArg")+"\n");
                mainF.write(symtab.preDefinedMethod.get("setRand")+"\n");
                mainF.write(symtab.preDefinedMethod.get("getRand")+"\n");
                //predefined methods filename_main.h
                mainH.write(symtab.preDeclaredMethod+"\n");
                // called methods
                for(String s:externFunctions) {
                	
                	//System.out.println(s);
                	//System.out.println(symtab.PREDEFINED);
                	if(symtab.PREDEFINED.resolve(s)!=null) {
                		continue;
                	}else if(s.split("_")[s.split("_").length-1].equals("init")) {
                		
                		ClassSymbol cs = (ClassSymbol)symtab.GLOBALS.resolve(s.split("_")[0]);
                		int n = ((MethodSymbol)cs.resolve("init")).getNumArgs();
                		String tmp ="int ";
                		tmp += s;
                		tmp +="(";
                		if(n==0)tmp+=");\n";
                		else if(n==1) {
                			tmp+="int);\n";
                		}else {//n>1
                			tmp+="int ";
                			int nn = n-1;
                			while(nn>0) {
                				tmp+=", int";
                				nn--;
                			}
                			tmp+=");\n";
                		}
                		mainH.write(tmp);
                	}else {//method_call
                		ClassSymbol cs = (ClassSymbol)symtab.GLOBALS.resolve(s.split("_")[0]);
                		//System.out.println(s.split("_")[1]);
                		MethodSymbol ms = (MethodSymbol)cs.resolveMethod(s.split("_")[1]);
                		//System.out.println(ms.getName()+ms.getNumArgs());
                		String tmp="";
                		if(ms.getType().getName().equals("void")) {
                			tmp += "void ";
                		}else {
                			tmp += "int ";
                		}
                		int n = ms.getNumArgs();
                		
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
                		mainH.write(tmp);
                	}
                	
                }
                
                //MR functions
                if(fileName.split("/")[fileName.split("/").length-1].equals("MR")) {
                	symtab.preDefinedbuildMR();
                	symtab.preDefinedgetMapper();
                	mainF.write(symtab.preDefinedMethod.get("buildMR")+"\n");
                    mainF.write(symtab.preDefinedMethod.get("getMapper")+"\n");
                    mainH.write(symtab.preDeclaredMR+"\n");
                } 

                for(Symbol s: symtab.PREDEFINED.getAllSymbols()) {
                	if(s.getName().equals("print")|| s.getName().equals("setRand")||s.getName().equals("getArg")||s.getName().equals("getRand")|| s.getName().equals("buildMR")||s.getName().equals("getMapper")) continue;
                	// imported method in the .c 
                	//System.out.println((FunctionSymbol)symtab.PREDEFINED.getSymbol(s.getName()));
                	String importedMethod = ((FunctionSymbol)symtab.PREDEFINED.getSymbol(s.getName())).getType().getName() + " " + s.getName() + "(";
                	int k = ((MethodSymbol)s).getNumArgs();
                	if (k==1) {
                		importedMethod += "int)";
                	}else if(k>1) {
                		importedMethod += "int";
                		int l = k;
                		while(l>0) {
                			importedMethod += ", int";
                		}
                		importedMethod += ")";
                		
                	}else {
                		importedMethod += ")";
                	}	
                	// declared method in the .h
                	mainH.write(importedMethod+";\n");
                	importedMethod += String.format("{\n\tprintf(\"Imported method %s did not implement\");\n\t return 0; \n}", s.getName());
                	mainF.write(importedMethod);
                }
                // generate lime main function
                mainF.write(mainBody);
                mainF.close();
                mainH.close();
        	}catch(Exception ex) {
        		System.err.println("Build Lime main file threw an exception:\n\n");
                ex.printStackTrace();
        	}
        	
        	
        }
        public static void parseSource(String source) throws Exception
        {
            // Parse a Lime file
            //
            try
            {  	
            	
            	// step 1 LEXER & PARSER
                LimeGrammarLexer lexer = new Builder.Lexer(source).build(); 
                LimeGrammarParser parser = new Builder.Parser(lexer).build();
                parser.setBuildParseTree(true);
                
                ParseTree tree = parser.compilationUnit();
                // step 2 SYMBOL DEFINE
                SymbolTable symtab = new SymbolTable();
                LimeParserTreeListener lptl = new LimeParserTreeListener(symtab);
                ParseTreeWalker.DEFAULT.walk(lptl, tree);
                
                // step 3 create lime class Json file 
                buildJson(source, symtab, lptl.guardmap);
                
                // step 4 load the string template file
                File file = new File(source);
                String dir = file.getParent();
                String templatesFilename = stringTemplateFile;
                STGroup templates = new STGroupFile(templatesFilename);
                
                // step 5 create lime classes skeleton files and LLVM files (one lime file may contains multiple classes)
                LimeSkeCodeGenListener lcgl = new LimeSkeCodeGenListener(symtab, templates);
                LimeLLVMCodeGenVisitor llvmcgv = new LimeLLVMCodeGenVisitor(symtab);
                LimeMainCodeGenVisitor lmcg = new LimeMainCodeGenVisitor(symtab);
                //System.out.println(source);
                HashSet<String> externFunctions = new HashSet<String>();
                for(int i=0; i<tree.getChildCount() && (tree.getChild(i) instanceof ClassDeclContext); ++i) {
                	//lime class name
                	String outputName = ((ClassDeclContext)tree.getChild(i)).ID().getText();
                	if(outputName.equals("Start")) {
                		ClassSymbol cs = (ClassSymbol)symtab.GLOBALS.getSymbol("Start");
                		//System.out.println(cs.externMethods);
                		externFunctions.addAll(cs.externMethods);
                		continue;
                	}
                	String limeSkeletonName = outputName+".skeleton.s";
                	String limeLLVMName = outputName+".c";
                	
                	FileWriter outputSkefile = new FileWriter(new File(dir, limeSkeletonName));
                	//System.out.print("writing file: "+limeSkeletonName+"\n");
                	ParseTreeWalker.DEFAULT.walk(lcgl, tree.getChild(i));
                	outputSkefile.write(lcgl.content);
                	outputSkefile.close();
                	
                	FileWriter outputLLVMfile = new FileWriter(new File(dir, limeLLVMName));
                	//System.out.print("writing file: "+limeLLVMName +"\n");
                	outputLLVMfile.write(llvmcgv.visit(tree.getChild(i)));
                	outputLLVMfile.close();
                	
                	
                }
            	//System.out.println(lmcg.visit(tree));
                genMain(source, symtab, lmcg.visit(tree), externFunctions);
            }
            catch (FileNotFoundException ex)
            {
                // The file we tried to parse does not exist
                System.err.println("\n  !!The file " + source + " does not exist!!\n");
            }
            catch (Exception ex)
            {
                // Something went wrong in the parser, report this
                System.err.println("Lime Parser threw an exception:\n\n");
                ex.printStackTrace();
            }
        }
}
