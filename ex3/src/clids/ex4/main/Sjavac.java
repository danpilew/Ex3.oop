package clids.ex4.main;

import java.io.File;
import java.io.IOException;

import clids.ex4.Exceptions.DefectiveBlockBuildingException;
import clids.ex4.Exceptions.InnvalidMethodException;
import clids.ex4.Exceptions.MethodAlreadyExistException;
import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.VariableAlreadyExistException;
import clids.ex4.Exceptions.charAfterEndException;
import clids.ex4.Exceptions.illegalExpressionException;
import clids.ex4.Exceptions.illigalVariablesNumberException;
import clids.ex4.Exceptions.invalidActionException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.compiler.Syntax;

public class Sjavac {
private static final int IO_FAILIOUR = 2;
private static final int COMPILATION_FAILIOUR = 1;
private static final int COMPILED = 0;
private static final String IO_FAILIOUR_MASSAGE = " IO Exception, wrong file destenation";
		 
	public static void main(String[] args){
		Parser parser = null;
		try {
			parser = new Parser(new File(args[0]));
		} catch (IOException e) {
			
			System.out.println(IO_FAILIOUR_MASSAGE);
			System.exit(IO_FAILIOUR);
		}
		try {
			//
			parser.parse();
			
		} catch (TypeNotMatchesException |  notInitializedVariableException | charAfterEndException | VariableAlreadyExistException | invalidActionException | illegalExpressionException | MethodAlreadyExistException | InnvalidMethodException | illigalVariablesNumberException | DefectiveBlockBuildingException e) {
			System.out.println(Syntax.method_call_Line);
			e.printStackTrace();
			System.exit(COMPILATION_FAILIOUR);
		}
		System.out.println(Syntax.var_Line);

		System.out.println("Yes");
		System.exit(COMPILED);
	}

}
