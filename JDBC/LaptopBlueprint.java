package JDBC;

import java.sql.SQLException;
/*
 * In this program we have created laptopmanagement for managing laptops 
 *for easy access and control
 *We have added some attributes like brandname,modelnumber,price,storage,colour,edition
 */
public class LaptopBlueprint {
	/*
	 * We have set attributes as Private for accessing within the same class or body 
	 *For most restricted access
	 */	 

	private String brandName;
	private int laptop_id;
	private int price;
	private String storage;
	private String colour;
	private String edition;
	private static String userName = "Room2";
	private static String passWord = "Welcome";
	
	/* Encapsulation using getter and setter method
	 * Getter method to get the values
	 * Setter method to put the values
	 */

	public String getBrandName() {    //getter method to get the values
		return brandName;
	}
	public void setBrandname(String brandName) {   //setter method to put the values
		this.brandName=brandName;
	}
	public int laptop_id() {
		return laptop_id;
	}
	public void laptop_id(int laptop_id) {
		this.laptop_id=laptop_id;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage=storage;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour=colour;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition=edition;
	}
	// tologin method is used for logging in
	
	public static void tologin(String username, String password)throws SQLException, Exception {
		
		if(userName.equals(username) && passWord.equals(password)){
			DriverClass.toAccessConnection();
		}
		else {
			System.out.println("check your credentials");
		}
		
	}
	public static void tologout() {
		System.out.println("Logged out Successfully");
	}
}
	
	
	
	


