package lime.symtab;

import lime.antlr4.BaseScope;
import lime.antlr4.GlobalScope;
import lime.antlr4.InvalidType;
import lime.antlr4.PredefinedScope;
import lime.antlr4.PrimitiveType;
import lime.antlr4.Symbol;
import lime.antlr4.Type;

public class SymbolTable {
	public static final Type INVALID_TYPE = new InvalidType();
	public BaseScope PREDEFINED = new PredefinedScope();
	public GlobalScope GLOBALS = new GlobalScope(PREDEFINED);

	public SymbolTable() {
		initTypeSystem();
	}

	public void initTypeSystem() {
		PrimitiveType intType  = new PrimitiveType("int");
		defineGlobalSymbol(intType);
		PrimitiveType boolType = new PrimitiveType("bool");
		defineGlobalSymbol(boolType);
	}

	public void definePredefinedSymbol(Symbol s) {
		PREDEFINED.define(s);
	}

	public void defineGlobalSymbol(Symbol s) {
		GLOBALS.define(s);
	}

}
