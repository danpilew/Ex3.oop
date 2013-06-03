package clids.ex4.Exceptions;

public class VariableAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public VariableAlreadyExistException() {
		super("Variable Already Exists");
	}

}

