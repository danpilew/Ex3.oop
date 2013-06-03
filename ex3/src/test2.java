import java.beans.MethodDescriptor;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.DuplicateMethodException;
import clids.ex4.Exceptions.InnvalidMethodException;
import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.illigalVariablesNumberException;
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
		
		HashMap<String, Variable> vars = new HashMap<String, Variable>();
		Variable var = new Variable("a",Type.INT,false,true);
		vars.put("a", var);
		Block block = new Block(0, null, null, vars );
		Variable[] methVars = new Variable[0];
		Method fooMeth = new Method(methVars, "foo");
		HashMap<String, Method> meths = new HashMap<String, Method>();
		meths.put("foo", fooMeth);
		String line = "foo() ;";
		System.out.println(Syntax.StringValue);
		System.out.println(Syntax.method_call_Line);
		/*
		System.out.println(Syntax.method_call_Line);
		HashMap<String, Variable> vars = new HashMap<String, Variable>();
		Variable var = new Variable("a",Type.BOOLEAN,false,false);
		vars.put("a", var);
		Block block = new Block(0, null, null, vars );
		String line = "if(a&&not)";
		try {
			System.out.println(isBlockDefine(line, block, 0));
		} catch (notInitializedVariableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TypeNotMatchesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	
	

}
