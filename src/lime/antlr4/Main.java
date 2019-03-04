package lime.antlr4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import lime.parsertreelistener.LimeLLVMCodeGenVisitor;
import lime.parsertreelistener.LimeParserTreeListener;

public class Main {
	public static void main(String[] args) throws IOException {
        String file_source = "input_data/PQ.lime";
        
        // step 1 LEXER & PARSER
        LimeGrammarLexer lexer = new Builder.Lexer(file_source).build(); 
        
        //System.out.print(lexer.toString());
        LimeGrammarParser parser = new Builder.Parser(lexer).build();
        //System.out.print(parser.toString());
        parser.setBuildParseTree(true);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        LimeSymbolListener limedef = new LimeSymbolListener();
        
        // step 2 SYMBOL DEFINE
        SymbolTable symtab = new SymbolTable();
        LimeParserTreeListener lptl = new LimeParserTreeListener(symtab);
        walker.DEFAULT.walk(lptl, tree);
        
        // step 3 CODE GENERATION
        //ClassLoader cl = Main.class.getClassLoader();
        //InputStream in = cl.getResourceAsStream(templatesFilename);
        //Reader rd = new InputStreamReader(in);
        
        LimeCodeGenListener lcgl = new LimeCodeGenListener(symtab);
        walker.DEFAULT.walk(lcgl, tree);
        //rd.close();
        
      //SymbolListener symbolListener = new SymbolListener();
        //walker.DEFAULT.walk(symbolListener, tree);
        LimeLLVMCodeGenVisitor symbolVisitor = new LimeLLVMCodeGenVisitor(symtab);
        System.out.print(symbolVisitor.visit(tree));
	}
}
