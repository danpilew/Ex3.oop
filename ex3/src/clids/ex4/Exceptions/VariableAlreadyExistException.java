package clids.ex4.Exceptions;

public class VariableAlreadyExistException extends CompilingException {

	private static final long serialVersionUID = 1L;

	public VariableAlreadyExistException(int line) {
		super(line, "Variable Already Exists");
	}

}
