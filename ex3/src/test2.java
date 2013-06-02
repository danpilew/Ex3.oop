import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.DuplicateMethodException;
import clids.ex4.Exceptions.InnvalidMethodException;
import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.compiler.Syntax;
import clids.ex4.compiler.Compiler;
import clids.ex4.dataTypes.Block;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;
import clids.ex4.dataTypes.VariableType.Type;
import clids.ex4.main.Parser;


public class test2 {
	int a = 2;
// Is it Working?
	public test2(boolean a){
		this.a = 2;
		
	}
	public static void main(String[] args){
		/*
		HashMap<String, Variable> vars = new HashMap<String, Variable>();
		Variable var = new Variable("a",Type.INT,false,true);
		vars.put("a", var);
		Block block = new Block(0, null, null, vars );
		Variable[] methVars = new Variable[1];
		methVars[0] = new Variable("b", Type.INT, true, true);
		Method fooMeth = new Method(methVars, "foo");
		HashMap<String, Method> meths = new HashMap<String, Method>();
		meths.put("foo", fooMeth);
		String line = "foo(a);";
		try {
			System.out.println(methodCall(line, block, meths, 0));
		} catch (InnvalidMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (notInitializedVariableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TypeNotMatchesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		HashMap<String, Variable> vars = new HashMap<String, Variable>();
		Variable var = new Variable("a",Type.INT,false,true);
		vars.put("a", var);
		Block block = new Block(0, null, null, vars );
	}
	public static boolean isBlockDefine(String line,
			Block currentBlock, int n) throws notInitializedVariableException, TypeNotMatchesException {
		Pattern ifOrWhile = Pattern.compile(Syntax.condition);
		Matcher ifOrWhileMatcher = ifOrWhile.matcher(line);
		if(ifOrWhileMatcher.matches()){
			String condition = ifOrWhileMatcher.group(1);
			for(int i = 0; i<2 || condition == null; i++){
				if(!Compiler.isValueFitExpression(condition,Type.BOOLEAN)){
					Variable var = currentBlock.getVar(condition);
					if(var == null || var.isHasValue()){
						throw new notInitializedVariableException(condition);
					}
					if(var.getType() != Type.BOOLEAN){
						throw new TypeNotMatchesException(condition, "if or while condition");
					}
				}
				condition = ifOrWhileMatcher.group(3);
			}
			return true;
		}
		return false;
	}
	
	public static boolean methodCall(String line,Block block,
			HashMap<String, Method> methods, int n) throws InnvalidMethodException, notInitializedVariableException, TypeNotMatchesException {
		Pattern metCall = Pattern.compile(Syntax.method_call_Line);
		Matcher valueMatcher = metCall.matcher(line);
		if(valueMatcher.matches()){
			
			String newMethName = valueMatcher.group(1);
			if(methods.get(newMethName) == null)
				throw new InnvalidMethodException(newMethName);
			Method method = methods.get(newMethName);
			String varsline = valueMatcher.group(2);
			varsline = varsline.replace(Syntax.unS, "");
			String[] varsNames = varsline.split(",");
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
