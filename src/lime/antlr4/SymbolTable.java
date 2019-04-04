package lime.antlr4;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
	public static final Type INVALID_TYPE = new InvalidType();

	public BaseScope PREDEFINED = new PredefinedScope();
	public GlobalScope GLOBALS = new GlobalScope(PREDEFINED);
	public Map<String, String> preDefinedMethod = new HashMap<String, String>();
	public String preDeclaredMethod;
	public String preDeclaredMR;
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
	
	public void preDefinedPrint() {
		String key= "print";
		String value = "void print(int x){\n" + 
				"	// This is the default built-in function: print\n" + 
				"	printf(\"%d\\n\", x);\n" + 
				"	return;\n" + 
				"}";
		preDefinedMethod.put(key, value);
	}
	
	public void preDefinedsetRand() {
		String key="setRand";
		String value ="void setRand(int num){\n" + 
				"    char *dir = argv_g[2];\n" + 
				"	 char filename[100];\n" + 
				"    char * line = NULL;\n" + 
				"    size_t len = 0;\n" + 
				"    ssize_t read;\n" + 
				"    snprintf(filename, 100, \"%s/%s\", dir, argv_g[1]);\n" + 
				"    FILE *file= fopen(filename, \"r\");\n" + 
				"    if (file == NULL) exit(EXIT_FAILURE);\n" + 
				"    input = (int *)malloc(sizeof(int)*num);\n" + 
				"    int i = 0;\n" + 
				"    while ((read = getline(&line, &len, file)) != -1) {\n" + 
				"        input[i]=atoi(line);\n" + 
				"        i++;\n" + 
				"    }\n" + 
				"    fclose(file);\n" + 
				"}";
		preDefinedMethod.put(key, value);
	}
	
	public void preDefinedgetRand() {
		String key="getRand";
		String value ="int getRand(int index){\n" + 
				"	return input[index];\n" + 
				"}";
		preDefinedMethod.put(key, value);
	}
	
	public void preDefinedgetArg() {
		String key="getArg";
		String value ="int getArg(int index){\n" + 
				"	// This is the default built-in function: getArg\n" + 
				"	// System global variables: int argc_g, char **argv_g\n" + 
				"	return atoi(argv_g[index]);\n" + 
				"}";
		preDefinedMethod.put(key, value);
	}
	
	public void preDefinedgetMapper() {
		String key="getMapper";
		String value ="struct Mapper_struct * getMapper(int index){\n" + 
				"	return (struct Mapper_struct *)m[index];\n" + 
				"}";
		preDefinedMethod.put(key, value);
	}
	
	public void preDefinedbuildMR() {
		String key="buildMR";
		String value ="void buildMR(int num){\n" + 
				"    r = (struct Reducer_struct **) malloc (sizeof(struct Reducer_struct *)*num);\n" + 
				"    m = (struct Mapper_struct **) malloc (sizeof(struct Mapper_struct *)*num);\n" + 
				"    int i = 0;\n" + 
				"    int N = num;\n" + 
				"    m[0] = (struct Mapper_struct *)Mapper_init(0);\n" + 
				"    i = 1;\n" + 
				"    while(i<N){\n" + 
				"        m[i] = (struct Mapper_struct *)Mapper_init(i);\n" + 
				"        r[i] = (struct Reducer_struct *)Reducer_init(i);\n" + 
				"        i = i + 1;\n" + 
				"    }\n" + 
				"    i = 1;\n" + 
				"    while(i<N/2){\n" + 
				"        r[i*2]->next = r[i];\n" + 
				"        r[i*2+1]->next = r[i];\n" + 
				"        i = i + 1;\n" + 
				"    }\n" + 
				"    i = 0;\n" + 
				"    while(i<N){\n" + 
				"        m[i]->next = r[(i+N)/2];\n" + 
				"        i = i + 1;\n" + 
				"    }\n" + 
				"    //return NULL;\n" + 
				"}";
		preDefinedMethod.put(key, value);
		preDeclaredMR = "int Mapper_init(int);\n"+
				"int Reducer_init(int);\n"+
				"void Mapper_map(int, void*,void*);\n"+
				"struct Reducer_struct{\n" + 
				"int pre_ebp;\n" + 
				"int pre_esp;\n" + 
				"int lock;\n" + 
				"int system_next;\n" + 
				"int index;\n" + 
				"struct Reducer_struct *next;\n" + 
				"int a1;\n" + 
				"int a2;\n" + 
				"int e1;\n" + 
				"int e2;\n" + 
				"};"+ 
				"\n" + 
				"struct Mapper_struct{\n" + 
				"int pre_ebp;\n" + 
				"int pre_esp;\n" + 
				"int lock;\n" + 
				"int system_next;\n" + 
				"struct Reducer_struct *next;\n" + 
				"int a;\n" + 
				"int e;\n" + 
				"int index;\n" + 
				"};\n" +
				"\n" + 
				"struct Mapper_struct **m;\n" + 
				"struct Reducer_struct **r;";
	}
	
	public void initPredefineMethod() {
		MethodSymbol fun_print = new MethodSymbol("print");
		PREDEFINED.define(fun_print);
		preDefinedPrint();
		MethodSymbol fun_getRand = new MethodSymbol("getRand");
		PREDEFINED.define(fun_getRand);
		preDefinedgetRand();
		MethodSymbol fun_setRand = new MethodSymbol("setRand");
		PREDEFINED.define(fun_setRand);
		preDefinedsetRand();
		MethodSymbol fun_getArg = new MethodSymbol("getArg");
		PREDEFINED.define(fun_getArg);
		preDefinedgetArg();
		preDeclaredMethod = "extern int argc_g;\n" + 
				"extern char ** argv_g;\n" + 
				"int * input;\n" + 
				"int getRand();\n" + 
				"void setRand(int num);\n" + 
				"void print(int x);\n" + 
				"int getArg(int index);\n" + 
				"void lime_main(void * self);";
	}
	
	public void definePredefineMethod(Symbol s) {
		PREDEFINED.define(s);
	}

	public void defineGlobalSymbol(Symbol s) {
		GLOBALS.define(s);
	}
}
