
public class VariableType {
	public enum Type {INT, DOUBLE, STRING, BOOLEAN, CHAR}; 
	
	public String getName(Type type){
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