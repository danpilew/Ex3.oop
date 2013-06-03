import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.compiler.Syntax;
import clids.ex4.dataTypes.VariableType;
import clids.ex4.dataTypes.VariableType.Type;



public class TestIsValueFitExpressison {
	
	public static void main(String[] args){
		String value = "5";
		VariableType.Type type = VariableType.Type.CHAR;
		System.out.println(isValueFitExpression(value, type));
	}
	
	
	
	private static boolean isValueFitExpression(String value, Type type) {
		String valueType = null;
		switch (type) {
		case INT: valueType = Syntax.intValue;
		break;
		case DOUBLE: valueType = Syntax.doubleValue;
		break;
		case CHAR: valueType = Syntax.charValue;
		break;
		case BOOLEAN: valueType = Syntax.booleanValue;
		break;
		case STRING: valueType = Syntax.StringValue;
		break;
		default:
		}
		Pattern valType = Pattern.compile(valueType);
		Matcher valueMatcher = valType.matcher(value);
		if (valueMatcher.matches())
			return true;
		else
			return false;
	}
	
	

}
