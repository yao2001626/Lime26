package lime.antlr4;

public class SymbolTable {
	public static final Type INVALID_TYPE = new InvalidType();

	public BaseScope PREDEFINED = new PredefinedScope();
	public GlobalScope GLOBALS = new GlobalScope(PREDEFINED);

	public SymbolTable() {
		initTypeSystem();
		initPredefineMethod();
	}

	public void initTypeSystem() {
		PrimitiveType intType  = new PrimitiveType("int");
		defineGlobalSymbol(intType);
		PrimitiveType boolType = new PrimitiveType("bool");
		defineGlobalSymbol(boolType);
		PrimitiveType voidType = new PrimitiveType("void");
		defineGlobalSymbol(voidType);
	}

	public void definePredefinedSymbol(Symbol s) {
		PREDEFINED.define(s);
	}
	
	public void initPredefineMethod() {
		MethodSymbol fun_print = new MethodSymbol("print");
		PREDEFINED.define(fun_print);
		MethodSymbol fun_rand = new MethodSymbol("rand");
		PREDEFINED.define(fun_rand);
		MethodSymbol fun_getArg = new MethodSymbol("getArg");
		PREDEFINED.define(fun_getArg);
	}
	
	public void definePredefineMethod(Symbol s) {
		PREDEFINED.define(s);
	}

	public void defineGlobalSymbol(Symbol s) {
		GLOBALS.define(s);
	}
}
