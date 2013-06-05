package clids.ex4.Exceptions;

public class DefectiveBlockBuildingException extends CompilingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DefectiveBlockBuildingException(int line) {
		super(line, "Missing '{' or '} - blocks are not well defined");
	}

}
