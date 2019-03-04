package lime.antlr4;

import java.util.Collection;

import org.antlr.v4.runtime.ParserRuleContext;

public class FunctionSymbol extends SymbolWithScope implements TypedSymbol{
	protected ParserRuleContext defNode;
	protected Type retType;
	public String guard;
	public FunctionSymbol(String name) {
		super(name);
	}

	public void setDefNode(ParserRuleContext defNode) {
		this.defNode = defNode;
	}

	public ParserRuleContext getDefNode() {
		return defNode;
	}

	@Override
	public Type getType() {
		return retType;
	}

	@Override
	public void setType(Type type) {
		retType = type;
}
	public int getNumberOfVariables() {
		return Utils.filter(symbols.values(), s -> s instanceof VariableSymbol).size();
	}

	public int getNumberOfParameters() {
		return Utils.filter(symbols.values(), s -> s instanceof ParameterSymbol).size();
	}

	//public String toString() { return name+":"+super.toString(); }
	public String toString() { 
		String s = name;
		Collection<Symbol> v = symbols.values();
		int t = 0;
		if(v !=null) {
			s+="(";
			for(Symbol x : v) {
				if(x instanceof ParameterSymbol) {
					s += x.getName();
				}
				t++;
				if(t<v.size())s += ", ";
			}
			s+=")";
		}
		return s; 
	}

}
