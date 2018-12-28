package lime.antlr4;

public class GlobalScope extends BaseScope {
	public GlobalScope(Scope scope) { super(scope); }
	public String getName() { return "global"; }
}
