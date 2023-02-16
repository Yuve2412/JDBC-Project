package JDBC;

import java.sql.*;
import java.util.Scanner;

public class LaptopDatabaseConnection {
	private static Scanner scan = new Scanner(System.in);

	/*
	 * PreparedStatement--> to get user input
	 * set--> is used to the set the values
	 * Sql query is used to insert the values to the tables
	 * executeUpdate is used for all dml queries
	 * To add all the laptop details in this method
	 * If there is any new stock 
	 */

	public void toAddValues(Connection connection) throws SQLException,Exception {
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Laptop_Details  values(?,?,?,?,?,?)");
		System.out.println("Enter the values that you want to add");
		pstmt.setString(1,scan.next());
		pstmt.setInt(2,scan.nextInt());
		pstmt.setInt(3,scan.nextInt());
		pstmt.setString(4,scan.next());
		pstmt.setString(5,scan.next());
		pstmt.setString(6,scan.next());
		int noOfRecordsInserted = pstmt.executeUpdate();
	}
	/*
	 * toDisplayAll methods is used to display all the values present in the table
	 */
	public void toDisplayAll(Connection connection) throws SQLException,Exception{
		Statement stmt = connection.createStatement();
		ResultSet resultSet= stmt.executeQuery("SELECT * FROM Laptop_Details");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2)+ " "+ resultSet.getInt(3) +" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));

		}
	}
	/*
	 * PreparedStatement--> to get user input
	 * search is done by searching an unique id*/
	public void toSearchById(Connection connection) throws SQLException, Exception  {
		PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Laptop_Details WHERE laptop_id = ? ");
		System.out.println("Enter the ID you want to search: ");
		int id = scan.nextInt();
		pstmt.setInt(1,id);
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2) + " "+ resultSet.getInt(3) +" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));

		}		
	}
	/*
	 *PreparedStatement--> to get user input
	 * delete is done by searching an unique id 
	 */
	public void toDeleteById(Connection connection) throws SQLException,Exception {
		PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Laptop_Details WHERE laptop_id = ? ");
		System.out.println("Enter the ID you want to delete: ");
		int lap_id= scan.nextInt();
		pstmt.setInt(1,lap_id);
		int resultSet = pstmt.executeUpdate();
		System.out.println(resultSet);
	}
	/*
	 *PreparedStatement--> to get user input
	 *price is updated by searching an unique id 
	 */
	public void toUpdateById(Connection connection) throws SQLException,Exception {
		System.out.println("Enter the record no to be update");
		int laptop_id = scan.nextInt();
		System.out.println("Enter the price to be updated");
		int price = scan.nextInt();
		PreparedStatement pstmt = connection.prepareStatement("UPDATE Laptop_Details SET price = ? where laptop_id =? ");
		pstmt.setInt(1,price);
		pstmt.setInt(2,laptop_id);
		int noOfRecordsUpdated = pstmt.executeUpdate();
	}



}




















