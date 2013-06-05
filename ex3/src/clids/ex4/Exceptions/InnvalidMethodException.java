package clids.ex4.Exceptions;

public class InnvalidMethodException extends CompilingException {

	private static final long serialVersionUID = 1L;

	public InnvalidMethodException(String name, int line) {
		super(line, "The method " + name + " is undefined");
	}

}
