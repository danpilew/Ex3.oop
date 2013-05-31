package clids.ex4.main;

import java.io.File;
import java.io.IOException;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.charAfterEndException;
import clids.ex4.Exceptions.notInitializedVariableException;

public class Sjavac {
private static final int IO_FAILIOUR = 2;
private static final String IO_FAILIOUR_MASSAGE = " IO Exception, wrong file destenation";
		 
	public static void main(String[] args)   {
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
		} catch (TypeNotMatchesException |  notInitializedVariableException | charAfterEndException e) {
			
			e.printStackTrace();
		}
	}

}
