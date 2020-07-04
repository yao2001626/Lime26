package lime.antlr4;

public class ParameterSymbol extends VariableSymbol implements MemberSymbol{
	int index = 0;
	Type typ;
	public ParameterSymbol(String name) {
		super(name); 
	}
	public ParameterSymbol(String name, int x) {
		super(name); 
		this.index = x;
	}
	public ParameterSymbol(String name, Type t) {
		super(name); 
		this.typ = t;
	}
	public int getIndex() {
		return index*4;
	}
	public Type getType() {
		return typ;
	}
	
	@Override
	public int getSlotNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
