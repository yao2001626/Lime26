package lime.antlr4;

public class TypeAlias extends BaseSymbol implements Type{
	
	protected Type targetType;
	public TypeAlias(String name, Type targetType) {
		super(name);
		this.targetType = targetType;
	}
	
	@Override
	public int getTypeIndex() { return -1; }

	public Type getTargetType() {
		return targetType;
	}

}
