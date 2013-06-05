package clids.ex4.Exceptions;

public class invalidActionException extends CompilingException {

	private static final long serialVersionUID = 1L;

	public invalidActionException(int line) {
		super(line, "the action is legal only inside method");
	}

}
