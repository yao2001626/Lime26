package lime.antlr4;

import java.util.HashSet;
import java.util.Set;
//import com.google.common.collect.Sets; 


public class MethodSymbol extends FunctionSymbol implements MemberSymbol{
	protected int slot = -1;
	protected boolean enabled = false;
	protected boolean unguarded = false;
	protected boolean privateMethod = false;
	protected int numargs = 0;
	public Set<String> methodAssignLvalue;
	public Set<String> guardIds;
	public String guardAsmCode = "";
	public String methodDecl = "";
	public String methodDeclforMain = "";
	
	public MethodSymbol(String name) {
		super(name);
		methodAssignLvalue = new HashSet<String>();
		guardIds = new HashSet<String>();
	}
	
	public void setNumArgs(int n) {
		numargs = n;
	}
	public int getNumArgs() {
		return numargs;
	}
	public void setEnabled(Set<String> cgids) {
		for(String s:cgids) {
			for(String s1:methodAssignLvalue) {
				if(s.equals(s1)) {
					enabled = true;
					return;
				}
			}
		}
	}
	public void setPrivate() {
		privateMethod = true;
	}
	public boolean isPrivateMethod() {
		return privateMethod;
	}
	
	@Override
	public int getSlotNumber() { return slot; }
	
	
	public void setUnguarded() {
		unguarded = true;
	}
	
	public boolean unguarded() {
		return unguarded;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
