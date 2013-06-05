package clids.ex4.Exceptions;

/**
 * 
 * General super class of all the Compiling t
 */
public class CompilingException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String COMPILING_MASSAGE = "Compiling failiour in line ";

	public CompilingException(int line, String description) {
		super(COMPILING_MASSAGE + Integer.toString(line + 1) + "\n"
				+ "Description : " + description);
	}

}
