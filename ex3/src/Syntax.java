
public class Syntax {
	String varType = "[int, double, String, boolean, char]";
	String premitionsOfMethods = "[public]"; // could be expanded
	String methodReturn = "[void]"; // could be expanded
	String Nspace = "\\s++"; // Necessary space, TO CHECK ABOUT POSSESIVE
	String unNspace = "\\s++"; // unNecessary space,  TO CHECK ABOUT POSSESIVE
	String intValue = "-?\\d";
	String doubleValue = intValue +"(\\.d*)?"; // how to use point ( "." ) as point?
	String charValue = ".";
	String StringValue = " \" " + charValue + "*" +  " \" "; //  check IT
	String booleanValue = "[true, false]" + "|" +  doubleValue;  // check IT
	
	
	
			
	

	public Syntax() {
		// TODO Auto-generated constructor stub
	}

}
