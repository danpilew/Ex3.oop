
public class Syntax {
	// VARIABELES
	public final String varType = "[int, double, String, boolean, char]";
	public final String varModifiers = "[final]";
	public final String varName = "_?[\\d | \\s]^\\S*+"; // check it  
	public final String intValue = "-?\\d";
	public final String doubleValue = intValue +"(\\(.d+)?)?"; // how to use point ( "." ) as point?
	public final String charValue = "."; // what about spaces?
	public final String StringValue = " \" " + charValue + "*" +  " \" "; //  check IT
	public final String booleanValue = "[true, false]" + "|" +  doubleValue;  // check IT
	public final String any_Value = "["+ intValue + "," + doubleValue + "," + charValue + "," + 
			StringValue + "," + booleanValue + "]";
	public final String Equality = "=";
	
	
	//METHODS
	public final String premitionsOfMethods = "[public]"; // could be expanded
	public final String methodReturn = "[void]"; // could be expanded
	public final String methodName = "\\d\\S*+"; // check it
	public final String openBrackets = "(";
	public final String closeBrackets = ")";
	
	
	//GENERAL
	public final String Nspace = "\\s++"; // Necessary space, TO CHECK ABOUT POSSESIVE
	public final String unNspace = "\\s*+"; // unNecessary space,  TO CHECK ABOUT POSSESIVE
	
	// FINAL
	public final String var_Line = unNspace + (varModifiers) + "?" + Nspace + (varType) + "?" + Nspace + 
			(varName) + unNspace + Equality + "?" + (any_Value + "|" + varName) + "?"; // closes are OK?
			
	public final String method_Line = unNspace + premitionsOfMethods + Nspace + methodReturn +
			Nspace + methodName + unNspace + openBrackets + 
			(varType + Nspace + varName) + "*" + closeBrackets; // check it

	public Syntax() {
		// TODO Auto-generated constructor stub
	}

}
