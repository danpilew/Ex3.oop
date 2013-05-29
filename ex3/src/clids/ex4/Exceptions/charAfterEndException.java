package clids.ex4.Exceptions;
// PLETZ - CHECK IT
public class charAfterEndException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public charAfterEndException() {
		super("chars after the line end");
	}

}
