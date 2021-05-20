
public class Manufacturer {
	private String manuName;
	Address addr; 
	
	//constructor for manufacturer
	
	Manufacturer(String name, Address a){
		manuName = name; 
		addr = a; 
	}
	String getManuName() {
		
		return manuName; 
	}
	
	Address getManuAddress() {
		
		return addr;
	}
	
}
