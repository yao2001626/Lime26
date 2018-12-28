package lime.antlr4;

public class FieldSymbol extends VariableSymbol implements MemberSymbol{
	protected int slot;

	public FieldSymbol(String name) {
		super(name);
	}

	@Override
	public int getSlotNumber() { return slot; }
}
