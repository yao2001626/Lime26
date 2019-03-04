package lime.antlr4;

public class ParameterSymbol extends VariableSymbol{
	int index = 0;
	public ParameterSymbol(String name) {
		super(name); 
	}
	public ParameterSymbol(String name, int x) {
		super(name); 
		this.index = x;
	}
	
	public int getIndex() {
		return index*4;
	}
	
}
