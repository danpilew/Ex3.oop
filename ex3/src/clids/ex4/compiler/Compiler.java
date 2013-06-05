package clids.ex4.compiler;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.CompilingException;
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
	static int lineNum;

	// VARIABLE DEFINE
	public static boolean VarDefine(String line, Block currentBlock,
			boolean inMethod, int n) throws CompilingException {
		// get Variables
		lineNum = n;
		HashMap<String, Variable> localVariables = currentBlock.getVariables();
		// create Pattern & Matcher
		final Pattern Var_PATTERN = Pattern.compile(Syntax.var_Line);
		Matcher VarMatcher = Var_PATTERN.matcher(line);
		// check match
		if (VarMatcher.matches()) {
			System.out.println("was HERE  " + line);
			// legal length
			if (VarMatcher.end() < line.length()) { 
				charAfterEndException e = new charAfterEndException(lineNum);
				throw e;
			}
			// is Final
			boolean isFinal = (!(VarMatcher.group(1) == null));
			String firstVar = VarMatcher.group(3).replaceAll(Syntax.unS, "");
			// type
			if (VarMatcher.group(2) == null) {
				if (inMethod) {
					actionInMethod(firstVar, currentBlock);
					return true;
				} else {
					invalidActionException e = new invalidActionException(
							lineNum);
					throw e;
				}
			}
			VariableType.Type type = VariableType.valueOf(VarMatcher.group(2)
					.replaceAll(Syntax.unS, ""));
			Variable newVar = initialVar(firstVar, isFinal, localVariables,
					type, currentBlock);
			localVariables.put(newVar.getName(), newVar);
			String extraVarsEsp = VarMatcher.group(4)
					.replaceAll(Syntax.unS, "");
			String[] extraVars = extraVarsEsp.split(",");
			for (String varDef : extraVars) {
				newVar = initialVar(varDef, isFinal, localVariables, type,
						currentBlock);
				if (newVar != null) {
					localVariables.put(newVar.getName(), newVar);
				}
			}
			currentBlock.putVariables(localVariables);
			return true;
		} else {
			return false;
		}
	}
	// Auxiliary method of VarDefine
	private static void actionInMethod(String expression, Block currentBlock)
			throws CompilingException {
		String[] arrExpression = expression.split("=");
		if (arrExpression.length != 2) {
			illegalExpressionException e = new illegalExpressionException(
					lineNum);
			throw e;
		} else {
			notInitializedVariableException e = new notInitializedVariableException(
					arrExpression[0], lineNum);
			Variable var = currentBlock.getVar(arrExpression[0]);
			if (var == null) {
				throw e;
			}
			if (var.isFinal()) {
				throw e;
			}
			String value = arrExpression[1];
			if (valueIsOk(value, var.getType(), currentBlock)) {
				var.setHasValue(true);
				currentBlock.update(var);
			} else {
				TypeNotMatchesException ex = new TypeNotMatchesException(
						var.getName(), value, lineNum);
				throw ex;
			}
		}
	}

	// Auxiliary method of VarDefine
	private static Variable initialVar(String expression, boolean isFinal,
			HashMap<String, Variable> localVariables, Type type,
			Block currentBlock) throws CompilingException {
		String[] arrExpression = expression.split("=");
		boolean hasValue = false;
		String name = arrExpression[0];
		if (name.equals("")) {
			return null;
		}
		if (localVariables.get(name) != null) {
			VariableAlreadyExistException e = new VariableAlreadyExistException(
					lineNum);
			throw e;
		}

		if (arrExpression.length == 1) {
			hasValue = false;
		} else if (arrExpression.length == 2) {
			String value = arrExpression[1];
			if (valueIsOk(value, type, currentBlock)) {
				hasValue = true;
			} else {
				TypeNotMatchesException e = new TypeNotMatchesException(name,
						value, lineNum);
				throw e;
			}
		}
		if (isFinal && !hasValue) {
			notInitializedVariableException e = new notInitializedVariableException(
					name, lineNum);
			throw e;
		}
		return new Variable(name, type, isFinal, hasValue);
	}

	// Auxiliary method of initialVar
	private static boolean valueIsOk(String value, Type type, Block currentBlock) {

		if (isValueFitExpression(value, type))
			return true;
		if (isValueFitVar(value, type, currentBlock))
			return true;
		return false;
	}

	// Auxiliary method of valueIsOk
	private static boolean isValueFitVar(String name, Type type,
			Block currentBlock) {
		Variable varCalledName = currentBlock.getVar(name);
		if (varCalledName != null) {
			if (varCalledName.getType() == type && varCalledName.isHasValue()) {
				return true;
			}
		}
		return false;
	}

	// Auxiliary method of valueIsOk
	public static boolean isValueFitExpression(String value, Type type) {
		String valueType = null;
		switch (type) {
		case INT:
			valueType = Syntax.intValue;
			break;
		case DOUBLE:
			valueType = Syntax.doubleValue;
			break;
		case CHAR:
			valueType = Syntax.charValue;
			break;
		case BOOLEAN:
			valueType = Syntax.booleanValue;
			break;
		case STRING:
			valueType = Syntax.StringValue;
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

	public static boolean isEmptyLine(String line) {
		Pattern emptyLine = Pattern.compile(Syntax.unS);
		Matcher emptyLineMatcher = emptyLine.matcher(line);
		return emptyLineMatcher.matches();
	}

	public static boolean isCommentLine(String line) {
		Pattern commentLine = Pattern.compile(Syntax.commentLine);
		Matcher commentLineMatcher = commentLine.matcher(line);
		return commentLineMatcher.matches();
	}

	public static boolean isReturnLine(String line) {
		Pattern commentLine = Pattern.compile(Syntax.returnLine);
		Matcher commentLineMatcher = commentLine.matcher(line);
		return commentLineMatcher.matches();
	}

	// METHOD DEFINE
	public static Method MethDefine(String line,
			HashMap<String, Method> methods, int n) throws CompilingException {
		// create Pattern & Matcher
		lineNum = n;
		final Pattern METHOD_DEFINE_PATTERN = Pattern
				.compile(Syntax.method_Defined_Line);
		Matcher METHMatcher = METHOD_DEFINE_PATTERN.matcher(line);

		if (!METHMatcher.matches())
			return null;

		else {
			String methName = METHMatcher.group(1).replaceAll(Syntax.unS, "");
			if (methods.get(methName) != null) {
				MethodAlreadyExistException e = new MethodAlreadyExistException(
						lineNum);
				throw e;
			}
			if (METHMatcher.group(2) == null) {
				return new Method(null, methName);
			} else {
				String[] Variables = METHMatcher.group(2).split(",");
				// Variables[i] is look like : type name
				Variable[] VarsInMeth = new Variable[Variables.length];

				for (int i = 0; i < VarsInMeth.length; i++) {
					Variable var = defineVarForMethod(Variables[i]);
					// Check if there are two Variables with the same name.
					for (int j = i - 1; j >= 0; j--) {
						if (var.getName().equals(VarsInMeth[j].getName()))
							throw new VariableAlreadyExistException(lineNum);
					}
					VarsInMeth[i] = var;
				}
				return new Method(VarsInMeth, methName);
			}
		}
	}
	// Auxiliary method of MethDefine
	private static Variable defineVarForMethod(String typePLUSvar) {
		// create Pattern & Matcher
		final Pattern varInMeth_PATTERN = Pattern.compile(Syntax.typeAndVar);
		Matcher varInMethMatcher = varInMeth_PATTERN.matcher(typePLUSvar);
		if (varInMethMatcher.matches()) {
			boolean isFinal = (!(varInMethMatcher.group(1) == null));
			String name = varInMethMatcher.group(3).replaceAll(Syntax.unS, "");
			VariableType.Type type = VariableType.valueOf(varInMethMatcher
					.group(2).replaceAll(Syntax.unS, ""));
			boolean hasValue = true;
			Variable newVar = new Variable(name, type, isFinal, hasValue);
			return newVar;
		} else {
			return null;
		}
	}

	public static boolean isBlockDefine(String line, Block currentBlock, int n)
			throws CompilingException {
		lineNum = n;
		Pattern ifOrWhile = Pattern.compile(Syntax.IfWhile_Line);
		Matcher ifOrWhileMatcher = ifOrWhile.matcher(line);
		if (ifOrWhileMatcher.matches()) {
			System.out.println("line" + line); // REMOVE
			String conditionLine = ifOrWhileMatcher.group(2);
			conditionLine = conditionLine.replaceAll(Syntax.unS, "");
			String[] conditions = conditionLine.split(Syntax.AndOR);
			for (String condition : conditions) {
				System.out.println("condition" + condition);
				if (!Compiler.isValueFitExpression(condition, Type.BOOLEAN)) {
					Variable var = currentBlock.getVar(condition);
					if (var == null || !var.isHasValue()) {
						throw new notInitializedVariableException(condition,
								lineNum);
					}
					if (var.getType() != Type.BOOLEAN
							&& var.getType() != Type.INT
							&& var.getType() != Type.DOUBLE) {
						throw new TypeNotMatchesException(condition,
								"if or while condition", lineNum);
					}
				}
			}
			return true;
		}
		return false;
	}

	public static boolean methodCall(String line, Block block,
			HashMap<String, Method> methods, int n) throws CompilingException {
		lineNum = n;
		Pattern metCall = Pattern.compile(Syntax.method_call_Line);
		Matcher valueMatcher = metCall.matcher(line);
		if (valueMatcher.matches()) {

			String newMethName = valueMatcher.group(1);
			if (methods.get(newMethName) == null)
				throw new InnvalidMethodException(newMethName, lineNum);
			Method method = methods.get(newMethName);
			String varsline = valueMatcher.group(2);
			if (varsline == null || Compiler.isEmptyLine(varsline)) {
				if (method.getVariables() == null
						|| method.getVariables().length == 0)
					return true;
				throw new illigalVariablesNumberException(lineNum);
			}
			varsline = varsline.replace(Syntax.unS, "");
			String[] varsNames = varsline.split(",");
			if (varsNames.length != method.getVariables().length)
				throw new illigalVariablesNumberException(lineNum);
			for (int i = 0; i < varsNames.length; i++) {

				if (!Compiler.isValueFitExpression(varsNames[i],
						method.getVariables()[i].getType())) {
					Variable var = block.getVar(varsNames[i]);
					if (var == null || !var.isHasValue()) {
						throw new notInitializedVariableException(varsNames[i],
								lineNum);
					}
					if (!var.getType().equals(
							method.getVariables()[i].getType())) {
						throw new TypeNotMatchesException(var.getName(),
								method.getVariables()[i].getName(), lineNum);
					}
				}
			}
			return true;
		}
		return false;
	}

}
