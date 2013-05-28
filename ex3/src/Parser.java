import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Exceptions.TypeNotMatchesException;
import Exceptions.notInitializedVariableException;


public class Parser {
	ArrayList<Variable> members = new ArrayList<Variable>();
	ArrayList<Method> methods = new ArrayList<Method>();
	String[] code;
	public Parser(File file) {
		code = getStringFromFile(file);
	}
	
	public void parse(File file){
		
		
		for(int n = 0; n<code.length; n++){
			Variable[] newVars = null;
			Method newMethod = null;
			try {
				newVars = Compiler.isVarDecleration(code[n], (Variable[]) members.toArray(new Variable[members.size()]));
			} catch (TypeNotMatchesException | notInitializedVariableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(newVars != null)
			{
					for(Variable var: newVars){
						members.add(var);
					}
				}
			else{
				newMethod = Compiler.isMethDecleration(code[n],(Method[]) methods.toArray(new Method[methods.size()]));
			}
			if(newMethod == null){}
				//throw Exception
			
			
		}
	}
	
	public Block findBlock(int n){
		int lineNumber = n;
		int blockCounter = 0;
		System.out.println("lineNumber = " + lineNumber);
		String line = code[lineNumber];
		for(int i = 0; i<line.length() ; i++){
			if(line.charAt(i) == Syntax.openBlock.charAt(0)){blockCounter++;}
			if(line.charAt(i) == Syntax.closeBlock.charAt(0)){blockCounter--;}
		}
			
		while(blockCounter != 0 ){
			lineNumber++;
			if(lineNumber == code.length){}
				//Throw Exception
			line = code[lineNumber];
			for(int i = 0; i<line.length() ; i++){
				if(line.charAt(i) == Syntax.openBlock.charAt(0)){blockCounter++;}
				if(line.charAt(i) == Syntax.closeBlock.charAt(0)){blockCounter--;}
			}
		}
		
		String[] blockCode = Arrays.copyOfRange(code, n, lineNumber);
		blockCode[0] = blockCode[0].substring(1);
		return new Block(n, blockCode, null, null);
		
	}
	private static String[] getStringFromFile(File code) {
		String[] ret = null;
		try (BufferedReader br = new BufferedReader(new FileReader(code))) {
			ArrayList<String> codeLines = new ArrayList<String>();
			String line = br.readLine();

			while (line != null) {
				codeLines.add(line);
				line = br.readLine();
			}
			ret = (String[]) codeLines.toArray(new String[codeLines.size()]); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
