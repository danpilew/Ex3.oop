package clids.ex4.dataTypes;


public class VariableType {
	
	public enum Type{
		 INT, DOUBLE, STRING, BOOLEAN, CHAR
	}
	
	private Type type;
	
	public static Type(String str){
		
	}
	
	public static String getName(Type type){
			switch (type) {
			case INT:
			case DOUBLE:
			case CHAR:
			case BOOLEAN:
				return type.name().toLowerCase();
			case STRING:
				return "String";
			default:
				return "";
			}
			// if Sting
		}		
	}