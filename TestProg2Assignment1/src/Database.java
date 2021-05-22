import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Database {

	ArrayList <Product> list; 
	Product pd; 
	boolean found;
	int index;
	
	
	Database(){

		list = new ArrayList<Product> ();
		
		}
	
	//adds the product object to the list database 
	void add(Product P){
        list.add(P);
    }
	
	//deletes the created product object from the list database
	 Product delete(int i) {
		return list.remove(i); 
	}
	

	//search method that returns an index to use for delete and add methods
	void search(String P) { //search method with parameter of the product name
		 found = false; 
		int i =0;
		while(!found && i < list.size()) {
			Product p = list.get(i); // another instance of product class
			
			if(p.getProdName().equalsIgnoreCase(P)) {
				pd = p;
				found = true;
				index = i; 
				
			} else {
				i++;
			}
		}
		
	}
	
	
	
	//
	  ArrayList<Product> getList() {
		 return list;
	 }
	  
	 public int showIndex() {
		 return index;
	 }
	 
	 boolean inList() {
		 return found; 
	 }

	public int size() {
		return list.size();
	}
	
	Product getProduct(){
		return pd;
	}

	

	
	
}
