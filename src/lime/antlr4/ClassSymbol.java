package lime.antlr4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** A symbol representing the class. It is a kind of data aggregate
 *  that has much in common with a struct.
 */
public class ClassSymbol extends DataAggregateSymbol {
	protected String superClassName; // null if this is Object
	protected int nextFreeMethodSlot = 0; // next slot to allocate
	protected int nextFreeActionSlot = 0; // next slot to allocate
	boolean enabled = false;
	int action_counter = 0;
	int size = 0;
	List<Symbol> fields = new LinkedList<Symbol>();
	HashMap<String, String> fields_init = new HashMap<String, String>();
	Set<Symbol> methods = new LinkedHashSet<Symbol>();
	Set<Symbol> actions = new LinkedHashSet<Symbol>();
	public Set<String> methodCalled;
	public Set<String> classGuardIds;
	public Set<String> externMethods;
	String objInitCode="";
	public ClassSymbol(String name) {
		super(name);
		classGuardIds = new HashSet<String>();
		methodCalled = new HashSet<String>();
		externMethods = new HashSet<String>();
		externMethods.add("print");
		externMethods.add("getRand");
	}
	public void addExternalFunction() {
		Set<String> dms = new HashSet<String>();
		for(MethodSymbol m:getDefinedMethods()) {
			dms.add(getName()+"_"+m.getName());
		}
		for(String m: methodCalled) {
			if(!dms.contains(m)) {
				externMethods.add(m);
			}
		}
	}
	public void setObjInitCode(String in) {
		this.objInitCode +=in;
	}
	public String getObjInitCode() {
		return this.objInitCode;
	}
	
	/** Return the ClassSymbol associated with superClassName or null if
	 *  superclass is not resolved looking up the enclosing scope chain.
	 */
	public ClassSymbol getSuperClassScope() {
		if ( superClassName!=null ) {
			if ( getEnclosingScope()!=null ) {
				Symbol superClass = getEnclosingScope().resolve(superClassName);
				if ( superClass instanceof ClassSymbol ) {
					return (ClassSymbol)superClass;
				}
			}
		}
		return null;
	}

	/** Multiple superclass or interface implementations and the like... */
	public List<ClassSymbol> getSuperClassScopes() {
		ClassSymbol superClassScope = getSuperClassScope();
		if ( superClassScope!=null ) {
			return Collections.singletonList(superClassScope);
		}
		return null;
	}

	@Override
	public Symbol resolve(String name) {
		Symbol s = resolveMember(name);
		if ( s!=null ) {
			return s;
		}
		// if not a member, check any enclosing scope. it might be a global variable for example
		Scope parent = getEnclosingScope();
		if ( parent != null ) return parent.resolve(name);
		return null; // not found
	}

	/** Look for a member with this name in this scope or any super class.
	 *  Return null if no member found.
	 */
	@Override
	public Symbol resolveMember(String name) {
		Symbol s = symbols.get(name);
		if ( s instanceof MemberSymbol ) {
			return s;
		}
		// walk superclass chain
		List<ClassSymbol> superClassScopes = getSuperClassScopes();
		if ( superClassScopes!=null ) {
			for (ClassSymbol sup : superClassScopes) {
				s = sup.resolveMember(name);
				if ( s instanceof MemberSymbol ) {
					return s;
				}
			}
		}
		return null;
	}

	/** Look for a field with this name in this scope or any super class.
	 *  Return null if no field found.
	 */
	@Override
	public Symbol resolveField(String name) {
		Symbol s = resolveMember(name);
		if ( s instanceof FieldSymbol ) {
			return s;
		}
		return null;
	}

	/** Look for a method with this name in this scope or any super class.
	 *  Return null if no method found.
	 */
	public MethodSymbol resolveMethod(String name) {
		Symbol s = resolveMember(name);
		if ( s instanceof MethodSymbol ) {
			return (MethodSymbol)s;
		}
		return null;
	}
	
	/** Look for a action with this name in this scope or any super class.
	 *  Return null if no method found.
	 */
	public ActionSymbol resolveAction(String name) {
		Symbol s = resolveMember(name);
		if ( s instanceof ActionSymbol ) {
			return (ActionSymbol)s;
		}
		return null;
	}

	public void setSuperClass(String superClassName) {
		this.superClassName = superClassName;
		nextFreeMethodSlot = getNumberOfMethods();
	}

	public String getSuperClassName() {
		return superClassName;
	}

