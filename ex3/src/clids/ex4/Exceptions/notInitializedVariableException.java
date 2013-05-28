package clids.ex4.Exceptions;

public class notInitializedVariableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public notInitializedVariableException(String var) {
		super("The var " + var + "have not been initialized");
	}

}
