public class Block {
	private int startLine;
	private String[] lines;
	private Block[] blocks;
	private Variable[] variables;
	
	public Block(int startLine, String[] lines, Block[] blocks, Variable[] variables) {
		this.startLine = startLine;
		this.lines = lines;
		this.blocks = blocks;
		this.variables = variables;
	}
	
	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}

	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public String[] getLines() {
		return lines;
	}
	public void setLines(String[] lines) {
		this.lines = lines;
	}
	public Block[] getBlocks() {
		return blocks;
	}
	public void setBlocks(Block[] blocks) {
		this.blocks = blocks;
	}
	
	

}
