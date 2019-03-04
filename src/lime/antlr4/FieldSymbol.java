package lime.antlr4;

public class FieldSymbol extends VariableSymbol implements MemberSymbol{
	protected int slot;
	int fieldIndex;
	public FieldSymbol(String name) {
		super(name);
		//this.fieldIndex = index;
		//this.slot = index;
	}

	@Override
	public int getSlotNumber() { return slot; }
	
	@Override
	public String toString() {
		String s = super.toString();
		return s +": "+ this.fieldIndex;
	}
}
