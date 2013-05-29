package clids.ex4.dataTypes;


public class Variable {
	private final String name;
	private final Type type;
	private final boolean isFinal;
	private final boolean hasValue;
	
	
	
	public Variable(String name, Type type, boolean isFinal,
			boolean hasValue) {
		this.name = name;
		this.type = type;
		this.isFinal = isFinal;
		this.hasValue = hasValue;
	}
	
	public String getName() {
		return name;
	}
	public Type getType() {
		return type;
	}
	public boolean isFinal() {
		return isFinal;
	}
	public boolean isHasValue() {
		return hasValue;
	}
	
	
}
