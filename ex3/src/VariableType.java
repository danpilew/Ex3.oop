import java.lang.reflect.Type;


public class VariableType {
	
	private Type type;
	
	public VariableType(String str){
		type = Enum<Type>.valueOf(Type, str);
	}
	
	public String getName(){
			return type.toString().toUpperCase();
			// if Sting
		}		
	}