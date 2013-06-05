package clids.ex4.Exceptions;

public class TypeNotMatchesException extends CompilingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TypeNotMatchesException(String var1, String var2, int line) {
		super(line, "The types of " + var1 + " and " + var2 + " not matches");
	}

}
