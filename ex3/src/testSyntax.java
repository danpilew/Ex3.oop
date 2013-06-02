import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clids.ex4.compiler.Syntax;


public class testSyntax {
	public static void main(String[] args){
		String line = "void aaa(int a)";
		//String line = "int a = 1, b = 2;";
		Pattern Var_PATTERN = Pattern.compile(Syntax.method_Defined_Line);
		//System.out.println(Var_PATTERN.toString());
		Matcher VarMatcher = Var_PATTERN.matcher(line);
		System.out.println(VarMatcher.matches());
		
		//for (int i =0; i<= 4; i++)
		//System.out.println(i +"  " +VarMatcher.group(i));
	}
}
