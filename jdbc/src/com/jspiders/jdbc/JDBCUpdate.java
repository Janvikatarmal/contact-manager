package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
			query="UPDATE users SET password ='janvi@12345' WHERE id= 1";
			statement.execute(query);
			System.out.println("Record is Updated");
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

	public static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver =  new com.mysql.cj.jdbc.Driver();
		connection = DriverManager.getConnection("jdbc:mysql://localhost:4996/demo12?user=root&password=root");	
	}
	
	public static void closeConnection() throws SQLException {
		if(statement!=null)
			statement.close();
		if(connection!=null)
			connection.close();
		if(driver!=null)
			DriverManager.deregisterDriver(driver);
		
		
	}
}
