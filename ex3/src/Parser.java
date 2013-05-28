import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {
	ArrayList<Variable> members = new ArrayList<Variable>();
	ArrayList<Method> methods = new ArrayList<Method>();
	String[] code;
	public Parser(File file) {
		String[] code = getStringFromFile(file);
	}
	
	public void parse(File file){
		
		
		for(int n = 0; n<code.length; n++){
			
		}
	}
	
	private static String[] getStringFromFile(File code) {
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
			e.printStackTrace();
		}
		return ret;
	}

}
