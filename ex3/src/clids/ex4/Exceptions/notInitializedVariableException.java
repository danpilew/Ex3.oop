package clids.ex4.Exceptions;

public class notInitializedVariableException extends CompilingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public notInitializedVariableException(String var, int line) {
		super(line, "The var " + var + " has not been initialized");
	}

}
