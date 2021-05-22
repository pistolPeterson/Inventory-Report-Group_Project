import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestReport {

	public static void main(String[] args) {
	

        Database db = new Database(); // creates database
        Database close = new Database();// creates db for inactive accounts
       
        
        Address testAddress = new Address("123","Miami","33181","FL");
        Manufacturer testManu = new Manufacturer("Nike", testAddress); 
        Product test = new Product("ChipsTest", 12, 12, "12/12/2000", testManu);
        db.add(test);

        boolean done = false;

        while (!done) {

            int firstOption = GetData.getInt("\tABC Enterprises Inventory Manager\n" 
                    + "\nPlease choose from the following:" + "\n1. Locate a Single Product"+ 
                    "\n2.Create an inventory report" + "\n3. List all deleted products" 
                    + " \n4. Update Product information" + "\n5.Add a Product" + "\n6.Delete a Product \n7.Exit");

            switch(firstOption)
            {
            case 1: 
                //Locates a single product from the DB
            	String pdNameSearch = GetData.getWord("Enter the product name: "); 
            	db.search(pdNameSearch);
            	
            	if(!db.inList()) {
            		JOptionPane.showMessageDialog(null, "Product not found.");
            	} else {
            		
            		Product searchedProduct = db.getProduct();
            		String s = "Name\tPrice\tQuantity\n";
            		s = s + searchedProduct.getProdName() + "\t" + searchedProduct.getUnitPrice() + "\t"  + searchedProduct.getQuantity();
            		display(s, "Product", 0);
            		
            	}
            	
            	
            
            	
            	
            	
                break;
            case 2: 
                //Creates an inventory report

            	
            	
            	ArrayList list = db.getList();
             if(list.isEmpty()) {
            	 JOptionPane.showMessageDialog(null, "List is empty");}
            	 else {
            	
            	 int i = 0;
            	int length = db.size();
            	 String s = "Product:\tPurchase Date\tQuantity\tPrice\tManufacturer\tState\n";
            	
            	 
            	 
            	 while(i < length)
            	 {
            	 Product p = (Product)list.get(i);
            	 s = s + p.getProdName() + "\t" + p.getDate()+ "\t" + p.getQuantity()+ "\t" + p.getUnitPrice() + "\t" + p.getManu().getManuName() + "\t" + p.getManu().getManuAddress().getState() + "\n";
            	 i++;
            	 }
            	 display(s, "Active Products",0);
            	}
            	 break;
            	
                
            case 3: 
                // shows all deleted products
            	ArrayList deletelist = close.getList();
				if(deletelist.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty");
				}else
				{
					int i= 0;
					int length = db.size();
					String s = "Product:\tPurchase Date\tManufacturer\tState\n";
					while(i<length)
					{
						Product p = (Product)deletelist.get(i);
						
						s = s + p.getProdName() + "\t" + p.getDate()  + "\t"   + p.getManu().getManuName()+ "\t" + p.getManu().getManuAddress().getZip() + "\n";
						i++;
					}
					display(s,"Deleted Products",0);
				}
				break;
            	
            	
            	
            	
            
            case 4: 
                // updates product information
            	String searchProdName = GetData.getWord("Enter name of product you'd like to update");
            	
            	db.search(searchProdName); // search for the name in the database
            	
            	if(!db.inList()) {
            		JOptionPane.showMessageDialog(null,"Product name not found");
            	}else {
            		int option = GetData.getInt("Would you like to (type 1) Change the price, (type 2) Change the quantity");
            		
            		switch(option) {
            		case 1: //change product price 
            			double newPrice = GetData.getDouble("Enter new price of product"); 
            			Product updatedProdPriceObj = db.getProduct(); // make a new wProduct object to update the price
            			updatedProdPriceObj.updatePrice(newPrice);
            			
            			break;
            			
            		case 2: 
            			// change quantity 
            			int newProdAmount = GetData.getInt("Enter the new amount");
            			Product updatedProdQuanObj = db.getProduct();// make a new Product object to update the quantity
            			updatedProdQuanObj.updateQuantity(newProdAmount);
            			break; 
            			
            			default: //error message 
            				JOptionPane.showMessageDialog(null, "Invalid option");
            		}
            	}
            	
            	
                break;
            case 5:
                // add a product
            	String addedProdName = GetData.getWord("What is the name of the product?");
            	
            	Double productPrice = GetData.getDouble("What is the product price?");
            	int productAmount = GetData.getInt("How many products is there? "); 
            	
            	String productDate = GetData.getWord("Please enter the date of the product added? (dd/MM/yyyy)");
            	
            	//address of the manufacturer 
            	String manuAddrStr =  GetData.getWord("Please enter the street");
            	String manuAddrCity =  GetData.getWord("Please enter the city");
            	
            	String manuAddrZip =  GetData.getWord("Please enter the zip code");
            	String manuAddrState =  GetData.getWord("Please enter the state");
            	
            	
            	Address newAddress = new Address(manuAddrStr,manuAddrCity,manuAddrZip,manuAddrState); 
            	String manufacturerName = GetData.getWord("Please enter the name of the manufacturer?");
            	Manufacturer newManu = new Manufacturer(manufacturerName,newAddress ); 
            	   // java.util.Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
            	   // System.out.println(sDate1+"\t"+date1);  
            	
            	//product object created!
            	Product newProduct = new Product(addedProdName, productAmount, productPrice, productDate, newManu);


            	//add product to arraylist in database
            	db.add(newProduct);
            
                break;
            case 6:
                //Delete a product
            
            	String deleteProdName = GetData.getWord("Enter name of product you wish to delete?");
            	db.search(deleteProdName);
            	
            	if(!db.inList()) {
            		JOptionPane.showMessageDialog(null, "Product not found");
            		
            	} else {
            		Product delProd = db.getProduct();
            		int index = db.showIndex();
            	
            		close.add(db.delete(index));
            		JOptionPane.showMessageDialog(null, "The product " + delProd.getProdName() + " has been deleted!");
            	}

                break;
            case 7: 
                // Exit
                done = true;
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter a Valid Option");
            }




        }


		
		
	}
	
	//display method that displays the inventory reports 
    static void display(String s, String heading, int MESSAGE_TYPE ) {
	JTextArea text = new JTextArea(s, 25, 40);
	JScrollPane pane = new JScrollPane(text);
 JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
	
}
	

}
