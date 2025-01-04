package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect {
	private static Driver driver;
	private static Statement statement;
	private static ResultSet resultSet;
	private static Connection connection;
	private static  String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
	        query = "SELECT * FROM users";
			statement.execute(query);
			resultSet = statement.getResultSet();
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("email"));
				System.out.println(resultSet.getLong("mobile"));
				System.out.println(resultSet.getString("password"));
			}
			
			
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
	
	public static void openConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//intialize driver with new keyword
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
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
	
