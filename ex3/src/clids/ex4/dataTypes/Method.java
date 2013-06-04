package clids.ex4.dataTypes;
import java.util.HashMap;

import clids.ex4.Exceptions.TypeNotMatchesException;
import clids.ex4.Exceptions.illigalVariablesNumberException;
import clids.ex4.Exceptions.notInitializedVariableException;

public class Method {
	private final Variable[] variables;
	private final String name;
	private Block commands;

	public Method(Variable[] variables, String name) {
		this.variables = variables;
		this.name = name;
		commands = null;
	}
	public void setBlock(Block block){
		if(commands == null)
			commands = block;
	}
	public HashMap<String, Variable> getVariableMap(){
		if(variables == null)
			return null;
		HashMap<String, Variable> returnedMap = new HashMap<String, Variable>();
		for(Variable var : variables){
			returnedMap.put(var.getName(), var);
		}
		return returnedMap;
	}
	public Block getCommands() {
		return commands;
	}

	public Variable[] getVariables() {
		return variables;
	}

	public String getName() {
		return name;
	}

	public void call(Variable[] inputVars) throws TypeNotMatchesException,
			illigalVariablesNumberException, notInitializedVariableException {
		if (variables.length != inputVars.length)
			throw new illigalVariablesNumberException();

		for (Variable var : inputVars) {
			if (var.isHasValue())
				throw new notInitializedVariableException(var.getName());
		}
		for (int i = 0; i < variables.length; i++) {
			if (variables[i].getType() != inputVars[i].getType()) {
				throw new TypeNotMatchesException(VariableType.getName(variables[i].getType()) 
						, VariableType.getName(inputVars[i].getType())); // CHECK IT, RETURN NAME OF TYPE, NOT OF VAR
			}
		}
	}
}
