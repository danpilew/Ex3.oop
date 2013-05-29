package clids.ex4.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.compiler.Compiler;
import clids.ex4.compiler.Syntax;
import clids.ex4.dataTypes.Block;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;


public class Parser {
	ArrayList<Variable> members = new ArrayList<Variable>();
	ArrayList<Method> methods = new ArrayList<Method>();
	String[] code;

	public Parser(File file) throws IOException {
		code = getStringFromFile(file);
	}

	public void parse() throws TypeNotMatchesException, notInitializedVariableException {

		for (int n = 0; n < code.length; n++) {
			Variable[] newVars = null;
			Method newMethod = null;
			
				newVars = Compiler.VarDefine(code[n],
						(Variable[]) members.toArray(new Variable[members
								.size()]));
			if (newVars != null) {
				for (Variable var : newVars) {
					members.add(var);
				}
			} else {
				newMethod = Compiler.isMethDecleration(code[n],
						(Method[]) methods.toArray(new Method[methods.size()]));
			}
			if (newMethod == null) {
			}
			// throw Exception
			newMethod.setBlock(findBlock(n));
			methods.add(newMethod);
			//Skips the Method
			n = n +newMethod.getCommands().getLines().length-1;
		}
		
		// ****STEP 2********8
		for(Method method : methods){
			
		}
	}

	public void compileBlock(Block block){
		
		
	}
	public Block findBlock(int n) {
		int lineNumber = n;
		int blockCounter = 0;
		System.out.println("lineNumber = " + lineNumber);
		String line = code[lineNumber];
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == Syntax.openBlock.charAt(0)) {
				blockCounter++;
			}
			if (line.charAt(i) == Syntax.closeBlock.charAt(0)) {
				blockCounter--;
			}
		}

		while (blockCounter != 0) {
			lineNumber++;
			if (lineNumber == code.length) {
			}
			// Throw Exception
			line = code[lineNumber];
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == Syntax.openBlock.charAt(0)) {
					blockCounter++;
				}
				if (line.charAt(i) == Syntax.closeBlock.charAt(0)) {
					blockCounter--;
				}
			}
		}
		// Creates the block as a subArray
		String[] blockCode = Arrays.copyOfRange(code, n, lineNumber + 1);
		// Removes everything that is before the '{'
		blockCode[0] = blockCode[0].substring(blockCode[0]
				.indexOf(Syntax.openBlock.charAt(0)) + 1);
		//removes everyThing that is after the '}'
		blockCode[blockCode.length - 1] = blockCode[blockCode.length - 1]
				.substring(0, blockCode.length - 1);
		return new Block(n, blockCode, null, null);

	}

	private static String[] getStringFromFile(File code) throws IOException {
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
			throw e;
		}
		return ret;
	}

}
