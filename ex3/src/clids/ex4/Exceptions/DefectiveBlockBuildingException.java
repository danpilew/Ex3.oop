package clids.ex4.Exceptions;

public class DefectiveBlockBuildingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DefectiveBlockBuildingException() {
		super("Missing '{' or '} - blocks are not well defined");
	}

}
