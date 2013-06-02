package clids.ex4.Exceptions;

public class InnvalidMethodException extends Exception {

	private static final long serialVersionUID = 1L;

	public InnvalidMethodException(String name) {
		super("The method " + name + " is undefined");
	}

	
}
