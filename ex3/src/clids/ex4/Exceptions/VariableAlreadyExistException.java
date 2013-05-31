package clids.ex4.Exceptions;

//PLETZ - CHECK IT
public class VariableAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public VariableAlreadyExistException() {
		super("Variable Already Exists");
	}

}

