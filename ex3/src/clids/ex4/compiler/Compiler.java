package clids.ex4.compiler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.charAfterEndException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;
import clids.ex4.dataTypes.VariableType;
import clids.ex4.dataTypes.VariableType.Type;


public class Compiler {

	public Compiler() {
		// TODO Auto-generated constructor stub
	}
	
	public static Variable[] VarDefine(String line ,Variable[] members) 
			throws TypeNotMatchesException, notInitializedVariableException, charAfterEndException {
		Variable [] variables;
		final Pattern Var_PATTERN = Pattern.compile(Syntax.var_Line);
		Matcher VarMatcher = Var_PATTERN.matcher(line);
		if (VarMatcher.matches()){
			// legal length 
			if (VarMatcher.end() < line.length()){ // CHECK CONDITION & EXEPTION
				charAfterEndException e = new charAfterEndException();
				throw e;
			}	
			// is Final
			boolean isFinal = (VarMatcher.group(0) == "final"); // CHECK ABOUT GROUP IF NULL
			// type
			VariableType.Type type = VariableType.valueOf(VarMatcher.group(1));
			// initial the array of Variables -
			// 1 - because must be one variable at group (3) 
			// the other variables are
			int variablesNum = 1+ VarMatcher.group(4).split(",").length;
			variables = new Variable[variablesNum]; // MAYBE USE LINKEDLIST
			variables[0] = initialVar(VarMatcher.group(3), isFinal, type, members); 
			
			
			
		}
				return null;
	}
	private static Variable initialVar(String expression, boolean isFinal, Type type, Variable[] members) throws TypeNotMatchesException {
		String[] arrExpression = expression.split("=");
		boolean hasValue;
		String name = arrExpression[0];
		name.replaceAll(" ","");
		if (name.equals(""))
			return null;
		if (arrExpression.length == 1){
			hasValue = false;
		}
		else if (arrExpression.length==2){
			String value = arrExpression[1];
			if (valueIsOk(value, type, members)){
				hasValue = true;
			}
			else{
				TypeNotMatchesException ex = new TypeNotMatchesException(name, value);
				throw ex;
			}
		}
		else{
			//Exception unknownException;
			//throw unknownException;
			return null;
		}
		
		return new Variable(name, type, isFinal, hasValue);
	}

	private static boolean valueIsOk(String value, Type type, Variable[] members) {
		
		if (isValueFitExpression(value, type))
			return true;
		if (isValueFitMember(value, members, type))
			return true;
		return false;
		}
		
		
		
	

	private static boolean isValueFitMember(String value, Variable[] members, Type type) {
		value.replaceAll(" ", "");
		for (Variable var: members){
			if (var.getName() == value){
				if (var.getType().equals(type))
					return true;
			}
		}
		return false;
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

	public static Method isMethDecleration(String str ,Method[] methods) {
		return null;
	}

}
