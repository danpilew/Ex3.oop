
public class Syntax {
	// VARIABELES
	String varType = "[int, double, String, boolean, char]";
	String varModifiers = "[final]";
	String varName = "_?[\\d^].*"; // check it  
	String intValue = "-?\\d";
	String doubleValue = intValue +"(\\.d*)?"; // how to use point ( "." ) as point?
	String charValue = "."; // what about spaces?
	String StringValue = " \" " + charValue + "*" +  " \" "; //  check IT
	String booleanValue = "[true, false]" + "|" +  doubleValue;  // check IT
	String Equality = "=";
	
	
	//METHODS
	String premitionsOfMethods = "[public]"; // could be expanded
	String methodReturn = "[void]"; // could be expanded
	
	//GENERAL
	String Nspace = "\\s++"; // Necessary space, TO CHECK ABOUT POSSESIVE
	String unNspace = "\\s++"; // unNecessary space,  TO CHECK ABOUT POSSESIVE
	
	
	
	
	
			
	

	public Syntax() {
		// TODO Auto-generated constructor stub
	}

}
