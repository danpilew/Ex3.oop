package clids.ex4.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
			notInitializedVariableException, charAfterEndException, VariableAlreadyExistException, invalidActionException, illegalExpressionException, MethodAlreadyExistException, InnvalidMethodException, illigalVariablesNumberException, DefectiveBlockBuildingException {
		String[] code = superBlock.getLines();
		for (int n = 0; n < code.length; n++) {
			if(Compiler.isEmptyLine(code[n]) || Compiler.isCommentLine(code[n])){
				continue;
			}
			boolean isNewVars = Compiler.VarDefine(code[n], superBlock, !inMethod);
			if (!isNewVars) {
				Method newMethod = Compiler.MethDefine(code[n], methods);
				if (newMethod == null) {
					throw new illegalExpressionException();
				}
				Block methodBlock = findBlock(n, superBlock);
				methodBlock.putVariables(newMethod.getVariableMap());
				newMethod.setBlock(methodBlock);
				methods.put(newMethod.getName(), newMethod);
				n = n + newMethod.getCommands().getLines().length-1;
				
			}
		}
		// ****STEP 2********
					for (Method method : methods.values()) {
						if(checkReturnStatement(method)){
							//Throw Exceptions
						}
						Block commands = method.getCommands();
						compileBlock(commands);
					}
	}

	public void compileBlock(Block commands) throws TypeNotMatchesException, notInitializedVariableException, charAfterEndException, VariableAlreadyExistException, invalidActionException, illegalExpressionException, InnvalidMethodException, illigalVariablesNumberException, DefectiveBlockBuildingException {
		for(int n =0 ; n<commands.getLines().length ; n++){
			String line = commands.getLines()[n];
			if(Compiler.isCommentLine(line) || Compiler.isEmptyLine(line) ||Compiler.isReturnLine(line) ){
				continue;
			}
			line = line.trim();
			/*//If therre is a return statement, checks if we are inside a method.
			if(Compiler.isReturnLine(line) && commands.getFatherBlock().equals(superBlock)){
				continue;
			}
			*/
			if(!Compiler.VarDefine(line, commands , inMethod)){
				//Var changed
				if(!Compiler.methodCall(line, commands, methods)){

					boolean ifOrWhile = Compiler.isBlockDefine(line, commands, n + commands.getStartLine());
					if(!ifOrWhile){
						throw new illegalExpressionException();
					}else{
						Block ifOrWhileBlock = findBlock(n + commands.getStartLine(), commands );
						compileBlock(ifOrWhileBlock);
						n = n+ifOrWhileBlock.getLines().length-1;
					}
				}
			}
		}
		
	}

	public Block findBlock(int n, Block fatherBlock) throws DefectiveBlockBuildingException {
		String[] code = superBlock.getLines();
		int lineNumber =  n;
		int blockCounter = 0;
		System.out.println("lineNumber = " + lineNumber);
		String line = code[lineNumber];
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == Syntax.openBlock.charAt(1)) {
				blockCounter++;
			}
			if (line.charAt(i) == Syntax.closeBlock.charAt(1)) {
				blockCounter--;
			}
		}

		while (blockCounter != 0) {
			lineNumber++;
			if (lineNumber == code.length) {
				throw new DefectiveBlockBuildingException();
			}
			line = code[lineNumber];
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == Syntax.openBlock.charAt(1)) {
					System.out.println(" Open! " + Syntax.openBlock.charAt(1) + line);
					blockCounter++;
				}else
				if (line.charAt(i) == Syntax.closeBlock.charAt(1)) {
					System.out.println(" Close!" + Syntax.closeBlock.charAt(1));

					blockCounter--;
				}
			}
		}
		// Creates the block as a subArray
		String[] blockCode = Arrays.copyOfRange(code, n , lineNumber + 1);
		// Removes everything that is before the '{'
		blockCode[0] = blockCode[0].substring(blockCode[0]
				.indexOf(Syntax.openBlock.charAt(1)) + 1);
		// removes everyThing that is after the '}'
		blockCode[blockCode.length - 1] = blockCode[blockCode.length - 1]
				.substring(0, blockCode[blockCode.length - 1].lastIndexOf('}'));
		return new Block(n, blockCode, fatherBlock, new HashMap<String, Variable>());

	}
	private boolean checkReturnStatement(Method method){
		String[] commands = method.getCommands().getLines();
		
		for(int i = commands.length-1;i > 0;i--){
			String line = commands[i];
			if(!Compiler.isCommentLine(line) && !Compiler.isEmptyLine(line)){
				if(Compiler.isReturnLine(line)){
					
					return true;
				}
				break;
			}
		}
		return false;
		
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
