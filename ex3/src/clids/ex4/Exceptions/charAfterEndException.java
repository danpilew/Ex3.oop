package clids.ex4.Exceptions;

// PLETZ - CHECK IT
public class charAfterEndException extends CompilingException {

	private static final long serialVersionUID = 1L;

	public charAfterEndException(int line) {
		super(line, "chars after the line ends");
	}

}
