
public class VariableType {
	
	private Type type;
	
	public VariableType(String str){
		type = new Varia str.toUpperCase();
	}
	
	public String getName(){
		switch (type) {
		case INT: 
		case DOUBLE: 
		case STRING: 
		case BOOLEAN:
		case CHAR: return (type.name().toLowerCase());
		default:
			return "";
			// exeption
		}	
		
	
		
		
	}
	
}