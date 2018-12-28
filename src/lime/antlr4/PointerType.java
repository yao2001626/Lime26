package lime.antlr4;

public class PointerType implements Type{

	protected Type targetType;
	public PointerType(Type targetType) {
		this.targetType = targetType;
	}

	@Override
	public String getName() {
		return toString();
	}

	@Override
	public int getTypeIndex() { return -1; }

	@Override
	public String toString() {
		return "*"+ targetType;
}
}
