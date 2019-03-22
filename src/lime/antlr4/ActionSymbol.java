package lime.antlr4;

import java.util.LinkedHashMap;
import java.util.Map;

public class ActionSymbol extends FunctionSymbol implements MemberSymbol{
	protected static int slot = 0;
	protected boolean unguarded = false;
	public ActionSymbol(String name) {
		super(name);
	}
	@Override
	public int getSlotNumber() { return ++slot; }
	@Override
	public String toString() { return name; }
	
	public void setUnguarded() {
		unguarded = true;
	}
	
	public boolean unguarded() {
		return unguarded;
	}
	
}
