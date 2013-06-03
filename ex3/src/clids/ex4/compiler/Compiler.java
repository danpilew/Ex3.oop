package clids.ex4.compiler;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.InnvalidMethodException;
import clids.ex4.Exceptions.MethodAlreadyExistException;
import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.VariableAlreadyExistException;
import clids.ex4.Exceptions.charAfterEndException;
import clids.ex4.Exceptions.illegalExpressionException;
import clids.ex4.Exceptions.illigalVariablesNumberException;
import clids.ex4.Exceptions.invalidActionException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.dataTypes.Block;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;
import clids.ex4.dataTypes.VariableType;
import clids.ex4.dataTypes.VariableType.Type;


public class Compiler {
	
	
	
	// VARIABLE DEFINE
	public static boolean VarDefine(String line ,Block currentBlock, boolean inMethod) 
			throws TypeNotMatchesException, notInitializedVariableException, charAfterEndException, VariableAlreadyExistException, invalidActionException, illegalExpressionException {
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
			boolean isFinal = (!(VarMatcher.group(1)==null));
			String firstVar = VarMatcher.group(3).replaceAll(Syntax.unS, "");
			// type
			if (VarMatcher.group(2)== null){
				if (inMethod){
					actionInMethod(firstVar, currentBlock);
					return true;
				}
				else {
					invalidActionException e = new invalidActionException();
					throw e;
				}
			}
			VariableType.Type type = VariableType.valueOf(VarMatcher.group(2).replaceAll(Syntax.unS, ""));
			// initial the array of Variables -
			// 1 - because must be one variable at group (3) 
			// the other variables are
			initialVar(firstVar, isFinal, type, localVars, currentBlock); 
			String extraVarsEsp =  VarMatcher.group(4).replaceAll(Syntax.unS, "");
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
	private static void actionInMethod(String expression, Block currentBlock) throws illegalExpressionException, notInitializedVariableException, TypeNotMatchesException {
		String[] arrExpression = expression.split("=");
		if(arrExpression.length!=2){
			illegalExpressionException e = new illegalExpressionException();
			throw e;
		}
		else{
			notInitializedVariableException e = new notInitializedVariableException(arrExpression[0]);
			Variable var = currentBlock.getVar(arrExpression[0]);
			if (var == null){
				throw e;
			}
			if (var.isFinal()){
				throw e;
			}
			String value = arrExpression[1];
			if (valueIsOk(value, var.getType(),  currentBlock)){
				var.setHasValue(true);
				currentBlock.update(var);
			}
			else{
				TypeNotMatchesException ex = new TypeNotMatchesException(var.getName(), value);
				throw ex;
			}
					}
	}

	// Auxiliary method of VarDefine
	private static void initialVar(String expression, boolean isFinal, Type type, HashMap<String, Variable> localVars, Block currentBlock) throws TypeNotMatchesException, VariableAlreadyExistException, notInitializedVariableException {
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
			if (valueIsOk(value, type, currentBlock)){
				hasValue = true;
			}
			else{
				TypeNotMatchesException e = new TypeNotMatchesException(name, value);
				throw e;
			}
		}
		else{
			return;
		}
		if (isFinal && !hasValue){
			notInitializedVariableException e = new notInitializedVariableException(name);
			throw e;
		}
		localVars.put(name, new Variable(name, type, isFinal, hasValue)); 
	}
	// Auxiliary method of initialVar
	private static boolean valueIsOk(String value, Type type, Block currentBlock) {
		
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
	public static boolean isValueFitExpression(String value, Type type) {
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
	
	public static boolean isEmptyLine(String line){
		Pattern emptyLine = Pattern.compile(Syntax.unS);
		Matcher emptyLineMatcher = emptyLine.matcher(line);
		return emptyLineMatcher.matches();
	}
	public static boolean isCommentLine(String line){
		Pattern commentLine = Pattern.compile(Syntax.commentLine);
		Matcher commentLineMatcher = commentLine.matcher(line);
		return commentLineMatcher.matches();
	}
	public static boolean isReturnLine(String line){
		Pattern commentLine = Pattern.compile(Syntax.returnLine);
		Matcher commentLineMatcher = commentLine.matcher(line);
		return commentLineMatcher.matches();
	}


	// METHOD DEFINE
	public static Method MethDefine(String line, HashMap<String, Method> methods) throws MethodAlreadyExistException {
		// create Pattern & Matcher
		final Pattern METHOD_DEFINE_PATTERN = Pattern.compile(Syntax.method_Defined_Line);
		Matcher METHMatcher = METHOD_DEFINE_PATTERN.matcher(line);
		
		if (!METHMatcher.matches())
			return null;
		
		else{
			String methName = METHMatcher.group(1).replaceAll(Syntax.unS, "");
			if (methods.get(methName)!=null){
				MethodAlreadyExistException e = new MethodAlreadyExistException();
				throw e;
			}
			if (METHMatcher.group(2) == null){
				return new Method(null, methName);
			}
			else{
			String[] Variables = METHMatcher.group(2).split(",");
			// Variables[i] is look like : type name
			Variable[] VarsInMeth = new Variable[Variables.length];
			
			for (int i = 0; i<VarsInMeth.length; i++){
				Variable var = defineVarForMethod(Variables[i]);
				VarsInMeth[i] = var;
			}	
			return new Method(VarsInMeth, methName);
			}
		}
	}
	
	
	 private static Variable defineVarForMethod(String typePLUSvar) {
		// create Pattern & Matcher
			final Pattern varInMeth_PATTERN = Pattern.compile(Syntax.typeAndVar);
			Matcher varInMethMatcher = varInMeth_PATTERN.matcher(typePLUSvar);
			if(varInMethMatcher.matches()){
				boolean isFinal = (!(varInMethMatcher.group(1)==null));
				String name = varInMethMatcher.group(3).replaceAll(Syntax.unS, "");
				VariableType.Type type = VariableType.valueOf(varInMethMatcher.group(2).replaceAll(Syntax.unS, ""));
				boolean hasValue = true;
				Variable newVar = new Variable(name, type, isFinal, hasValue);
				return newVar;
			}
			else{
				return null;
			}
	}
	
	 
	 
	 
	 
	 public static boolean isBlockDefine(String line,
				Block currentBlock, int n) throws notInitializedVariableException, TypeNotMatchesException {
			Pattern ifOrWhile = Pattern.compile(Syntax.IfWhile_Line);
			Matcher ifOrWhileMatcher = ifOrWhile.matcher(line);
			if(ifOrWhileMatcher.matches()){
				String condition = ifOrWhileMatcher.group(2);
				for(int i = 0; i<2 && condition != null; i++){
					if(!Compiler.isValueFitExpression(condition,Type.BOOLEAN)){
						Variable var = currentBlock.getVar(condition);
						if(var == null || !var.isHasValue()){
							throw new notInitializedVariableException(condition);
						}
						if(var.getType() != Type.BOOLEAN){
							throw new TypeNotMatchesException(condition, "if or while condition");
						}
					}
					condition = ifOrWhileMatcher.group(5);
				}
				return true;
			}
			return false;
		}
	 
	 public static boolean methodCall(String line,Block block,
				HashMap<String, Method> methods) throws InnvalidMethodException, notInitializedVariableException, TypeNotMatchesException, illigalVariablesNumberException {
			Pattern metCall = Pattern.compile(Syntax.method_call_Line);
			Matcher valueMatcher = metCall.matcher(line);
			if(valueMatcher.matches()){
				
				String newMethName = valueMatcher.group(1);
				if(methods.get(newMethName) == null)
					throw new InnvalidMethodException(newMethName);
				Method method = methods.get(newMethName);
				String varsline = valueMatcher.group(2);
				if(varsline == null){
					if(method.getVariables().length == 0)
						return true;
					throw new illigalVariablesNumberException();
				}
				varsline = varsline.replace(Syntax.unS, "");
				String[] varsNames = varsline.split(",");
				if(varsNames.length != method.getVariables().length)
					throw new illigalVariablesNumberException();
				for(int i = 0; i < varsNames.length; i++){
					
					if(!Compiler.isValueFitExpression(varsNames[i], method.getVariables()[i].getType())){
						Variable var = block.getVar(varsNames[i]);
						if(var == null || !var.isHasValue()){
							throw new notInitializedVariableException(varsNames[i]);
						}
						if(!var.getType().equals(method.getVariables()[i].getType())){
							throw new TypeNotMatchesException(var.getName(), method.getVariables()[i].getName());
						}
					}
				}
				return true;
			}
			return false;
		}
		

}
