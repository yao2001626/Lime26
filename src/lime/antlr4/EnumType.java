package lime.antlr4;

import java.util.LinkedHashSet;
import java.util.Set;

public class EnumType implements Type {
	public String name;
	public Set<String> values;
	
	public EnumType(){
		name = "enum";
		values = new LinkedHashSet<String>();
	}
	
	public void addAllValues(LinkedHashSet<String> vs) {
		values.addAll(vs);
	}
	
	@Override
	public String getName() {
		return "enum";
	}
	@Override
	public int getTypeIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

}
