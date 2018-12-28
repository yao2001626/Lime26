package lime.antlr4;

public class LimeValue implements Comparable<LimeValue> {

	public static final LimeValue NULL = new LimeValue();
	public static final LimeValue VOID = new LimeValue();
	private Object value;
	 private LimeValue() {
	        // private constructor: only used for NULL and VOID
	        value = new Object();
	}
	@Override
	public int compareTo(LimeValue o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
