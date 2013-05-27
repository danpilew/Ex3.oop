public class Block {
	private int startLine;
	private String[] lines;
	private Block[] blocks;
	
	public Block(int startLine, String[] lines, Block[] blocks) {
		this.startLine = startLine;
		this.lines = lines;
		this.blocks = blocks;
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
