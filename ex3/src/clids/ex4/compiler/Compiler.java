package clids.ex4.compiler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;


public class Compiler {

	public Compiler() {
		// TODO Auto-generated constructor stub
	}
	
	public static Variable[] VarDefine(String line ,Variable[] members) 
			throws TypeNotMatchesException, notInitializedVariableException {
		Variable [] variables;
		final Pattern Var_PATTERN = Pattern.compile(Syntax.var_Line);
		Matcher VarMatcher = Var_PATTERN.matcher(line);
		if (VarMatcher.matches()){
			boolean isFinal = (VarMatcher.group(0) == "final"); // CHECK ABOUT GROUP IF NULL
			
		}
		return null;
	}
	public static Method isMethDecleration(String str ,Method[] methods) {
		return null;
	}

}
