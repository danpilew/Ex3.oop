import java.util.HashMap;

import clids.ex4.Exceptions.MethodAlreadyExistException;
import clids.ex4.compiler.Compiler;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;


public class TestDefineVarMeth {
	public static void main(String[] args) throws MethodAlreadyExistException {
		String line = "void a (int c, final double b)";
		HashMap<String, Method> hashMap = new HashMap<String, Method>();
		Method meth;
		meth = Compiler.MethDefine(line, hashMap);
		System.out.println(meth.getName());
		Variable var = meth.getVariables()[0];
		System.out.println(var.getName());
		System.out.println(var.getType());
		System.out.println(var.isFinal());
		System.out.println(var.isHasValue());
		Variable var2 = meth.getVariables()[1];
		System.out.println(var2.getName());
		System.out.println(var2.getType());
		System.out.println(var2.isFinal());
		System.out.println(var2.isHasValue());
		
		
		//System.out.println(var.getName());
		//System.out.println(var.getType());
		//System.out.println(var.isFinal());
		//System.out.println(var.isHasValue());
	}

}
