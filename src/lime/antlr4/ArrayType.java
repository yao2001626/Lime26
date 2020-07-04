package lime.antlr4;

public class ArrayType implements Type{
	protected final Type elemType;
	protected final int numElems; // some languages allow you to point at arrays of a specific size

	public ArrayType(Type elemType) {
		this.elemType = elemType;
		this.numElems = -1;
	}

	public ArrayType(Type elemType, int numElems)
	{
		this.elemType = elemType;
		this.numElems = numElems;
	}

	@Override
	public String getName() {
		return toString();
	}

	@Override
	public int getTypeIndex() { return -1; }

	@Override
	public String toString() {
		//return elemType+"[]";
		return elemType.getName();
	}
	
	public Type getType() {
		return elemType;
	}

}
