package clids.ex4.dataTypes;

public class Variable {
	private final String name;
	private final VariableType.Type type;
	private final boolean isFinal;
	private boolean hasValue;

	/**
	 * @param hasValue
	 *            the hasValue to set
	 */

	public Variable(String name, VariableType.Type type, boolean isFinal,
			boolean hasValue) {
		this.name = name;
		this.type = type;
		this.isFinal = isFinal;
		this.hasValue = hasValue;
	}

	public void setHasValue(boolean hasValue) {
		this.hasValue = hasValue;
	}

	public String getName() {
		return name;
	}

	public VariableType.Type getType() {
		return type;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public boolean isHasValue() {
		return hasValue;
	}

}
