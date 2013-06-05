package clids.ex4.compiler;

public class Syntax {
	// GENERAL
	public static final String NS = "\\s++"; // Necessary space
	public static final String unS = "\\s*+"; // unNecessary space
	public static final String oBr = "("; // openBrackets
	public static final String cBr = ")"; // closeBrackets
	public static final String openBlock = "\\{"; // openBlock
	public static final String closeBlock = "\\}"; // closeBlock
	public static final String endLine = ";";
	public static final String commentLine = "//.*";
	public static final String returnLine = unS + "return" + unS + endLine;

	// VARIABELES
	public static final String varType = "(int|double|String|boolean|char)";
	public static final String varModifiers = "final";
	public static final String varName = "_?[a-zA-Z]\\w*";
	public static final String intValue = unS + "-?\\d+" + unS;
	public static final String doubleValue = unS + intValue
			+ "(?:(?:\\.\\d)\\d*)?" + unS;
	public static final String charValue = unS + "'" + "." + "'" + unS;
	public static final String StringValue = unS + "\".*\"" + unS;
	public static final String booleanValue = unS + "true|false" + "|"
			+ doubleValue + unS; // check IT
	public static final String any_Value = "(?:" + intValue + "|" + doubleValue
			+ "|" + charValue + "|" + StringValue + "|" + booleanValue + ")";
	public static final String Equality = "=";
	public static final String initialWay = varName
			+ unS
			+ (oBr + "?:" + unS + Equality + unS
					+ (oBr + "?:" + any_Value + "|" + varName + cBr) + cBr)
			+ "?" + unS; // check if () are OK

	// METHODS
	public static final String methodReturn = "void"; // could be expanded
	public static final String methodName = "([a-zA-Z]\\w*)"; //
	public static final String Return = "return";
	public static final String typeAndVar = unS + "(" + varModifiers + NS + ")"
			+ "?" + unS + "(?:" + varType + ")" + unS + "(" + varName + ")"
			+ unS;

	// IF, WHILE BLOCKS
	public static final String IfWhile = "(if|while)";
	public static final String AndOR = "(&&|\\|\\|)";
	public static final String legalInCondition = booleanValue + "|" + varName;
	public static final String condition = unS + "\\(" + unS + "(" + "(?:"
			+ legalInCondition + ")" + "("
			+ (unS + AndOR + unS + "(?:" + legalInCondition + ")") + ")" + "*"
			+ ")" + unS + "\\)" + unS; // booleanValue included double

	// FINAL
	public static final String var_Line = unS
			+ (oBr + varModifiers + NS + cBr)
			+ "?"
			+ "(?:"
			+ varType
			+ NS
			+ ")"
			+ "?"
			+ (oBr + unS + initialWay + unS + cBr)
			+ unS
			+ (oBr + (oBr + ":?" + unS + "," + unS + initialWay + cBr) + "*" + cBr)
			+ unS + endLine + unS;

	// public static final String var_putValue = unS + //

	public static final String method_Defined_Line = unS + methodReturn + NS
			+ methodName + unS + "\\(" + "(" + unS + "(?:" + "(?:"
			+ varModifiers + NS + ")" + "?" + varType + NS + varName + unS
			+ ")" + "(?:" + unS + "," + unS + "(?:" + varModifiers + NS + ")"
			+ "?" + varType + NS + varName + unS + ")" + "*" + ")" + "?"
			+ "\\)" + unS + openBlock + unS;

	

	public static final String method_call_Line = unS + methodName + unS
			+ "\\(" + unS + "(" + "(?:" +varName + "|" + any_Value+ ")" + unS + "(?:" + "," + unS
			+ "(?:" + varName + "|" + any_Value + ")" + unS + ")" + "*" + ")"
			+ "?" + "\\)" + unS + endLine + unS;
	
	public static final String IfWhile_Line = IfWhile + unS + condition + unS
			+ openBlock;

	public Syntax() {
		// TODO Auto-generated constructor stub
	}

}
