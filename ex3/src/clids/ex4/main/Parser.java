package clids.ex4.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.VariableAlreadyExistException;
import clids.ex4.Exceptions.charAfterEndException;
import clids.ex4.Exceptions.illegalExpressionException;
import clids.ex4.Exceptions.invalidActionException;
import clids.ex4.Exceptions.notInitializedVariableException;
import clids.ex4.compiler.Compiler;
import clids.ex4.compiler.Syntax;
import clids.ex4.dataTypes.Block;
import clids.ex4.dataTypes.Method;
import clids.ex4.dataTypes.Variable;

public class Parser {
	HashMap<String, Variable> members = new HashMap<String, Variable>();
	HashMap<String, Method> methods = new HashMap<String, Method>();
	Block superBlock;
	private final boolean inMethod = true;

	public Parser(File file) throws IOException {
		superBlock = new Block(0, getStringFromFile(file), null, members);
	}

	public void parse() throws TypeNotMatchesException,
			notInitializedVariableException, charAfterEndException, VariableAlreadyExistException, invalidActionException, illegalExpressionException {
		String[] code = superBlock.getLines();
		for (int n = 0; n < code.length; n++) {
			if(code[n].charAt(0) == '/' && code[n].charAt(1) == '/'){
				continue;
			}
			boolean isNewVars = Compiler.VarDefine(code[n], superBlock, !inMethod);

			if (!isNewVars) {
				Method newMethod = Compiler.MethDefine(code[n], methods);
				if (newMethod == null) {
					throw new illegalExpressionException();
				}
				// Skips the Method
			//	n = n + newMethod.getCommands().getLines().length - 1;
				// HANDEL THIS
			}

			// ****STEP 2********8
			for (Method method : methods.values()) {
				Block commands = method.getCommands();
				compileBlock(commands);
			}
		}
	}

	public void compileBlock(Block commands) throws TypeNotMatchesException, notInitializedVariableException, charAfterEndException, VariableAlreadyExistException, invalidActionException, illegalExpressionException {
		for(int n =0 ; n<commands.getLines().length ; n++){
			String line = commands.getLines()[n];
			if(line.charAt(0) == '/' && line.charAt(1) == '/'){
				continue;
			}
			if(!Compiler.VarDefine(line, commands , inMethod)){
				//Var changed
				if(!Compiler.methodCall(line, methods, n)){
					Block ifOrWhile = Compiler.blockDefine(line, methods, n);
					if(ifOrWhile == null){
						throw new illegalExpressionException();
					}else{
						compileBlock(ifOrWhile);
						n = n+ifOrWhile.getLines().length;
					}
				}
			}
		}
		
	}

	public Block findBlock(int n) {
		String[] code = superBlock.getLines();
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
		// removes everyThing that is after the '}'
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
