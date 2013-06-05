package clids.ex4.Exceptions;

public class MethodAlreadyExistException extends CompilingException {
	private static final long serialVersionUID = 1L;

	public MethodAlreadyExistException(int line) {
		super(line, "method Already Exists");
	}
}