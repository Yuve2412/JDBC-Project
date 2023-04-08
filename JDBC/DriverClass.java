package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DriverClass {
	private static Scanner scan = new Scanner(System.in);
	public static Connection createConnection() {
		Connection connection = null;
		try {
			String userName = "root";  //sql username
			String password = "Yuvedha#24"; // sql password
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Laptop_Management", userName, password);
			Statement stmt = connection.createStatement();
		}
		catch(Exception obj) {
			System.out.println(obj);
		}
		return connection;
	}
	//LaptopDatabaseConnection class object is created to access the non static methods
	public static void toAccessConnection() throws SQLException, Exception{
		Connection databaseConnection = createConnection();
		LaptopDatabaseConnection laptopobj = new LaptopDatabaseConnection();
		Scanner scan = new Scanner(System.in); //get input from user
		//to display menu
		System.out.println("1. Add a Laptop");
		System.out.println("2. Display all Number of laptop");
		System.out.println("3. Search a Modelnumber");
		System.out.println("4. Delete a Soldgoods");
		System.out.println("5. update a Newstock");
		System.out.println("6. Logout");
		
		/*
		 * Local varriable- enterchoice
		 * Do while loop is used to execute the program atleast once
		 */
		byte enterChoice; 
		do{ 
			// switch cases
			enterChoice = scan.nextByte();
			switch(enterChoice) {
			case 1:
				laptopobj.toAddValues(databaseConnection);
				break;
			case 2:
				laptopobj.toDisplayAll(databaseConnection);
				break;
			case 3:
				laptopobj.toSearchById(databaseConnection);
				break;
			case 4:
				laptopobj.toDeleteById(databaseConnection);
				break;
			case 5:
				laptopobj.toUpdateById(databaseConnection);
				break;

			case 6:
				LaptopBlueprint.tologout();
				break;
			}
		}while(enterChoice !=6);
		scan.close();
	}
	// This method is used to get username and password from the user
	public static void main(String args[]) throws SQLException, Exception {
		System.out.print("Enter user name: ");
		String username = scan.next();
		System.out.print("Enter Password: ");
		String password = scan.next();
		LaptopBlueprint.tologin(username, password);

	}
}
