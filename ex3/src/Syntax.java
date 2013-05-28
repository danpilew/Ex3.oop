
public class Syntax {
	//GENERAL
	public static final String Nspace = "\\s++"; // Necessary space, TO CHECK ABOUT POSSESIVE
	public static final String unNspace = "\\s*+"; // unNecessary space,  TO CHECK ABOUT POSSESIVE
	public static final String openBrackets = "(";
	public static final String closeBrackets = ")";
	public static final String openBlock = "{";
	public static final String closeBlock = "}";
	public static final String endLine = ";";
	
	// VARIABELES
	public static final String varType = "[int, double, String, boolean, char]";
	public static final String varModifiers = "[final]";
	public static final String varName = "_?[\\d | \\s]^\\S*+"; // check it  
	public static final String intValue = "-?\\d";
	public static final String doubleValue = intValue +"(\\(.d+)?)?"; // how to use point ( "." ) as point?
	public static final String charValue = "."; // what about spaces?
	public static final String StringValue = " \" " + charValue + "*" +  " \" "; //  check IT
	public static final String booleanValue = "[true, false]" + "|" +  doubleValue;  // check IT
	public static final String any_Value = "["+ intValue + "," + doubleValue + "," + charValue + "," + 
			StringValue + "," + booleanValue + "]";
	public static final String Equality = "=";
	
	//METHODS
	public static final String premitionsOfMethods = "[public]"; // could be expanded
	public static final String methodReturn = "[void]"; // could be expanded
	public static final String methodName = "\\d\\S*+"; // check it
	public static final String Return = "return";
	
	//IF, WHILE BLOCKS
	public static final String IF = "if";
	public static final String WHILE = "while";
	public static final String AndOR = "&&" +"|"+ "||";
	public static final String condition = +unNspace + openBrackets + (booleanValue + "|" + varName) +
			(AndOR + unNspace +   ); // booleanValue included double
	
	
	
	// FINAL
	public static final String var_Line = unNspace + (varModifiers) + "?" + Nspace + (varType) + "?" + Nspace + 
			(varName) + unNspace + Equality + "?" + (any_Value + "|" + varName) + "?" + endLine; // closes are OK?
			
	public static final String method_Defined_Line = unNspace + premitionsOfMethods + Nspace + methodReturn +
			Nspace + methodName + unNspace + openBrackets + 
			(varType + Nspace + varName) + "?" + unNspace + 
			(","+ unNspace +varType + Nspace + varName+unNspace) + "*"
			+ closeBrackets; // check it
	
	public static final String method_call_Line = unNspace + methodName + unNspace + openBrackets + 
			varName + "?" + unNspace + (","+ unNspace + varName + unNspace) + "*" + 
			closeBrackets + endLine;
	

	public Syntax() {
		// TODO Auto-generated constructor stub
	}

}