	@Override
	public void setSlotNumber(Symbol sym) {
		if ( sym instanceof MethodSymbol ) {
			MethodSymbol msym = (MethodSymbol)sym;
			// handle inheritance. If not found in this scope, check superclass
			// if any.
			ClassSymbol superClass = getSuperClassScope();
			if ( superClass !=null ) {
				MethodSymbol superMethodSym = superClass.resolveMethod(sym.getName());
				if ( superMethodSym!=null ) {
					msym.slot = superMethodSym.slot;
				}
			}
			if ( msym.slot==-1 ) {
				msym.slot = nextFreeMethodSlot++;
			}
		}
		else if ( sym instanceof ActionSymbol ) {
			ActionSymbol asym = (ActionSymbol)sym;
			// handle inheritance. If not found in this scope, check superclass
			// if any.
			ClassSymbol superClass = getSuperClassScope();
			if ( superClass !=null ) {
				ActionSymbol superActionSym = superClass.resolveAction(sym.getName());
				if ( superActionSym!=null ) {
					asym.slot = superActionSym.slot;
				}
			}
			if ( asym.slot==-1 ) {
				asym.slot = nextFreeActionSlot++;
			}
		}
		
		{
			super.setSlotNumber(sym);
		}
	}

	/** Return the set of all methods defined within this class */
	public Set<MethodSymbol> getDefinedMethods() {
		Set<MethodSymbol> methods = new LinkedHashSet<>();
		for (MemberSymbol s : getSymbols()) {
			if ( s instanceof MethodSymbol ) {
				methods.add((MethodSymbol)s);
			}
		}
		return methods;
	}

	/** Return the set of all methods either inherited or not */
	public Set<MethodSymbol> getMethods() {
		Set<MethodSymbol> methods = new LinkedHashSet<>();
		ClassSymbol superClassScope = getSuperClassScope();
		if ( superClassScope!=null) {
			methods.addAll(superClassScope.getMethods());
		}
		methods.removeAll(getDefinedMethods()); // override method from superclass
		methods.addAll( getDefinedMethods() );
		return methods;
	}
	
	/** Return the set of all actions defined within this class */
	public Set<ActionSymbol> getDefinedActions() {
		Set<ActionSymbol> actions = new LinkedHashSet<>();
		for (MemberSymbol s : getSymbols()) {
			if ( s instanceof ActionSymbol ) {
				actions.add((ActionSymbol)s);
			}
		}
		return actions;
	}

	/** Return the set of all actions either inherited or not */
	public Set<ActionSymbol> getActions() {
		Set<ActionSymbol> actions = new LinkedHashSet<>();
		ClassSymbol superClassScope = getSuperClassScope();
		if ( superClassScope!=null) {
			actions.addAll(superClassScope.getActions());
		}
		actions.removeAll(getDefinedActions()); // override action from superclass
		actions.addAll( getDefinedActions() );
		return actions;
	}

	@Override
	public List<? extends FieldSymbol> getFields() {
		List<FieldSymbol> fields = new ArrayList<>();
		ClassSymbol superClassScope = getSuperClassScope();
		if ( superClassScope!=null ) {
			fields.addAll( superClassScope.getFields() );
		}
		fields.addAll( getDefinedFields() );
		return fields;
	}
	
	public int getFieldIndex(String s) {
		List<FieldSymbol> fields = (List<FieldSymbol>) this.getFields();
		int index = 0;
		for (FieldSymbol f:fields) {
			if(f.getName().equals(s)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	/** get the number of methods defined specifically in this class */
	public int getNumberOfDefinedMethods() {
		int n = 0;
		for (MemberSymbol s : getSymbols()) {
			if ( s instanceof MethodSymbol ) {
				n++;
			}
		}
		return n;
	}
	/** get the number of actions defined specifically in this class */
	public int getNumberOfDefinedActions() {
		int n = 0;
		for (MemberSymbol s : getSymbols()) {
			if ( s instanceof ActionSymbol ) {
				n++;
			}
		}
		return n;
	}
	
	/** get the total number of methods visible to this class */
	public int getNumberOfMethods() {
		int n = 0;
		ClassSymbol superClassScope = getSuperClassScope();
		if ( superClassScope!=null ) {
			n += superClassScope.getNumberOfMethods();
		}
		n += getNumberOfDefinedMethods();
		return n;
	}
	/** get the total number of actions visible to this class */
	public int getNumberOfActions() {
		int n = 0;
		ClassSymbol superClassScope = getSuperClassScope();
		if ( superClassScope!=null ) {
			n += superClassScope.getNumberOfActions();
		}
		n += getNumberOfDefinedActions();
		return n;
	}

	public int getNumberOfFields() {
		int n = 0;
		ClassSymbol superClassScope = getSuperClassScope();
		if ( superClassScope!=null ) {
			n += superClassScope.getNumberOfFields();
		}
		n += getNumberOfDefinedFields();
		return n;
	}

	@Override
	public String toString() {
		return name+":"+super.toString();
	}
}
