package Exceptions;

public class TypeNotMatchesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TypeNotMatchesException(String var1, String var2) {
		super("The types of" + var1 +"and" +var2 + "not matches");
	}

}
