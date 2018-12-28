package lime.antlr4;

import java.util.LinkedHashMap;
import java.util.Map;

public class MethodSymbol extends FunctionSymbol implements MemberSymbol{
	protected int slot = -1;

	public MethodSymbol(String name) {
		super(name);
	}

	@Override
	public int getSlotNumber() { return slot; }
}
