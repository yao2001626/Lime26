package lime.antlr4;

import java.util.List;
import java.util.Set;

public interface Scope {
	String getName();
	Scope getEnclosingScope();
	void setEnclosingScope(Scope s);
	void define(Symbol sym) throws IllegalArgumentException;
	Symbol resolve(String name);
	
	Symbol getSymbol(String name);
	void nest(Scope scope) throws IllegalArgumentException;
	List<Scope> getNestedScopes();
	List<Scope> getEnclosingPathToRoot();
	List<Scope> getNestedScopedSymbols();
	List<? extends Symbol> getSymbols();
	List<? extends Symbol> getAllSymbols();
	
	Set<String> getSymbolNames();
	int getNumberOfSymbols();
	public String toQualifierString(String separator);
}
