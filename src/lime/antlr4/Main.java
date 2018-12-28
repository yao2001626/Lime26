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

public class Main {
	/*
	public static void listMethodNames(String source) {
        ParseTreeWalker.DEFAULT.walk(new LimeGrammarBaseListener() {

            // The grammar rule for a function definition looks like this:
            //
            //      funcdef
            //       : DEF NAME parameters ( '->' test )? ':' suite
            //       ;
            //
            @Override
            public void enterMethodDecl(LimeGrammarParser.MethodDeclContext ctx) {
                System.out.println("NAME=" + ctx.ID().getText());
            }

        }, parser.compilationUnit());
    }
	*/
	public static void main(String[] args) throws IOException {
        String file_source = "input_data/PQ.lime";
        
        // step 1 LEXER & PARSER
        LimeGrammarLexer lexer = new Builder.Lexer(file_source).build(); 
        LimeGrammarParser parser = new Builder.Parser(lexer).build();
        parser.setBuildParseTree(true);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        LimeSymbolListener limedef = new LimeSymbolListener();
        
        // step 2 SYMBOL DEFINE
        SymbolTable symtab = new SymbolTable();
//        LimeParserTreeListener lptl = new LimeParserTreeListener(symtab.globals, symtab);
//        walker.DEFAULT.walk(lptl, tree);
        
        // step 3 CODE GENERATION
        //ClassLoader cl = Main.class.getClassLoader();
        //InputStream in = cl.getResourceAsStream(templatesFilename);
        //Reader rd = new InputStreamReader(in);
        
        LimeCodeGenListener lcgl = new LimeCodeGenListener(symtab);
        walker.DEFAULT.walk(lcgl, tree);
        //rd.close();

        // step 4 EMIT IR
        ST hello = new ST("Hello, <name>");
        hello.add("name", "World");
        System.out.println(hello.render());
	}
}
