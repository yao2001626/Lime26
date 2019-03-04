package lime.backend;

import java.util.HashMap;
import java.util.Map;

public class X86RegisterManager implements RegisterManager{
	private final int WORD_SIZE = 4;
	private final Register[] callParamRegisters = {}; //pass on the stack
	private final Register[] calleeSaveRegisters = {};
	private final Register[] callerSaveRegisters = {new Register("EBX"),
			new Register("ECX"), new Register("EDX"), new Register("EDI"), new Register("ESI") };
	private final Register reservedRegister = new Register("EBP");
	
	//private RegisterAllocator allocator = new GraphColorAllocator();
	private Map<String, Value> idToValueMapping = new HashMap<String, Value>();
	private Map<Value, String> valueToIdMapping = new HashMap<Value, String>();

	private int k;
	@Override
	public Register getRegisterByIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
