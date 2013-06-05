package clids.ex4.dataTypes;

import java.util.HashMap;

public class Method {
	private final Variable[] variables;
	private final String name;
	private Block commands;

	public Method(Variable[] variables, String name) {
		this.variables = variables;
		this.name = name;
		commands = null;
	}

	public void setBlock(Block block) {
		if (commands == null)
			commands = block;
	}

	public HashMap<String, Variable> getVariableMap() {
		if (variables == null)
			return null;
		HashMap<String, Variable> returnedMap = new HashMap<String, Variable>();
		for (Variable var : variables) {
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
}
