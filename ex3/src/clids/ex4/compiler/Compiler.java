package clids.ex4.compiler;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.VariableAlreadyExistException;
import clids.ex4.Exceptions.charAfterEndException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.dataTypes.Block;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;
import clids.ex4.dataTypes.VariableType;
import clids.ex4.dataTypes.VariableType.Type;


public class Compiler {
	
	//public static boolean VarPutValue (String line, Block currentBlock){
		//HashMap<String, Variable> localVars = currentBlock.getVariables();
		
	//}
	
	public static boolean VarDefine(String line ,Block currentBlock) 
			throws TypeNotMatchesException, notInitializedVariableException, charAfterEndException, VariableAlreadyExistException {
		// get Vars
		HashMap<String, Variable> localVars = currentBlock.getVariables();
		// create Pattern & Matcher
		final Pattern Var_PATTERN = Pattern.compile(Syntax.var_Line);
		Matcher VarMatcher = Var_PATTERN.matcher(line);
		// check match
		if (VarMatcher.matches()){
			// legal length 
			if (VarMatcher.end() < line.length()){ // CHECK CONDITION & EXEPTION
				charAfterEndException e = new charAfterEndException();
				throw e;
			}	
			// is Final
		//	for  (int i =0; i<= 4; i++)   // REMOVE
			//		System.out.println(i +"  " +VarMatcher.group(i));
			boolean isFinal = (VarMatcher.group(1).replaceAll(Syntax.unS, "").equals("final"));
			// type
			VariableType.Type type = VariableType.valueOf(VarMatcher.group(2));
			// initial the array of Variables -
			// 1 - because must be one variable at group (3) 
			// the other variables are
			String firstVar = VarMatcher.group(3).replaceAll(Syntax.unS, "");
		//	System.out.println(firstVar); //REMOVE
			initialVar(firstVar, isFinal, type, localVars, currentBlock); 
			String extraVarsEsp =  VarMatcher.group(4).replaceAll(Syntax.unS, "");
			//int variablesNum = VarMatcher.group(4).split(",").length; // +1 (first var) -1 (null before first ,))
			String[] extraVars =  extraVarsEsp.split(",");
			for (String varDef: extraVars){
				initialVar(varDef, isFinal, type, localVars, currentBlock);
			}
			return true;
		}
		else{
				return false;
		}
	}
	// Auxiliary method of VarDefine
	private static void initialVar(String expression, boolean isFinal, Type type, HashMap<String, Variable> localVars, Block currentBlock) throws TypeNotMatchesException, VariableAlreadyExistException {
		String[] arrExpression = expression.split("=");
	//	System.out.println("arrExpression"); // REMOVE
		//for (String exp: arrExpression) // REMOVE
			//System.out.println(exp);
		boolean hasValue;
		String name = arrExpression[0];
		if (name.equals("")){
			return;
		}
		if (localVars.get(name) != null){
			VariableAlreadyExistException e = new VariableAlreadyExistException();
			throw e;
		}
			
		if (arrExpression.length == 1){
			hasValue = false;
		}
		else if (arrExpression.length==2){
			String value = arrExpression[1];
			if (valueIsOk(value, type, localVars, currentBlock)){
				hasValue = true;
			}
			else{
				TypeNotMatchesException e = new TypeNotMatchesException(name, value);
				throw e;
			}
		}
		else{
			System.out.println("split by = > 2 - WTF?!");
			return;
		}
		
		localVars.put(name, new Variable(name, type, isFinal, hasValue)); 
	}
	// Auxiliary method of initialVar
	private static boolean valueIsOk(String value, Type type, HashMap<String, Variable> localVars, Block currentBlock) {
		
		if (isValueFitExpression(value, type))
			return true;
		if (isValueFitVar(value,  type, currentBlock))
			return true;
		return false;
		}
		
		
		
	
	// Auxiliary method of valueIsOk
	private static boolean isValueFitVar(String name, Type type, Block currentBlock) {
		Variable varCalledName = currentBlock.getVar(name);
		if (varCalledName != null){
			if (varCalledName.getType() == type && varCalledName.isHasValue()){
				return true;
			}
		}
		return false;
	}
	// Auxiliary method of valueIsOk
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
	


	public static boolean MethDefine(String string,
			HashMap<String, Method> methods, int n) {
		// TODO Auto-generated method stub
		return false;
	}
	public static Block blockDefine(String line,
			HashMap<String, Method> methods, int n) {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean methodCall(String line,
			HashMap<String, Method> methods, int n) {
		Pattern metCall = Pattern.compile(Syntax.method_call_Line);
		
		// TODO Auto-generated method stub
		return false;
	}

}
