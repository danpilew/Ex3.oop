package clids.ex4.Exceptions;

public class DuplicateMethodException extends CompilingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateMethodException(int line, String name) {
		super(line, "The method with name " + name + " already exists");
	}

}
