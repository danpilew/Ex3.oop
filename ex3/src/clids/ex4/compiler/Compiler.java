package clids.ex4.compiler;
import java.lang.Package;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.charAfterEndException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Type;
import clids.ex4.dataTypes.Variable;
import clids.ex4.dataTypes.VariableType;


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
				Exception e = new charAfterEndException();
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
			variables = new Variable[variablesNum];
			
			
			
		}
				return null;
	}
	public static Method isMethDecleration(String str ,Method[] methods) {
		return null;
	}

}
