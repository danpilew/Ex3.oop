package clids.ex4.Exceptions;

public class MethodAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public MethodAlreadyExistException() {
		super("method Already Exists");
	}
}