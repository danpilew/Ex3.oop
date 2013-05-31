import java.io.File;
import java.io.IOException;

import clids.ex4.dataTypes.Block;
import clids.ex4.main.Parser;


public class test2 {
	int a = 2;
// Is it Working?
	public test2(boolean a){
		this.a = 2;
		
	}
	public static void main(String[] args){
		File file = new File("C:\\Users\\T7639496\\Desktop\\test.txt");
		Parser pars = null;
		try {
			pars = new Parser(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Block block = pars.findBlock(5);
		String[] a = block.getLines();
		for(String str : a){
			System.out.println(str);
		}
	}
}
