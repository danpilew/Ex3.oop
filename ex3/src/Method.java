import Exceptions.TypeNotMatchesException;
import Exceptions.illigalVariablesNumberException;
import Exceptions.notInitializedVariableException;

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
				throw new TypeNotMatchesException(variables[i].getType()
						.getName(), inputVars[i].getType().getName());
			}
		}
	}
}
