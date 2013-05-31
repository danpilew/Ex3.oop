package clids.ex4.Exceptions;

public class DuplicateMethodException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateMethodException(String name) {
		super("The method with name " + name + " already exists");
	}

}
