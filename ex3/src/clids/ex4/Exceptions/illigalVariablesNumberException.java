package clids.ex4.Exceptions;

public class illigalVariablesNumberException extends CompilingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public illigalVariablesNumberException(int line) {
		super(line, "Illigal number of variables");
	}
}
