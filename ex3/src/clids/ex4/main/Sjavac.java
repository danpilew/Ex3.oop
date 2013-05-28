package clids.ex4.main;

import java.io.File;

public class Sjavac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parser parser = new Parser(new File(args[0]));
	}

}
