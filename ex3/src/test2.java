import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.Exceptions.DuplicateMethodException;
import clids.ex4.Exceptions.InnvalidMethodException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.compiler.Syntax;
import clids.ex4.dataTypes.Block;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;
import clids.ex4.main.Parser;


public class test2 {
	int a = 2;
// Is it Working?
	public test2(boolean a){
		this.a = 2;
		
	}
	public static void main(String[] args){
		File file = new File("C:\\Users\\T7639496\\Desktop\\test.txt");
		Parser pars = null;
		try {
			pars = new Parser(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Block block = pars.findBlock(5);
		String[] a = block.getLines();
		for(String str : a){
			System.out.println(str);
		}
	}
	
	public static boolean methodCall(String line,Block block,
			HashMap<String, Method> methods, int n) throws InnvalidMethodException, notInitializedVariableException {
		Pattern metCall = Pattern.compile(Syntax.method_call_Line);
		Matcher valueMatcher = metCall.matcher(line);
		if(valueMatcher.matches()){
			
			String newMethName = valueMatcher.group(1);
			if(methods.get(newMethName) == null)
				throw new InnvalidMethodException(newMethName);
			Method method = methods.get(newMethName);
			String varsName = valueMatcher.group(2);
			varsName = varsName.replace(Syntax.unS, "");
			String[] varsNames = varsName.split(",");
			for(int i = 0; i < varsName.length() ; i++){
				Variable var = block.getVar(varsNames[i]);
				if(var == null || !var.isHasValue())
					throw new notInitializedVariableException(varsNames[i]);
				if(var.getType().equals(method.getVariables()[i].getType())){
					
				}
			}
		}
		return false;
	}
	
	
}
