
public class Address {

	private String street;
	private String city;
	private String zipCode;
	private String state; 
	
	
	//constructor for address
	Address(String str, String c, String zip, String st){
		
		street = str;
		city = c;
		zipCode = zip;
		state = st; 
	}
	
	
	String getState() {
		
		return state;
	}
	
}
