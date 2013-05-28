package clids.ex4.compiler;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;


public class Compiler {

	public Compiler() {
		// TODO Auto-generated constructor stub
	}
	
	public static Variable[] VarDefine(String str ,Variable[] members) 
			throws TypeNotMatchesException, notInitializedVariableException {
		static final Pattern Var_PATTERN = Pattern.compile(S);
		return null;
	}
	public static Method isMethDecleration(String str ,Method[] methods) {
		return null;
	}

}
