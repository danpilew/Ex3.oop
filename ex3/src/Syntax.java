
public class Syntax {
	// VARIABELES
	public final String varType = "[int, double, String, boolean, char]";
	public final String varModifiers = "[final]";
	public final String varName = "_?[\\d^].*"; // check it  
	public final String intValue = "-?\\d";
	public final String doubleValue = intValue +"(\\(.d+)?)?"; // how to use point ( "." ) as point?
	public final String charValue = "."; // what about spaces?
	public final String StringValue = " \" " + charValue + "*" +  " \" "; //  check IT
	public final String booleanValue = "[true, false]" + "|" +  doubleValue;  // check IT
	public final String Equality = "=";
	
	
	//METHODS
	public final String premitionsOfMethods = "[public]"; // could be expanded
	public final String methodReturn = "[void]"; // could be expanded
	
	//GENERAL
	public final String Nspace = "\\s++"; // Necessary space, TO CHECK ABOUT POSSESIVE
	public final String unNspace = "\\s++"; // unNecessary space,  TO CHECK ABOUT POSSESIVE
	
	
	
	
	
			
	

	public Syntax() {
		// TODO Auto-generated constructor stub
	}

}
