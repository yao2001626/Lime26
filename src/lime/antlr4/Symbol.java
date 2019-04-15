package lime.antlr4;

public interface Symbol {
	String getName();
	Scope getScope();
	void setScope(Scope scope); // set scope (not enclosing) for this symbol; who contains it?
	int getInsertionOrderNumber(); // index showing insertion order from 0
	void setInsertionOrderNumber(int i);

	// to satisfy adding symbols to sets, hashtables
	int hashCode();
	boolean equals(Object o);	
}
