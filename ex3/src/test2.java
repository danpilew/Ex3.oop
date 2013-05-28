import java.io.File;


public class test2 {
// Is it Working?
	public static void main(String[] args){
		File file = new File("C:\\Users\\T7639496\\Desktop\\test.txt");
		Parser pars = new Parser(file);
		Block block = pars.findBlock(5);
		String[] a = block.getLines();
		for(String str : a){
			System.out.println(str);
		}
	}
}
