package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertUsingPrepSta {
	
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	
	public static void main(String[] args) {
		System.out.println("Enter values to be entered");
		Scanner scanner =new Scanner(System.in);
		try {
			openConnection();
			query = "INSERT INTO users VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Enter id:");
			preparedStatement.setInt(1,scanner.nextInt());
			System.out.println("Enter Name:");
			preparedStatement.setString(2,scanner.next());
			System.out.println("Enter Email:");
			 preparedStatement.setString(3,scanner.next());
			 System.out.println("Enter mobileNo:");
			preparedStatement.setLong(4,scanner.nextLong());
			System.out.println("Enter Password:");
			preparedStatement.setString(5,scanner.next());
			int rows = preparedStatement.executeUpdate();
			System.out.println(rows + "row's affected");
			System.out.println("Record Successfully added!!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection= DriverManager.getConnection("jdbc:mysql://localhost:4996/demo12?user=root&password=root");
		
		
	}
	private static void closeConnection() throws SQLException {
		if(preparedStatement!=null)
		preparedStatement.close();
		if(connection!=null)
			connection.close();
		if(driver!=null)
			DriverManager.deregisterDriver(driver);
		
	}
}
