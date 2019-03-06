package lime.antlr4;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//import com.google.common.collect.Sets; 


public class MethodSymbol extends FunctionSymbol implements MemberSymbol{
	protected int slot = -1;
	protected boolean enabled = false;
	public Set<String> methodAssignLvalue;
	
	public MethodSymbol(String name) {
		super(name);
		methodAssignLvalue = new HashSet<String>();
		
	}
	
	public void setEnabled(Set<String> cgids) {
		/*
		Set<String> answer = Sets.j(methodGuardIds, methodAssignLvalue); 
		if(!answer.isEmpty()) {
			enabled = true;
		}*/
		
		for(String s:cgids) {
			for(String s1:methodAssignLvalue) {
				if(s.equals(s1)) {
					enabled = true;
					return;
				}
			}
		}
	}
	@Override
	public int getSlotNumber() { return slot; }
	
	
	public boolean isEnabled() {
		return enabled;
	}
}
