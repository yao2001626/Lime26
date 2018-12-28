package lime.antlr4;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class LimeAST extends CommonToken {
	public Scope scope;		//
	public Symbol symbol; 	//
    public LimeAST(Token t) { super(t); }
}
