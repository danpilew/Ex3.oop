package clids.ex4.compiler;

public class Syntax {
	//GENERAL
	public static final String NS = "\\s++"; // Necessary space
	public static final String unS = "\\s*+"; // unNecessary space
	public static final String oBr = "("; // openBrackets
	public static final String cBr = ")"; //closeBrackets
	public static final String openBlock = "{"; //openBlock
	public static final String closeBlock = "}"; //closeBlock
	public static final String endLine = ";";
	
	// VARIABELES
	public static final String varType = "(int|double|String|boolean|char)";
	public static final String varModifiers = "final";
	public static final String varName = "_?[a-zA-Z]\\w*+";
	public static final String intValue = "-?\\d+";
	public static final String doubleValue = intValue +"(\\.\\d)?\\d*+"; // how to use point ( "." ) as point?
	public static final String charValue = ".";
	public static final String StringValue = " \" " + charValue + "*" + " \" ";
	public static final String booleanValue = "[true, false]" + "|" +  doubleValue;  // check IT
	public static final String any_Value = "("+ intValue + "|" + doubleValue + "|" + charValue + "|" + 
			StringValue + "|" + booleanValue + ")";
	public static final String Equality = "=";
	
	//METHODS
	public static final String premitionsOfMethods = "public"; // could be expanded
	public static final String methodReturn = "void"; // could be expanded
	public static final String methodName = "\\d\\w*+"; //
	public static final String Return = "return"; 
	
	//IF, WHILE BLOCKS
	public static final String IfWhile = "(if|while)";
	public static final String AndOR = "(&&|\\|\\|)";
	public static final String legalInCondition = booleanValue + "|" + varName;
	public static final String condition = unS + oBr + unS + legalInCondition +
		(unS + AndOR + unS + legalInCondition) + unS + closeBlock; // booleanValue included double
	
	
	
	// FINAL
	public static final String var_Line = unS +  varModifiers + "?" + NS + (varType) + "?" + NS + 
			(varName) + unS + Equality + "?" + (any_Value + "|" + varName) + "?" + endLine + unS; // closes are OK?
			
	public static final String method_Defined_Line = unS + premitionsOfMethods + NS + methodReturn +
			NS + methodName + unS + oBr + 
			(varType + NS + varName) + "?" + unS + 
			(","+ unS +varType + NS + varName+unS) + "*"
			+ cBr + unS; // check it - could be final
	
	public static final String method_call_Line = unS + methodName + unS + oBr + 
			varName + "?" + unS + (","+ unS + varName + unS) + "*" + 
			cBr + endLine + unS;
	
	public static final String IfWhile_Line = IfWhile + unS + condition + unS; 
	

	public Syntax() {
		// TODO Auto-generated constructor stub
	}

}
