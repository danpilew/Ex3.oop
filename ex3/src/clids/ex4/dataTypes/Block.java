package clids.ex4.dataTypes;


import java.util.HashMap;

public class Block {
	private final int startLine;
	private final String[] lines;
	private  final Block fatherBlock;
	private HashMap<String,Variable> variables;
	
	public Block(int startLine, String[] lines, Block fatherBlock, HashMap<String,Variable> variables) {
		this.startLine = startLine;
		this.lines = lines;
		this.fatherBlock = fatherBlock;
		this.variables = new HashMap<String, Variable>(variables);
	}
	
	public HashMap<String,Variable> getVariables() {
		return variables;
	}

	public void setVariables(HashMap<String, Variable> variables) {
		this.variables = variables;
	}

	public int getStartLine() {
		return startLine;
	}
	
	public Block getFatherBlock() {
		return fatherBlock;
	}

	public String[] getLines() {
		return lines;
	}
	
	public Variable getVar(String varName){
		Variable ret = null;
		Block curBlock = this;
		ret = curBlock.getVariables().get(varName);
		while(ret==null && curBlock.getFatherBlock() != null){
			curBlock = curBlock.getFatherBlock();
			ret = curBlock.getVariables().get(varName);
		}
		return ret;
	}

	public void update(String name) {
		// TODO Auto-generated method stub
		
	}


	

}
