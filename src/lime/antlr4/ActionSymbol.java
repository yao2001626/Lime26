package lime.antlr4;

import java.util.LinkedHashMap;
import java.util.Map;

public class ActionSymbol extends FunctionSymbol implements MemberSymbol{
	protected int slot = -1;

	public ActionSymbol(String name) {
		super(name);
	}

	@Override
	public int getSlotNumber() { return slot; }
}
