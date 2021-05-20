import javax.swing.JOptionPane;

public class Product {

	private String productName; 
	private int productQuantity;
	private double productPrice;
	String date; 
	Manufacturer manu; 
//changed date object to string 
	
	//main constructor class for product
	Product(String name, int quantity, double price, String d, Manufacturer m){
		productName = name;
		productQuantity = quantity; 
		productPrice = price; 
		date = d;
		manu = m;
		
	}
	//mutator to change price and quantity 
	
	public void updatePrice(double newPrice) {
		
		productPrice = newPrice;
		
	}
	public void updateQuantity(int newQuanity) {
		
		productQuantity = newQuanity;
		
	}
	

	
	
	
	// make the accessors for the testReport 
	String getProdName() {
		return productName;
	}
	double getQuantity() {
		return productQuantity; 
	}
	
	double getUnitPrice() {
		
		return productPrice;
	}
	String getDate() {
		
		return date; 
	}
	Manufacturer getManu() {
		return manu; 
	}


	
}
