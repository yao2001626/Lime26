package lime.antlr4;

public class EnumSymbol extends BaseSymbol implements Type, MemberSymbol {
	public Type type;
	public static int index= 0 ;
	protected int constantValue; 
	
	public EnumSymbol(String name) {
		super(name);
		constantValue = index++;
	}
	
	public EnumSymbol(Type ty, String name) {
		super(name);
		this.type = ty;
	}
	
	public int getConstantValue() {
		return constantValue;
	}
	
	@Override
	public int getTypeIndex() {
		return 0;
	}

	@Override
	public int getSlotNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
}
